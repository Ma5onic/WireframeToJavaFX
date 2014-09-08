/*
* This file was generated by Generator.xtend 
* for the WireframeSketcher screen file login.screen
* at Mon, 8 Sep 2014 12:06:18 +0200
*/
package application

import java.util.HashMap
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import org.apache.commons.io.FilenameUtils
		
/* Generated */
class ScreenNavigatorControllerlogin extends AbstractNavigatorController {

	
	// Constructor
	new(Object controller, HashMap<Long, String> map) {
		super()
		_appController = controller as AppController
		
		initNavigatorMap
		println("ScreenNavigatorControllerlogin initialized.")
		
	}
	
	/* Generated */
	@FXML
	def handleButtonAction2(ActionEvent event) {				
		loadNewFXMLForScreen (event,  "screen1")
		
	} 
	
	/* Generated */
	override def initNavigatorMap(){
		_navigatorMap = <Long, String>newHashMap
		_navigatorMap.put(2l, "screen1")

	}
	/* Generated */
	override getAppController() {
		_appController
	}
	
	/* Generated */
	override getNavigatorMap() {
		_navigatorMap
	}
	
	/* Generated */
	override getScreenName() {
		"login"
	}
}