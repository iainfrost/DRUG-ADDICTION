/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudemedicaments;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
    //combo box
    @FXML
    private ComboBox cbEtude;
  
    //textfields 
    @FXML
    private TextField txtIdentifiant;
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
    
    
    Patient p = new Patient();
    ArrayList<Etude> etudes= new ArrayList<Etude>();
    
    //methodes
    @FXML
    public void retournerMenuPrincipal(ActionEvent event) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("menuP.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Addiction à la drogue - Menu principal");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    public void rechercherPatient() throws SQLException{

        p.setId(Integer.valueOf(txtIdentifiant.getText()));
        p.chargerPatient(p.getId());
        txtNAM.setText(p.getNoAssuMaladie());
        txtNom.setText(p.getNom());
        txtPrenom.setText(p.getPrenom());
        txtAdresse.setText(p.getAdresse());
        txtTelMaison.setText(p.getTelMaison());
        txtTelMobile.setText(p.getTelMobile());
        txtContact.setText(p.getContactUrgence());
        txtContactTelephone.setText(p.getTelUrgence());
    }

    @FXML
    public void ajouterPatient() throws SQLException{
       
        p.setNoAssuMaladie(txtNAM.getText());
        p.setNom(txtNom.getText());
        p.setPrenom(txtPrenom.getText());
        p.setAdresse(txtAdresse.getText());
        p.setTelMaison(txtTelMaison.getText());
        p.setTelMobile(txtTelMobile.getText());
        p.setContactUrgence(txtContact.getText());
        p.setTelUrgence(txtContactTelephone.getText());
        p.ajoutPatient();
    }
    
    @FXML
    public void modifierPatient() throws SQLException{
        
        p.setId(Integer.valueOf(txtIdentifiant.getText()));
        p.chargerPatient(p.getId());
        
        p.setNoAssuMaladie(txtNAM.getText());
        p.setNom(txtNom.getText());
        p.setPrenom(txtPrenom.getText());
        p.setAdresse(txtAdresse.getText());
        p.setTelMaison(txtTelMaison.getText());
        p.setTelMobile(txtTelMobile.getText());
        p.setContactUrgence(txtContact.getText());
        p.setTelUrgence(txtContactTelephone.getText());
        
        p.modPatient();
    }
    
    @FXML
    public void supprimerPatient() throws SQLException{
        p.effPatient();
    }
    
    
    public static void chargerEtudes(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        etudes.add(new Etude());
        
        cbEtude.getItems().addAll(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            "Option 5",
            "Option 6"
        );
        
    }    
    
}
