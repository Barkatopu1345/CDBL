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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author barka
 */
public class BuyProductFXMLController implements Initializable {

    
    @FXML private ChoiceBox choicebox;
    @FXML private TableColumn<?, ?> choiceBoxLabel;
    /**
     * By this method choice box's label will be updated.
     */
    @FXML
    public void choiceBoxLabelUpdate(){
        choiceBoxLabel.setText(choicebox.getValue().toString());
    }
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        choicebox.getItems().add("ABCD");
        choicebox.getItems().add("EFGH");
        choicebox.getItems().add("IJKL");
    }    

    @FXML
    private void changeSceneFXMLButtonOnCLickFromBuyProductToInvestorHome(ActionEvent event) throws IOException {
         Parent guestUser = FXMLLoader.load(getClass().getResource("/investor/investorFXML.fxml"));
        Scene guestUserScene = new Scene(guestUser);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Home Page.");
        window.setScene(guestUserScene);
        window.show();
    }

    @FXML
    private void changeSceneToBuyProducts(MouseEvent event) {
    }

}
