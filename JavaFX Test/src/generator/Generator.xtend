package generator

import application.AppController
import application.Constants
import application.FXMLBuilder
import application.InvalidLayoutException
import application.ResourceSetHandler
import com.wireframesketcher.model.Arrow
import com.wireframesketcher.model.Button
import com.wireframesketcher.model.Checkbox
import com.wireframesketcher.model.HLine
import com.wireframesketcher.model.Image
import com.wireframesketcher.model.Label
import com.wireframesketcher.model.List
import com.wireframesketcher.model.Master
import com.wireframesketcher.model.Screen
import com.wireframesketcher.model.State
import com.wireframesketcher.model.TextField
import com.wireframesketcher.model.Widget
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Calendar
import java.util.HashMap
import java.util.SortedMap
import java.util.regex.Pattern
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import no.fhl.screenDecorator.AbstractDecorator
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.ecore.util.EcoreUtil
import org.w3c.dom.Element
import com.wireframesketcher.model.Position

/**
 * Retrieves the EMF model data from a screen file and generates a corresponding FXML file.
 * @author Fredrik Haugen Larsen
 */
/** Indicates which type of decorator model the generator is parsing. */
enum DecoratorModelType {
	DATA,
	ACTION,
	STYLE
}
class Generator {
	
	
	/** The FXMLBuilder class saves FXML data to a specified file.
	 *  After calling the constructor, and one or more createType methods,
	 *  the save method must be called in order to save the FXML file.   
	 */
	extension FXMLBuilder builder

	String fontFace
	long radioButtonId = 0
	int fontSize

	AppController appController

	File navigatorControllerFile = null
	BufferedWriter writer = null

	// Temp. defaults
	public final static int PADDING_SIZE = 100

	SortedMap<Integer, Pair<Boolean, Boolean>> columns
	SortedMap<Integer, Pair<Boolean, Boolean>> rows

	private HashMap<Long, String> navigatorMap
	private HashMap<Object, AbstractDecorator> decoratorMap

	String methodString
	
	// The name of this screen file
	String filename
	// The safe name of the current screen file. dashes have been removed.
	String safeFileName
	
	/** List of the reference arrows that are used together with Data, Actions and Style */
	ArrayList<Arrow> arrowList = null
	/** Maps a master to the arrow and widget */
	HashMap<Master, Pair<Arrow, Widget>> masterMap = null


	def HashMap<Long, String> getNavigatorMap() {
		return navigatorMap
	}
	
	/** Constructor */ 
	new(Object appController, HashMap<Object, AbstractDecorator> decoratorMap) {
		this.appController = appController as AppController
		this.decoratorMap = decoratorMap
	}

	/** Used to assess what layout style should be used 
	 * @return A string with the layout style. E.g <em>GridPane</em>*/
	def String assessLayoutStyle(Screen screen) {

		/* Hard coded so far */
		//return "AnchorPane" // Must disable gridconstraints etc
		return "GridPane"
	}

	/** Adds a new element unless it is a duplicate */
	def <K> void addNew(SortedMap<K, Pair<Boolean, Boolean>> col, K key, Pair<Boolean, Boolean> value) {
		col.put(key, col.get(key) + value);
	}

	def static <T> int indexOf(Iterable<T> iterable, T value) {
		var i = 0
		for (T ignore : iterable) {
			if (ignore == value) {
				return i
			}
			i = i + 1
		}
		return -1
	}

	def void initBuilder(Screen screen) {

		// Assess what layout style should be used
		var layoutStyle = assessLayoutStyle(screen)

		// The grid must have been generated first
		// Set up XML
		builder = new FXMLBuilder(50, 50, layoutStyle)
		
	}


	
	
	/* ************* Grid system ********************************************* */
	/**	Generates the grid structure in case of GridPane
	* @param screen The screen that is to be generated*/
	def void generateGrid(Screen screen, String fileName) {

		// Initialize the FXML builder
		initBuilder(screen)

		columns = <Integer, Pair<Boolean, Boolean>>newTreeMap([i1, i2|i1 - i2], 0 -> null)
		rows = <Integer, Pair<Boolean, Boolean>>newTreeMap([i1, i2|i1 - i2], 0 -> null)

		/* The horizontal and vertical ruler guides can be used to 
		 * force a larger layout than what is deduced from the widget 
		 * positions. There can be several guides, so the ones at the
		 * edges are used. */
		var maxHorizontal = 0
		var maxVertical = 0
		for (hGuide : screen.HRuler.guides) {

			// Get the max positions 
			if(hGuide.position > maxHorizontal) maxHorizontal = hGuide.position

		}
		for (vGuide : screen.VRuler.guides) {

			// Get the max positions 
			if(vGuide.position > maxVertical) maxVertical = vGuide.position
		}
		builder.setPaneWidth(maxHorizontal)
		builder.setPaneHeight(maxVertical)

		for (widget : screen.widgets) {
			if (!(widget instanceof Arrow) && !(widget instanceof Master)){
				addNew(columns, widget.x, true -> false)
				addNew(columns, widget.x + widget.measuredWidth, false -> true)
				addNew(rows, widget.y, true -> false)
				addNew(rows, widget.y + widget.measuredHeight, false -> true)
			}

		}
		(builder.getRootElement += "columnConstraints" ) => [
			var previous = -1
			for (column : columns.keySet) {
				var minWidth = -1
				if (previous < 0) {
					previous = column
				} else {
					val previousPair = columns.get(previous)
					if ( previousPair != null && (columns.get(previous).key || columns.get(column).value) ) {
						
						(it += "ColumnConstraints" ) => [
						]

					} else {
						minWidth = column - previous
						val width = minWidth;
						(it += "ColumnConstraints" ) => [
							it += "minWidth" -> width + ""
						]
					}

				}
				minWidth = -1
				previous = column
			}
		]
		(builder.getRootElement += "rowConstraints" ) => [
			var previous = -1
			for (row : rows.keySet) {
				var minHeight = -1
				if (previous < 0) {
					previous = row
				} else {
					val previousPair = rows.get(previous)
					if (previousPair != null && (rows.get(previous).key || rows.get(row).value)) {
						(it += "RowConstraints" ) => [
						]
					} else {
						minHeight = row - previous
						val height = minHeight;
						(it += "RowConstraints" ) => [
							it += "minHeight" -> height + ""
						]
					}
				}
				minHeight = -1
				previous = row
			}
		]

	}

	/* ************* End Grid system ***************************************** */
	/**	Generates the different screens 
	* @param screen The screen that is to be generated*/
	def void generate(Screen screen, String fileName) {
		filename = fileName
		navigatorControllerFile = new File(
			"/Users/f/Dropbox/Skole/workspace/JavaFX Test/src/application/ScreenNavigatorController" + fileName +
				".xtend");
		navigatorControllerFile.createNewFile()
		writer = new BufferedWriter(new FileWriter(navigatorControllerFile));
		var calendar = Calendar.getInstance();
		calendar.getTime();
		var dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		val dateString = dateFormat.format(calendar.getTime());

		// class names cannot include hyphens and other special characters
		safeFileName = fileName.replaceAll("-", "")
		val startString = '''
		/*
		* This file was generated by Generator.xtend 
		* for the WireframeSketcher screen file «fileName».screen
		* at «dateString»
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
		class ScreenNavigatorController«safeFileName» extends AbstractNavigatorController {
		
			
			// Constructor
			new(Object controller, HashMap<Long, String> map) {
				super()
				_appController = controller as AppController
				
				initNavigatorMap
				println("ScreenNavigatorController«safeFileName» initialized.")
				
			}
			
			'''

		writer.write(startString);


		
		generateWithoutSave(screen, fileName)

		// Statically generate the navigator map 
		writer.write(
			'''
				«"\t"»/* Generated */
					override def initNavigatorMap(){
						_navigatorMap = <Long, String>newHashMap
			''')

		val set = navigatorMap.entrySet
		if (set != null) {
			for (entry : set) {
				writer.write(
					'''		_navigatorMap.put(«entry.key.longValue»l, "«entry.value»")
					''')
					
			}
		}

		val endString = '''
			
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
					"«safeFileName»"
				}
			}'''
		writer.write(endString)
		if(writer != null) writer.close

		// Save fxml
		if (fileName == null || fileName == "") {
			save(Constants.FXML_DIRECTORY, "untitled.fxml")
			println("Saved file as " + Constants.FXML_DIRECTORY + "untitled.fxml")
		} else {
			save(Constants.FXML_DIRECTORY, fileName + ".fxml")
//			println("Saved file as " + Constants.FXML_DIRECTORY + fileName + ".fxml")
		}

	}

	def void generateArrowReferenceList(Screen screen){
		arrowList = newArrayList
		
		screen.widgets.filter(Arrow).forEach[ arrow | 
			arrowList.add(arrow)	
		]
	}
	
		
	/** Just creating an extension method for getting the absolute number */
	def abs(int number){
		return Math.abs(number)
	}	

	private def arrowPointIsInsideWidget(Pair<Integer, Integer> arrowPoint, Widget widget){
		return (arrowPoint.key >= widget.x && arrowPoint.key <= widget.x + widget.measuredWidth &&
			arrowPoint.value >= widget.y && arrowPoint.value <= widget.y + widget.measuredHeight)
	}
	
	def buildMasterMapForScreen(Screen screen){
		// Get the models and widgets who are connected with an arrow and generate the models
		generateArrowReferenceList(screen)
		masterMap = <Master, Pair<Arrow, Widget>>newHashMap 
		var Pair<Arrow, Widget> pairWidget = null
		var Pair<Arrow, Master> pairMaster = null
						
		for (arrow : arrowList){
				
			for (widget : screen.widgets){ 
				// We do not want to compare Arrow with another Arrow (or itself)
				if (!(widget instanceof Arrow)){
					
					if ( !(widget instanceof Master)){
						// Check if the arrow terminates to a widget
						var Pair<Integer, Integer> arrowHead = arrow.x -> arrow.y
						
						if (arrow.left == false && arrow.right == true && arrow.direction == Position.BOTTOM){
							arrowHead = arrowHead.key + arrow.measuredWidth -> arrowHead.value 
						} else if (arrow.left == false && arrow.right == true){
							arrowHead = arrowHead.key + arrow.measuredWidth -> arrowHead.value + arrow.measuredHeight
						} else if (arrow.direction == Position.BOTTOM){
							arrowHead = arrowHead.key -> arrowHead.value + arrow.measuredHeight 	
						}
							
						if (arrowPointIsInsideWidget(arrowHead, widget)){
							// Arrow points to and is connected to the widget
							pairWidget = arrow -> widget
						}
						
					} else {
						// Check if that arrow start in a Master (Data, Action, Style)
						var Pair<Integer, Integer> arrowTail = arrow.x + arrow.measuredWidth -> arrow.y + arrow.measuredHeight
						
						if (arrow.left == false && arrow.right == true && arrow.direction == Position.BOTTOM){
							arrowTail = arrow.x -> arrowTail.value 
						} else if (arrow.left == false && arrow.right == true){
							arrowTail = arrow.x -> arrow.y
						} else if (arrow.direction == Position.BOTTOM){
							arrowTail = arrow.x + arrow.measuredWidth -> arrow.y // + arrow.measuredHeight
						}
						
						if(arrowPointIsInsideWidget(arrowTail, widget)){ 
							// Arrow is anchored in the master
							pairMaster = arrow -> widget as Master
						}
					}
					if (pairWidget != null && pairMaster != null){
						masterMap.put(pairMaster.value, arrow -> pairWidget.value)
						pairWidget = null
						pairMaster = null
					}
				}
			}
		}
		
	}
	
	def sortMasterMap(){
		masterMap.keySet
	}
	/**	Generates the different screens 
	* @param screen The screen that is to be generated*/
	def void generateWithoutSave(Screen screen, String fileName) {

		initBuilder(screen) 
		generateGrid(screen, fileName)
		buildMasterMapForScreen(screen)
		
		
		
		if (builder.getLayoutType == "GridPane") {
			if (columns == null || rows == null) {
				throw new InvalidLayoutException(
					"Column and/or row data is null. 
							It looks like generateGrid() failed.");
			}
		}

		// Maps the button id to the screen name it refers to
		navigatorMap = <Long, String>newHashMap()

		// The font face is set globally per screen
		if (null == screen.font || null == screen.font.name) {
			fontFace = "System"
		} else {
			fontFace = screen.font.name.replaceAll("\\s", "")
		}

		// Generate FXML for each widget using dispatch methods
		screen.widgets.forEach[generateFxml(it)]

		// update the navigatorMap for the application controller
		appController?.setNavigatorMap(navigatorMap)

	}

	/** Escapes the dollar signs so javafx does not interpolate the variable */
	def escapeText(String text){
		if (text.startsWith("$")){
			return "\\" + text
		}
		return text
	}
	
	def static operator_plus(Pair<Boolean, Boolean> p1, Pair<Boolean, Boolean> p2) {
		(p1 != null && p1.key || p2 != null && p2.key) -> (p1 != null && p1.value || p2 != null && p2.value)
	}
	
	/**	Generates the different widget types 
	 * @param widget The widget that is to be generated*/
	def dispatch void generateFxml(Widget widget) {

	}

	/** Generates the decorator models. Action and Style */
	def dispatch void generateFxml(Master master){
		val generator = ScreenDecoratorGenerator.instance
		val modelType = generator.getMasterType(master)
		if (modelType != DecoratorModelType.DATA){
			generator.generateForMasterUsingMasterMap(master, masterMap)
		}
	}


	/** CheckBox */
	def dispatch void generateFxml(Button widget) {

		// Get the decorator for this widget
//		val decorator = decoratorMap.get(widget)
//		if (decorator != null) {
//				
//			println("--> The Button widget with id "+ widget.id + " has a decorator")
////			println(decorator)
//		}
		
		if (builder.getLayoutType == "AnchorPane") {

			if (widget.link != null) {
				val fxml = widget.link.trimFileExtension
				navigatorMap.put(widget.id, fxml.toString);
			}

			(builder += "Button" ) => [
				it += "text" -> escapeText(widget.text)
				it += "layoutX" -> widget.x
				it += "layoutY" -> widget.y
				it += "style" -> "-fx-base:" + widget.background + ";"
				it += "id" -> widget.id
				if(widget.state == State.DISABLED) it += "disable" -> "true"
				it += "onAction" -> "#handleButtonAction" + widget.id
			]

			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
				if (widget.measuredHeight > widget.measuredWidth)
					widget.measuredHeight
				else
					widget.measuredWidth)

		} else if (builder.getLayoutType == "GridPane") {

			// This is a button with a special link property
			if (widget.link != null) {
				val fxml = widget.link.trimFileExtension
				navigatorMap.put(widget.id, fxml.toString);
			}

			val col1 = columns.keySet.indexOf(widget.x)
			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
			val colSpan = col2 - col1

			val row1 = rows.keySet.indexOf(widget.y)
			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
			val rowSpan = row2 - row1;

			(builder += "Button" ) => [
				it += "text" -> escapeText(widget.text)
				it += "id" -> widget.id
				if(widget.state == State.DISABLED) it += "disable" -> "true"
				it += "onAction" -> "#handleButtonAction" + widget.id
				it += "style" -> "-fx-base:" + widget.background + ";" //+ "-fx-font: 22 helvetica;"
				it += "GridPane.columnIndex" -> col1
				it += "GridPane.rowIndex" -> row1
				it += "GridPane.columnSpan" -> colSpan
				it += "GridPane.rowSpan" -> rowSpan
			]

		}

		// This is a navigation button to a new screen 
		if (widget.link != null) {

			// Add method for button
			methodString = '''
				«"\t"»/* Generated */
					@FXML
					def handleButtonAction«widget.id»(ActionEvent event) {				
						loadNewFXMLForScreen (event,  "«navigatorMap.get(widget.id)»")
						
					} 
					
			'''

		} else { // This is a normal button with no link

			methodString = '''
				/* Generated */
					@FXML
					def handleButtonAction«widget.id»(ActionEvent event) {
						
						val stateValues = StateController.getInstance().stateValues
						var loginAttempt = Integer.parseInt(stateValues.get("loginAttempt"))
						println(loginAttempt)
						stateValues.put("loginAttempt", "" + (loginAttempt + 1))
						
						
						val fileResources = appController.resourceSetHandler.resourceSet.resources
						val resourceList = fileResources.filter[FilenameUtils.getExtension(it.URI.path) == "screen" 
						&& FilenameUtils.getName(it.URI.path) == "«safeFileName».screen"]

						var String id 
						if (event.source instanceof Button){
							id = (event.source as Button).id
						} else if (event.source instanceof Label){
							id = (event.source as Label).id
						} else if (event.source instanceof TextField){
							id = (event.source as TextField).id
						} else {
							println("Warning: event.source is of unknown type")
							id = "0"
						}
						resourceList.performActionForWidgetId(id)
						
						resourceList.evaluateRules
						
					}
			'''
		}

		writer.write(methodString);

	} // end Button

	/** CheckBox */
	def dispatch void generateFxml(Checkbox widget) {

		if (builder.getLayoutType == "AnchorPane") {

			(builder += "CheckBox" ) => [
				it += "layoutX" -> widget.x
				it += "layoutY" -> widget.y
				it += "text" -> escapeText(widget.text)
				it += "selected" -> if(widget.selected) "yes" else "no"
			]

			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
				if (widget.measuredHeight > widget.measuredWidth)
					widget.measuredHeight
				else
					widget.measuredWidth)

		} else if (builder.getLayoutType == "GridPane") {

			val col1 = columns.keySet.indexOf(widget.x)
			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
			val colSpan = col2 - col1

			val row1 = rows.keySet.indexOf(widget.y)
			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
			val rowSpan = row2 - row1;

			(builder += "CheckBox" ) => [
				it += "text" -> escapeText(widget.text)
				it += "selected" -> if(widget.selected) "yes" else "no"
				it += "GridPane.columnIndex" -> col1
				it += "GridPane.rowIndex" -> row1
				it += "GridPane.columnSpan" -> colSpan
				it += "GridPane.rowSpan" -> rowSpan
			]
		}

	} // end Checkbox

	def dispatch void generateFxml(Image widget) {

		/** Image */
		// TODO: finn resource mappa til Start.screen sånn at man kan bruke "src" til å hente ut den samme bildefila
		//println(widget.src)
		val path = widget.src.path
		val index = path.lastIndexOf("/");
		val fileName = path.substring(index + 1);

		if (builder.getLayoutType == "AnchorPane") {

			(builder += "ImageView" ) => [
				it += "layoutX" -> widget.x
				it += "layoutY" -> widget.y
				if(widget.rotation != null) it += "rotate" -> widget.rotation;
				if(widget.HFlip) it += "scaleX" -> "-1"
				if(widget.VFlip) it += "scaleY" -> "-1"
				it += "fitHeight" -> widget.measuredHeight
				it += "fitWidth" -> widget.measuredWidth;
				(it += "image" ) => [
					(it += "Image") => [
						it += "url" -> "@" + fileName
					]
				]
			]

			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
				if (widget.measuredHeight > widget.measuredWidth)
					widget.measuredHeight
				else
					widget.measuredWidth)

		} else if (builder.getLayoutType == "GridPane") {

			val col1 = columns.keySet.indexOf(widget.x)
			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
			val colSpan = col2 - col1

			val row1 = rows.keySet.indexOf(widget.y)
			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
			val rowSpan = row2 - row1;

			(builder += "ImageView" ) => [
				it += "GridPane.columnIndex" -> col1
				it += "GridPane.rowIndex" -> row1
				it += "GridPane.columnSpan" -> colSpan
				it += "GridPane.rowSpan" -> rowSpan;
				(it += "image" ) => [
					(it += "Image") => [
						it += "url" -> "@" + fileName
					]
				]
			]

		}

	} // end Image

	/** Label */
	def dispatch void generateFxml(Label widget) {

//		// Get the decorator for this widget
//		val decorator = decoratorMap.get(widget) as WidgetDecorator
//		if (decorator != null) {
//			println("--> The Label widget with id "+ decorator.widget.id + " has a decorator")
//			
//			// Create a test with the #hidden label widget  
//			if (widget.id == 58 ){
//			
//				decorator.viewRules.forEach [
////					println ("stateFeature: " + it.stateFeature) //.name) // denne gir ConcurrentModificationException
////					println ("stateFeatureValue: " + it.stateFeatureValue)
////					println ("viewProperty: " + it.viewProperty)
////					println ("viewPropertyValue: " + it.viewPropertyValue)
////					println ("viewPropertyType: " + it.viewPropertyType)
////					println("--")
//				]
//				
//			}
//			
//		} else {
//			
//			// There is no decorator. This should not affect anything
//		} 


		// If font size is null assume 12 
		fontSize = 12;
		if (null != widget.font.size) {
			fontSize = widget.font.size.size;
		}

		/** In order to get correct font names for the various weights (bold, semi-bold, 
		 * thin etc) and postures (italic, regular) we create an intermediate font variable using
		 * the screen's font face and then get the correct full name from it. */
		val fontBuilder = new Text

		fontBuilder.setFont(
			Font.font(
				fontFace,
				if (widget.font.bold != null && widget.font.bold)
					FontWeight.BOLD
				else
					FontWeight.NORMAL,
				if (widget.font.italic != null && widget.font.italic)
					FontPosture.ITALIC
				else
					FontPosture.REGULAR,
				fontSize
			))

		if (builder.getLayoutType == "AnchorPane") {

			(builder += "Label") => [
				it += "layoutX" -> widget.x
				it += "layoutY" -> widget.y
				if(widget.foreground != null) it += "textFill" -> widget.foreground
				if(widget.rotation != null) it += "rotate" -> widget.rotation
				it += "id" -> widget.id
				it += "text" -> escapeText(widget.text);
				(it += "font") => [
					(it += "Font") => [
						it += "name" -> fontBuilder.font.name
						it += "size" -> fontSize
					]
				]
			]
			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
				if (widget.measuredHeight > widget.measuredWidth)
					widget.measuredHeight
				else
					widget.measuredWidth)

		} else if (builder.getLayoutType == "GridPane") {

			val col1 = columns.keySet.indexOf(widget.x)
			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
			val colSpan = col2 - col1

			val row1 = rows.keySet.indexOf(widget.y)
			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
			val rowSpan = row2 - row1;

			(builder += "Label") => [
				it += "GridPane.columnIndex" -> col1
				it += "GridPane.rowIndex" -> row1
				it += "GridPane.columnSpan" -> colSpan
				it += "GridPane.rowSpan" -> rowSpan
				if(widget.foreground != null) it += "textFill" -> widget.foreground
				if(widget.rotation != null) it += "rotate" -> widget.rotation
				it += "id" -> widget.id

				it += "text" -> escapeText(widget.text);
				(it += "font") => [
					(it += "Font") => [
						it += "name" -> fontBuilder.font.name
						it += "size" -> fontSize
					]
				]
			]

		}

	} // end Label

	/** Textfield */
	def dispatch void generateFxml(TextField widget) {

		if (builder.getLayoutType == "AnchorPane") {

			(builder += "TextField") => [
				it += "layoutX" -> widget.x
				it += "layoutY" -> widget.y
				it += "text" -> escapeText(widget.text)
				it += "id" -> widget.id
			]
			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
				if (widget.measuredHeight > widget.measuredWidth)
					widget.measuredHeight
				else
					widget.measuredWidth)

		} else if (builder.getLayoutType == "GridPane") {

			val col1 = columns.keySet.indexOf(widget.x)
			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
			val colSpan = col2 - col1

			val row1 = rows.keySet.indexOf(widget.y)
			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
			val rowSpan = row2 - row1;

			(builder += "TextField") => [
				it += "text" -> escapeText(widget.text)
				it += "id" -> widget.id
				it += "prefWidth" -> widget.measuredWidth
				it += "GridPane.columnIndex" -> col1
				it += "GridPane.rowIndex" -> row1
				it += "GridPane.columnSpan" -> colSpan
				it += "GridPane.rowSpan" -> rowSpan
			]

		}

	} // end TextField

	def dispatch void generateFxml(List widget) {

		// TODO Tolke radiobutton fra andre "List" items
		// List Items
		(builder += "VBox" ) => [ vbox |
			val col1 = columns.keySet.indexOf(widget.x)
			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
			val colSpan = col2 - col1
			val row1 = rows.keySet.indexOf(widget.y)
			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
			val rowSpan = row2 - row1;
			vbox += "GridPane.columnIndex" -> col1
			vbox += "GridPane.rowIndex" -> row1
			vbox += "GridPane.columnSpan" -> colSpan
			vbox += "GridPane.rowSpan" -> rowSpan;
			widget.items.forEach [ item |
				/* 
				 * 
				 * A	N	C	H	O	R		L	A	Y	O	U	T
				 * 
				 * */
				if (builder.getLayoutType == "AnchorPane") {

					(builder += "RadioButton" ) => [ radioButton |
						// The regex pattern
						var string = "\\((\\s|o)\\) (\\w+)"
						var pattern = Pattern.compile(string, Pattern.CASE_INSENSITIVE);
						var matcher = pattern.matcher(item.text);
						if (matcher.find()) {

							// The wiki format (o) means selected
							if (matcher.group(1).equals("o")) {

								radioButton += "selected" -> "true"
								radioButton += "text" -> matcher.group(2)

							// The wiki format ( ) means deselected
							} else if (matcher.group(1).equals(" ")) {

								radioButton += "selected" -> "false"
								radioButton += "text" -> matcher.group(2)
							}

						} else {

							// TODO This should be changed later
							println("Syntax error, or this is not a radio button!")
						}
						// Should only create the ToggleGroup for each unique widget id 
						// This corresponds to each group in the EMF model
						// If the id is not unique then this is a new radio button group
						if (widget.id != radioButtonId) {

							(radioButton += "toggleGroup") => [
								(it += "ToggleGroup" ) => [
									it += "id" -> widget.id
								]
							]
						} else {

							// The toggle group has been created, so we append the group id
							radioButton += "toggleGroup" -> "$" + widget.id
						}
						// The coordinate of the widget + the item coordinates
						radioButton += "layoutX" -> widget.x + item.x
						radioButton += "layoutY" -> widget.y + item.y
						checkPaneDimensionsAndExpandForXY(widget.x + item.x + widget.measuredWidth,
							widget.y + item.y + widget.measuredHeight,
							if (widget.measuredHeight > widget.measuredWidth)
								widget.measuredHeight
							else
								widget.measuredWidth)
					]

				/* 
				 * 
				 * G	R	I	D		L	A	Y	O	U	T
				 * 
				 * */
				} else if (builder.getLayoutType == "GridPane") {

					(vbox += "RadioButton" ) => [ radioButton |
						// The regex pattern
						var string = "\\((\\s|o)\\) (.*)"
						var pattern = Pattern.compile(string, Pattern.CASE_INSENSITIVE);
						var matcher = pattern.matcher(item.text);
						if (matcher.find()) {

							// The wiki format (o) means selected
							if (matcher.group(1).equals("o")) {

								radioButton += "selected" -> "true"
								radioButton += "text" -> matcher.group(2)

							// The wiki format ( ) means deselected
							} else if (matcher.group(1).equals(" ")) {

								radioButton += "selected" -> "false"
								radioButton += "text" -> matcher.group(2)
							}

						} else {

							// TODO This should be changed later
							println("Syntax error, or this is not a radio button!")
						}
						// Should only create the ToggleGroup for each unique widget id 
						// This corresponds to each group in the EMF model
						// If the id is not unique then this is a new radio button group
						if (widget.id != radioButtonId) {
							(radioButton += "toggleGroup") => [
								(it += "ToggleGroup" ) => [
									it += "id" -> widget.id
								]
							]
						} else {

							// The toggle group has been created, so we append the group id
							radioButton += "toggleGroup" -> "$" + widget.id
						}
					]

				}
			]
		]
	} // end List, RadioButton

	//   <widgets xsi:type="model:HLine" id="34" x="24" y="124" width="294" measuredWidth="294" measuredHeight="6"/>
	def dispatch void generateFxml(HLine widget) {
		if (builder.getLayoutType == "AnchorPane") {

			val id = widget.id;
			(builder += "Separator") => [
				it += "layoutX" -> widget.x
				it += "layoutY" -> widget.y
				it += "prefWidth" -> widget.measuredWidth
				it += "id" -> id
			]
			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
				if (widget.measuredHeight > widget.measuredWidth)
					widget.measuredHeight
				else
					widget.measuredWidth)

		} else if (builder.getLayoutType == "GridPane") {

			val col1 = columns.keySet.indexOf(widget.x)
			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
			val colSpan = col2 - col1

			val row1 = rows.keySet.indexOf(widget.y)
			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
			val rowSpan = row2 - row1;

			val id = widget.id;
			(builder += "Separator") => [
				it += "prefWidth" -> widget.measuredWidth
				it += "id" -> id
				it += "GridPane.columnIndex" -> col1
				it += "GridPane.rowIndex" -> row1
				it += "GridPane.columnSpan" -> colSpan
				it += "GridPane.rowSpan" -> rowSpan
			]
		}
	}
	
	
	/** Checks if the input coordinates are equal or larger than the pane dimensions.
	 * If that is the case the pane is expanded by <code>(x - paneWidth) + paneWidth + padding</code> 
	 * @param x The x coordinate of the item 
	 * @param y The y coordinate of the item
	 * @param padding The extra padding   
	 * */
	def checkPaneDimensionsAndExpandForXY(int x, int y, int padding) {

		val paddingN = 100
		if (x >= builder.getPaneWidth) {
			builder.paneWidth = (x - getPaneWidth) + getPaneWidth + paddingN // + 100
		}
		if (y >= builder.getPaneHeight) {
			builder.paneHeight = (y - getPaneHeight) + getPaneHeight + paddingN // + 50
		}

	}

	def Element operator_add(Element element, String elementName) {
		val child = builder.createElement(elementName);
		element.appendChild(child);
		return child;
	}

	def operator_add(Element element, Pair<String, Object> attrValue) {
		element.setAttribute(attrValue.key, String.valueOf(attrValue.value))
	}

	def dispatch HashMap<Long, String> generateNavigatorMap(Screen screen) {
		navigatorMap = <Long, String>newHashMap
		screen.widgets.forEach[generateNavigatorMap(it)]
		return navigatorMap
	}

	def dispatch generateNavigatorMap(Widget widget) {
	}

	def dispatch generateNavigatorMap(Button button) {
		if (button.link != null) {
			val fxmlFile = button.link.trimFileExtension
			navigatorMap.put(button.id, fxmlFile.toString)
		}
		return navigatorMap
	}
	


	def static void main(String[] args) {
		
		// Delete all generated files
		val directory = new File(Constants.PROJECT_DIR  + Constants.SUB_PROJECT_NAME)
		for (File fileEntry : directory.listFiles()) {
			if (!fileEntry.isDirectory()) {
				if (fileEntry.name.endsWith(".ecore")) {
					if (!fileEntry.delete) println("Error: Failed to delete generated file " + fileEntry.name + " in " + directory)
				} 
				if (fileEntry.name.endsWith(".xmi")) {
					if (!fileEntry.delete) println("Error: Failed to delete generated file " + fileEntry.name + " in " + directory)
				}
				if (fileEntry.name.endsWith(".screendecorator")) {
					if (!fileEntry.delete) println("Error: Failed to delete generated file " + fileEntry.name + " in " + directory)
				}
			}
		}
		
		// Create a resource set and populate it with all relevant files.
		// This eliminates different instances of the same files.
		val resourceSetHandler = ResourceSetHandler.instance
		val resSet = resourceSetHandler.resourceSet
		
		// Traverse the decorators and build a map from WireframeSketcher widgets to widget decorators 
		val decoratorMap = resourceSetHandler.decoratorMap
			
		// Generate FXML for the screen files
		println("- - - - - - - - - -\n- Generating FXML -\n- - - - - - - - - -")
		val fxmlGenerator = new Generator(null, decoratorMap)
		
		val decoratorGenerator = ScreenDecoratorGenerator.instance
		for (i : 0 ..< resSet.resources.size) {
			resSet.resources.get(i).contents.filter(Screen).forEach [
				val path = EcoreUtil.getURI(it).path
				val screenFileLocation = Constants.PROJECT_DIR + Constants.SUB_PROJECT_NAME
				// Ignore screen files in other folders (like assets)
				if (path.startsWith(screenFileLocation)) {
					val name = FilenameUtils.getBaseName(path)
					println("Generating Data model for " + name)

					fxmlGenerator.buildMasterMapForScreen(it)
					it.widgets.filter(Master).forEach [
						val modelType = decoratorGenerator.getMasterType(it)
						if (modelType == DecoratorModelType.DATA) {
							decoratorGenerator.generateForMasterUsingMasterMap(it, fxmlGenerator.masterMap)
						}
					]
				}
			]
		}
		// Generate the FXML elements for this screen file 
		for (i : 0..< resSet.resources.size){
			resSet.resources.get(i).contents.filter(Screen).forEach[
				val path = EcoreUtil.getURI(it).path
				val screenFileLocation = Constants.PROJECT_DIR  + Constants.SUB_PROJECT_NAME
				// Ignore screen files in other folders (like assets)
				if (path.startsWith(screenFileLocation)){
					val name = FilenameUtils.getBaseName(path) 
					println("Generating FXML for " + name)
					
					fxmlGenerator.generate(it, name)
				} 
			]
			
		}
	}
}



