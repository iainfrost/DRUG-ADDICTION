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
            
            Parent root = FXMLLoader.load(getClass().getResource("menuP.fxml"));
            
            Stage stage = new Stage();
            stage.setTitle("Addiction à la drogue - Menu Principal");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
        catch (Exception e){
            
        }
    
    }
}
