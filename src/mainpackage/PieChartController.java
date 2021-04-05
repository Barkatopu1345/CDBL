
package mainpackage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class PieChartController implements Initializable {

    ObservableList<String> year = FXCollections.observableArrayList("2018", "2019", "2020");
    @FXML
    private RadioButton dseRadioButton;
    @FXML
    private RadioButton cseRadioButton;
    @FXML
    private PieChart pieCharBox;
    @FXML
    private Label tilteLabel;
    @FXML
    private ComboBox comboBox;
    @FXML
    private ToggleGroup radioButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.setValue("Choose a year");
        comboBox.setItems(year);
    }

    @FXML
    private void buttonClickOnToGoBack(ActionEvent event) throws IOException {
        Parent guestUser = FXMLLoader.load(getClass().getResource("/investor/investorFXML.fxml"));
        Scene guestUserScene = new Scene(guestUser);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(guestUserScene);
        window.show();
    }

    @FXML
    private void generateButtonOnAction(ActionEvent event) {
        File f = null;
        String str = "";
        Scanner sc = null;
        int count = 0;
        String[] companyList;
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        String type = "";
        
        String y = (String) comboBox.getSelectionModel().getSelectedItem();
        
        if(dseRadioButton.isSelected()){
            type = "DSE";
        }
        else if(cseRadioButton.isSelected()){ 
            type = "CSE";
        }
        try {
            tilteLabel.setText("Pie chart of "+ type +" market at " + y);
            f = new File("marketStatus.txt");
            if (f.exists()) {
                sc = new Scanner(f);
                while (sc.hasNext()) {
                    str += sc.nextLine() + "\n";
                    count++;
                }
                companyList = new String[count];
                companyList = str.split("\n");
                String[] array = new String[4];
                for (String s : companyList) {
                    array = s.split(", ");
                     
                    
                    if(type.equals(array[0]) && y.equals(array[1])){
                    list.add(new PieChart.Data(array[2], Integer.valueOf(array[3])));
                    }
                }
                pieCharBox.setData(list);
            }
        } catch (Exception ex) {
            System.out.println("");
        }

    }

}
