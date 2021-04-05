/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import classes.Investor;
import classes.forgetPasswordApplicants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ForgetPasswordListController implements Initializable {
    forgetPasswordApplicants fpa;
    @FXML
    private Button buttonOnClickToAdminHome;
    @FXML
    private TableView table;
    @FXML
    private TableColumn<forgetPasswordApplicants, String> idColumn;
    @FXML
    private TableColumn<forgetPasswordApplicants, String> passwordColumn;
    @FXML
    private TableColumn<forgetPasswordApplicants, String> typeColumn;

    
    public void initialize(URL url, ResourceBundle rb) {
        buttonClickOnToLoadTable();
       
    }   
    
    
    
    private void buttonClickOnToLoadTable() {
        String str = "";
        int count = 0;

        idColumn.setCellValueFactory(new PropertyValueFactory("ID"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory("password"));
        typeColumn.setCellValueFactory(new PropertyValueFactory("type"));
       
        
        
        
          try {
            File f = new File("ForgetPasswordApplicantsList.txt");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                str += s.nextLine() + "\n";
                count++;
            }
            int size = 3;
            String[] tokens = new String[count];
            tokens = str.split("\n");
            String[] array = new String[size];
            for (int i = 0; i < count; i++) {

                array = tokens[i].split(",");

                            fpa = new forgetPasswordApplicants(
                               array[0],array[1],
                               array[2]
                               
                            );
                table.getItems().add(fpa);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
         
    
    }
    
    @FXML
    private void buttonOnClickToAdminHome(ActionEvent event) throws IOException {
        Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/adminHomeFXML.fxml"));
        Scene guestUserScene = new Scene(guestUser);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(guestUserScene);
        window.show();
    }
    
}

