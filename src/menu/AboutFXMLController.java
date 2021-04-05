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
import javafx.fxml.FXML;
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
public class AboutFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
            public void changeSceneToAboutUs(ActionEvent event) throws IOException{
             Parent guestUser;
             guestUser = FXMLLoader.load(getClass().getResource("/guestpkg/guestFXML.fxml"));
             Scene guestUserScene = new Scene(guestUser);

             Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
             window.setTitle("Login as a guest");
             window.setScene(guestUserScene);
             window.show();
          }
}
