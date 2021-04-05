/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import classes.Investor;
import classes.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ListOfInvestorsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label listOfaccount;
    Investor investor;
    @FXML
    private Label listOfaccount1;
    @FXML
    private Label listOfaccount2;
    @FXML
    private TextArea text;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String str="";
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        f = new File("investors.bin");
        if (!f.exists()) {
            

        } else {
            try {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User u;
                try {
                    while (true) {

                        investor = (Investor) ois.readObject();
                        
                            str += "Name: "+investor.getName()+" ID: "+investor.getID()+ "NID: " + investor.getNid() + " Email: " 
                                    + investor.getEmail()+" Password:"+ investor.getPassword()+"\n" ; 
                            
                        
                    }
                } catch (Exception e) {  }
            } catch (IOException ex) { } 
            finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex) {
                }
            }
        }
        text.setText(str);
    }    

    @FXML
    private void buttonClickOnToAdminHome(MouseEvent event) throws IOException {
            Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/adminHomeFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Home");
            window.setScene(guestUserScene);
            window.show();
    }
    
}
