/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.jeudedames;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
<<<<<<< HEAD

/**
 *
 * @author Quent
=======
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author simon
>>>>>>> main
 */
public class PartieTest {
    
    public PartieTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

<<<<<<< HEAD
    

    /**
     * Test of initPartie method, of class Partie.
     */
    @Test
    public void testInitPartie() {
        System.out.println("initPartie");
        Partie instance = new Partie();
        instance.initPartie();
        ArrayList<Pion> listeCree = instance.getListePions();
        assertTrue(listeCree.size()==40);
        assertTrue(listeCree.get(0).getX()==0 && listeCree.get(0).getY()==0);
        for(Pion pion : listeCree){
            assertTrue((pion.getX()+pion.getY())%2==0 && pion.getX()>=0 && pion.getX()<10 && pion.getY()>=0 && pion.getY()<10);
        }
    }

    /**
     * Test of verifierCase method, of class Partie.
     */
    @Test
    public void testVerifierCase() {
        System.out.println("verifierCase");
        Pion p1= new Pion(true, 0, 0);
        Pion p2= new Pion(false, 2, 7);
        Pion p3= new Pion(true,0,1);
        Pion p4= new Pion(false,9,3);
        p4.setReine(true);
        ArrayList<Pion> liste=new ArrayList<>();
        liste.add(p1);
        liste.add(p2);
        liste.add(p3);
        liste.add(p4);
        Partie instance = new Partie(liste);
        assertEquals(p1, instance.verifierCase(0, 0));
        assertEquals(p2, instance.verifierCase(2, 7));
        assertEquals(p3, instance.verifierCase(0, 1));
        assertEquals(p4, instance.verifierCase(9, 3));
        assertEquals(null, instance.verifierCase(1, 0));
=======
    /**
     * Test of compter method, of class Partie.
     * @param nbBlanc   Nombre de pions blancs à trouver
     * @param nbNoir    Nombre de pions noirs à trouver
     */
    @ParameterizedTest
    @CsvSource({"10,10", "10,0", "0,10", "0,0"})
    public void testCompter(int nbBlanc, int nbNoir) {
        System.out.println("compter B" + nbBlanc + " N" + nbNoir);
        
        // Création d'une partie avec les bons nombres de pions        
        Partie partie = new Partie();
        ArrayList<Pion> listPions = new ArrayList<>();
        
        for (int i = 0; i < nbNoir || i < nbBlanc; i++) {
            if (i < nbBlanc) {
                listPions.add(new Pion(true, 0, 0));
            }
            
            if (i < nbNoir) {
                listPions.add(new Pion(false, 0, 0));
            }
        }
        
        partie.setListePions(listPions);
        
        // Test du nombres de pions
        assertEquals(partie.compter(true), nbBlanc);
        assertEquals(partie.compter(false), nbNoir);
>>>>>>> main
    }
    
}
