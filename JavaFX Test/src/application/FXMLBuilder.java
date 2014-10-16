package application;

import generator.LayoutStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

public class FXMLBuilder {

	public static final int DEFAULT_PANE_WIDTH = 50;
	public static final int DEFAULT_PANE_HEIGHT = 50;
	Document doc;
	Element rootElement;

	Element children;
	int paneWidth;
	int paneHeight;
	LayoutStyle layoutType;

	public Element getRootElement() {
		return rootElement;
	}

	public LayoutStyle getLayoutType() {
		return layoutType;
	}

	public void setLayoutType(LayoutStyle newLayoutType) {
		layoutType = newLayoutType;
	}

	public int getPaneWidth() {
		return paneWidth;
	}

	public int getPaneHeight() {
		return paneHeight;
	}

	public void setPaneWidth(int newPaneWidth) {
		paneWidth = newPaneWidth;
		updatePaneWidth(paneWidth);
	}

	public void setPaneHeight(int newPaneHeight) {
		paneHeight = newPaneHeight;
		updatePaneHeight(paneHeight);
	}

	private void updatePaneHeight(int height) {
		if (null != rootElement && height > 0) {
			rootElement.setAttribute("minHeight", "" + height);
		}
	}

	private void updatePaneWidth(int width) {
		if (null != rootElement && width > 0) {
			rootElement.setAttribute("minWidth", "" + width);
		}

	}

	public Element createElement(String elementName) {
		return doc.createElement(elementName);
	}

	public Element operator_add(String elementName) {
		Element element = createElement(elementName);
		children.appendChild(element);
		return element;
	}

	// /** Creates a new XMLBuilder object with a 100x100 default pane size */
	// public XMLBuilder() throws ParserConfigurationException {
	// this(100, 100, "AnchorPane");
	// }

	/**
	 * The XMLBuilder constructor builds an FXML file with the required
	 * processing instructions and the Pane element. Document doc is set.
	 * 
	 * @param newPaneHeigth
	 *            The height of the pane
	 * @param newPaneWidth
	 *            The width of the pane
	 **/
	@SuppressWarnings("unused")
	public FXMLBuilder(int newPaneHeight, int newPaneWidth, LayoutStyle layout)
			throws ParserConfigurationException {

		paneHeight = newPaneHeight;
		paneWidth = newPaneWidth;
		layoutType = layout;

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		doc = docBuilder.newDocument();

		// Should be true
		doc.setXmlStandalone(true);

		// TODO Find a better way of selecting what is to be imported

		ProcessingInstruction import1 = doc.createProcessingInstruction(
				"import", "java.lang.*");
		ProcessingInstruction import2 = doc.createProcessingInstruction(
				"import", " javafx.scene.control.*");
		ProcessingInstruction import3 = doc.createProcessingInstruction(
				"import", "javafx.scene.layout.*");
		ProcessingInstruction import4 = doc.createProcessingInstruction(
				"import", "javafx.scene.text.*");
		ProcessingInstruction import5 = doc.createProcessingInstruction(
				"import", "javafx.scene.image.*");
		ProcessingInstruction import6 = doc.createProcessingInstruction(
				"import", "javafx.geometry.*");
		// ProcessingInstruction import7 = doc.createProcessingInstruction(
		// "import", "javafx.geometry.Insets");

		doc.appendChild(import1);
		doc.appendChild(import2);
		doc.appendChild(import3);
		doc.appendChild(import4);
		doc.appendChild(import5);
		doc.appendChild(import6);
		// doc.appendChild(import7);

		if (layoutType == LayoutStyle.AnchorPane) {
			/* Using AnchorPane with explicit coordinates */
			rootElement = doc.createElement("AnchorPane");
			rootElement.setAttribute("id", "screenPane"); 
			rootElement.setAttribute("maxHeight", "-Infinity");
			rootElement.setAttribute("maxWidth", "-Infinity");
			rootElement.setAttribute("minHeight", "-Infinity");
			rootElement.setAttribute("minWidth", "-Infinity");
			rootElement.setAttribute("minHeight",
					Integer.toString(newPaneHeight));
			rootElement.setAttribute("minWidth",
					Integer.toString(newPaneWidth));
			rootElement.setAttribute("xmlns", "http://javafx.com/javafx/8");
			rootElement.setAttribute("xmlns:fx", "http://javafx.com/fxml/1");
//			rootElement.setAttribute("fx:controller",
//					"application.FXMLDocumentController");

		} else if (layoutType == LayoutStyle.GridPane) {

			rootElement = doc.createElement("GridPane");
			rootElement.setAttribute("id", "screenPane"); 
			// rootElement.setAttribute("alignment", "center");
			rootElement.setAttribute("hgap", "0");
			rootElement.setAttribute("vgap", "0");
			rootElement.setAttribute("xmlns", "http://javafx.com/javafx/8");
			rootElement.setAttribute("xmlns:fx", "http://javafx.com/fxml/1");
			// rootElement.setAttribute("fx:controller",
			// "application.ScreenNavigatorController");

			// If these values are not default, there are guides in place
			// and no reason to add padding
			if (newPaneWidth == DEFAULT_PANE_WIDTH
					|| newPaneHeight == DEFAULT_PANE_HEIGHT) {

				// Create some padding
				Element padding = doc.createElement("padding");
				rootElement.appendChild(padding);
				Element insets = doc.createElement("Insets");
				insets.setAttribute("top", "25");
				insets.setAttribute("right", "25");
				insets.setAttribute("bottom", "25");
				insets.setAttribute("left", "25");
				padding.appendChild(insets);
			}

			// For debugging enable grid lines
			if (Constants.enableDebugLines == true){
				rootElement.setAttribute("gridLinesVisible", "true");
			}
		}

		doc.appendChild(rootElement);

		// Populate with Label, TextField etc
		children = doc.createElement("children");
		rootElement.appendChild(children);

		

	}

	/** 
	 * Saves the FXML data as the given <em>filename</em>. <em>directory</em> must be a full path eg. to a JavaFX project.
	 * @param filename
	 * 			The name of the file
	 * @param directory
	 * 			The full path of the directory */
	public void save(String directory, String filename) throws FileNotFoundException,
			UnsupportedEncodingException, TransformerException {
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();

		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
		transformer.setOutputProperty(
				"{http://xml.apache.org/xslt}indent-amount", "4");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

		DOMSource source = new DOMSource(doc);
		File fxmlFile = new File(directory + filename); 
		OutputStream outputStream = null;
		outputStream = new FileOutputStream(fxmlFile);

		StreamResult result = new StreamResult(new OutputStreamWriter(
				outputStream, "UTF-8"));

		transformer.transform(source, result);

		//System.out.println("XMLBuilder Done");

	}

	public static void main(String[] args) throws UnsupportedEncodingException,
			FileNotFoundException {

		System.out.println("Warning: Run from generator");

	}

}
