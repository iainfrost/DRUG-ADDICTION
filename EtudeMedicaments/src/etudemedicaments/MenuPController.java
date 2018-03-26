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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
            app_stage.setTitle("Addiction à la drogue - Analyser une étude");
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
            
            app_stage.setTitle("Addiction à la drogue - Ajouter un patient");
            //bouton ajouter actif et visible
            home_page_scene.lookup("#btnAjouter").setVisible(true);
            home_page_scene.lookup("#btnAjouter").setDisable(false);
            //bouton modifier inactif et invisible
            home_page_scene.lookup("#btnModifier").setVisible(false);
            home_page_scene.lookup("#btnModifier").setDisable(true);
            //bouton supprimer inactif et invisible
            home_page_scene.lookup("#btnSupprimer").setVisible(false);
            home_page_scene.lookup("#btnSupprimer").setDisable(true);
            //bouton recherche inactif et invisible
            home_page_scene.lookup("#btnRechercher").setVisible(false);
            home_page_scene.lookup("#btnRechercher").setDisable(true);
             //champs de données actifs a part txtID
            home_page_scene.lookup("#txtIdentifiant").setDisable(true);
            home_page_scene.lookup("#txtIdentifiant").setVisible(false);
            home_page_scene.lookup("#lblID").setVisible(false);
            home_page_scene.lookup("#txtNAM").setDisable(false);
            home_page_scene.lookup("#txtNom").setDisable(false);
            home_page_scene.lookup("#txtPrenom").setDisable(false);
            home_page_scene.lookup("#txtAdresse").setDisable(false);
            home_page_scene.lookup("#txtTelMaison").setDisable(false);
            home_page_scene.lookup("#txtTelMobile").setDisable(false);
            home_page_scene.lookup("#txtContact").setDisable(false);
            home_page_scene.lookup("#txtContactTelephone").setDisable(false);
            home_page_scene.lookup("#cbEtude").setDisable(false);
            home_page_scene.lookup("#cbEtude").setVisible(false);
            
            app_stage.setScene(home_page_scene);
            app_stage.show();  
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
        catch (Exception e){
            
        }
    
    }
      public void handleModifier(ActionEvent event) throws IOException {
       
         
        try{
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("formulaire.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide(); //optional
            app_stage.setTitle("Addiction à la drogue - Modifier un patient");
            
            //bouton ajouter inactif et invisible
            home_page_scene.lookup("#btnAjouter").setVisible(false);
            home_page_scene.lookup("#btnAjouter").setDisable(true);
            //bouton modifier actif et visible
            home_page_scene.lookup("#btnModifier").setVisible(true);
            home_page_scene.lookup("#btnModifier").setDisable(false);
            //bouton supprimer inactif et invisible
            home_page_scene.lookup("#btnSupprimer").setVisible(false);
            home_page_scene.lookup("#btnSupprimer").setDisable(true);
            //bouton recherche actif et visible
            home_page_scene.lookup("#btnRechercher").setVisible(true);
            home_page_scene.lookup("#btnRechercher").setDisable(false);
             //champs de données actifs 
            home_page_scene.lookup("#txtIdentifiant").setDisable(false);
            home_page_scene.lookup("#txtIdentifiant").requestFocus();
            home_page_scene.lookup("#txtNAM").setDisable(false);
            home_page_scene.lookup("#txtNom").setDisable(false);
            home_page_scene.lookup("#txtPrenom").setDisable(false);
            home_page_scene.lookup("#txtAdresse").setDisable(false);
            home_page_scene.lookup("#txtTelMaison").setDisable(false);
            home_page_scene.lookup("#txtTelMobile").setDisable(false);
            home_page_scene.lookup("#txtContact").setDisable(false);
            home_page_scene.lookup("#txtContactTelephone").setDisable(false);
            home_page_scene.lookup("#cbEtude").setDisable(false);
            home_page_scene.lookup("#cbEtude").setVisible(false);
            
            app_stage.setScene(home_page_scene);
                        
            app_stage.show();  
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
        catch (Exception e){
            
        }
    
    }
    public void handleSupprimer(ActionEvent event) throws IOException {
       
         
        try{
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("formulaire.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide(); //optional
            app_stage.setTitle("Addiction à la drogue - Supprimer un patient");
            //bouton ajouter inactif et invisible
            home_page_scene.lookup("#btnAjouter").setVisible(false);
            home_page_scene.lookup("#btnAjouter").setDisable(true);
            //bouton modifier inactif et invisible
            home_page_scene.lookup("#btnModifier").setVisible(false);
            home_page_scene.lookup("#btnModifier").setDisable(true);
            //bouton supprimer actif et visible
            home_page_scene.lookup("#btnSupprimer").setVisible(true);
            home_page_scene.lookup("#btnSupprimer").setDisable(false);
            //bouton recherche inactif et invisible
            home_page_scene.lookup("#btnRechercher").setVisible(true);
            home_page_scene.lookup("#btnRechercher").setDisable(false);
            //champs de données inactifs à part txtID
            home_page_scene.lookup("#txtIdentifiant").setDisable(false);
            home_page_scene.lookup("#txtIdentifiant").requestFocus();
            home_page_scene.lookup("#txtNAM").setDisable(true);
            home_page_scene.lookup("#txtNom").setDisable(true);
            home_page_scene.lookup("#txtPrenom").setDisable(true);
            home_page_scene.lookup("#txtAdresse").setDisable(true);
            home_page_scene.lookup("#txtTelMaison").setDisable(true);
            home_page_scene.lookup("#txtTelMobile").setDisable(true);
            home_page_scene.lookup("#txtContact").setDisable(true);
            home_page_scene.lookup("#txtContactTelephone").setDisable(true);
            home_page_scene.lookup("#cbEtude").setDisable(true);
            home_page_scene.lookup("#cbEtude").setVisible(false);
            
            app_stage.setScene(home_page_scene);
            app_stage.show();  
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
        catch (Exception e){
            
        }
    
    }
    public void handleHelp(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText("Aide à l'utilisateur");
        alert.setContentText("Arrange-toi tout seul, t'es supposé de savoir comment !!!");
        alert.showAndWait();
        
       
    }
}
