package generator

import application.Constants
import application.ResourceSetHandler
import com.wireframesketcher.model.Arrow
import com.wireframesketcher.model.Master
import com.wireframesketcher.model.Screen
import com.wireframesketcher.model.Widget
import com.wireframesketcher.model.story.Storyboard
import java.io.File
import java.util.HashMap
import no.fhl.screenDecorator.DecoratorModel
import no.fhl.screenDecorator.ScreenDecoratorFactory
import no.fhl.screenDecorator.ScriptAction
import no.fhl.screenDecorator.WidgetDecorator
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import no.fhl.screenDecorator.WidgetContainerDecorator

/** A singleton class that parse and generate screendecorator models */
class ScreenDecoratorGenerator {
	private static ScreenDecoratorGenerator instance = null
	

	def static getInstance() {
		if (instance == null) {
			instance = new ScreenDecoratorGenerator
		}
		instance
	}

	def getMasterType(Master master){
		var DecoratorModelType modelType = null
		// It will not resolve master.screen, so we use a dirty method to check what type it is..
		val uri = master.screen.toString
		switch uri {
			case uri.endsWith("Models.screen#Data)"):
				modelType = DecoratorModelType.DATA
			case uri.endsWith("Models.screen#Actions)"):
				modelType = DecoratorModelType.ACTION
			case uri.endsWith("Models.screen#Styles)"):
				modelType = DecoratorModelType.STYLE
		}
		return modelType
	}

	def void generateForMasterUsingMasterMap(Master master, HashMap<Master, Pair<Arrow, Widget>> masterMap) {
		var DecoratorModelType modelType = master.masterType

		if (master.overrides.widgets.size > 1) {
			println("Warning: There should only be one override for this master.")
		}
		var String textString
		if (master.overrides.widgets.size > 0) {
			textString = master.overrides.widgets.get(0).text
		}

		// Tokenize the string on newline &#xA;
		val dataStrings = textString.split("\\n")

		switch modelType {
			case DecoratorModelType.DATA : instance.generateDataModel(dataStrings, master, masterMap)
			case DecoratorModelType.ACTION : instance.generateDecoratorAction(dataStrings, master, masterMap)
			case DecoratorModelType.STYLE : instance.generateDecoratorStyle(dataStrings, master, masterMap)
		}
	}

	def void generateDataModel(String[] dataString, Master master, HashMap<Master, Pair<Arrow, Widget>> masterMap) {
		val resourcePath = master.container.eResource.URI.path
		val baseName = FilenameUtils.getBaseName(resourcePath).toLowerCase
		val arrow = masterMap.get(master)?.key
		
		if (arrow == null) {
			// If there is no arrow, this should be parsed for app or screen
			if (dataString.get(0).toLowerCase.trim == "app") {
				// If the first string is app
				val appName = Constants.SUB_PROJECT_NAME
				createEcoreData(dataString, appName)
			} else {
				// Otherwise, this is for a screen 
				createEcoreData(dataString, baseName)
			}
		} else {
			// Arrow not null. Create model for the widget
			val widget = masterMap.get(master).value
			val name = baseName + "Id" + widget.id
			createEcoreData(dataString, name)			
		}
	}

	def void generateDecoratorAction(String[] dataString, Master master, HashMap<Master, Pair<Arrow, Widget>> masterMap) {
				
		var String feature = null
		var String value = null
		val widget = masterMap.get(master)?.value
		if (widget != null) {
			for (string : dataString) {
				feature = getFeatureNameFromDataString(string)
				value = getFeatureValueFromDataString(string)
				if (feature != "") {
					createScriptAction(widget, feature + " = " + value)
				}
			}
		}
	}

	/**  Generates styles (view rules) for the master. Supports several styles. */
	def void generateDecoratorStyle(String[] dataString, Master master, HashMap<Master, Pair<Arrow, Widget>> masterMap) {

		var String feature = null
		var String featureValue = null
		var String property = null
		var String propertyValue = null

		val widget = masterMap.get(master)?.value
		try {
			var scriptStringList = newArrayList(dataString)

			// Remove any blank lines
			for (i : 0 ..< scriptStringList.size) {
				if (scriptStringList.get(i).trim.empty == true) {

					// Remove the empty line
					scriptStringList.remove(i.intValue)
				}
			}

			var scriptPairList = newArrayList

			// If there's an odd number of scripts, do not parse anything.
			if ((scriptStringList.size % 2) != 0) {
				println("Error: Unable to parse decorator style for widget \"" + widget.text + 
					"\". Odd number of lines. ")
				return
			} else {

				// Add the pairs to a list
				for (var i = 0; i < scriptStringList.size; i += 2) {
					var scriptPair = scriptStringList.get(i) -> scriptStringList.get(i + 1)
					scriptPairList.add(scriptPair)
				}

			}
			// For each pair, parse the values.
			for (scriptPair : scriptPairList) {
				
				val ifString = scriptPair.key.split(" is ")
				feature = ifString.get(0).split(" ", 4).get(1).trim
				featureValue = ifString.get(1).trim
			
				val setString = scriptPair.value.split(" is ")
				property = setString.get(0).split(" ").get(1)
				propertyValue = setString.get(0).split(" ", 4).get(3)
				// Convert double quotes and empty to an empty string 
				if (featureValue == "\"\"" || featureValue == "empty") {
					featureValue = ""
				} else if (featureValue == "\" \"") {
					// Whitespace
					featureValue = " "
				}

				if (widget != null) {
					// This is a widget style (viewRule for the widget)
					createViewRuleForWidget(widget, feature, featureValue, property, propertyValue)

				} else {
					// This is a screen style (viewRule for the screen)
					val screen = master.eContainer as Screen
					createViewRuleForScreen(screen, feature, featureValue, property, propertyValue)
				}
			}

		} catch (Exception e) {
			println("Error parsing Style (view rule)")
			e.printStackTrace
			// array out of bounds from failed parsing, most likely.
		}
	}

	def getStateFeatureFromNameUsingScreen(String featureName, Screen screen){
		val screenResourcePath = screen.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		
		// for alle ecore filer let etter feature med navn feature
		val directory = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/"
		val appName = Constants.SUB_PROJECT_NAME
		
		val screenEcorePath = directory + screenName + ".ecore"
		val appEcorePath = directory + appName + ".ecore"
		
		
		var result = getStateFeatureFromEcorePath(featureName, screenEcorePath)
		if (result == null){
			result = getStateFeatureFromEcorePath(featureName, appEcorePath)
		}
		return result as EAttribute
	}
	
		
	def getStateFeatureFromNameUsingWidget(String featureName, Widget widget){
		val screen = widget.eContainer as Screen
		val screenResourcePath = widget.eContainer.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		val widgetModelName = screenName + "Id" + widget.id 
		
		// for alle ecore filer let etter feature med navn feature
		val directory = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/"
		val widgetEcorePath = directory + widgetModelName + ".ecore"
		
		
		var result = getStateFeatureFromEcorePath(featureName, widgetEcorePath)
		if (result == null){
			result = getStateFeatureFromNameUsingScreen(featureName, screen)
			
		}
		return result as EAttribute
		
	}
	
	def getStateFeatureFromEcorePath(String featureName, String path){
		var appResources = ResourceSetHandler.instance.resourceSet.resources.filter[
			it.URI == URI::createFileURI(path)]
			

		if (appResources.size > 0){
			val eClass = appResources.get(0).contents.get(0).eContents.get(0) as EClass
			for ( stateFeature : eClass.EAllStructuralFeatures) {
				if (stateFeature.name == featureName){
					return stateFeature
				}
			}
		}
		return null
	}
	
	def createViewRuleForScreen(Screen screen, String feature, String featureValue, String property,
		String propertyValue){
		val screenResourcePath = screen.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		val factory = ScreenDecoratorFactory.eINSTANCE
		var foundWidgetContainerDecorator = false
		
		val decoratorResource = getDecoratorResourceForScreenName(screenName)
		if (decoratorResource != null) {

			val stateFeature = getStateFeatureFromNameUsingScreen(feature, screen)
			if (stateFeature == null) {
				println("Unable to find state feature " + feature + " for view rule. Screen: " + screen)
				return null
			}
			val decoratorModel = decoratorResource.contents.get(0) as DecoratorModel
			for (widgetContainerDecorator : decoratorModel.decorators) {
				if (widgetContainerDecorator instanceof WidgetContainerDecorator) {
					if (widgetContainerDecorator.widgetContainer == screen) {
						foundWidgetContainerDecorator = true

						// Check if the view rule exist.
						var viewRuleAlreadyExist = false
						for (viewRule : widgetContainerDecorator.viewRules) {
							if (viewRule.stateFeature == feature && viewRule.stateFeatureValue == featureValue &&
								viewRule.viewProperty == property && viewRule.viewPropertyValue == propertyValue) {
								viewRuleAlreadyExist = true
							}
						}
						if (viewRuleAlreadyExist == false) {
							val viewRule = factory.createViewRule
							viewRule.viewProperty = property
							viewRule.viewPropertyValue = propertyValue
							viewRule.stateFeature = stateFeature
							viewRule.stateFeatureValue = featureValue
							// TODO: Støtt flere typer
							if (propertyValue == "true" || propertyValue == "false"){
								viewRule.viewPropertyType = EcorePackage.Literals.EBOOLEAN
							} else {
								viewRule.viewPropertyType = EcorePackage.Literals.ESTRING
							}
							widgetContainerDecorator.viewRules.add(viewRule)

						}
					}
				}

			}
			if (foundWidgetContainerDecorator == false) {

				// Create the widget
				val widgetContainerDecorator = factory.createWidgetContainerDecorator
				widgetContainerDecorator.widgetContainer = screen
				if (ecoreModelForScreenExist(screen) == false) {
					widgetContainerDecorator.model = getEcoreModelForScreen(screen)
				}

				val viewRule = factory.createViewRule
				viewRule.viewProperty = property
				viewRule.viewPropertyValue = propertyValue
				viewRule.stateFeature = stateFeature
				viewRule.stateFeatureValue = featureValue
				// TODO: Støtt flere typer
				if (propertyValue == "true" || propertyValue == "false"){
					viewRule.viewPropertyType = EcorePackage.Literals.EBOOLEAN
				} else {
					viewRule.viewPropertyType = EcorePackage.Literals.ESTRING
				}

				widgetContainerDecorator.viewRules.add(viewRule)
				decoratorModel.decorators.add(widgetContainerDecorator)
			}
			decoratorResource.save(null)
		} else { 
			// There is no decorator resource. Create it.
			
			val resourceSet = ResourceSetHandler.instance.resourceSet
			val directory = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/"
			val path = directory + screenName + ".screendecorator"
			val resource = resourceSet.createResource(URI.createFileURI(path))
			
			val decoratorModel = factory.createDecoratorModel
			
			// Create the widget container
			val widgetContainerDecorator = factory.createWidgetContainerDecorator
			widgetContainerDecorator.widgetContainer = screen
			if (ecoreModelForScreenExist(screen) == false) {
				widgetContainerDecorator.model = getEcoreModelForScreen(screen)
			}

			val stateFeature = getStateFeatureFromNameUsingScreen(feature, screen)
			if (stateFeature == null) {
				println("Unable to find state feature " + feature + " for view rule. Screen: " + screen)
				return null
			}
			val viewRule = factory.createViewRule
			viewRule.viewProperty = property
			viewRule.viewPropertyValue = propertyValue
			viewRule.stateFeature = stateFeature
			viewRule.stateFeatureValue = featureValue

			// TODO: Støtt flere typer
			if (propertyValue == "true" || propertyValue == "false") {
				viewRule.viewPropertyType = EcorePackage.Literals.EBOOLEAN
			} else {
				viewRule.viewPropertyType = EcorePackage.Literals.ESTRING
			}

			widgetContainerDecorator.viewRules.add(viewRule)
			decoratorModel.decorators.add(widgetContainerDecorator)

			val screenModelPath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/" + screenName + ".ecore"
			var file = new File(screenModelPath)
			val screenDecorator = factory.createWidgetContainerDecorator
			if (file.exists){
				val screenmodelResource = resourceSet.getResource(URI.createFileURI(screenModelPath), true)
				screenDecorator.model = screenmodelResource.contents.get(0).eContents.get(0) as EClass 
			}
			screenDecorator.widgetContainer = screen as Screen
		
		
			val storyboardModelPath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/" + "muniapp.ecore"
			val storyboardDecorator = factory.createStoryboardDecorator
			storyboardDecorator.storyboard = ResourceSetHandler.instance.storyboardResource.contents.get(0) as Storyboard
			file = new File(storyboardModelPath)
			if (file.exists){
				val modelResource = resourceSet.getResource(URI.createFileURI(storyboardModelPath), true)
				storyboardDecorator.model = modelResource.contents.get(0).eContents.get(0) as EClass
			}

			decoratorModel.decorators.add(storyboardDecorator)
			decoratorModel.decorators.add(screenDecorator)
			
			resource.contents.add(decoratorModel)
			resource.save(null)
		}
	}
	
	def createViewRuleForWidget(Widget widget, String feature, String featureValue, String property,
		String propertyValue) {
		val screenResourcePath = widget.eContainer.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		var foundWidgetDecorator = false
		val factory = ScreenDecoratorFactory.eINSTANCE

		val decoratorResource = getDecoratorResourceForScreenName(screenName)
		if (decoratorResource != null) {

			val stateFeature = getStateFeatureFromNameUsingWidget(feature, widget)
			if (stateFeature == null) {
				println("Unable to find state feature " + feature + " for view rule. Widget: " + widget)
				return null
			}
			val decoratorModel = decoratorResource.contents.get(0) as DecoratorModel
			for (widgetDecorator : decoratorModel.decorators) {
				if (widgetDecorator instanceof WidgetDecorator) {
					if (widgetDecorator.widget == widget) {
						foundWidgetDecorator = true

						// Check if the view rule exist.
						var viewRuleAlreadyExist = false
						for (viewRule : widgetDecorator.viewRules) {
							if (viewRule.stateFeature == feature && viewRule.stateFeatureValue == featureValue &&
								viewRule.viewProperty == property && viewRule.viewPropertyValue == propertyValue) {
								viewRuleAlreadyExist = true
							}
						}
						if (viewRuleAlreadyExist == false) {
							val viewRule = factory.createViewRule
							viewRule.viewProperty = property
							viewRule.viewPropertyValue = propertyValue
							viewRule.stateFeature = stateFeature
							viewRule.stateFeatureValue = featureValue
							// TODO: Støtt flere typer
							if (propertyValue == "true" || propertyValue == "false"){
								viewRule.viewPropertyType = EcorePackage.Literals.EBOOLEAN
							} else {
								viewRule.viewPropertyType = EcorePackage.Literals.ESTRING
							}
							widgetDecorator.viewRules.add(viewRule)

						}
					}
				}

			}
			if (foundWidgetDecorator == false) {

				// Create the widget
				val widgetDecorator = factory.createWidgetDecorator
				widgetDecorator.widget = widget
				if (ecoreModelForWidgetExist(widget) == false) {
					widgetDecorator.model = getEcoreModelForWidget(widget)
				}

				val viewRule = factory.createViewRule
				viewRule.viewProperty = property
				viewRule.viewPropertyValue = propertyValue
				viewRule.stateFeature = stateFeature
				viewRule.stateFeatureValue = featureValue
				// TODO: Støtt flere typer
				if (propertyValue == "true" || propertyValue == "false"){
					viewRule.viewPropertyType = EcorePackage.Literals.EBOOLEAN
				} else {
					viewRule.viewPropertyType = EcorePackage.Literals.ESTRING
				}

				widgetDecorator.viewRules.add(viewRule)
				decoratorModel.decorators.add(widgetDecorator)
			}
			decoratorResource.save(null)
		} else { 
			val resourceSet = ResourceSetHandler.instance.resourceSet
			val directory = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/"
			val path = directory + screenName + ".screendecorator"
			val resource = resourceSet.createResource(URI.createFileURI(path))
			
			val decoratorModel = factory.createDecoratorModel
			
			// Create the widget container
			val widgetDecorator = factory.createWidgetDecorator
			widgetDecorator.widget = widget
			if (ecoreModelForWidgetExist(widget) == false) {
				widgetDecorator.model = getEcoreModelForWidget(widget)
			}

			val stateFeature = getStateFeatureFromNameUsingWidget(feature, widget)
			if (stateFeature == null) {
				println("Unable to find state feature " + feature + " for view rule. Widget: " + widget)
				return null
			}
			val viewRule = factory.createViewRule
			viewRule.viewProperty = property
			viewRule.viewPropertyValue = propertyValue
			viewRule.stateFeature = stateFeature
			viewRule.stateFeatureValue = featureValue

			// TODO: Støtt flere typer
			if (propertyValue == "true" || propertyValue == "false") {
				viewRule.viewPropertyType = EcorePackage.Literals.EBOOLEAN
			} else {
				viewRule.viewPropertyType = EcorePackage.Literals.ESTRING
			}

			widgetDecorator.viewRules.add(viewRule)
			decoratorModel.decorators.add(widgetDecorator)

			val screenModelPath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/" + screenName + ".ecore"
			var file = new File(screenModelPath)
			val screenDecorator = factory.createWidgetContainerDecorator
			if (file.exists){
				val screenmodelResource = resourceSet.getResource(URI.createFileURI(screenModelPath), true)
				screenDecorator.model = screenmodelResource.contents.get(0).eContents.get(0) as EClass 
			}
			screenDecorator.widgetContainer = widget.eContainer as Screen
		
		
			val storyboardModelPath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/" + "muniapp.ecore"
			val storyboardDecorator = factory.createStoryboardDecorator
			storyboardDecorator.storyboard = ResourceSetHandler.instance.storyboardResource.contents.get(0) as Storyboard
			file = new File(storyboardModelPath)
			if (file.exists){
				val modelResource = resourceSet.getResource(URI.createFileURI(storyboardModelPath), true)
				storyboardDecorator.model = modelResource.contents.get(0).eContents.get(0) as EClass
			}

			decoratorModel.decorators.add(storyboardDecorator)
			
			resource.contents.add(decoratorModel)
			resource.save(null)
		}
	}
	
	def getDecoratorResourceForScreenName(String screenName){
		val directory = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/"
		val path = directory + screenName + ".screendecorator"
		getDecoratorResourceForPath(path)
	}
	
	def getDecoratorResourceForPath(String filePath) {
		var resources = ResourceSetHandler.instance.resourceSet.resources.filter[
			it.URI == URI::createFileURI(filePath)]
		if (resources.size > 0) {
			return resources.get(0)
		}
		return null
	}

	
	def createScriptAction(Widget widget, String script){
		val screenResourcePath = widget.eContainer.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		var foundWidgetDecorator = false
		val factory = ScreenDecoratorFactory.eINSTANCE	
		
		val decoratorResource = getDecoratorResourceForScreenName(screenName)
		if (decoratorResource != null){
			
			val decoratorModel = decoratorResource.contents.get(0) as DecoratorModel
			for ( widgetDecorator :  decoratorModel.decorators){
				if (widgetDecorator instanceof WidgetDecorator){
					if (widgetDecorator.widget == widget){
						foundWidgetDecorator = true
						// Check if the script exist.
						var scriptAlreadyExist = false
						for ( action : widgetDecorator.actions){
							if ((action as ScriptAction).script == script){
								scriptAlreadyExist = true
							}
						}
						if (scriptAlreadyExist == false){
							val action = factory.createScriptAction
							action.script = script
							widgetDecorator.actions.add(action)
						}
					}
				}
				
			}
			if (foundWidgetDecorator == false){
				// Create the widget
				val widgetDecorator = factory.createWidgetDecorator
				widgetDecorator.widget = widget
				if (ecoreModelForWidgetExist(widget) == false){
					widgetDecorator.model = getEcoreModelForWidget(widget)
				}
				val action = factory.createScriptAction
				action.script = script
				widgetDecorator.actions.add(action)
				decoratorModel.decorators.add(widgetDecorator)
			}
			
			decoratorResource.save(null)
			
		} else { 
			// There is no decorator resource. Create it.
			
			val resourceSet = ResourceSetHandler.instance.resourceSet
			val directory = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/"
			val path = directory + screenName + ".screendecorator"
			
			val resource = resourceSet.createResource(URI.createFileURI(path))
			
			val decoratorModel = factory.createDecoratorModel
			val widgetDecorator = factory.createWidgetDecorator
			
			val scriptAction = factory.createScriptAction
			scriptAction.script = script		
			
			widgetDecorator.widget = widget
			widgetDecorator.actions.add(scriptAction)
			
			
			val screenModelPath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/" + screenName + ".ecore"
			var file = new File(screenModelPath)
			val screenDecorator = factory.createWidgetContainerDecorator
			if (file.exists){
				val screenmodelResource = resourceSet.getResource(URI.createFileURI(screenModelPath), true)
				screenDecorator.model = screenmodelResource.contents.get(0).eContents.get(0) as EClass 
			}
			screenDecorator.widgetContainer = widget.eContainer as Screen
		
		
			val storyboardModelPath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME + "/" + "muniapp.ecore"
			val storyboardDecorator = factory.createStoryboardDecorator
			storyboardDecorator.storyboard = ResourceSetHandler.instance.storyboardResource.contents.get(0) as Storyboard
			file = new File(storyboardModelPath)
			if (file.exists){
				val modelResource = resourceSet.getResource(URI.createFileURI(storyboardModelPath), true)
				storyboardDecorator.model = modelResource.contents.get(0).eContents.get(0) as EClass
				
			}

			decoratorModel.decorators.add(widgetDecorator)
			decoratorModel.decorators.add(storyboardDecorator)
			decoratorModel.decorators.add(screenDecorator)
			
			resource.contents.add(decoratorModel)
			resource.save(null)
		}
	}
	
	def getEcoreModelForScreen(Screen screen){
		val resource = getEcoreResourceForScreen(screen)
		if (resource != null){
			return resource.contents?.get(0) as EClass
		}
		return null
	}
	
	def getEcoreModelForWidget(Widget widget){
		val resource = getEcoreResourceForWidget(widget)
		if (resource != null){
			return resource.contents?.get(0) as EClass
		}
		return null
	}
	
	def getEcoreResourceForScreen(Screen screen){
		val screenResourcePath = screen.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		var ecoreFilePath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME 
			+ "/"+ screenName + ".ecore"
		return getEcoreResourceForPath(ecoreFilePath)
	}
	
	def getEcoreResourceForWidget(Widget widget){
		val screenResourcePath = widget.eContainer.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		val widgetDataFileName = screenName + "Id" + widget.id 
		var ecoreFilePath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME 
			+ "/"+ widgetDataFileName + ".ecore"
		return getEcoreResourceForPath(ecoreFilePath)
	}
	
	private def getEcoreResourceForPath(String filePath) {
		var resources = ResourceSetHandler.instance.resourceSet.resources.filter[
			it.URI == URI::createFileURI(filePath)]
		if (resources.size > 0) {
			return resources.get(0)
		}
		return null
	}
	
	private def ecoreModelForScreenExist(Screen screen){
		val screenResourcePath = screen.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		var ecoreFilePath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME 
			+ "/"+ screenName + ".ecore"
			
		return ecoreDataFileExist(ecoreFilePath)
	}
	
	private def ecoreModelForWidgetExist(Widget widget){
//		val fileName = 
		val screenResourcePath = widget.eContainer.eResource.URI.path
		val screenName = FilenameUtils.getBaseName(screenResourcePath).toLowerCase
		val widgetDataFileName = screenName + "Id" + widget.id 
		var ecoreFilePath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME 
			+ "/"+ widgetDataFileName + ".ecore"
			
		return ecoreDataFileExist(ecoreFilePath)
	}

	private def ecoreDataFileExist(String filePath) {
		// Check if file exist
		var ecoreFile = new File(filePath)
		if (ecoreFile.exists) {
			return true
		}
		return false
	}

	
	def createEcoreData(String[] data, String ecoreName) {
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("ecore", new EcoreResourceFactoryImpl)
		val resourceSet = ResourceSetHandler.instance.resourceSet // new ResourceSetImpl
		var ecoreFilePath = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME 
			+ "/"+ ecoreName + ".ecore"
		var Resource ecoreResource = null
		if (ecoreName == null) {
			println("Cannot create ScreenDecorator data for ecoreName = null")
			return
		}
		if (data == null) {
			println("Cannot create ScreenDecorator data for data = null")
			return
		}
		if (ecoreDataFileExist(ecoreFilePath) == true) {
			// Ecore file exist. Load it and append any data
			// Load the ecore resource
			ecoreResource = resourceSet.getResource(URI.createFileURI(ecoreFilePath), true)
			// Empty the file
		    ecoreResource.contents.clear
			
			val ePackage = createRootPackage(ecoreName)
			val eClass = createEmptyClass(ePackage, ecoreName)
			
			createAttributeForData(eClass, data)
			
			// Add the Package (including class and attributes) to the resource file
			ecoreResource.contents.add(ePackage)
			
			/* // With some implementation this allows several annotations to point to the same model.
			// But deleting attributes is not handled.
			// It works by only adding attributes which are not already in the resource file
			for (string : data) {
				val name = getNameFromDataString(string)
				// If name is empty its either a parse error or scope indicator. E.g "app" or "screen"
				if (name != ""){
					// newItemString1
					var foundAttribute = false
					for (clazz : ePackage.eContents) {
						for (attribute : clazz.eContents) {
	
							val eAttribute = attribute as EAttribute
							if (name != "" && name == eAttribute.name) {
								foundAttribute = true
							} 
						}
					}
					if (foundAttribute == false){
						val type = getTypeFromDataString(string)
						println("Legger til: " + name + " med type " + type)
						createAttribute(eClassifier as EClass, name, type)
					}		
					
				}
			} */
			
				
			// Use the Schema Location save option so the editor can handle XMI files 
			var saveOptions = new HashMap(1)
			saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE)
			ecoreResource.save(saveOptions)

		} else {

			// Create the ecore file
			ecoreResource = resourceSet.createResource(
				URI.createFileURI(ecoreFilePath)
			)

			val ePackage = createRootPackage(ecoreName)
			val eClass = createEmptyClass(ePackage, ecoreName)
			createAttributeForData(eClass, data)
			
			// Add the Package (including class and attributes) to the resource file
			ecoreResource.contents.add(ePackage)
			
		}
		// Use the Schema Location save option so the editor can handle XMI files 
		var saveOptions = new HashMap(1)
		saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE)
		ecoreResource.save(saveOptions)
	}
	private def createRootPackage(String name) {
		val ecoreFactory = EcoreFactory.eINSTANCE

		// Create the root package
		val rootPackage = ecoreFactory.createEPackage
		rootPackage.name = name
		rootPackage.nsPrefix = name 
		rootPackage.nsURI = Constants.SUB_PROJECT_NAME + "." + name
		return rootPackage
	}
	
	private def EClass createEmptyClass(EPackage aPackage, String className) {
		val ecoreFactory = EcoreFactory.eINSTANCE
		val eClass = ecoreFactory.createEClass
		if (className != null) {
			eClass.name = className
		} else {
			eClass.name = "default"
		}
		if (aPackage != null) {
			aPackage.EClassifiers.add(eClass)
		}
		return eClass
	}
	
	private def createAttributeForData(EClass eClass, String[] data){
		var String type = null
		var String name = null
		for (string : data){
				type = getTypeFromDataString(string)
				name = getNameFromDataString(string)
				if (type != "" || name != ""){
					createAttribute(eClass, name, type)
				}
		}
	}
	private def EAttribute createAttribute(EClass eClass, String name, String type) {
		
		val ecoreFactory = EcoreFactory.eINSTANCE
		val eAttribute = ecoreFactory.createEAttribute()
		
		var EDataType eType = null
		switch type.toLowerCase {
			case "string" : eType = EcorePackage.Literals.ESTRING
			case "bool" : eType = EcorePackage.Literals.EBOOLEAN
			case "int" : eType = EcorePackage.Literals.EINT
			case "float" : eType = EcorePackage.Literals.EFLOAT
			case "double" : eType = EcorePackage.Literals.EDOUBLE
			default : eType = EcorePackage.Literals.ESTRING
		}
		eAttribute.setName(name)
		eAttribute.setEType(eType)
		if (eClass != null){
			eClass.getEStructuralFeatures.add(eAttribute)
		}
		return eAttribute
	}
	
	def getFeatureNameFromDataString(String dataString){
		getLHSFromDataString(dataString, "=")
	}
	def getFeatureValueFromDataString(String dataString){
		getRHSFromDataString(dataString, "=")
	}
	def getNameFromDataString(String dataString) {
		getRHSFromDataString(dataString, " ")
	}
	def getTypeFromDataString(String dataString) {
		getLHSFromDataString(dataString, " ")
	}
	private def getLHSFromDataString(String dataString, String seperator) {
		var splitString = dataString.split(seperator) 
		if (splitString.size == 2) { 
			return splitString.get(0).trim
		}
		return ""
	}
	
	private def getRHSFromDataString(String dataString, String seperator) {
		var splitString = dataString.split(seperator) // "String  newItemString1"
		if (splitString.size == 2) { // [String], [newItemString1] 
			return splitString.get(1).trim
		} 
		return ""
	}
	
}
