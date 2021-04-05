/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import classes.Investor;
import classes.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ForgetPasswordFXMLController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    
    Investor investor;
    @FXML
    private TextField passwordFiled;
    @FXML
    private TextField typeFiield;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void buttonClickOnToForgetPassword(ActionEvent event) throws IOException {
            Parent guestUser = FXMLLoader.load(getClass().getResource("/mainpackage/logIn.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            guestUserScene.getStylesheets().add("/signup/signupfxml.css");
            Stage window  = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("CDBL");
            window.setScene(guestUserScene);
            window.show();
    
    }

    @FXML
    private void buttonOnClickToSubmit(ActionEvent event) {
                   try {
            Parent guestUser;
            try (FileWriter fw = new FileWriter("ForgetPasswordApplicantsList.txt",true)) {
                String str = id.getText()+","+passwordFiled.getText()+","+typeFiield.getText()+"\n";
                
                fw.write(str);
                fw.close();

            
            ButtonType yes = new ButtonType("OK");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("We have recieve your application. Please contact with admin.");
            alert.getButtonTypes().clear();
            alert.getButtonTypes().add(yes);
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get() == yes){
                alert.close();
            }
            }
            
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
    
         User idValidation() {
        User u = null;
        investor = null;
        String ID = id.getText().toString();
        
        
        //System.out.println(ID + "      " + pass);
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
         
  
        f = new File("investors.bin");

        if (f.exists()) { 
            try {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);

                try {
                    while (true) {

                        u = (User) ois.readObject();

                        String userID = u.getID();
                        String pass1 = u.getPassword();
                        //System.out.println(userID + "    " + pass1 + "  " + pass);
                        if (userID.equals(ID)) {
                            break;

                        }
                    }

                } catch (Exception e) {
                    u = null;
                }
            } catch (IOException ex) {
            } finally {
               
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex) {
                }
            }

        }
         
        return u;
    }
        class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException 
        {
            super(out);
        }
        @Override
        protected void writeStreamHeader() throws IOException {
        }
    }
    
}
