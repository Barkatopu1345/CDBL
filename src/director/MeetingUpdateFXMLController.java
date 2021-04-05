/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package director;

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
public class MeetingUpdateFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    public void changeFXMLButtonOnClicktoMeetingCreation(ActionEvent event) throws IOException{
        Parent create = FXMLLoader.load(getClass().getResource("/director/meetingCreationFXML.fxml"));
        Scene scene = new Scene(create);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Create a meeting");
        window.setScene(scene);
        window.show();
  
    }
    
        @FXML
        public void changeFXMLButtonOnCLickFromDirectorHomeToNoticeBoard(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/director/directorHomeFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Home page");
            window.setScene(guestUserScene);
            window.show();
        }
}
