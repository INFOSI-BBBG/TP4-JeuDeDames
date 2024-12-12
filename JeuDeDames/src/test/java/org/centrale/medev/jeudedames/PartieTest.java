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
    @CsvSource({"1,0,0,0,false"})
    public void testVerifierPrisePossible(int xBlanc, int yBlanc, int xNoir, int yNoir, boolean prisePossible) {
        System.out.println("verifierPrisePossible");
        // Création d'une partie avec les bons nombres de pions        
        Partie partie = new Partie();
        ArrayList<Pion> listPions = new ArrayList<>();
        listPions.add(new Pion(true, xBlanc, yBlanc));
        listPions.add(new Pion(false, xNoir, yNoir));
        partie.setListePions(listPions);
        System.out.println("listPions.get(0)" + listPions.get(0));
        boolean expResult = partie.verifierPrisePossible(listPions.get(0));
        assertEquals(expResult, prisePossible);
    }
    
}
