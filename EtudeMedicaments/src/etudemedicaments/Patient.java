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
import java.util.Date;
import javafx.scene.control.Alert;

/**
 * S'occupe de la gestion d'un patient
 * @author razan
 */
public class Patient {
    //Variables
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private Date dateNaissance;
    private String telMaison;
    private String telMobile;
    private String telUrgence;
    private String contactUrgence;
    private String email;
    private String noAssuMaladie;
    private ArrayList<Date> priseMedicament;
    
    //Méthodes
    //Constructeurs

    /**
     *Constructeur par défaut
     */

    public Patient() {
        this.priseMedicament = new ArrayList<>();
        this.id = 0;
        nom="";
        prenom="";
        adresse="";
        dateNaissance=new Date();
        telMaison="";
        telMobile="";
        telUrgence="";
        contactUrgence="";
        email="";
        noAssuMaladie="";
    }
    
    //Gettteurs

    /**
     * Accesseur de l'id du patient
     * @return l'id du patient
     */

    public int getId() {
        return id;
    }

    /**
     * Accesseur du nom du patient
     * @return le nom du patient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Accesseur du prenom du patient
     * @return le prenom du patient
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Accesseur de l'adresse du patient
     * @return l'adresse du patient
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Accesseur de la date de naissance du patient
     * @return la date de naissance du patient
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Accesseur du téléphone à la maison du patient
     * @return le téléphone à la maison du patient
     */
    public String getTelMaison() {
        return telMaison;
    }

    /**
     * Accesseur du téléphone mobile du patient
     * @return le téléphone mobile du patient
     */
    public String getTelMobile() {
        return telMobile;
    }

    /**
     * Accesseur du numéros du téléphone d'urgence du patient
     * @return le téléphone d'urgence du patient
     */
    public String getTelUrgence() {
        return telUrgence;
    }

    /**
     * Accesseur du nom du contact d'urgence du patient
     * @return le nom du contact d'urgence du patient
     */
    public String getContactUrgence() {
        return contactUrgence;
    }

    /**
     * Accesseur de l'adresse courriel du patient
     * @return l'adresse courriel du patient
     */
    public String getEmail() {
        return email;
    }

    /**
     * Accesseur du numéros d'assurance maladie du patient
     * @return le numéros d'assurance maladie du patient
     */
    public String getNoAssuMaladie() {
        return noAssuMaladie;
    }

    /**
     * Accesseur de la liste de prise de médicament du patient
     * @return la liste de prise de médicament du patient
     */
    public ArrayList<Date> getPriseMedicament() {
        return priseMedicament;
    }
    
    //Setteur

    /**
     * Affectateur de l'id du patient
     * @param id l'id du patient
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Affectateur du nom du patient
     * @param nom nom du patient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Affectateur du prenom du patient
     * @param prenom prenom du patient
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Affectateur de l'adresse du patient
     * @param adresse l'adresse du patient
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Affectateur de la date de naissance du patient
     * @param dateNaissance la date de naissance du patient
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Affectateur du téléphone à la maison du patient
     * @param telMaison téléphone à la maison du patient
     */
    public void setTelMaison(String telMaison) {
        this.telMaison = telMaison;
    }

    /**
     * Affectateur du téléphone mobile du patient
     * @param telMobile téléphone mobile du patient
     */
    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    /**
     * Affectateur du numéros du téléphone d'urgence du patient
     * @param telUrgence numéros du téléphone d'urgence du patient
     */
    public void setTelUrgence(String telUrgence) {
        this.telUrgence = telUrgence;
    }

    /**
     * Affectateur du nom du contact d'urgence du patient
     * @param contactUrgence nom du contact d'urgence du patient
     */
    public void setContactUrgence(String contactUrgence) {
        this.contactUrgence = contactUrgence;
    }

    /**
     * Affectateur de l'adresse courriel du patient
     * @param email l'adresse courriel du patient
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Affectateur du numéros d'assurance maladie du patient
     * @param noAssuMaladie numéros d'assurance maladie du patient
     */
    public void setNoAssuMaladie(String noAssuMaladie) {
        this.noAssuMaladie = noAssuMaladie;
    }
    
    //Méthodes autres   
    private void genererListePrises() 
        throws SQLException
    {
        Connection conn = SimpleDataSource.getConnection();
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                "SELECT date_prise_medicament "
                        + "FROM prise_medicament "
                        + "WHERE id_patient = ?;");
            stat.setInt(1, this.id);
            ResultSet result = stat.executeQuery();
            while (result.next())
            {
                Date datex = result.getDate(1);
                this.priseMedicament.add(datex);   
            }
        }
        finally
        {
            conn.close();
        }
    }
    
    /**
     * Charge un patient selon l'id qui lui est passé
     * @param id l'id du patient à charger
     * @throws SQLException
     */
    public void chargerPatient(int id) 
        throws SQLException
    {
        Connection conn = SimpleDataSource.getConnection();
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                "SELECT nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie "
                        + "FROM patient "
                        + "WHERE id_patient = ?;");
                stat.setInt(1, id);
            ResultSet result = stat.executeQuery();
            if (result.next())
            {
                this.id = id;
                this.nom = result.getString(1);
                this.prenom = result.getString(2);
                this.adresse = result.getString(3);
                this.dateNaissance = result.getDate(4);
                this.telMaison = result.getString(5);
                this.telMobile = result.getString(6);
                this.telUrgence = result.getString(7);
                this.contactUrgence = result.getString(8);
                this.email = result.getString(9);
                this.noAssuMaladie = result.getString(10);
                genererListePrises();
            }
            else
            {
                System.out.println("Aucun patient associé trouvé");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Aucun patient associé trouvé");

                alert.showAndWait();
            }
        }
        finally
        {
            conn.close();
        }
    }
        
    /**
     * Enregistre les modifications faites à un patient dans la base de données
     * @throws SQLException
     */
    public void modPatient() throws SQLException{
        Connection conn = SimpleDataSource.getConnection();
        
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                    "UPDATE patient "
                            + "SET nom_patient = ?, "
                            + "prenom_patient = ?, "
                            + "adresse_patient = ?, "
                            + "no_tel_maison = ?, "
                            + "no_tel_mobile = ?, "
                            + "no_tel_urgences = ?, "
                            + "contact_urgences = ?, "
                            + "email_patient = ?, "
                            + "numero_assu_maladie = ?"
                            + "WHERE id_patient = ?;");
                    stat.setString(1, this.nom);
                    stat.setString(2, this.prenom);
                    stat.setString(3, this.adresse);
                    stat.setString(4, this.telMaison);
                    stat.setString(5, this.telMobile);
                    stat.setString(6, this.telUrgence);
                    stat.setString(7, this.contactUrgence);
                    stat.setString(8, this.email);
                    stat.setString(9, this.noAssuMaladie);
                    stat.setInt(10, this.id);
                    stat.executeUpdate();
        }
        finally
        {
            conn.close();
        
        }
    }
    
    /**
     * Ajoute un nouveau patient dans la base de données selon les informations entrées dans l'objet
     * @throws SQLException
     */
    public void ajoutPatient() throws SQLException{
        Connection conn = SimpleDataSource.getConnection();
        
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                    "INSERT INTO patient "
                            + "(nom_patient, prenom_patient, adresse_patient, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) "
                            + "VALUES (?,?,?,?,?,?,?,?,?);");
                    stat.setString(1, this.nom);
                    stat.setString(2, this.prenom);
                    stat.setString(3, this.adresse);
                    stat.setString(4, this.telMaison);
                    stat.setString(5, this.telMobile);
                    stat.setString(6, this.telUrgence);
                    stat.setString(7, this.contactUrgence);
                    stat.setString(8, this.email);
                    stat.setString(9, this.noAssuMaladie);
                    
                    stat.executeUpdate();
        }
        finally
        {
            conn.close();
        
        }
    }
     
    /**
     * Supprime un patient de la base de donnée selon l'id enregistrer
     * @throws SQLException
     */
    public void effPatient() throws SQLException{
        Connection conn = SimpleDataSource.getConnection();
        try
        {
        PreparedStatement stat=conn.prepareStatement (
            "DELETE FROM patient WHERE id_patient = ?;"
            );
            stat.setInt(1, id);
            stat.executeUpdate();
        }
        finally
        {
            conn.close();
        }
     }

    /**
     * S'occupe d'enregistrer ou modifier le patient dans la base de données selon si l'id est affecter ou non
     * @throws SQLException
     */
    public void enregistrerPatient() 
        throws SQLException
    {
        Connection conn = SimpleDataSource.getConnection();
        try
        {
            boolean exist = false;
            if(this.id > 0)
                exist = true;
            
            PreparedStatement stat = null;
            
            if(exist)
            {
                stat = conn.prepareStatement (
                    "UPDATE patient "
                            + "SET nom_patient = ?, prenom_patient = ?, adresse_patient = ?, date_naissance = ?, no_tel_maison = ?, no_tel_mobile = ?, no_tel_urgences = ?, contact_urgences = ?, email_patient = ?, numero_assu_maladie = ?"
                            + "WHERE id_patient = ?;");
            }
            else
            {
                stat = conn.prepareStatement (
                    "INSERT INTO patient "
                            + "(nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) "
                            + "VALUES (?,?,?,?,?,?,?,?,?,?);");
            }
            
            stat.setString(1, this.nom);
            stat.setString(2, this.prenom);
            stat.setString(3, this.adresse);
            stat.setString(4, this.telMaison);
            stat.setString(5, this.telMobile);
            stat.setString(6, this.telUrgence);
            stat.setString(7, this.contactUrgence);
            stat.setString(8, this.email);
            stat.setString(9, this.noAssuMaladie);
            
            if(exist)
                stat.setInt(11, this.id);
            
            stat.executeUpdate();
        }
        finally
        {
            conn.close();
        }
    }
}
