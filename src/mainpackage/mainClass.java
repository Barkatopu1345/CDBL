
package mainpackage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class mainClass extends Application {

    @Override
    public void start(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("logIn.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(mainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setTitle("Welcome. ");
        stage.setScene(scene);
        stage.show();
    }
    
        public static void main(String[] args) {
            launch(args);
    }
}
