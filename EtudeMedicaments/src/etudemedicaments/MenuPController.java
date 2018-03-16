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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mndus
 */
public class MenuPController implements Initializable {
    
    @FXML
    private Button btnAnalyse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleQuitter(){
        System.exit(0);
    }
    
    @FXML
    public void handleAnalyse(ActionEvent event) throws IOException {
       
         
        try{
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("analyse.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();  
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
        catch (Exception e){
            
        }
    
    }
     public void handleAjouter(ActionEvent event) throws IOException {
       
         
        try{
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("formulaire.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();  
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
        catch (Exception e){
            
        }
    
    }
     
    
}
