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
import java.util.ArrayList;

/**
 *
 * @author mndus
 */
public class ListerEtude {
    
    /**
     * Liste toutes les études dans la base de données
     * @return Liste de toutes les études dans la base de données
     * @throws SQLException
     */
    public static ArrayList<Etude> lister()throws SQLException
    {
        ArrayList<Etude> liste = new ArrayList<>();
        Connection conn = SimpleDataSource.getConnection();
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                "SELECT * FROM etude");
            
            ResultSet result = stat.executeQuery();
            
            while (result.next())
            {
                 Etude e = new Etude();
                e.setId(result.getInt(1));
                e.setTitre(result.getString(2));
                e.setDescription(result.getString(3));
                e.setDebut(result.getDate(4));
                e.setFin(result.getDate(5));
                e.chargerPatient();
                
                liste.add(e);
            }
           
        }
        finally
        {
            conn.close();
        }
        
        return liste;
    }
}
