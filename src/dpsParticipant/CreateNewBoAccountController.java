/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpsParticipant;

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
public class CreateNewBoAccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
          public void changeSceneTocongratulationsPageFromSignupPage(ActionEvent event) throws IOException {
            Parent guestUser = FXMLLoader.load(getClass().getResource("/signup/congratulationsFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            guestUserScene.getStylesheets().add("/signup/signupfxml.css");
            Stage window  = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Congratulations!");
            window.setScene(guestUserScene);
            window.show();
      }
    
}
