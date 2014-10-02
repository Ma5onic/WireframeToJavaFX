package application

import com.wireframesketcher.model.Screen
import generator.Generator
import java.io.File
import java.io.FileNotFoundException
import java.lang.reflect.Constructor
import java.nio.file.Paths
import java.util.HashMap
import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import no.fhl.screenDecorator.AbstractDecorator
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * 
 * @author Fredrik Haugen Larsen
 */
class AppController extends Application {

	/* The name of the initial fxml file */
	String fileName =   "screen1" // "recipe" //

	/** A resource set with all loaded resources */
	ResourceSet resourceSet

	/** An instance of the ResourceSetHandler  */
	ResourceSetHandler resourceSetHandler

	@FXML
	private Parent root
	Generator fxmlGenerator

	/** A map of widget IDs and links to other screen files*/
	HashMap<Long, String> navigatorMap
	HashMap<String, FXMLSceneResource> fxmlMap
	Scene scene
	Object screenNavigatorController

	HashMap<Object, AbstractDecorator> decoratorMap

	boolean hasLoadedXMIFiles

	/** If the XMI files has been created and/or loaded */
	def hasLoadedXMIFiles() {
		return hasLoadedXMIFiles
	}

	/* Getters */
	def getNavigatorMap() {
		navigatorMap
	}

	def getResourceSetHandler() {
		resourceSetHandler
	}

	def getFxmlGenerator() {
		fxmlGenerator
	}

	def getRoot() {
		root
	}

	def getFxmlMap() {
		fxmlMap
	}

	def getScene() {
		scene
	}

	def getDecoratorMap() {
		decoratorMap
	}

	/* Setters */
	def void setNavigatorMap(HashMap<Long, String> newNavigatorMap) {
		navigatorMap = newNavigatorMap
	}

	def void setRoot(Parent newRoot) {
		root = newRoot
	}

	def void setFxmlMap(HashMap<String, FXMLSceneResource> newFxmlMap) {
		fxmlMap = newFxmlMap
	}

	def getNavigatorMapForFxml(String fileName) {

		val resourceSet = resourceSetHandler.resourceSet

		val HashMap<String, HashMap<Long, String>> map = newHashMap
		resourceSet.resources.forEach [
			val name = FilenameUtils.getBaseName(it.URI.path)
			if (name + "." + it.URI.fileExtension == fileName + ".screen") {
				it.contents.filter(Screen).forEach [
					
					map.put("navigatorMap", fxmlGenerator.generateNavigatorMap(it))
				]
			}
		]
		
		

		// The generator calls the appController setNavigatorMap() with an updated map
		return map.get("navigatorMap")
	}

	override start(Stage stage) {

		// Initialize generator
		fxmlGenerator = new Generator(this, null)
		fxmlMap = <String, FXMLSceneResource>newHashMap

		// Create a resource set and populate it with all relevant files.
		// This eliminates different instances of the same files.
		resourceSetHandler = ResourceSetHandler.instance
		resourceSet = resourceSetHandler.resourceSet

		// Traverse the decorators and build a map from WireframeSketcher widgets to widget decorators 
		decoratorMap = resourceSetHandler.decoratorMap

		// Used for reflection of the controller and for method invocation
		var Class<?> class
		var Constructor<?> constructor


		// Load the fxml file and set the custom controller class
		try {
			var filePath = "src/application/" + fileName + ".fxml"
			if (Paths.get(filePath).toFile().exists()) {

				val loader = new FXMLLoader
				val location = Paths.get(filePath).toUri.toURL

				// Create the dedicated ScreenNavigatorController using reflection 
				val safeFileName = fileName.replace("-", "").replace(" ", "")
				class = Class.forName("application.ScreenNavigatorController" + safeFileName)
				constructor = class.getConstructor(Object, HashMap)
				screenNavigatorController = constructor.newInstance(this, navigatorMap)
				loader.setLocation(location)
				loader.setController(screenNavigatorController)
				setRoot = loader.load() as Parent

			} else {
				throw new FileNotFoundException()
			}

		} catch (FileNotFoundException e) {

			println("No such file '" + fileName + ".fxml" + "'. Did you forget to run the generator?")
			return
		}

		scene = new Scene(getRoot)

		// Save the scene in the map along with the screen file checksum
		val fxmlFile = new File(Constants.FXML_DIRECTORY + fileName + ".fxml")
		if (!fxmlFile.exists) {
			throw new FileNotFoundException(
				"Generate should have created the file " + fxmlFile + ".fxml - Check write permissions")
		}
		val checksum = MD5Checksum.checkSum(fxmlFile.absolutePath)
		val fxmlSceneResource = new FXMLSceneResource(fileName, scene, checksum, navigatorMap)
		fxmlMap?.put(fileName, fxmlSceneResource)

		// Load and/or create the XMI instance files
		initXMIFiles

		// Resolve all proxies
		EcoreUtil.resolveAll(resourceSetHandler.resourceSet)

		// Use reflection and invoke the evaluteRules method for this controller
		val fileResources = resourceSetHandler.resourceSet.resources
		val resource = fileResources.filter[FilenameUtils.getName(it.URI.path) == fileName + ".screen"].get(0)
		val finalConstructor = screenNavigatorController
		class.methods.forEach [
			if (it.name == "evaluateRules") {
				it.invoke(finalConstructor, resource)
			}
		]

		stage.setScene(scene)
		stage.show()
	}

	/**  Loads the XMI files and creates them if they don't exist.<br>
	 *   Each ecore file should have a corrosponding XMI instance file*/
	private def initXMIFiles() {
		
		resourceSetHandler.createXMIInstances
		hasLoadedXMIFiles = true
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main().
	 * 
	 * @param args
	 *            the command line arguments
	 */
	def static void main(String[] args) {

		launch(args)

	}

}
