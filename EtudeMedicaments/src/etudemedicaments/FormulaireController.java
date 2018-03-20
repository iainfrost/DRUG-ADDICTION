/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudemedicaments;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private ComboBox<Etude> cbEtude;
    
   
  
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
    ObservableList options = FXCollections.observableArrayList();

    
    //methodes
    @FXML
    public void retournerMenuPrincipal(ActionEvent event) throws IOException{
        //System.out.println("retour menu principal");
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
        //Patient p = new Patient();
        System.out.println("recherche d'un patient");
        //String id = txtIdentifiant.getText();
        //System.out.println(id);
        p.setId(Integer.valueOf(txtIdentifiant.getText()));
        System.out.println(p.getId());
        p.chargerPatient(p.getId());
        System.out.println(p.getId());
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
        System.out.println("Ajout d'un patient");
        //System.out.println("NAM :" + txtNAM.getText());
        //System.out.println("Prenom :" + txtPrenom.getText() + " " + "Nom : " + txtNom.getText());       
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
        System.out.println("Modification d'un patient");
        
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
        System.out.println("Suppression du patient #" + p.getId());
        p.effPatient();
    }
    
    
    public void chargerEtudes() throws SQLException{
        Connection conn= SimpleDataSource.getConnection();
        
        try
        {
            String query="SELECT titre_etude FROM etude";
            PreparedStatement stat = conn.prepareStatement (query);
            
            ResultSet result = stat.executeQuery();
           while (result.next())
            {
               options.add(result.getString("titre_etude"));
               
            }
           
        }
        finally
        {
            conn.close();
        }
       
    }
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        try {
            chargerEtudes();
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cbEtude.setItems(options);
        /*cbEtude.getItems().addAll(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            "Option 5",
            "Option 6"
        );*/
        
    }    
    
}
