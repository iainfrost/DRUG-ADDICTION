/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudemedicaments;

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
 * @author mndus
 */
public class AnalyseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void handleRetour(ActionEvent event) throws IOException {
       
         
        try{
            
                  
            System.out.print("1 ");
            Parent root = FXMLLoader.load(getClass().getResource("menuP.fxml"));
            System.out.print("2 ");
            Stage stage = new Stage();
            System.out.print("3 ");
            stage.setTitle("Addiction à la drogue - Analyse");
            System.out.print("4 ");
            stage.setScene(new Scene(root));
            System.out.print("5 ");
            stage.setResizable(false);
            System.out.print("6 ");
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
        catch (Exception e){
            
        }
    
    }
}
