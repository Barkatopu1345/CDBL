/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investor;

import classes.Investor;
import classes.User;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author barka
 */
public class InvestorFXMLController implements Initializable {

    Investor iv = null;
    @FXML
    private Label label;
    @FXML
    private Button loadButton;
    public void passData(User u){
        iv = (Investor) u;
           System.out.println(u.getName());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }  

    @FXML
    
    public void changeFXMLButtonOnCLickFromInvestoToComplain(ActionEvent event) throws IOException{
        Parent guestUser = FXMLLoader.load(getClass().getResource("/investor/complainFXML.fxml"));
        Scene guestUserScene = new Scene(guestUser);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("complain.");
        window.setScene(guestUserScene);
        window.show();
    }
    @FXML
        public void changeFXMLButtonOnCLickFromInvestoToLogin(ActionEvent event) throws IOException{
            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Do you want to logout?");
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(yes,no);
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get() == null){
                System.out.println("Error 404");
            }
            else{
            
            
            Parent guestUser = FXMLLoader.load(getClass().getResource("/mainpackage/logIn.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Home page.");
            window.setScene(guestUserScene);
            window.show();
            }
        }
    @FXML
    
            public void    changeFXMLButtonOnCLickFromInvestoChangeDps(ActionEvent event) throws IOException{
                Parent guestUser = FXMLLoader.load(getClass().getResource("/investor/changeDpsFXML.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Home page.");
                window.setScene(guestUserScene);
                window.show();
            }
    @FXML
            public void changeFXMLButtonOnCLickFromInvestoSellProducts(ActionEvent event) throws IOException{
                Parent guestUser = FXMLLoader.load(getClass().getResource("/investor/sellProductFXML.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Sell your product.");
                window.setScene(guestUserScene);
                window.show();
            }
    @FXML
    
    
            public void changeFXMLButtonOnCLickFromInvestoBuyProducts(ActionEvent event) throws IOException{
                Parent guestUser = FXMLLoader.load(getClass().getResource("/investor/buyProductFXML.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Buy new product.");
                window.setScene(guestUserScene);
                window.show();
            }
    @FXML
    
            public void changeFXMLButtonOnCLickFromInvestoDps(ActionEvent event) throws IOException{
                Parent guestUser = FXMLLoader.load(getClass().getResource("/dpsParticipant/dpsHomeFXML.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Home");
                window.setScene(guestUserScene);
                window.show();
            }    
            
    @FXML
            public void changeFXMLButtonOnCLickFromInvestoToDirectorHome(ActionEvent event) throws IOException{
                Parent guestUser = FXMLLoader.load(getClass().getResource("/director/directorHomeFXML.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Home");
                window.setScene(guestUserScene);
                window.show();
            }
            
        @FXML
            public void changeFXMLButtonOnCLickToHRHome(ActionEvent event) throws IOException{
                Parent guestUser = FXMLLoader.load(getClass().getResource("/humanResource/humanResourceHomeFXML.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Home");
                window.setScene(guestUserScene);
                window.show();
            }


            @FXML
            private void buttonClickOnToSeeMarketStatus(ActionEvent event) throws IOException {
                Parent guestUser = FXMLLoader.load(getClass().getResource("/mainpackage/pieChart.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("Home");
                window.setScene(guestUserScene);
                window.show();
            }




            
}
