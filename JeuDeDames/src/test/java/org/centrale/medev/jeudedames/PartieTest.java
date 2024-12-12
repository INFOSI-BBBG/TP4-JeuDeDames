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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author simon
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
     * @param estBlanc
     * @param estReine 
     * @param x coordonnée en x du point a tester
     * @param y coordonées en y du point a tester
     */
    @ParameterizedTest
    @CsvSource({"true,false,0,0", "false,false,2,8", "true,false,8,4", "false,true,9,1"})
    public void testVerifierCase(Boolean estBlanc,Boolean estReine, int x, int y) {
        System.out.println("verifierCase");
        Pion p1= new Pion(estBlanc, x, y);
        p1.setReine(estReine);
        ArrayList<Pion> liste=new ArrayList<>();
        liste.add(p1);
        Partie instance = new Partie(liste);
        assertEquals(p1, instance.verifierCase(x, y));
        assertEquals(null, instance.verifierCase(x+1, y+1));
    }

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
    }

    /**
     * Test of verifierCase method, of class Partie.
     */
    @ParameterizedTest
    @CsvSource({"1,0,0,0,false","1,0,2,1,true","1,0,0,1,false"})
    public void testVerifierPrisePossible(int xBlanc, int yBlanc, int xNoir, int yNoir, boolean prisePossible) {
        System.out.println("verifierPrisePossible");
        // Création d'une partie avec les bons nombres de pions        
        Partie partie = new Partie();
        ArrayList<Pion> listPions = new ArrayList<>();
        listPions.add(new Pion(true, xBlanc, yBlanc));
        listPions.add(new Pion(false, xNoir, yNoir));
        partie.setListePions(listPions);
        System.out.println(xBlanc+","+ yBlanc+","+ xNoir+","+ yNoir+","+ prisePossible);
        boolean result = partie.verifierPrisePossible(listPions.get(0));
        System.out.println("result: "+ result);
        assertEquals(result, prisePossible);
        
        // On vérfie que c'est toujours false quand les deux pions ont la même couleur
        ArrayList<Pion> otherListPions = new ArrayList<>();
        otherListPions.add(new Pion(true, xBlanc, yBlanc));
        otherListPions.add(new Pion(true, xNoir, yNoir));
        partie.setListePions(otherListPions);
        System.out.println(xBlanc+","+ yBlanc+","+ xNoir+","+ yNoir+","+ false);
        result = partie.verifierPrisePossible(otherListPions.get(0));
        System.out.println("result: "+ result);
        assertEquals(result, false);
    }
    
}
