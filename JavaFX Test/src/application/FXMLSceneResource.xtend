package application

import javafx.scene.Scene
import java.util.HashMap

/** 
 * Stores the filename, the corrosponding scene instance, the checksum of the screen file and its navigator map. 
 * @author Fredrik Haugen Larsen
 */ 
class FXMLSceneResource {

	/** Stores the filename, the corrosponding scene instance, the checksum of the screen file and its navigator map.<br> 
	 * The navigator map includes widget IDs and links to other screen files.*/
	new(String filename, Scene scene, String screenFileChecksum, HashMap<Long, String> navigatorMap) {
		this.filename = filename
		this.scene = scene
		this.screenFileChecksum = screenFileChecksum
		this.navigatorMap = navigatorMap

	}
	/* Fields */
	String filename
	Scene scene
	String screenFileChecksum
	HashMap<Long, String> navigatorMap
	/* Getters */
	def getFilename() {
		filename
	}

	def getScene() {
		scene
	}

	def getChecksum() {
		screenFileChecksum
	}
	
	def getNavigatorMap(){
		navigatorMap
	}

	/* Setters */
	def void setFilename(String newFilename) {
		filename = newFilename
	}

	def void setScene(Scene newScene) {
		scene = newScene
	}

	def void setChecksum(String newChecksum) {
		screenFileChecksum = newChecksum
	}
	
	def void setNavigatorMap(HashMap<Long, String> newNavigatorMap){
		navigatorMap = newNavigatorMap
	}

}
