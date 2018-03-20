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
 *
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

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getTelMaison() {
        return telMaison;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public String getTelUrgence() {
        return telUrgence;
    }

    public String getContactUrgence() {
        return contactUrgence;
    }

    public String getEmail() {
        return email;
    }

    public String getNoAssuMaladie() {
        return noAssuMaladie;
    }

    public ArrayList<Date> getPriseMedicament() {
        return priseMedicament;
    }
    
    //Setteur
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setTelMaison(String telMaison) {
        this.telMaison = telMaison;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public void setTelUrgence(String telUrgence) {
        this.telUrgence = telUrgence;
    }

    public void setContactUrgence(String contactUrgence) {
        this.contactUrgence = contactUrgence;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
                    //stat.setDate(4, (java.sql.Date) this.dateNaissance);
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
    
     public void ajoutPatient() throws SQLException{
        Connection conn = SimpleDataSource.getConnection();
        //resetPatient();
        try
        {
            PreparedStatement stat = conn.prepareStatement (
                    "INSERT INTO patient "
                            + "(nom_patient, prenom_patient, adresse_patient, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) "
                            + "VALUES (?,?,?,?,?,?,?,?,?);");
                    stat.setString(1, this.nom);
                    stat.setString(2, this.prenom);
                    stat.setString(3, this.adresse);
                    //stat.setDate(4, (java.sql.Date) this.dateNaissance);
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
            stat.setDate(4, (java.sql.Date) this.dateNaissance);
            stat.setString(5, this.telMaison);
            stat.setString(6, this.telMobile);
            stat.setString(7, this.telUrgence);
            stat.setString(8, this.contactUrgence);
            stat.setString(9, this.email);
            stat.setString(10, this.noAssuMaladie);
            
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
