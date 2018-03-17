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
 *
 * @author iain
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
       //Patient p = new Patient();
         /*p.chargerPatient(3);
        System.out.println(p.getNom());
        p.setNom("Raton");
        //p.setPrenom("Marmotte");
        //p.setAdresse("86, rue des animaux morts Sherbrooke, QC CA");
        //p.setTelMaison("123-456-7890");
        //p.setTelMobile("123-456-7890");
        //p.setTelUrgence("123-456-7890");
        //p.setContactUrgence("Castor");
        //p.setEmail("boudboi@foret.com");
        //p.setNoAssuMaladie("RATM89121134");
        
        p.enregistrerPatient();*/
        launch(args);
    }
    
}

