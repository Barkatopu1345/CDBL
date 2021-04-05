/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

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
public class AdminHomeFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

        @FXML
        public void changeFXMLButtonOnCLickToLogout(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/mainpackage/logIn.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Logout");
            window.setScene(guestUserScene);
            window.show();
        }   
        @FXML
        public void buttonClickOnForSignupAsInvestor(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/selectnewInvestorFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Logout");
            window.setScene(guestUserScene);
            window.show();
        }
        @FXML
        public void changeFXMLButtonOnCLickToNewDps(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/selectNewDps.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("DPs list");
            window.setScene(guestUserScene);
            window.show();
        }        
        @FXML
        public void changeFXMLButtonOnCLickToDeleteAccount(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/deleteAccountFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Account list");
            window.setScene(guestUserScene);
            window.show();
        }

    @FXML
    private void buttonCLickOnForViewListOfInvestor(ActionEvent event) throws IOException {
        Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/listOfInvestorFXML.fxml"));
        Scene guestUserScene = new Scene(guestUser);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(guestUserScene);
        window.show();
    }

    @FXML
    private void buttonCLickOnForViewForgetPasswordList(ActionEvent event) throws IOException {
        Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/forgetPasswordList.fxml"));
        Scene guestUserScene = new Scene(guestUser);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(guestUserScene);
        window.show();
    
    
    }

}
