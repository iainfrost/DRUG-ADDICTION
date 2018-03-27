/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudemedicaments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class EtudeTest {
    
    public EtudeTest() {
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
     * Test of getId method, of class Etude.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Etude instance = new Etude();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitre method, of class Etude.
     */
    @Test
    public void testGetTitre() {
        System.out.println("getTitre");
        Etude instance = new Etude();
        String expResult = "";
        String result = instance.getTitre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Etude.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Etude instance = new Etude();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebut method, of class Etude.
     */
    @Test
    public void testGetDebut() {
        System.out.println("getDebut");
        Etude instance = new Etude();
        Date expResult = new Date();
        Date result = instance.getDebut();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFin method, of class Etude.
     */
    @Test
    public void testGetFin() {
        System.out.println("getFin");
        Etude instance = new Etude();
        Date expResult = new Date();
        Date result = instance.getFin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType_etude method, of class Etude.
     */
    @Test
    public void testGetType_etude() {
        System.out.println("getType_etude");
        Etude instance = new Etude();
        String expResult = "";
        String result = instance.getType_etude();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPatients method, of class Etude.
     */
    @Test
    public void testGetPatients() {
        System.out.println("getPatients");
        Etude instance = new Etude();
        ArrayList<Patient> result = instance.getPatients();
    }

    /**
     * Test of setId method, of class Etude.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        Etude instance = new Etude();
        instance.setId(id);
        int result = instance.getId();
        assertEquals(id, result);
    }

    /**
     * Test of setTitre method, of class Etude.
     */
    @Test
    public void testSetTitre() {
        System.out.println("setTitre");
        String titre = "Raton";
        Etude instance = new Etude();
        instance.setTitre(titre);
        String result = instance.getTitre();
        assertEquals(titre, result);
    }

    /**
     * Test of setDescription method, of class Etude.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Une étude";
        Etude instance = new Etude();
        instance.setDescription(description);
        String result = instance.getDescription();
        assertEquals(description, result);
    }

    /**
     * Test of setDebut method, of class Etude.
     */
    @Test
    public void testSetDebut() {
        System.out.println("setDebut");
        Date debut = new Date();
        Etude instance = new Etude();
        instance.setDebut(debut);
        Date result = instance.getDebut();
        assertEquals(debut, result);
    }

    /**
     * Test of setFin method, of class Etude.
     */
    @Test
    public void testSetFin() {
        System.out.println("setFin");
        Date fin = new Date();
        Etude instance = new Etude();
        instance.setFin(fin);
        Date result = instance.getFin();
        assertEquals(fin, result);
    }

    /**
     * Test of setType_etude method, of class Etude.
     */
    @Test
    public void testSetType_etude() {
        System.out.println("setType_etude");
        String type_etude = "Poire";
        Etude instance = new Etude();
        instance.setType_etude(type_etude);
        String result = instance.getType_etude();
        assertEquals(type_etude, result);
    }

    /**
     * Test of ChargerEtude method and ChargerPatient method, of class Etude.
     * @throws java.lang.Exception
     */
    @Test
    public void testChargerEtude() throws Exception {
        System.out.println("ChargerEtude");
        int id = 1;
        Etude instance = new Etude();
        instance.ChargerEtude(id);
    }

    /**
     * Test of genererStats method, of class Etude.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenererStats() throws Exception {
        System.out.println("genererStats");
        int id = 1;
        Etude instance = new Etude();
        instance.ChargerEtude(id);
        instance.genererStats();
    }

    /**
     * Test of trouverProf method, of class Etude.
     * @throws java.lang.Exception
     */
    @Test
    public void testTrouverProf() throws Exception {
        System.out.println("trouverProf");
        int id = 1;
        Etude instance = new Etude();
        instance.ChargerEtude(id);
        instance.trouverProf();
    }
    
}
