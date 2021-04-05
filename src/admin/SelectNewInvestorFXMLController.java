
package admin;

import classes.Investor;
import classes.User;
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
import javafx.stage.Stage;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SelectNewInvestorFXMLController implements Initializable {
    User user;
    Investor investor;
    @FXML
    private TableView<Investor> tableView;

    @FXML
    private TableColumn<Investor, String> nameColumn;
    @FXML
    private TableColumn<Investor, String> emailColumn;
    @FXML
    private TableColumn<Investor, String> passwordColumn;
    @FXML
    private TableColumn<Investor, String> nidTextField;


   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonClickOnToLoadTable();
        
        

    }    

        @FXML
        public void changeFXMLButtonOnCLickToAdminHome(ActionEvent event) throws IOException{
            Parent guestUser = FXMLLoader.load(getClass().getResource("/admin/adminHomeFXML.fxml"));
            Scene guestUserScene = new Scene(guestUser);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Home");
            window.setScene(guestUserScene);
            window.show();
        }

       


    
        private void buttonClickOnToLoadTable() {
        String str = "";
        int count = 0;

        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        nidTextField.setCellValueFactory(new PropertyValueFactory("nid"));
        emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory("password"));
        
        
        
          try {
            File f = new File("ApplicationFormForInvestormember.txt");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                str += s.nextLine() + "\n";
                count++;
            }
            int size = 4;
            String[] tokens = new String[count];
            tokens = str.split("\n");
            String[] array = new String[size];
            for (int i = 0; i < count; i++) {

                array = tokens[i].split(",");

                            investor = new Investor(
                               array[0],array[1],
                               array[2],array[3]
                               
                            );
                tableView.getItems().add(investor);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
         
    
    }

    @FXML
    private void buttonOnClickToSubmitNewMemberList(ActionEvent event) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        tableClass tableclass = null;
        String BOID = generateID();
        System.out.println(BOID);
        try {

            investor = tableView.getSelectionModel().getSelectedItem();
                        user = new Investor(
                        investor.getName(), investor.getNid(),
                        investor.getEmail(), investor.getPassword()
                         ,BOID      
                        
                );
                        
                        
           File f = null;
       
        try {
            f = new File("investors.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(user);
            //System.out.println(user.getID());

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
            System.out.println("sorry sir");
        } 
    
    }
    

 String generateID() {
        int id = 1;
        String eId = "5";
        
        String uniqueID = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
        String s = dtf.format(now);
        String st = Character.toString(s.charAt(2)) + Character.toString(s.charAt(3));
        eId += st;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        f = new File("investors.bin");
        if (!f.exists()) {
            uniqueID = "1";

        } else {
            try {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                
                try {
                    while (true) {

                        investor = (Investor) ois.readObject();
                        String userID = investor.getID();
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


    
        
}
