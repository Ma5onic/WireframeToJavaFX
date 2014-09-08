/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application.old;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//import java.net.URI;

/**
 * 
 * @author f
 */
public class FXMLDocumentController extends Application {

	@FXML
	private Parent root;

	public Parent getRoot() {
		return root;
	}

	public void setRoot(Parent newRoot) {
		root = newRoot;
	}

	
	@Override
	public void start(Stage stage) throws MalformedURLException, IOException {

		String fileName = "Start.fxml";
		// String fileName = "screen3.fxml";
		try {
			String filePath = "src/application/" + fileName;
			if (Paths.get(filePath).toFile().exists()) {
				// root = FXMLLoader.load(Paths.get(filePath).toUri().toURL());

				FXMLLoader loader = new FXMLLoader();
				URL location = Paths.get(filePath).toUri().toURL();
				loader.setLocation(location);
				//loader.setController(new ScreenNavigatorController());
				root = (Parent) loader.load();

			} else {
				throw new FileNotFoundException();
			}

		} catch (FileNotFoundException e) {

			System.out.println("No such file '" + fileName
					+ "'. Did you forget to run the generator?");
			return;
		}

		
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		// Works in run time
		// Node n = getNodeByRowColumnIndex(1, 1,
		// ((GridPane) scene.lookup("#gridPane1")));
		// if (n != null) {
		// // Den er ikke tom
		// System.out.println(n);
		// } else {
		// // den er tom
		// }

	}

	// Get the node from the grid position in run time
	public Node getNodeByRowColumnIndex(final int row, final int column,
			GridPane gridPane) {
		Node result = null;
		ObservableList<Node> childrens = gridPane.getChildren();
		for (Node node : childrens) {
			if (GridPane.getRowIndex(node) == row
					&& GridPane.getColumnIndex(node) == column) {
				result = node;
				break;
			}
		}
		return result;
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
	public static void main(String[] args) {

		launch(args);

	}

}
