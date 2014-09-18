package application

import com.wireframesketcher.model.Screen
import com.wireframesketcher.model.Widget
import com.wireframesketcher.model.story.Storyboard
import java.io.File
import java.io.FileNotFoundException
import java.lang.reflect.Method
import java.nio.file.Paths
import java.util.HashMap
import javafx.event.Event
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import no.fhl.screenDecorator.AbstractDecorator
import no.fhl.screenDecorator.EventScriptAction
import no.fhl.screenDecorator.ScriptAction
import no.fhl.screenDecorator.WidgetContainerDecorator
import no.fhl.screenDecorator.WidgetDecorator
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource

/** Used to indicate if the methods <code>getPropertyForNode()</code> or 
 * <code>setPropertyForNode()</code> was successful in invoking the property.
 */
enum PropertyResult {
	SUCCESS,
	NO_SUCH_METHOD,
	ILLEGAL_ARGUMENT_TYPE
}

abstract class AbstractNavigatorController {

	protected AppController _appController
	protected HashMap<Long, String> _navigatorMap

	abstract def AppController getAppController()

	abstract def HashMap<Long, String> getNavigatorMap()

	abstract def String getScreenName()

	/**  Populates the statically generated navigator map */
	abstract def void initNavigatorMap()

	def performActionForWidgetId(Resource resource, String widgetId) {
		if (widgetId == "-1" || widgetId == null) {
			return
		}
		resource.contents.filter(Screen).forEach [
			it.widgets.filter[it.id == Long.parseLong(widgetId)].forEach [ widget |
				// This is the widget we are looking for
				val decorator = appController.decoratorMap.get(widget) as WidgetDecorator
				if (decorator != null) { // There is a decorator for the widget
					decorator.actions.forEach [
						if (it instanceof EventScriptAction) {
							setScriptFeatureForWidget(script, widget)
						} else if (it instanceof ScriptAction) {
							setScriptFeatureForWidget(it.script, widget)
						}
					]

				}
			]
		]
	}
	
	
	/** Returns the invoked value of <code>propertyName</code> on <code>node</code><br>
	 * Returns <code>PropertyResult.NO_SUCH_METHOD</code> if the method does not exist. */
	def getPropertyForNode(Node node, String propertyName) {
		try {
			val method = node.class.getMethod("get" + propertyName.toFirstUpper)
			var Object result
			try {

				result = method.invoke(node)
			} catch (Exception e) {
				println("getProperty() No such method: " + "get" + propertyName + e.stackTrace)
				return PropertyResult.NO_SUCH_METHOD
			}
			return result

		} catch (NoSuchMethodException e) {
			return PropertyResult.NO_SUCH_METHOD
		}

	}

	/** Invokes the method <code>propertyName</code> on <code>node</code> using <code>propertyValue</code><br>
	 * Returns <code>PropertyResult.SUCCESS</code> if successful and <code>PropertyResult.NO_SUCH_METHOD</code><br>
	  if there is no such method. If <code>propertyType</code> is wrong then <code>PropertyResult.ILLEGAL_ARGUMENT_TYPE</code> is returned*/
	def setPropertyForNode(Node node, String propertyName, EDataType propertyType, String propertyValue) {
		var Method method = null
		var Object result = null

		val viewValue = propertyType.EPackage.EFactoryInstance.createFromString(propertyType, propertyValue)

		var argClass = propertyType.instanceClass
		try {
			while ((argClass != null && (! "Object".equals(argClass.simpleName))) && method == null) {
				try {
					method = node.class.getMethod("set" + propertyName.toFirstUpper, argClass)
				} catch (Exception e) {
					argClass = argClass.superclass
				}
			}
		
		if (method == null){
			println("Could not find the method " + "set" + propertyName.toFirstUpper + "(" + argClass + " arg)")
			return null
		}
		result = method.invoke(node, viewValue)
			
		} catch (NoSuchMethodException e) {
			println("setProperty() No such method: " + "set" + propertyName.toFirstUpper)
			e.printStackTrace();
			return PropertyResult.NO_SUCH_METHOD
		} catch (IllegalArgumentException e) {
			println("setProperty() Illegal argument type: " + "set" + propertyName.toFirstUpper)
			e.printStackTrace();
			return PropertyResult.ILLEGAL_ARGUMENT_TYPE
		}
		if (result == null) {
			result = PropertyResult.SUCCESS
		}
		return result
	}

	/** Check if there is a property of name <code>propertyName</code> in <code>node</code>*/
	def hasProperty(String propertyName, Node node) {
		val name = propertyName + "Property"
		var Method method = null
		try {
			method = node.class.getMethod(name, null)
			method.invoke(node)

		} catch (Exception e) {
			return false
		}
		return true
	}

	def evaluateRules(Resource resource) {

		resource.contents.filter(Screen).forEach [
				evaluateWidgetDecoratorForScreen(it)
				evaluateWidgetContainerDecoratorForScreen(it)
			]
		
	}

	def evaluateWidgetContainerDecoratorForScreen(Screen screen){
		val decorator = appController.decoratorMap.get(screen) as WidgetContainerDecorator
		if (decorator != null) {

			// There is a decorator for the screen
			decorator.viewRules.forEach [
				val value = resolveValueForFeature(it.stateFeature.name, screen)
				// If this rule is relevant, or its value is wildcard
				if (value == it.stateFeatureValue || it.stateFeatureValue == "*") {

					// Wildcard value means it should be performed regardless of the stateFeatureValue
					// It can be used together with another specific value.
					// E.g if textFeature = "password", set style="green".
					// Adding textFeature = "*", set style = "" before the rule will reset the style 

					val node = appController.root.lookup("#gridPane1" )
					if (node != null) {

						val result = setPropertyForNode(node, it.viewProperty, it.viewPropertyType,
							it.viewPropertyValue)
						if (result == PropertyResult.NO_SUCH_METHOD) {
							println(
								"No such method: " + "set" + it.viewProperty.toFirstUpper + " for " + node)
						} else if (result == PropertyResult.SUCCESS) {
							println(
								"Found the method: " + "set" + it.viewProperty.toFirstUpper + " for " + node)
						}
					}
				}
			]
		} 
	}
	def evaluateWidgetDecoratorForScreen(Screen screen) {
		screen.widgets.forEach [ widget |
			// If the widget has text in the format =${value}
			// then blank it out
			if (widget.text.startsWith("=${") && widget.text.endsWith("}")) {
				val node = appController.root.lookup("#" + widget.id)
				val propertyName = "text"
				if (node != null) {
					setPropertyForNode(node, propertyName, EcorePackage.eINSTANCE.EString, "")
				}
			}
			val decorator = appController.decoratorMap.get(widget) as WidgetDecorator
			if (decorator != null) {

				// There is a decorator for the widget
				decorator.viewRules.forEach [
					val value = resolveValueForFeature(it.stateFeature.name, widget)
					// If this rule is relevant, or its value is wildcard
					if (value == it.stateFeatureValue || it.stateFeatureValue == "*") {

						// Wildcard value means it should be performed regardless of the stateFeatureValue
						// It can be used together with another specific value.
						// E.g if textFeature = "password", set style="green".
						// Adding textFeature = "*", set style = "" before the rule will reset the style 
						// Find the javafx object
						val node = appController.root.lookup("#" + decorator.widget.id)
						if (node != null) {

							val result = setPropertyForNode(node, it.viewProperty, it.viewPropertyType,
								it.viewPropertyValue)
							if (result == PropertyResult.NO_SUCH_METHOD) {
								println(
									"No such method: " + "set" + it.viewProperty.toFirstUpper + " for " + node)
							} else if (result == PropertyResult.SUCCESS) {
								println(
									"Found the method: " + "set" + it.viewProperty.toFirstUpper + " for " + node)
							}
						}
					}
				]
			}
			if (widget.text.resolvable) {

				// There is no decorator for this widget, but it has a special text format
				// go through the scope (handled automatically by resolveValueForFeature)
				//  and look for the feature text (e.g newItemString2)
				// The JavaFX representation of the widget
				val node = appController.root.lookup("#" + widget.id)
				if (node != null) {
					val text = resolveValueForFeature(widget.text, widget)
					setPropertyForNode(node, "text", EcorePackage.eINSTANCE.EString, text)
				}
			}
		]
	}

	/** Returns the XMI resource for the application as defined in <code>Constants.SUB_PROJECT_NAME</code> */
	def getXMIResource() {
		val ecorePathFileList = appController.resourceSetHandler.ecorePathFileList
		val fullPath = "/" + FilenameUtils.getPath(ecorePathFileList.get(0))
			

		var resources = appController.resourceSetHandler.resourceSet.resources.filter[
			it.URI == URI::createFileURI(fullPath + Constants.SUB_PROJECT_NAME + ".xmi")]
		
		if (resources.size > 0) {
			return resources.get(0)
		}
		return null

	}
	/* TODO: This method is extremely messy. (and probably very redundant)
	 * Look at getModelForWidget and fix this method.
	 */
	def setScriptFeatureForWidget(String script, Widget widget) {
		var AbstractDecorator decorator = appController.decoratorMap.get(widget)
		if (decorator == null) {
			println("Decorator is null, aborting.")
			return false
		}
		if (decorator.model != null) {
			val result = setScriptFeatureForModel(script, decorator.model)
			if (result == false){
				println("This needs to be fixed. AbstractNavigatorController.setScriptFeatureForWidget")
			}
			return true
		}
		val storyboard = appController.resourceSetHandler.storyboardResource.contents.get(0) as Storyboard
		if (decorator.model == null) { // widget model is null, check screen
			decorator = appController.decoratorMap.get(widget.eContainer) // as WidgetContainerDecorator 
			if (decorator == null) { // no decorator for this screen, check storyboard
				decorator = appController.decoratorMap.get(storyboard) 
				if (decorator == null) { // no decorator for storyboard. There is no model!
					println("Warning: There is no model at all!")
					return false
				} else if (decorator.model != null) { // storyboard is not null.
					setScriptFeatureForModel(script, decorator.model)
					return true
				} else {
					
					return false
				}
			} else { // screen has a decorator
				if (decorator.model != null) {
					val result = setScriptFeatureForModel(script, decorator.model)
					if (result == false) {
						// Try with the app decorator
						decorator = appController.decoratorMap.get(storyboard) // as StoryboardDecorator 
						if (decorator == null) { // no decorator for storyboard. There is no model!
							return false
						} else if (decorator.model != null) { // storyboard is not null.
							setScriptFeatureForModel(script, decorator.model)
							return true
						} else {
							return false
						}
					}
					
					return true
				}
				if (decorator.model == null) { // But there is no model, so check storyboard  
					decorator = appController.decoratorMap.get(storyboard) // as StoryboardDecorator 
					if (decorator == null) { // no decorator for storyboard. There is no model!
						return false
					} else if (decorator.model != null) { // storyboard is not null.
						setScriptFeatureForModel(script, decorator.model)
						return true
					} else {
						return false
					}
				}
			}

		}

	}

	def getIdForInputProperty(Iterable<Resource> resourceList, String value) {
		for (resource : resourceList) {
			for (screen : resource.contents.filter(Screen)) {
				for (widget : screen.widgets) {
					if (widget.text == "=" + value) {
						return widget.id
					}
				}
			}
		}
		return null
	}
	
	def setScriptFeatureForModel(String script, EClass model) {
		if (appController.hasLoadedXMIFiles) {
			val resource = XMIResource
			if (resource == null) {
				println("ERROR: resource was null")
				return null
			}
			
			// Find the EObject corrosponding with the model
			val eObject = getEObjectForModelWithResource(model, resource)

			// Split around the equal sign. But only first occurance
			val scriptStringArray = script.split("=", 2)
			val scriptFeature = scriptStringArray.get(0).trim
			val scriptValue = scriptStringArray.get(1).trim
			var resolvedScriptValue = scriptValue
			// if value is ${value} then look for a widget with the same text 
			// attribute and get the id, then get the javafx.text object with that id	
			if (scriptValue.startsWith("${") && scriptValue.endsWith("}")) {
				val fileResources = appController.resourceSetHandler.resourceSet.resources
				var resourceList = fileResources.filter[FilenameUtils.getName(it.URI.path) == screenName + ".screen"]

				// If there is widget with text property =${value}  
				val id = getIdForInputProperty(resourceList, scriptValue)

				// If there is a javafx object which should be resolved
				if (id != null) {
					var node = appController.root.lookup("#" + id)
					if (node != null) {
						val propertyName = "text"
						val text = getPropertyForNode(node, propertyName) as String
						resolvedScriptValue = text
					}
				}
			}
			if (scriptValue == "bool" || scriptValue == "toggle"){
				// bool as value sets the variable's value to the opposite boolean value. 
				// If variable is false, then it is set to true and vice versa.
				val returnString = resolveValueForModelUsingResource(scriptFeature, model, resource)
					
				if (returnString == "false") resolvedScriptValue = "true"
				if (returnString == "true") resolvedScriptValue = "false"
			}
			// Allow simple integer increments
			if (scriptValue == "increment" || scriptValue == "count" || scriptValue == "inc"){
				
				val returnString = resolveValueForModelUsingResource(scriptFeature, model, resource)
				try {
					var integer = Integer.parseInt(returnString)
					integer += 1
					resolvedScriptValue = integer.toString
					println("Incrementing... " + resolvedScriptValue)
				} catch (Exception e){
					println("Unable to increment integer value: " + returnString)
				}
			}
			val feature = model.getEStructuralFeature(scriptFeature)
			if (feature != null) {
				if (feature.EType == EcorePackage.eINSTANCE.EBoolean) {

					// This is a boolean
					eObject.eSet(feature, Boolean.valueOf(resolvedScriptValue))
				} else if (feature.EType == EcorePackage.eINSTANCE.EInt) {

					// This is an int
					eObject.eSet(feature, Integer.valueOf(resolvedScriptValue))
				} else if (feature.EType == EcorePackage.eINSTANCE.EString) {

					// This is a String (or something else)
					eObject.eSet(feature, resolvedScriptValue)
				}
				// Update the changes in the XMI file						
				resource.save(null)
				return true
			}
			// Failed to set value. (The model was incorrect)
			return false
		}
		// No XMI resource loaded. This is an error.
		return null
	}

	/** Retuns true if the text starts with ${ and ends with } */
	def isResolvable(String text) {
		if (text.startsWith("${") && text.endsWith("}")) {
			return true
		}
		false
	}

	/** If the string is a structural feature than resolve it, else return the string.
	 * The format is '${nameOfStructuralFeature}', but it will also parse 'nameOfStructuralFeature'
	 */
	 def String resolveValueForFeature(String string, Screen screen) {
	 		var model = getModelForScreen(screen, null)
		var returnString = string
		if (string == null) {
			println("resolveValueForFeature: String is null")
			return null
		}

		val resource = getXMIResource
		if (resource == null) {
			println("Resource is null")
			return string
		}

		// Check the whole scope starting with the widget->screen->storyboard
		do {
			returnString = resolveValueForModelUsingResource(string, model, resource)
			// If the strings are different the variable has been resolved
			if (returnString != string) { // returnString != null && 
				return returnString
			}

			// The strings are equal so we check one level up the scope
			model = getModelForScreen(screen, model)

		// If model is null, then there are no more models in the scope to check
		} while (model != null)

		// This is not a feature inside the scope. Return the unresolved string
		return string
	 }
	 
	def String resolveValueForFeature(String string, Widget widget) {
		var model = getModelForWidget(widget, null)
		var returnString = string
		if (string == null) {
			println("resolveValueForFeature: String is null")
			return null
		}

		val resource = getXMIResource
		if (resource == null) {
			println("Resource is null")
			return string
		}

		// Check the whole scope starting with the widget->screen->storyboard
		do {
			returnString = resolveValueForModelUsingResource(string, model, resource)
			// If the strings are different the variable has been resolved
			if (returnString != string) { // returnString != null && 
				return returnString
			}

			// The strings are equal so we check one level up the scope
			model = getModelForWidget(widget, model)

		// If model is null, then there are no more models in the scope to check
		} while (model != null)

		// This is not a feature inside the scope. Return the unresolved string
		return string
	}

	/** Returns the EObject whoes EClass matches model */
	def getEObjectForModelWithResource(EClass model, Resource resource) {

		// Find the EObject corrosponding with the model
		var EObject eObject = null
		for (content : resource.contents) {
			if (content.eClass == model) {
				eObject = content
			}
		}
		if (eObject == null) {
			println("ERROR: No EObject found for the model " + model)
			return null
		}
		return eObject
	}

	def String resolveValueForModelUsingResource(String string, EClass model, Resource resource) {
		if (model == null){
			println("model is null ")
			return string
		}
		// Find the EObject corrosponding with the model
		val eObject = getEObjectForModelWithResource(model, resource)
		// If this is a structural feature it should have the format ${nameOfStructuralFeature}
		var EStructuralFeature feature = null
		if (string.resolvable) {
			val featureString = string.subSequence(2, string.length - 1) as String
			feature = model.getEStructuralFeature(featureString)
		} else {
			feature = model.getEStructuralFeature(string)
		}
		if (feature != null) {
			try {
				var value = eObject.eGet(feature)
				if (feature.EType == EcorePackage.eINSTANCE.EBoolean) {
					// Convert boolean to string
					return String.valueOf(value)
				} else if (feature.EType == EcorePackage.eINSTANCE.EString) {
					return value as String
				} else if (feature.EType == EcorePackage.eINSTANCE.EInt) {
					return value.toString
				}

			} catch (Exception e) {
				println("Error setting feature for eObject")
			}
		}
		return string
	}
	
	def getModelForScreen(Screen screen, EClass model){
		val xmiResource = XMIResource
		val screenName = FilenameUtils.getBaseName(screen.eResource.URI.path).toLowerCase
		var EClass eClass = null
		var EClass screenClass = null
		var EClass storyboardClass = null
		
		// Find the storyboard / app class
		val appName = Constants.SUB_PROJECT_NAME.toLowerCase
		for (i : 0..< xmiResource.contents.size){
			eClass = xmiResource.contents.get(i).eClass
			if (eClass.name == appName){
				storyboardClass = eClass
			}
		}
		// This is the same class as we received
		if (model == storyboardClass){
			return null
		}
		// look for screen class
		for (i : 0..< xmiResource.contents.size){
			eClass = xmiResource.contents.get(i).eClass
			if (eClass.name == screenName){
				screenClass = eClass
			}
		}
		// This is the same class as we received
		if (model == screenClass){
			return storyboardClass
		}

		if (screenClass == null) {
			if (storyboardClass == null) {
				return null
			} else {
				return storyboardClass
			}
		} else {
			return screenClass
		}
	}
	/** Returns the model for the widget. If the same model is found as the one provied, null is returned. */
	def getModelForWidget(Widget widget, EClass model){
		
		val xmiResource = XMIResource
		val screenName = FilenameUtils.getBaseName(widget.eContainer.eResource.URI.path).toLowerCase
		val widgetClassName = screenName + "Id" + widget.id 
		var EClass eClass = null
		var EClass screenClass = null
		var EClass widgetClass = null
		var EClass storyboardClass = null
		
		// Find the storyboard / app class
		val appName = Constants.SUB_PROJECT_NAME.toLowerCase
		for (i : 0..< xmiResource.contents.size){
			eClass = xmiResource.contents.get(i).eClass
			if (eClass.name == appName){
				storyboardClass = eClass
			}
		}
		// This is the same class as we received
		if (model != null && model == storyboardClass){
			return null
		}
		// look for screen class
		for (i : 0..< xmiResource.contents.size){
			eClass = xmiResource.contents.get(i).eClass
			if (eClass.name == screenName){
				screenClass = eClass
			}
		}
		// This is the same class as we received
		if (model != null && model == screenClass){
			return storyboardClass
		}
		// Look for widget class
		for (i : 0..< xmiResource.contents.size){
			eClass = xmiResource.contents.get(i).eClass
			if (eClass.name == widgetClassName){
				widgetClass = eClass
			}
		}
		// This is the same class as we received
		if (model != null && model == widgetClass){
			return screenClass
		}
		if (widgetClass == null){
			if (screenClass == null){
				if (storyboardClass == null){
					return null
				} else {
					return storyboardClass					
				}
			} else {
				return screenClass
			}
		} else {
			return widgetClass
		}

		
	}

	def getResourceForScreenFile(String screenFile){
		val fileResources = appController.resourceSetHandler.resourceSet.resources
		val resourceList = fileResources.filter[FilenameUtils.getName(it.URI.path) == screenFile]
		if (resourceList.size > 0){
			return resourceList.get(0)
		}
		return null	
	}
	
	def getResourceForModel(Iterable<Resource> fileList, EClass model) {
		if(model == null) return null
		if (fileList != null) {
			for (resource : fileList) {
				if (resource != null) {
					for (eObject : resource.contents) {
						if (eObject.eClass.name == model.name) {
							return resource
						}
					}
				}
			}
		}
		return null
	}

	def performActionForEvent(Event event){
		val resource = getResourceForScreenFile(screenName + ".screen")
		
		val id = getPropertyForNode(event.source as Node, "id")
		if (id != null && id != PropertyResult.NO_SUCH_METHOD){
			resource.performActionForWidgetId(id as String)
		}
	}
	
	def evaluateRulesForScreen(String screen){
		val resource = getResourceForScreenFile(screen + ".screen")
		resource.evaluateRules
	}
	
	def loadNewFXMLForScreen (Event event, String nextScreen){
		var Parent root = null 
		var Stage stage = null 
		var Scene scene = null
		var String checksum = null
		val sceneResource = appController.fxmlMap?.get(nextScreen)
		// If there are any actions for the button. Perform them 
		event.performActionForEvent
		
		var fxmlFile = new File(
		Constants.FXML_DIRECTORY + nextScreen + ".fxml" )
		if (fxmlFile.exists) {
			checksum = MD5Checksum.checkSum(fxmlFile.absolutePath)
		}
		if (sceneResource != null && sceneResource.checksum == checksum) {
	
				println("Checksums are identical. There is no point of loading a new fxml file.")
	
				println("Loading stored resource...")
				scene = sceneResource.scene
				stage = appController.root.getScene().getWindow() as Stage;
	
				appController.root = scene.root
				println("Done.")
	
		} else if (sceneResource == null || (sceneResource != null && sceneResource.checksum != checksum) ) { 
			// The file does not exist, or the the file exist but has changed. then load the updated file
	
				val filePath = "src/application/" + nextScreen + ".fxml";
	
				if (!new File(filePath).exists) {
					throw new FileNotFoundException(
						"Could not find " + nextScreen + ".fxml " + "You need to run the generator.")
				}					
				val loader = new FXMLLoader();
				val location = Paths.get(filePath).toUri().toURL();
				loader.setLocation(location);
				println("Checksum mismatch. The FXML file has been edited.\nLoading new resource file...")
				_navigatorMap = appController.getNavigatorMapForFxml(nextScreen)
				
		
				// Create the dedicated ScreenNavigatorController using reflection 
				val safeFileName = nextScreen.replace("-","") 
				val className = Class.forName("application.ScreenNavigatorController" + safeFileName);
				val con = className.getConstructor(Object, HashMap);
				val controller = con.newInstance(appController, _navigatorMap);
				loader.setController(controller);
		
				root = loader.load() as Parent;
				stage = appController.root.getScene().getWindow() as Stage
				scene = new Scene(root)
				appController.root = root
				
				val fxmlSceneResource = new FXMLSceneResource(nextScreen, scene, checksum, _navigatorMap)
				appController.fxmlMap?.put(safeFileName, fxmlSceneResource)
				println("Done")
			}
			
			nextScreen.evaluateRulesForScreen
	
		stage.setScene(scene);
		stage.show();
	}
}
