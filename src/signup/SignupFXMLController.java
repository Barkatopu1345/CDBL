/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.io.FileWriter;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SignupFXMLController implements Initializable {

    @FXML
    private TextField nidTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passTextField;
    @FXML
    private TextField nameTextField;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
      public void changeSceneToSignupPageFromCongratulations(ActionEvent event) throws IOException {
            try {
            Parent guestUser;
            try (FileWriter fw = new FileWriter("ApplicationFormForInvestormember.txt",true)) {
                String str = nameTextField.getText() + "," + nidTextField.getText() + ","+emailTextField.getText()+","
                        + passTextField.getText() + "\n";
                
                fw.write(str);
                fw.close();
                guestUser = FXMLLoader.load(getClass().getResource("/signup/congratulationsFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);

            Stage window  = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Congratulations!");
            window.setScene(guestUserScene);
            window.show();
            fw.close();
            }
            
        } catch (IOException ex) {
            System.out.println("Error");
        }
        }  
      @FXML
      public void changeSceneToSignupPageFromHomePage(ActionEvent event) throws IOException {
            Parent guestUser = FXMLLoader.load(getClass().getResource("/mainpackage/logIn.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            guestUserScene.getStylesheets().add("/signup/signupfxml.css");
            Stage window  = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("CDBL");
            window.setScene(guestUserScene);
            window.show();
        }
    
}
