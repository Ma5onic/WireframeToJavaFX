//package application
//
////import generator.Generator
//import com.wireframesketcher.model.ModelPackage
//import com.wireframesketcher.model.Screen
//import java.io.File
//import java.io.FileNotFoundException
//import java.nio.file.Paths
//import java.util.HashMap
//import javafx.event.ActionEvent
//import javafx.fxml.FXML
//import javafx.fxml.FXMLLoader
//import javafx.scene.Parent
//import javafx.scene.Scene
//import javafx.scene.control.Button
//import javafx.stage.Stage
//import org.eclipse.emf.common.util.URI
//import org.eclipse.emf.ecore.EPackage
//import org.eclipse.emf.ecore.resource.Resource
//import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
//import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
//
///**
// * 
// * @author Fredrik Haugen Larsen
// */
//class ScreenNavigatorController extends AbstractController {
//
//	ApplicationController appController
//
//	// Constructor
//	new(ApplicationController controller, HashMap<Integer, String> map) {
//		super()
//		appController = controller
//	}
//
//
//
//	@FXML
//	def handleButtonAction(ActionEvent event) {
//		println("- - - - - - - - handleButtonAction - - - - - - - - - ")
//		if (event.getSource() instanceof Button) {
//
//			val button = event.getSource() as Button;
//
//			var screenName = appController.navigatorMap.get(Integer.parseInt(button.id))
//			println("Pressed on a button with a link to: " + screenName + ".screen")
//
//			//			println("screenMap   :" + appController.screenMap)
//			val sceneResource = appController.screenMap?.get(screenName)
//
//			var Parent root = null 
//			var Stage stage = null 
//			var Scene scene = null
//
//			var screenFile = new File(
//				"/Users/f/Documents/Eclipse Workspaces/workspace/wireframing-tutorial/" + screenName + ".screen")
//			if (!screenFile.exists) {
//				throw new FileNotFoundException("Could not find " + screenFile)
//			}
//			var checksum = MD5Checksum.checkSum(screenFile.absolutePath)
//
//			if (sceneResource != null && sceneResource.checksum == checksum) {
//
//				// The resource has been loaded already
//				println("The stored checksum is: " + sceneResource.checksum)
//				screenFile = new File(
//					"/Users/f/Documents/Eclipse Workspaces/workspace/wireframing-tutorial/" + screenName + ".screen")
//				if (!screenFile.exists) {
//					throw new FileNotFoundException("Could not find " + screenFile)
//				}
//				checksum = MD5Checksum.checkSum(screenFile.absolutePath)
//
//				println("The new    checksum is: " + checksum)
//
//				println("Checksums are identical! There is no point of generating a new fxml file.")
//				appController.navigatorMap = sceneResource.navigatorMap
//
//				//println("navigatorMap: " + appController.navigatorMap)
//				println("Loading stored resource...")
//				scene = sceneResource.scene
//				stage = appController.root.getScene().getWindow() as Stage;
//
//				appController.root = scene.root
//				println("Done.")
//
//			} else { // The resource has not been loaded
//
//				if (sceneResource != null && sceneResource.checksum != checksum) {
//					println("Checksum differs, generating " + screenName + ".fxml again")
//
//				}
//
//				// Generates FXML for the .screen file 'screenName'
//				generate(screenName)
//
//				val filePath = "src/application/" + screenName + ".fxml";
//				val loader = new FXMLLoader();
//				val location = Paths.get(filePath).toUri().toURL();
//				loader.setLocation(location);
//				loader.setController(this);
//
//				root = loader.load() as Parent;
//				stage = appController.root.getScene().getWindow() as Stage;
//
//				scene = new Scene(root);
//				appController.root = root
//
//				// Save the scene in the map along with the screen file checksum
//				screenFile = new File(
//					"/Users/f/Documents/Eclipse Workspaces/workspace/wireframing-tutorial/" + screenName + ".screen")
//				if (!screenFile.exists) {
//					throw new FileNotFoundException("Could not find " + screenFile)
//				}
//				checksum = MD5Checksum.checkSum(screenFile.absolutePath)
//				val fxmlSceneResource = new FXMLSceneResource(screenName, scene, checksum, appController.navigatorMap)
//				appController.screenMap?.put(screenName, fxmlSceneResource)
//
//			//				println("navigatorMap: " + appController.navigatorMap)
//			}
//
//			stage.setScene(scene);
//			stage.show();
//
//		}
//
//	}
//
//
//	def void generate(String fileName) {
//		EPackage.Registry.INSTANCE.put("http://wireframesketcher.com/1.0/model.ecore", ModelPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("screen", new XMIResourceFactoryImpl());
//		val resSet = new ResourceSetImpl();
//
//		var res = null as Resource
//		try {
//			res = resSet.getResource(
//				URI.createFileURI(
//					"/Users/f/Documents/Eclipse Workspaces/workspace/wireframing-tutorial/" + fileName + ".screen"), true);
//
//		} catch (Exception e) {
//			System.out.println("No such file. " + e.getMessage());
//			return;
//		}
//
//		res.contents.filter(Screen).forEach[appController.fxmlGenerator.generateGrid(it, fileName)]
//
//		res.contents.filter(Screen).forEach[appController.fxmlGenerator.generate(it, fileName)]
//
//	}
//}
