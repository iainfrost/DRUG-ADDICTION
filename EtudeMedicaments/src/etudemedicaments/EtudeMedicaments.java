/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudemedicaments;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Cette application servira a gérer des patients participant à des études de 
 * médicaments et analyser les résultats.
 * @author Iain Frost
 * @author Marie Noëlle Dussault
 * @author Loup Olivier Gaven-Forest 
 */
public class EtudeMedicaments extends Application {
   
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("menuP.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Addiction à la drogue - Menu principal");
        stage.setResizable(false);
        
        stage.show();
    }
  
    /**
     * @param args the command line argument
     */
    public static void main(String[] args)
        throws Exception
    {
        SimpleDataSource.init();
        
        Etude e = new Etude();
        e.ChargerEtude(1);
        System.out.println(e.getTitre());
        int[] genererStats = e.genererStats();
        System.out.println(genererStats[2]);
        
        
        launch(args);
    } 
}

