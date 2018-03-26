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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mndus
 */
public class AnalyseController implements Initializable {

    /**
     * objets du formulaire et variables
     * @param etudeCB, c'est la liste des études
     * @param lblNbPart, le nombre de patients
     * @param lblDebut, la date de début de l'étude
     * @param lblFin, la date de fin de l'étude
     * @param lblPro, le nom du professionel
     * @param etudes, la liste objet/etude 
     */
    
    //combo box
    @FXML
    private ComboBox etudeCB;
    
    //label
    @FXML
    private Label lblNbPart;    
    @FXML
    private Label lblDebut;    
    @FXML
    private Label lblFin;    
    @FXML
    private Label lblPro;    
    
    //liste d'étude
    ArrayList<Etude> etudes= new ArrayList<Etude>();
    
    /**
     * Initialise la classe de contrôle.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            etudes = ListerEtude.lister();
            
            for(Etude e: etudes){
                etudeCB.getItems().add(e.getTitre());
            }
        }
        catch (SQLException e){
                
                }
    }
    
    /**
     * Lorsque le bouton retour est appuyé, la fenêtre d'analyse se referme et 
     * la fenêtre Menu Principal est allumé.
     * 
     * @param event, le bouton Retour est appuyé
     * @throws IOException 
     */
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
    /**
     * prépare les titres d'études en vue de les présenter en ComboBox
     */
    public void handleCB(){
        String choix = etudeCB.getValue().toString();
        System.out.println(choix);
        
        try{
            for(Etude e: etudes){
                    if(e.getTitre().equals(choix)){
                        
                        lblNbPart.setText(Integer.toString(e.getPatients().size()));
                        lblDebut.setText(e.getDebut().toString());
                        lblFin.setText(e.getFin().toString());
                        lblPro.setText(e.trouverProf());
                    }
                }
        }
        catch (SQLException e){
            
        }
    }
}
