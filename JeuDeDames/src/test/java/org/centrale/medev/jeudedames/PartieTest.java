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

/**
 *
 * @author Quent
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
    }
    
}
