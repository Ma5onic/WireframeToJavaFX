//package application
//
//import com.wireframesketcher.model.ModelPackage
//import com.wireframesketcher.model.Screen
//import generator.Generator
//import java.io.File
//import java.io.FileNotFoundException
//import java.nio.file.Paths
//import java.util.HashMap
//import javafx.application.Application
//import javafx.fxml.FXML
//import javafx.fxml.FXMLLoader
//import javafx.scene.Parent
//import javafx.scene.Scene
//import javafx.stage.Stage
//import org.eclipse.emf.common.util.URI
//import org.eclipse.emf.ecore.EPackage
//import org.eclipse.emf.ecore.resource.Resource
//import org.eclipse.emf.ecore.resource.ResourceSet
//import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
//import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
//
///**
// * 
// * @author Fredrik Haugen Larsen
// */
//class ApplicationController {
//
//	@FXML
//	private Parent root;
//
//	Generator fxmlGenerator
//	HashMap<Integer, String> navigatorMap
//	HashMap<String, FXMLSceneResource> screenMap
//
//	Object screenNavigatorController
//
//	Resource resource
//
//	/* Getters */
//	def getNavigatorMap() {
//		navigatorMap
//	}
//
//	def getFxmlGenerator() {
//		fxmlGenerator
//	}
//
//	def getRoot() {
//		root
//	}
//
//	def getScreenMap() {
//		screenMap
//	}
//
//	/* Setters */
//	def void setNavigatorMap(HashMap<Integer, String> newNavigatorMap) {
//		navigatorMap = newNavigatorMap
//	}
//
//	def void setRoot(Parent newRoot) {
//		root = newRoot;
//	}
//
//	def void setScreenMap(HashMap<String, FXMLSceneResource> newScreenMap) {
//		screenMap = newScreenMap
//	}
//
//	override start(Stage stage) {
//
//		//  This dictates the initial screen file 
//		val fileName = "Start"
//
//		// initialize generator
//		fxmlGenerator = new Generator(this)
//		screenMap = <String, FXMLSceneResource>newHashMap
//
//		EPackage.Registry.INSTANCE.put("http://wireframesketcher.com/1.0/model.ecore", ModelPackage.eINSTANCE)
//		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("screen", new XMIResourceFactoryImpl())
//		val ResourceSet resSet = new ResourceSetImpl();
//
//		resource = resSet.getResource(
//			URI.createFileURI(
//				"/Users/f/Documents/Eclipse Workspaces/workspace/wireframing-tutorial/" + fileName + ".screen"), true)
//
//		var filePath = "src/application/" + fileName + ".fxml";
//
//		resource.contents.filter(Screen).forEach [
//			// Generate the columns and row data for the grid
//			fxmlGenerator.generateGrid(it, fileName)
//			// Generate and save the FXML elements
//			fxmlGenerator.generate(it, fileName)
//		]
//
//	
//		try {
//			filePath = "src/application/" + fileName + ".fxml";
//			if (Paths.get(filePath).toFile().exists()) {
//
//				val loader = new FXMLLoader();
//				val location = Paths.get(filePath).toUri().toURL();
//				screenNavigatorController = new ScreenNavigatorController0(this, navigatorMap);
//
//				loader.setLocation(location);
//				loader.setController(screenNavigatorController);
//				root = loader.load() as Parent;
//
//			} else {
//				throw new FileNotFoundException();
//			}
//
//		} catch (FileNotFoundException e) {
//
//			System.out.println("No such file '" + fileName + "'. Did you forget to run the generator?");
//			return;
//		}
//
//
//		val scene = new Scene(root);
//
//		// Save the scene in the map along with the screen file checksum
//		val screenFile = new File(
//			"/Users/f/Documents/Eclipse Workspaces/workspace/wireframing-tutorial/" + fileName + ".screen")
//		if (!screenFile.exists) {
//			throw new FileNotFoundException("Could not find " + screenFile)
//		}
//		val checksum = MD5Checksum.checkSum(screenFile.absolutePath)
//		val fxmlSceneResource = new FXMLSceneResource(fileName, scene, checksum, navigatorMap)
//		screenMap?.put(fileName, fxmlSceneResource)
//
//		stage.setScene(scene);
//		stage.show();
//	}
//
//	/**
//	 * The main() method is ignored in correctly deployed JavaFX application.
//	 * main() serves only as fallback in case the application can not be
//	 * launched through deployment artifacts, e.g., in IDEs with limited FX
//	 * support. NetBeans ignores main().
//	 * 
//	 * @param args
//	 *            the command line arguments
//	 */
//	def static void main(String[] args) {
//
//		launch(args);
//
//	}
//
//}
