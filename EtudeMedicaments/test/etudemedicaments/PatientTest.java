/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudemedicaments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author razan
 */
public class PatientTest {
    
    public PatientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        SimpleDataSource.init();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Patient.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Patient instance = new Patient();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNom method, of class Patient.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrenom method, of class Patient.
     */
    @Test
    public void testGetPrenom() {
        System.out.println("getPrenom");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getPrenom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdresse method, of class Patient.
     */
    @Test
    public void testGetAdresse() {
        System.out.println("getAdresse");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getAdresse();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateNaissance method, of class Patient.
     */
    @Test
    public void testGetDateNaissance() {
        System.out.println("getDateNaissance");
        Patient instance = new Patient();
        Date expResult = new Date();
        Date result = instance.getDateNaissance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelMaison method, of class Patient.
     */
    @Test
    public void testGetTelMaison() {
        System.out.println("getTelMaison");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getTelMaison();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelMobile method, of class Patient.
     */
    @Test
    public void testGetTelMobile() {
        System.out.println("getTelMobile");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getTelMobile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelUrgence method, of class Patient.
     */
    @Test
    public void testGetTelUrgence() {
        System.out.println("getTelUrgence");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getTelUrgence();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactUrgence method, of class Patient.
     */
    @Test
    public void testGetContactUrgence() {
        System.out.println("getContactUrgence");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getContactUrgence();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Patient.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNoAssuMaladie method, of class Patient.
     */
    @Test
    public void testGetNoAssuMaladie() {
        System.out.println("getNoAssuMaladie");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getNoAssuMaladie();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPriseMedicament method, of class Patient.
     */
    @Test
    public void testGetPriseMedicament() {
        System.out.println("getPriseMedicament");
        Patient instance = new Patient();
        ArrayList<Date> expResult = new ArrayList<>();
        ArrayList<Date> result = instance.getPriseMedicament();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Patient.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 3;
        Patient instance = new Patient();
        instance.setId(id);
        int result = instance.getId();
        assertEquals(id, result);
    }

    /**
     * Test of setNom method, of class Patient.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "Marmotte";
        Patient instance = new Patient();
        instance.setNom(nom);
        String result = instance.getNom();
        assertEquals(nom, result);
    }

    /**
     * Test of setPrenom method, of class Patient.
     */
    @Test
    public void testSetPrenom() {
        System.out.println("setPrenom");
        String prenom = "Raton";
        Patient instance = new Patient();
        instance.setPrenom(prenom);
        String result = instance.getPrenom();
        assertEquals(prenom, result);
    }

    /**
     * Test of setAdresse method, of class Patient.
     */
    @Test
    public void testSetAdresse() {
        System.out.println("setAdresse");
        String adresse = "12 rue des animaux morts, Sherbrooke, QC";
        Patient instance = new Patient();
        instance.setAdresse(adresse);
        String result = instance.getAdresse();
        assertEquals(adresse, result);
    }

    /**
     * Test of setDateNaissance method, of class Patient.
     */
    @Test
    public void testSetDateNaissance() {
        System.out.println("setDateNaissance");
        Date dateNaissance = new Date();
        Patient instance = new Patient();
        instance.setDateNaissance(dateNaissance);
        Date result = instance.getDateNaissance();
        assertEquals(dateNaissance, result);
    }

    /**
     * Test of setTelMaison method, of class Patient.
     */
    @Test
    public void testSetTelMaison() {
        System.out.println("setTelMaison");
        String telMaison = "123-456-7890";
        Patient instance = new Patient();
        instance.setTelMaison(telMaison);
        String result = instance.getTelMaison();
        assertEquals(telMaison, result);
    }

    /**
     * Test of setTelMobile method, of class Patient.
     */
    @Test
    public void testSetTelMobile() {
        System.out.println("setTelMobile");
        String telMobile = "123-456-7890";
        Patient instance = new Patient();
        instance.setTelMobile(telMobile);
        String result = instance.getTelMobile();
        assertEquals(telMobile, result);
    }

    /**
     * Test of setTelUrgence method, of class Patient.
     */
    @Test
    public void testSetTelUrgence() {
        System.out.println("setTelUrgence");
        String telUrgence = "123-456-7890";
        Patient instance = new Patient();
        instance.setTelUrgence(telUrgence);
        String result = instance.getTelUrgence();
        assertEquals(telUrgence, result);
    }

    /**
     * Test of setContactUrgence method, of class Patient.
     */
    @Test
    public void testSetContactUrgence() {
        System.out.println("setContactUrgence");
        String contactUrgence = "Lemming";
        Patient instance = new Patient();
        instance.setContactUrgence(contactUrgence);
        String result = instance.getContactUrgence();
        assertEquals(contactUrgence, result);
    }

    /**
     * Test of setEmail method, of class Patient.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "poil@gmail.com";
        Patient instance = new Patient();
        instance.setEmail(email);
        String result = instance.getEmail();
        assertEquals(email, result);
    }

    /**
     * Test of setNoAssuMaladie method, of class Patient.
     */
    @Test
    public void testSetNoAssuMaladie() {
        System.out.println("setNoAssuMaladie");
        String noAssuMaladie = "MARR12118700";
        Patient instance = new Patient();
        instance.setNoAssuMaladie(noAssuMaladie);
        String result = instance.getNoAssuMaladie();
        assertEquals(noAssuMaladie, result);
    }

    /**
     * Test of chargerPatient method, of class Patient.
     * @throws java.lang.Exception
     */
    @Test
    public void testChargerPatient() throws Exception {
        System.out.println("chargerPatient");
        int id = 1;
        Patient instance = new Patient();
        instance.chargerPatient(id);
    }

    /**
     * Test of modPatient method, of class Patient.
     * @throws java.lang.Exception
     */
    @Test
    public void testModPatient() throws Exception {
        System.out.println("modPatient");
        Patient instance = new Patient();
        int id = 1;
        instance.chargerPatient(id);
        instance.setNom("Kurro");
        instance.modPatient();
    }

    /**
     * Test of ajoutPatient method, of class Patient.
     * @throws java.lang.Exception
     */
    @Test
    public void testAjoutPatient() throws Exception {
        System.out.println("ajoutPatient");
        Patient instance = new Patient();
        instance.setPrenom("Raton");
        instance.setNom("Marmotte");
        instance.setAdresse("12 rue des animaux morts, Sherbrooke, QC");
        instance.setTelMaison("123-456-7890");
        instance.setTelMobile("123-456-7890");
        instance.setTelUrgence("123-456-7890");
        instance.setContactUrgence("Lemming");
        instance.setNoAssuMaladie("MARR12118700");
        instance.setEmail("poil@gmail.com");
        
        instance.ajoutPatient();
    }

    /**
     * Test of effPatient method, of class Patient.
     * @throws java.lang.Exception
     */
    @Test
    public void testEffPatient() throws Exception {
        System.out.println("effPatient");
        Patient instance = new Patient();
        int id = 11;
        instance.chargerPatient(id);
        instance.effPatient();
    }    
}
