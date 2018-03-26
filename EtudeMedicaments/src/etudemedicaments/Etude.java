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
    /**
     * variables de la classe Etude
     * @param id, l'identification de l'étude
     * @param titre, le titre de l'étude
     * @param description, une description de l'étude
     * @param debut, la date du début de l'étude
     * @param fin, la date de la fin d'une étude
     * @param type_etude, le type d'étude engagée
     * @param patients, la liste des patients reliés à l'étude
     */

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
    /**
     * constructeur d'Etude sans paramètre
     */
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
    /**
     * retourne l'identité d'une étude
     * @return id l'identité d'une étude
     */
    public int getId() {
        return id;
    }

    /**
     * retourne le titre d'une étude
     * @return titre le titre d'une étude
     */
    public String getTitre() {
        return titre;
    }

    /**
     * retourne la description d'une étude
     * @return description la description du cours
     */
    public String getDescription() {
        return description;
    }

    /**
     * retourne la date du début de l'étude
     * @return debut la date de début de l'étude
     */
    public Date getDebut() {
        return debut;
    }

    /**
     * retourne la date de la fin de l'étude
     * @return fin, la date de la fin de l'étude
     */
    public Date getFin() {
        return fin;
    }

    /**
     * retourne le type d'étude
     * @return type_etude , le type de l'étude 
     */
    public String getType_etude() {
        return type_etude;
    }

    /**
     * retourne la liste de patients
     * @return patients la liste de patients
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }
    
    //Setteur

    /**
     * assigne l'identité de l'étude
     * @param id , l'identité de l'étude
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * assigne le titre de l'étude
     * @param titre le titre de l'étude
     */
    public void setTitre(String titre){
        this.titre = titre;
    }

    /**
     * assigne la description de l'étude
     * @param description la description de l'étude
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * assigne la date du début de l'étude
     * @param debut la date de début de l'étude
     */
    public void setDebut(Date debut) {
        this.debut = debut;
    }

    /**
     * assigne la date de la fin de l'étude
     * @param fin la date de début de l'étude
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }

    /**
     * assigne le type de l'étude 
     * @param type_etude le type de l'étude
     */
    public void setType_etude(String type_etude) {
        this.type_etude = type_etude;
    }

    /**
     * assigne la liste de patients
     * @param patients la liste de patients
     */
    public void setPatients(ArrayList<Patient> patients) {    
        this.patients = patients;
    }

    //Méthodes autres

    /**
     * Cherche une étude par identité dans la base de donnée et la charge dans 
     * l'objet étude
     * @param id l'identité du client
     * @throws SQLException
     */
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
    
    /**
     * cherche la liste de tout les patients d'une étude dans la base de donnée et
     * l'incorpore dans la liste de patients appartenant à l'étude
     * @throws SQLException
     */
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
    
    /**
     * génère les statistiques et les retournent sous forme de tableau
     * @return stats, tableau de statistiques 
     */
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
    
    /**
     * recherche le professionnel responsable de l'étude et en retourne le nom
     * @return prof, le nom du professionnel
     * @throws SQLException
     */
    public String trouverProf() throws SQLException
    {
        String prof = "";
        
        
         Connection conn= SimpleDataSource.getConnection();
        try
        {
            
            PreparedStatement stat = conn.prepareStatement (
                "SELECT p.nom_professionnel, p.prenom_professionnel, p.specialite FROM professionnel AS p INNER JOIN ta_etude_professionel AS t ON p.no_professionnel = t.id_prof WHERE t.id_etude = ?"
                );
                        
            stat.setInt(1, this.id);
            ResultSet result = stat.executeQuery();
              
                if(!result.next()){
                    System.out.println("Aucun professionnel n'est associer a cette étude");
                }
            prof =  result.getString(2) + " " +result.getString(1) + ", "  + result.getString(3);
            System.out.println(prof);
        }
        finally
        {
            conn.close();
        }
        
        
        return prof;
    }
}
