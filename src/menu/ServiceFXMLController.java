/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author barka
 */
public class ServiceFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
  /***By pressing this function's button,we are changing scene guest scene to Services
 *  scene
 *   
     * @param event
     * @throws java.io.IOException
 */ 
    
        public void changeSceneToServices(ActionEvent event) throws IOException{
             Parent guestUser;
             guestUser = FXMLLoader.load(getClass().getResource("/gusetpkg/guestFXML.fxml"));
             Scene guestUserScene = new Scene(guestUser);

             Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
             window.setTitle("Our services");
             window.setScene(guestUserScene);
             window.show();
          }
    
}
