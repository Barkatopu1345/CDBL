/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author barka
 */
public class LatestStockPriceController implements Initializable {
    @FXML
    WebView view;
    WebEngine engine;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    public void google(ActionEvent event){
        engine.load("https://www.google.com/search?q=google+job+salary&rlz=1C1CHBF_enBD933BD933&oq=&aqs=chrome.0.35i39i362l8...8.60140028j0j15&sourceid=chrome&ie=UTF-8");
    }
        @FXML
        public void changeSceneToStok(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/guestpkg/guestFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Home.");
            window.setScene(guestUserScene);
            window.show();
        }
       

}
