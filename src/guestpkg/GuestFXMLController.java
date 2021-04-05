/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.event.ActionEvent; 
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author barka
 */
public class GuestFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
/**
 * 
 *By pressing this function's button,we are changing scene guest scene to about
 * us scene
 *   
     * @param event
     * @throws java.io.IOException
 */ 
    
    @FXML
        public void changeSceneToAboutUs(ActionEvent event) throws IOException{
             Parent guestUser;
             guestUser = FXMLLoader.load(getClass().getResource("/menu/aboutFXML.fxml"));
             Scene guestUserScene = new Scene(guestUser);

             Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
             window.setTitle("About CDBL");
             window.setScene(guestUserScene);
             window.show();
          }
        /**
 * 
 *By pressing this function's button,we are changing scene guest scene to about
 * us scene
 *   
     * @param event
     * @throws java.io.IOException
 */ 
    
    @FXML
        public void changeSceneToContactUs(ActionEvent event) throws IOException{
             Parent guestUser;
             guestUser = FXMLLoader.load(getClass().getResource("/menu/contactUsFXML.fxml"));
             Scene guestUserScene = new Scene(guestUser);

             Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
             window.setTitle("Contact information");
             window.setScene(guestUserScene);
             window.show();
          }
        /**
 * 
 * 
 * /**
 * 
 *By pressing this function's button,we are changing scene guest scene to Services
 *  scene
 *   
     * @param event
     * @throws java.io.IOException
 */ 
    
    @FXML
        public void changeSceneToServices(ActionEvent event) throws IOException{
             Parent guestUser;
             guestUser = FXMLLoader.load(getClass().getResource("/menu/serviceFXML.fxml"));
             Scene guestUserScene = new Scene(guestUser);

             Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
             window.setTitle("Our services");
             window.setScene(guestUserScene);
             window.show();
          }
        /**
         * 
 * 
 * /**
 * 
 *By pressing this function's button,we are changing scene guest scene to E-Services
 *  scene
 *   
     * @param event
     * @throws java.io.IOException
 */ 
    
    @FXML
        public void changeSceneToEServices(ActionEvent event) throws IOException{
             Parent guestUser;
             guestUser = FXMLLoader.load(getClass().getResource("/menu/eServiceFXML.fxml"));
             Scene guestUserScene = new Scene(guestUser);

             Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
             window.setTitle("Our E-services");
             window.setScene(guestUserScene);
             window.show();
          }
        /**
 *By pressing this function's button,we are changing scene guest scene to login
 * scene
 *   
     * @param event
     * @throws java.io.IOException
 */ 
    @FXML
        public void changeSceneToguestPage(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/mainpackage/logIn.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Welcome.");
            window.setScene(guestUserScene);
            window.show();
        }
    @FXML
        public void changeSceneToStok(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/guestpkg/latestStockPrice.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Hey");
            window.setScene(guestUserScene);
            window.show();
            
        }



}
