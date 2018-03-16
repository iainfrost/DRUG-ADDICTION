/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudemedicaments;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ifros
 */
public class FormulaireController implements Initializable {

    //boutons
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnMenuPrincipal;
    @FXML
    private Button btnRechercher;
    
    //choicebox
    @FXML
    private ChoiceBox cbEtude;
  
    //textfields    
    @FXML
    private TextField txtNAM;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtTelMaison;
    @FXML
    private TextField txtTelMobile;
    @FXML
    private TextField txtContact;
    @FXML
    private TextField txtContactTelephone;
    
    //methodes
    @FXML
    public void retournerMenuPrincipal(){
        System.out.println("retour menu principal");
    }
    
    @FXML
    public void rechercherPatient(){
        System.out.println("recherche d'un patient");
    }
    
    @FXML
    public void ajouterPatient(){
        System.out.println("Ajout d'un patient");
    }
    
    @FXML
    public void modifierPatient(){
        System.out.println("Modification d'un patient");
    }
    
    @FXML
    public void supprimerPatient(){
        System.out.println("Suppression d'un patient");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}
