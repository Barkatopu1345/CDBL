/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;


import classes.Investor;
import classes.User;
import investor.InvestorFXMLController;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author barka
 */
public class LogInController implements Initializable {

    private Label username;
    @FXML
    private Button signup;
    @FXML
    private Button signup1;
    @FXML
    private TextField idTextField;
    @FXML
    private PasswordField passTextField;
    @FXML
    private Button signInButton;
    Investor investor;
    @FXML
    private Label label;
    @FXML
    private Button forgetButton;
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    


        @FXML
    private void logInUserOnClick(ActionEvent event) throws IOException {
        String s = idTextField.getText();
        
        User u = idValidation();
        //System.out.println(u.getName() + "    " + u.getPassword() + "  " + u.getID());
         if (idTextField.getText().toString().equals("1234")) // admin
         {
            if (passTextField.getText().equals("1345")) {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("/admin/adminHomeFXML.fxml"));
                Scene scene2 = new Scene(scene2Parent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene2);
                window.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Invalid Username or Password!");
                alert.showAndWait();
            }
        }
                 else if (u == null) {
            
            label.setText("contact with admin");
            idTextField.setText("");
            passTextField.setText("");
        }
        else if (idTextField.getText().toString().equals("6211")) {
           
               Parent scene2Parent = FXMLLoader.load(getClass().getResource("/dpsParticipant/dpsHomeFXML.fxml"));
               Scene scene2 = new Scene(scene2Parent);
               Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
               window.setScene(scene2);
               window.show();
           
        }
         else if (s.charAt(0) == '5') {
            if (u != null) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/investor/investorFXML.fxml"));
                Parent personViewParent = loader.load();
                Scene personViewScene = new Scene(personViewParent);
                InvestorFXMLController controller = loader.getController();
                controller.passData((User) idValidation());
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Wlecome "+u.getName());
                window.setScene(personViewScene);
                window.show();
                
            }

    }
         

    }
    
    
    
     User idValidation() {
        User u = null;
        investor = null;
        String ID = idTextField.getText().toString();
        
        String pass = passTextField.getText().toString();
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
                        if (userID.equals(ID) && pass1.equals(pass) ) {
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
    
    
    
    
    
    
    
    
    
    
    
    @FXML
        public void changeSceneToSignupPageFromHomePage(ActionEvent event) throws IOException {
            Parent guestUser = FXMLLoader.load(getClass().getResource("/signup/signupFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            guestUserScene.getStylesheets().add("/signup/signupfxml.css");
            Stage window  = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Sing up.");
            window.setScene(guestUserScene);
            window.show();
        }

    
    @FXML
        public void changeSceneToguestPage(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/guestpkg/guestFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Login as a guest.");
            window.setScene(guestUserScene);
            window.show();
        }
            
    @FXML
            public void changeFXMLButtonOnCLickFromLogintosignupAsDps(ActionEvent event) throws IOException{
                Parent guestUser = FXMLLoader.load(getClass().getResource("/signup/signupAsDpsMemberFXML.fxml"));
                Scene guestUserScene = new Scene(guestUser);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setTitle("SignUp");
                window.setScene(guestUserScene);
                window.show();
            }


    @FXML
    private void buttonClickOnToForgetPassword(ActionEvent event) throws IOException {
            Parent guestUser = FXMLLoader.load(getClass().getResource("/mainpackage/forgetPasswordFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            guestUserScene.getStylesheets().add("/signup/signupfxml.css");
            Stage window  = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Forget Password!");
            window.setScene(guestUserScene);
            window.show();
    
    }
            
}
