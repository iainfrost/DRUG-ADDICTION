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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mndus
 */
public class AnalyseController implements Initializable {

    
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
   
    @FXML
    private Button btnRetour;
    
    @FXML
    private BarChart<String, Number> bcFrequence;
    
     ArrayList<Etude> etudes= new ArrayList<Etude>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            etudes = ListerEtude.lister();
            
            for(Etude e: etudes){
                System.out.println(e.getTitre());
                etudeCB.getItems().add(e.getTitre());
            }
        }
        catch (SQLException e){
                
                }
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
    @FXML
    public void handleCB(){
        String choix = etudeCB.getValue().toString();
        System.out.println(choix);
        bcFrequence.getData().clear();
        int[] stat = null;
        
        try{
            
            for(Etude e: etudes){
                if(e.getTitre().equals(choix)){

                    lblNbPart.setText(Integer.toString(e.getPatients().size()));
                    lblDebut.setText(e.getDebut().toString());
                    lblFin.setText(e.getFin().toString());
                    lblPro.setText(e.trouverProf());
                   
                    stat = e.genererStats();
                }
            }
        }
        catch (SQLException e){
           
        }
        
        
        XYChart.Series<String, Number> serie = new XYChart.Series();
        serie.setName("Prises");
        for(int i =0; i < stat.length ;i++){
           
            serie.getData().add(new XYChart.Data("Jour " +(i+1), stat[i]));
            System.out.println(i);
            
        }
        
        bcFrequence.getData().add(serie);
        
    }
}
