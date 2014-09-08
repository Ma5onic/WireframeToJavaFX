//package generator
//
//import application.FXMLBuilder
//import application.AppController
//import application.InvalidLayoutException
//import com.wireframesketcher.model.Button
//import com.wireframesketcher.model.Checkbox
//import com.wireframesketcher.model.Image
//import com.wireframesketcher.model.Label
//import com.wireframesketcher.model.List
//import com.wireframesketcher.model.ModelPackage
//import com.wireframesketcher.model.Screen
//import com.wireframesketcher.model.TextField
//import com.wireframesketcher.model.Widget
//import java.util.HashMap
//import java.util.SortedMap
//import java.util.regex.Pattern
//import javafx.scene.text.Font
//import javafx.scene.text.FontPosture
//import javafx.scene.text.FontWeight
//import javafx.scene.text.Text
//import org.eclipse.emf.common.util.URI
//import org.eclipse.emf.ecore.EPackage
//import org.eclipse.emf.ecore.resource.Resource
//import org.eclipse.emf.ecore.resource.ResourceSet
//import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
//import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
//import org.w3c.dom.Element
//
///**
// * Retrieves the EMF model data and generates a corresponding FXML file.
// * @author Fredrik Haugen Larsen
// */
//class Generator {
//
//	/** The XMLBuilder class saves FXML data to a specified file.
//	 *  After calling the constructor, and one or more createType methods,
//	 *  the save method must be called in order to save the FXML file.   
//	 */
//	extension FXMLBuilder builder
//
//
//	String fontFace
//	boolean shouldCreateToggleGroup = true
//	int fontSize
//	
//
//	AppController appController
//	// Temp. defaults
//	public final static int PADDING_SIZE = 100;
//
//	SortedMap<Integer, Pair<Boolean, Boolean>> columns
//	SortedMap<Integer, Pair<Boolean, Boolean>> rows
//
//	private HashMap<Integer, String> navigatorMap
//	int navigatorId
//	
//	def HashMap<Integer, String> getNavigatorMap(){
//		return navigatorMap
//	}
//
//	new(AppController appController){
//		this.appController = appController
//	}
//	
//	/** Used to assess what layout style should be used 
//	 * @return A string with the layout style. E.g <em>GridPane</em>*/
//	def String assessLayoutStyle(Screen screen) {
//
//		/* Hard coded so far */
//		//		return "AnchorPane"
//		return "GridPane"
//	}
//
//	/** Adds a new element unless it is a duplicate */
//	def <K> void addNew(SortedMap<K, Pair<Boolean, Boolean>> col, K key, Pair<Boolean, Boolean> value) {
//		col.put(key, col.get(key) + value);
//	}
//
//	def static <T> int indexOf(Iterable<T> iterable, T value) {
//		var i = 0
//		for (T ignore : iterable) {
//			if (ignore == value) {
//				return i
//			}
//			i = i + 1
//		}
//		return -1
//	}
//
//	def void initBuilder(Screen screen) {
//			// Assess what layout style should be used
//		var layoutStyle = assessLayoutStyle(screen)
//
//		// The grid must have been generated first
//		// Set up XML
//		builder = new FXMLBuilder(50, 50, layoutStyle)
//	}
//	/* ************* Grid system ********************************************* */
//	/**	Generates the grid structure in case of GridPane
//	* @param screen The screen that is to be generated*/
//	def void generateGrid(Screen screen, String fileName) {
//
//		// Initialize the FXML builder
//		initBuilder(screen) 
//
//		columns = <Integer, Pair<Boolean, Boolean>>newTreeMap([i1, i2|i1 - i2], 0 -> null)
//		rows = <Integer, Pair<Boolean, Boolean>>newTreeMap([i1, i2|i1 - i2], 0 -> null)
//
//		for (widget : screen.widgets) {
//			addNew(columns, widget.x, true -> false)
//			addNew(columns, widget.x + widget.measuredWidth, false -> true)
//			addNew(rows, widget.y, true -> false)
//			addNew(rows, widget.y + widget.measuredHeight, false -> true)
//
//		}
//
//		(builder.getRootElement += "columnConstraints" ) => [
//			var previous = -1
//			for (column : columns.keySet) {
//				var minWidth = -1
//				if (previous < 0) {
//					previous = column
//				} else {
//					val previousPair = columns.get(previous)
//					if (previousPair != null && (columns.get(previous).key || columns.get(column).value)) {
//
//						//					(builder.rootElement += "columnConstraints" ) => [
//						(it += "ColumnConstraints" ) => [
//							//it += "percentWidth" -> "100"
//						]
//
//					//					]
//					} else {
//						minWidth = column - previous
//						val width = minWidth;
//						(it += "ColumnConstraints" ) => [
//							it += "minWidth" -> width + ""
//						]
//					}
////					println(previous + " - " + column + " " + minWidth)
//
//				}
//				minWidth = -1
//				previous = column
//			}
//		]
//		(builder.getRootElement += "rowConstraints" ) => [
//			var previous = -1
//			for (row : rows.keySet) {
//				var minHeight = -1
//				if (previous < 0) {
//					previous = row
//				} else {
//					val previousPair = rows.get(previous)
//					if (previousPair != null && (rows.get(previous).key || rows.get(row).value)) {
//						(it += "RowConstraints" ) => [
//							//it += "percentWidth" -> "100"
//						]
//					} else {
//						minHeight = row - previous
//						val height = minHeight;
//						(it += "RowConstraints" ) => [
//							it += "minHeight" -> height + ""
//						]
//					}
//				}
//				minHeight = -1
//				previous = row
//			}
//		]
//		// Generate the file 
//		//generate(screen,  fileName)
//	}
//
//	/* ************* End Grid system ***************************************** */
//	/**	Generates the different screens 
//	* @param screen The screen that is to be generated*/
//	def void generate(Screen screen, String fileName) {
//
//		generateWithoutSave(screen, fileName)
//		
//		//generate(screen.widgets.get(1)) 
//		// save xml
//		if (fileName == null || fileName == "") {
//			save("untitled.fxml")
//			println("Saved file as untitled.fxml")
//		} else {
//			save(fileName + ".fxml")
//			println("Saved file as " + fileName + ".fxml")
//		}
//		
//		// Reset for next generator
//		shouldCreateToggleGroup = true
//	}
//
//	/**	Generates the different screens 
//	* @param screen The screen that is to be generated*/
//	def void generateWithoutSave(Screen screen, String fileName) {
// 		
// 		
//		initBuilder(screen)
//		generateGrid(screen, fileName)
//		
//		if (builder.getLayoutType == "GridPane") {
//			if (columns == null || rows == null) {
//				throw new InvalidLayoutException(
//					"Column and/or row data is null. 
//							Did you remember to run the grid layout generator?");
//			}
//		}
//		
//		
//	
//
//		// Maps the button id to the screen name it refers to
//		navigatorMap = <Integer, String>newHashMap()
//
//		// The font face is set globally per screen
//		if (null == screen.font || null == screen.font.name) {
//			fontFace = "System"
//		} else {
//			fontFace = screen.font.name.replaceAll("\\s", "")
//		}
//
//		// Add for each
//	
//		
//		screen.widgets.forEach[generateFxml(it)]
//
//		// update the navigatorMap for the application controller
//		appController.setNavigatorMap(navigatorMap)	
//		
//		// Reset the button id 
//		navigatorId = 0
//	}
//
//
//	/**	Generates the different widget types 
//	 * @param widget The widget that is to be generated*/
//	def dispatch void generateFxml(Widget widget) {
//	}
//
//	def static operator_plus(Pair<Boolean, Boolean> p1, Pair<Boolean, Boolean> p2) {
//		(p1 != null && p1.key || p2 != null && p2.key) -> (p1 != null && p1.value || p2 != null && p2.value)
//	}
//
//	/** CheckBox */
//	def dispatch void generateFxml(Button widget) {
//
//		if (builder.getLayoutType == "AnchorPane") {
//
//			val screen = widget.link.trimFileExtension
//			navigatorMap.put(navigatorId, screen.toString);
//
//			(builder += "Button" ) => [
//				it += "text" -> widget.text
//				it += "layoutX" -> widget.x
//				it += "layoutY" -> widget.y
//				it += "id" -> navigatorId
//				it += "onAction" -> "#handleButtonAction" + navigatorId
//			]
//			navigatorId = navigatorId + 1
//
//			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
//				if (widget.measuredHeight > widget.measuredWidth)
//					widget.measuredHeight
//				else
//					widget.measuredWidth)
//
//		} else if (builder.getLayoutType == "GridPane") {
//
//
//			val screen = widget.link.trimFileExtension
//			navigatorMap.put(navigatorId, screen.toString);
//
//			val col1 = columns.keySet.indexOf(widget.x)
//			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
//			val colSpan = col2 - col1
//
//			val row1 = rows.keySet.indexOf(widget.y)
//			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
//			val rowSpan = row2 - row1;
//
//			(builder += "Button" ) => [
//				it += "text" -> widget.text
//				it += "onAction" -> "#handleButtonAction"
//				it += "id" -> navigatorId 
//				it += "GridPane.columnIndex" -> col1
//				it += "GridPane.rowIndex" -> row1
//				it += "GridPane.columnSpan" -> colSpan
//				it += "GridPane.rowSpan" -> rowSpan
//			]
//			navigatorId = navigatorId + 1
//
//		}
//
//	} // end Button
//
//	/** CheckBox */
//	def dispatch void generateFxml(Checkbox widget) {
//
//		if (builder.getLayoutType == "AnchorPane") {
//
//			(builder += "CheckBox" ) => [
//				it += "layoutX" -> widget.x
//				it += "layoutY" -> widget.y
//				it += "text" -> widget.text
//				it += "selected" -> if(widget.selected) "yes" else "no"
//			]
//
//			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
//				if (widget.measuredHeight > widget.measuredWidth)
//					widget.measuredHeight
//				else
//					widget.measuredWidth)
//
//		} else if (builder.getLayoutType == "GridPane") {
//
//			val col1 = columns.keySet.indexOf(widget.x)
//			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
//			val colSpan = col2 - col1
//
//			val row1 = rows.keySet.indexOf(widget.y)
//			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
//			val rowSpan = row2 - row1;
//
//			(builder += "CheckBox" ) => [
//				it += "text" -> widget.text
//				it += "selected" -> if(widget.selected) "yes" else "no"
//				it += "GridPane.columnIndex" -> col1
//				it += "GridPane.rowIndex" -> row1
//				it += "GridPane.columnSpan" -> colSpan
//				it += "GridPane.rowSpan" -> rowSpan
//			]
//		}
//
//	} // end Checkbox
//
//	def dispatch void generateFxml(Image widget) {
//
//		/** Image */
//		// finn resource mappa til Start.screen sånn at man kan bruke "src" til å hente ut den samme bildefila
//		//println(widget.src)
//		val path = widget.src.path
//		val index = path.lastIndexOf("/");
//		val fileName = path.substring(index + 1);
//
//		if (builder.getLayoutType == "AnchorPane") {
//
//			(builder += "ImageView" ) => [
//				it += "layoutX" -> widget.x
//				it += "layoutY" -> widget.y
//				if(widget.rotation != null) it += "rotate" -> widget.rotation;
//				if(widget.HFlip) it += "scaleX" -> "-1"
//				if(widget.VFlip) it += "scaleY" -> "-1"
//				it += "fitHeight" -> widget.measuredHeight
//				it += "fitWidth" -> widget.measuredWidth;
//				(it += "image" ) => [
//					(it += "Image") => [
//						it += "url" -> "@" + fileName
//					]
//				]
//			]
//
//			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
//				if (widget.measuredHeight > widget.measuredWidth)
//					widget.measuredHeight
//				else
//					widget.measuredWidth)
//
//		} else if (builder.getLayoutType == "GridPane") {
//
//			val col1 = columns.keySet.indexOf(widget.x)
//			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
//			val colSpan = col2 - col1
//
//			val row1 = rows.keySet.indexOf(widget.y)
//			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
//			val rowSpan = row2 - row1;
//
//			(builder += "ImageView" ) => [
//				it += "GridPane.columnIndex" -> col1
//				it += "GridPane.rowIndex" -> row1
//				it += "GridPane.columnSpan" -> colSpan
//				it += "GridPane.rowSpan" -> rowSpan;
//				(it += "image" ) => [
//					(it += "Image") => [
//						it += "url" -> "@" + fileName
//					]
//				]
//			]
//
//		}
//
//	} // end Image
//
//	/** Label */
//	def dispatch void generateFxml(Label widget) {
//
//		// If font size is null assume 12 
//		fontSize = 12;
//		if (null != widget.font.size) {
//			fontSize = widget.font.size.size;
//		}
//
//		/** In order to get correct font names for the various weights (bold, semi-bold, 
//		 * thin etc) and postures (italic, regular) we create an intermediate font variable using
//		 * the screen's font face and then get the correct full name from it. */
//		val fontBuilder = new Text
//
//		fontBuilder.setFont(
//			Font.font(
//				fontFace,
//				if (widget.font.bold != null && widget.font.bold)
//					FontWeight.BOLD
//				else
//					FontWeight.NORMAL,
//				if (widget.font.italic != null && widget.font.italic)
//					FontPosture.ITALIC
//				else
//					FontPosture.REGULAR,
//				fontSize
//			))
//
//		if (builder.getLayoutType == "AnchorPane") {
//
//			(builder += "Label") => [
//				it += "layoutX" -> widget.x
//				it += "layoutY" -> widget.y
//				if(widget.foreground != null) it += "textFill" -> widget.foreground
//				if(widget.rotation != null) it += "rotate" -> widget.rotation
//				it += "text" -> widget.text;
//				(it += "font") => [
//					(it += "Font") => [
//						it += "name" -> fontBuilder.font.name
//						it += "size" -> fontSize
//					]
//				]
//			]
//			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
//				if (widget.measuredHeight > widget.measuredWidth)
//					widget.measuredHeight
//				else
//					widget.measuredWidth)
//
//		} else if (builder.getLayoutType == "GridPane") {
//			
//			
//
//			val col1 = columns.keySet.indexOf(widget.x)
//			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
//			val colSpan = col2 - col1
//
//			val row1 = rows.keySet.indexOf(widget.y)
//			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
//			val rowSpan = row2 - row1;
//
//			(builder += "Label") => [
//				it += "GridPane.columnIndex" -> col1
//				it += "GridPane.rowIndex" -> row1
//				it += "GridPane.columnSpan" -> colSpan
//				it += "GridPane.rowSpan" -> rowSpan
//				if(widget.foreground != null) it += "textFill" -> widget.foreground
//				if(widget.rotation != null) it += "rotate" -> widget.rotation
//				it += "text" -> widget.text;
//				(it += "font") => [
//					(it += "Font") => [
//						it += "name" -> fontBuilder.font.name
//						it += "size" -> fontSize
//					]
//				]
//			]
//
//		}
//
//	// spør omg i++ og om felt i lambda-uttrykk
//	} // end Label
//
//	/** Textfield */
//	def dispatch void generateFxml(TextField widget) {
//
//		if (builder.getLayoutType == "AnchorPane") {
//
//			(builder += "TextField") => [
//				it += "layoutX" -> widget.x
//				it += "layoutY" -> widget.y
//				it += "text" -> widget.text
//				it += "fx:id" -> "textField0" // dev test
//			]
//			checkPaneDimensionsAndExpandForXY(widget.x + widget.measuredWidth, widget.y + widget.measuredHeight,
//				if (widget.measuredHeight > widget.measuredWidth)
//					widget.measuredHeight
//				else
//					widget.measuredWidth)
//
//		} else if (builder.getLayoutType == "GridPane") {
//
//			val col1 = columns.keySet.indexOf(widget.x)
//			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
//			val colSpan = col2 - col1
//
//			val row1 = rows.keySet.indexOf(widget.y)
//			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
//			val rowSpan = row2 - row1;
//
//			(builder += "TextField") => [
//				it += "text" -> widget.text
//				it += "fx:id" -> "textField0" // dev test
//				it += "GridPane.columnIndex" -> col1
//				it += "GridPane.rowIndex" -> row1
//				it += "GridPane.columnSpan" -> colSpan
//				it += "GridPane.rowSpan" -> rowSpan
//			]
//
//		}
//
//	} // end TextField
//
//	def dispatch void generateFxml(List widget) {
//
//		// TODO Tolke radiobutton fra andre "List" items
//		// List Items
//		(builder += "VBox" ) => [ vbox |
//			val col1 = columns.keySet.indexOf(widget.x)
//			val col2 = columns.keySet.indexOf(widget.x + widget.measuredWidth)
//			val colSpan = col2 - col1
//			val row1 = rows.keySet.indexOf(widget.y)
//			val row2 = rows.keySet.indexOf(widget.y + widget.measuredHeight)
//			val rowSpan = row2 - row1;
//			vbox += "GridPane.columnIndex" -> col1
//			vbox += "GridPane.rowIndex" -> row1
//			vbox += "GridPane.columnSpan" -> colSpan
//			vbox += "GridPane.rowSpan" -> rowSpan;
//			widget.items.forEach [ item |
//				/* 
//				 * 
//				 * A	N	C	H	O	R		L	A	Y	O	U	T
//				 * 
//				 * */
//				if (builder.getLayoutType == "AnchorPane") {
//
//					(builder += "RadioButton" ) => [ radioButton |
//						// The regex pattern
//						var string = "\\((\\s|o)\\) (\\w+)"
//						var pattern = Pattern.compile(string, Pattern.CASE_INSENSITIVE);
//						var matcher = pattern.matcher(item.text);
//						if (matcher.find()) {
//
//							// The wiki format (o) means selected
//							if (matcher.group(1).equals("o")) {
//
//								radioButton += "selected" -> "true"
//								radioButton += "text" -> matcher.group(2)
//
//							// The wiki format ( ) means deselected
//							} else if (matcher.group(1).equals(" ")) {
//
//								radioButton += "selected" -> "false"
//								radioButton += "text" -> matcher.group(2)
//							}
//
//						} else {
//
//							// TODO This should be changed later
//							println("Syntax error, or this is not a radio button!")
//						}
//						// Should only create the ToggleGroup for the first RadioButton
//						// then set the id for the toggleGroup attribute
//						if (shouldCreateToggleGroup) {
//							(radioButton += "toggleGroup") => [
//								(it += "ToggleGroup" ) => [
//									it += "fx:id" -> "radioGroup"
//								]
//							]
//							shouldCreateToggleGroup = false
//						} else {
//
//							// The toggle group has been created, so we append the group id
//							radioButton += "toggleGroup" -> "$radioGroup"
//						}
//						// The coordinate of the widget + the item coordinates
//						radioButton += "layoutX" -> widget.x + item.x
//						radioButton += "layoutY" -> widget.y + item.y
//						checkPaneDimensionsAndExpandForXY(widget.x + item.x + widget.measuredWidth,
//							widget.y + item.y + widget.measuredHeight,
//							if (widget.measuredHeight > widget.measuredWidth)
//								widget.measuredHeight
//							else
//								widget.measuredWidth)
//					]
//
//				/* 
//				 * 
//				 * G	R	I	D		L	A	Y	O	U	T
//				 * 
//				 * */
//				} else if (builder.getLayoutType == "GridPane") {
//
//					(vbox += "RadioButton" ) => [ radioButton |
//						// The regex pattern
//						var string = "\\((\\s|o)\\) (\\w+)"
//						var pattern = Pattern.compile(string, Pattern.CASE_INSENSITIVE);
//						var matcher = pattern.matcher(item.text);
//						if (matcher.find()) {
//
//							// The wiki format (o) means selected
//							if (matcher.group(1).equals("o")) {
//
//								radioButton += "selected" -> "true"
//								radioButton += "text" -> matcher.group(2)
//
//							// The wiki format ( ) means deselected
//							} else if (matcher.group(1).equals(" ")) {
//
//								radioButton += "selected" -> "false"
//								radioButton += "text" -> matcher.group(2)
//							}
//
//						} else {
//
//							// TODO This should be changed later
//							println("Syntax error, or this is not a radio button!")
//						}
//						// Should only create the ToggleGroup for the first RadioButton
//						// then set the id for the toggleGroup attribute thereafter
//						if (shouldCreateToggleGroup) {
//							(radioButton += "toggleGroup") => [
//								(it += "ToggleGroup" ) => [
//									it += "fx:id" -> "radioGroup"
//								]
//							]
//							shouldCreateToggleGroup = false
//						} else {
//
//							// The toggle group has been created, so we append the group id
//							radioButton += "toggleGroup" -> "$radioGroup"
//						}
//					]
//
//				}
//			]
//		]
//	} // end List, RadioButton
//
//	/** Checks if the input coordinates are equal or larger than the pane dimensions.
//	 * If that is the case the pane is expanded by <code>(x - paneWidth) + paneWidth + padding</code> 
//	 * @param x The x coordinate of the item 
//	 * @param y The y coordinate of the item
//	 * @param padding The extra padding   
//	 * */
//	def checkPaneDimensionsAndExpandForXY(int x, int y, int padding) {
//
//		val paddingN = 100
//		if (x >= builder.getPaneWidth) {
//			builder.paneWidth = (x - getPaneWidth) + getPaneWidth + paddingN // + 100
//
//		//			println("paneWidth updated to " + builder.paneWidth)
//		}
//		if (y >= builder.getPaneHeight) {
//			builder.paneHeight = (y - getPaneHeight) + getPaneHeight + paddingN // + 50
//
//		//			println("paneHeight updated to " + builder.paneHeight)
//		}
//
//	}
//
//	def Element operator_add(Element element, String elementName) {
//		val child = builder.createElement(elementName);
//		element.appendChild(child);
//		return child;
//	}
//
//	def operator_add(Element element, Pair<String, Object> attrValue) {
//		element.setAttribute(attrValue.key, String.valueOf(attrValue.value))
//	}
//
////	def static void main(String[] args) {
////		EPackage.Registry.INSTANCE.put("http://wireframesketcher.com/1.0/model.ecore", ModelPackage.eINSTANCE)
////		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("screen", new XMIResourceFactoryImpl())
////		val ResourceSet resSet = new ResourceSetImpl();
////
////		val fileName = "Start"
////
////		var res = resSet.getResource(
////			URI.createFileURI(
////				"/Users/f/Documents/Eclipse Workspaces/workspace/wireframing-tutorial/" + fileName + ".screen"), true)
////
////		val fxmlGenerator = new Generator()
////
////		// Generate the columns and row data for the grid
////		res.contents.filter(Screen).forEach[fxmlGenerator.generateGrid(it, fileName)]
////
////		// Generate the FXML elements 
////		res.contents.filter(Screen).forEach[fxmlGenerator.generate(it, fileName)]
////
////	}
//
//}
