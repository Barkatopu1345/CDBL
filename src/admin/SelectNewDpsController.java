/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import classes.AppendableClass;
import classes.DpsMember;
import classes.Investor;
import classes.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author barka
 */
public class SelectNewDpsController implements Initializable {

    DpsMember dps;
    User user;
    
    @FXML

    private TableView<DpsMember> tableView ;
    @FXML
    private TableColumn<DpsMember, String> nameColumn;
    @FXML
    private TableColumn<DpsMember, String> licenColumn;
    @FXML
    private TableColumn<DpsMember, String> emailColumn;
    @FXML
    private TableColumn<DpsMember, String> passColumn;
    @FXML
    private TableColumn<DpsMember, String> addressColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonClickOnToLoadTable();
    }

    @FXML
    public void changeFXMLButtonOnCLickToAdminHome(ActionEvent event) throws IOException {
        Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/adminHomeFXML.fxml"));
        Scene guestUserScene = new Scene(guestUser);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(guestUserScene);
        window.show();
    }

    private void buttonClickOnToLoadTable() {
        String str = "";
        int count = 0;
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        licenColumn.setCellValueFactory(new PropertyValueFactory("licence"));
        emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
        passColumn.setCellValueFactory(new PropertyValueFactory("password"));
        addressColumn.setCellValueFactory(new PropertyValueFactory("address"));

        try {
            File f = new File("ApplicationFormForDpsMember.txt");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                str += s.nextLine() + "\n";
                count++;
            }
            int size = 5;
            String[] tokens = new String[count];
            tokens = str.split("\n");
            String[] array = new String[size];
 //           tableClass tableclass;
            for (int i = 0; i < count; i++) {

                array = tokens[i].split(",");

//                tableclass = new tableClass(
//                        array[0], array[1],
//                        array[2], array[3],
//                        array[4]
//                );

                            dps = new DpsMember(
                               array[0],array[1],
                               array[2],array[3],
                               array[4]
                            );
                tableView.getItems().add(dps);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }

    }

    @FXML
    public void buttonOnClickToSubmitNewMemberList(ActionEvent event) throws FileNotFoundException, IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        tableClass tableclass = null;
        String str = generateID();
        try {

            dps = tableView.getSelectionModel().getSelectedItem();
                        user = new DpsMember(
                        dps.getName(),str, dps.getLicence(),
                        dps.getEmail(), dps.getPassword(),
                        dps.getAddress()
                );
                        
                        
           File f = null;
       
        try {
            f = new File("dpsusers.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(user);
            System.out.println(user.getID());

        } catch (IOException ex) {
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (IOException ex) {
            }
        }

        } catch (RuntimeException rn) {
            System.out.println("Runtime Error");
        } 

    }
    
    
 String generateID() {
        int id = 1;
        String eId = "6";
        
        String uniqueID = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
        String s = dtf.format(now);
        String st = Character.toString(s.charAt(2)) + Character.toString(s.charAt(3));
        eId += st;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        f = new File("dpsusers.bin");
        if (!f.exists()) {
            uniqueID = "1";

        } else {
            try {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                
                try {
                    while (true) {

                        dps = (DpsMember) ois.readObject();
                        String userID = dps.getID();
                        if (userID.charAt(0) == eId.charAt(0)) {
                            id += 1;
                        }
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
        uniqueID = Integer.toString(id);
        eId += uniqueID;
        System.out.println(eId);
        return eId ;
    }


    
    
    
    
    

//    @FXML
//    private void readBinary(ActionEvent event) throws FileNotFoundException, IOException {
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        File f = new File("User.bin");
//        User u = null;
//        fis = new FileInputStream(f);
//        ois = new ObjectInputStream(fis);
//        try {
//            while (true) {
//                u = (User) ois.readObject();
//            }
//        } catch (Exception ex) {
//            System.out.println("fskldfjslakd;fj");
//        } finally {
//
//            ois.close();
//
//        }
//
//    }

}
