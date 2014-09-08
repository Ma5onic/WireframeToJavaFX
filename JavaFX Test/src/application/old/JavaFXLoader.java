/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application.old;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Fredrik Haugen Larsen
 */
public class JavaFXLoader extends Application {


	@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
	
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	
    	String URL = "(o) Mann&#10;( ) Kvinne";
    	
    	
    	  BufferedReader br = new BufferedReader(new FileReader("/Users/f/Documents/Eclipse Workspaces/workspace/JavaFX Test/src/application/text"));
    	    try {
    	        StringBuilder sb = new StringBuilder();
    	        String line = br.readLine();

    	        while (line != null) {
    	            sb.append(line);
    	            sb.append(System.lineSeparator());
    	            line = br.readLine();
    	        }
    	        String everything = sb.toString();
    	        System.out.println(everything);
    	    } finally {
    	        br.close();
    	    }
    	
    	
		Pattern pattern = Pattern.compile("\\((\\s|o)\\) (\\w+)", Pattern.CASE_INSENSITIVE);
    	Matcher matcher = pattern.matcher(URL);
    	
    	while (matcher.find()) {
    		if (matcher.group(1).equals("o")){
    			System.out.println("This radio button is selected: " + matcher.group(0));
        	    System.out.println("The text of the button is: " + matcher.group(2)); 

    		}  else if (matcher.group(1).equals(" ")){
    			System.out.println("This radio button is deselected: " + matcher.group(0));
        	    System.out.println("The text of the button is: " + matcher.group(2)); 
    		}

    	} 
    	
       // launch(args);
        
    }
    
 
    
}
