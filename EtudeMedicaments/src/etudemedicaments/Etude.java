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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.Alert;

/**
 *
 * @author iain
 */
public class Etude {
    //Variables
    private int id;
    private String titre;
    private String description;
    private Date debut;
    private Date fin;
    private String type_etude;
    private ArrayList<Patient> patients;

    
    //Méthodes
    //Constructeurs
    public Etude() {
        id = 0;
        titre = "";
        description = "";
        debut = new Date();
        fin = new Date();
        type_etude="";
        patients = new ArrayList<>();
    }
    
    //Gettteurs

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public String getType_etude() {
        return type_etude;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
    
    //Setteur
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setType_etude(String type_etude) {
        this.type_etude = type_etude;
    }

    public void setPatients(ArrayList<Patient> patients) {    
        this.patients = patients;
    }

    //Méthodes autres
    public void ChargerEtude(int id) 
            throws SQLException 
    {
        Connection conn= SimpleDataSource.getConnection();
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                    "SELECT e.titre_etude, e.description_etude, e.date_debut, e.date_fin, te.nom_type "
                            + "FROM etude AS e INNER JOIN type_etude AS te "
                            + "ON e.id_type_etude = te.id_type_etu "
                            + "WHERE e.id_etude = ?"
            );
            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();
            if (result.next())
            {
                this.id = id;
                this.titre = result.getString(1);
                this.description = result.getString(2);
                this.debut = result.getDate(3);
                this.fin = result.getDate(4);
                //this.type_etude = result.getString(5);
                chargerPatient();
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
    
    public void chargerPatient()
            throws SQLException
    {
        Connection conn= SimpleDataSource.getConnection();
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                "SELECT lp.id_patient "
                    + "FROM etude AS e INNER JOIN ta_liste_patient AS lp "
                    + "ON e.id_etude = lp.id_etude "
                    + "WHERE e.id_etude = ?"
                );
            stat.setInt(1, this.id);
            ResultSet result = stat.executeQuery();
            while(result.next())
            {
                int id_patient = result.getInt(1);
                Patient p = new Patient();
                p.chargerPatient(id_patient);
                patients.add(p);
            }           
        }
        finally
        {
            conn.close();
        }
    }
    
    public int[] genererStats()
    {
        //Ramasse le nombre de jours à vérifier
        long dureeInMillies = Math.abs(fin.getTime() - debut.getTime());
        int duree = (int) TimeUnit.DAYS.convert(dureeInMillies, TimeUnit.MILLISECONDS);
        
        //On crée la tableau d'int
        int stats[] = new int[duree + 1];
        
        for (int i = 0; i <= duree; i++)
        {
            System.out.println(i);
            //Nombre de prises pour la journée
            int prise = 0;
            
            //On ramasse la date a vérifier
            Date dt = debut;
            Calendar c = Calendar.getInstance(); 
            c.setTime(dt); 
            c.add(Calendar.DATE, i);
            dt = c.getTime();
            
            System.out.println(dt);
            
            //Pour chaque Patient de l'étude...
            for (Patient patient : this.patients)
            {
                //On regarde chacun des jours jusqu'à trouver le jour correspondant (Si il existe)
                for(Date date_prise : patient.getPriseMedicament())
                {
                    //Si la date est la même on ajoute 1 à prise
                    if (date_prise.compareTo(dt) == 0)
                    {
                        prise++; 
                        //Arrête la boucle lorsque l'on a trouver la date (Évite des itérations inutiles)
                        break;
                    }
                }
            }
            stats[i] = prise;
        }
        return stats;
    } 
}
