/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investor;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author barka
 */
public class ChangeDpsFXMLController implements Initializable {

    @FXML private ComboBox comboBox;
    @FXML private Label comboLabel;
    
    /**
     * by this method combo box label will be updated 
     */
    
    @FXML
    public void comboBoxUpdated(){
        this.comboLabel.setText("DPs selected " + comboBox.getValue().toString());
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * These items are configuring the combo box.
         */
        comboBox.getItems().add("ABCD");
        comboBox.getItems().add("XYZ");
    }    
    @FXML
            public void changeSceneToHomePage(ActionEvent event) throws IOException{
                Parent guestUser = FXMLLoader.load(getClass().getResource("/investor/investorFXML.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Home page.");
                window.setScene(guestUserScene);
                window.show();
        }

}
