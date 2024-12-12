/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.jeudedames;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Classe de test pour Partie
 * @author simon
 */
public class PartieTest {
    /**
     * Test of compter method, of class Partie.
     * @param nbBlanc   Nombre de pions blancs à trouver
     * @param nbNoir    Nombre de pions noirs à trouver
     */
    @ParameterizedTest
    @CsvSource({"10,10", "10,0", "0,10", "0,0"})
    void testCompter(int nbBlanc, int nbNoir) {
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
    
}
