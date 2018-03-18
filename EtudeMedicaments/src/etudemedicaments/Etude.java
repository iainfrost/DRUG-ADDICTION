/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudemedicaments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author iain
 */
public class Etude {
    private int id;
    private String titre;

    public Etude() {
        id=0;
        titre="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public void ChargerEtudes() throws SQLException{
        Connection conn= SimpleDataSource.getConnection();
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                "SELECT id_etude, titre_etude "
                        + "FROM etude ;"
            );
                
            ResultSet result = stat.executeQuery();
            if (result.next())
            {
                this.id = result.getInt(1);
                this.titre = result.getString(2);
                
            }
            else
            {
                System.out.println("Aucune etude trouvé");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Aucune etude trouvé");

                alert.showAndWait();
            }
        }
        finally
        {
            conn.close();
        }
        
        
    }
    
}
