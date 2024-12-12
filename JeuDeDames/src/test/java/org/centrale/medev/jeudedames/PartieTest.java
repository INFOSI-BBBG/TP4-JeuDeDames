/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.jeudedames;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    
    /**
     * Test of verifierCase method, of class Partie. Simple Deplacement
     */
    @Test
    public void testDeplacementSimple() {
        System.out.println("deplacement Simple");
        Pion p1= new Pion(true, 0, 0); 
        ArrayList<Pion> liste=new ArrayList<>();
        liste.add(p1);
        Partie instance = new Partie(liste);
        
        String input = "D"; 
        InputStream in = new ByteArrayInputStream(input.getBytes()); 
        System.setIn(in); 
        
        boolean manger=instance.deplacement(p1); 
        assertFalse(manger); 
        assertEquals(p1.getX(), 1);
        assertEquals(p1.getY(), 1);
        
        
    }
    
    
    /**
     * Test of verifierCase method, of class Partie. Sortir du plateau
     */
    @Test
    public void testDeplacementOut() {
        //déplacement pour sortir (test) puis se déplacer correctement 
        System.out.println("deplacement hors du plateau");
        
        Pion p2= new Pion(true, 0, 0); 
        ArrayList<Pion> liste2=new ArrayList<>();
        liste2.add(p2);
        Partie instance2 = new Partie(liste2);
         
        String input2 = "G" + System.getProperty("line.separator")+"D"+System.getProperty("line.separator"); 
        InputStream in2 = new ByteArrayInputStream(input2.getBytes()); 
        System.setIn(in2); 
        boolean manger=instance2.deplacement(p2); 
        assertFalse(manger); 
        assertEquals(p2.getX(), 1);
        assertEquals(p2.getY(), 1);
    }
    
     /**
     * Test of verifierCase method, of class Partie. Manger un pion
     */
    @Test
    public void testDeplacementEat() {
        //déplacement pour sortir (test) puis se déplacer correctement 
        System.out.println("deplacement manger un pion");
        
        Pion p1= new Pion(true, 0, 0); 
        ArrayList<Pion> liste=new ArrayList<>();
        liste.add(p1);
       
        
        Pion p2= new Pion(true, 1, 1); 
        liste.add(p2);
        
        Partie instance = new Partie(liste);
         
        String input = "D"; 
        InputStream in = new ByteArrayInputStream(input.getBytes()); 
        System.setIn(in); 
        boolean manger=instance.deplacement(p1); 
        assertTrue(manger); 
        assertEquals(p1.getX(), 2);
        assertEquals(p1.getY(), 2);
        assertEquals(instance.getListePions().size(),1); 
    }
    
    /**
     * Test of verifierCase method, of class Partie. Pion bloquant
     */
    @Test
    public void testDeplacementBlocked() {
        //déplacement pour sortir (test) puis se déplacer correctement 
        System.out.println("deplacement bloqué puis déplacement ok");
        
        Pion p1= new Pion(true, 2, 0); 
        ArrayList<Pion> liste=new ArrayList<>();
        liste.add(p1);
        Pion p2= new Pion(true, 1, 1); 
        liste.add(p2);
        Pion p3= new Pion(true, 0, 2); 
        liste.add(p3);
        
        Partie instance = new Partie(liste);
         
        String input = "G" + System.getProperty("line.separator")+"D"+System.getProperty("line.separator");  
        InputStream in = new ByteArrayInputStream(input.getBytes()); 
        System.setIn(in); 
        boolean manger=instance.deplacement(p1); 
        assertFalse(manger); 
        assertEquals(p1.getX(), 3);
        assertEquals(p1.getY(), 1);
    }
    
    
    /**
     * Test of verifierCase method, of class Partie. Pion Noir
     */
    @Test
    public void testDeplacementSimpleBlack() {
        System.out.println("deplacement Simple Noir");
        Pion p1= new Pion(false, 1, 9); 
        ArrayList<Pion> liste=new ArrayList<>();
        liste.add(p1);
        Partie instance = new Partie(liste);
        
        String input = "D"; 
        InputStream in = new ByteArrayInputStream(input.getBytes()); 
        System.setIn(in); 
        
        instance.deplacement(p1);
        assertEquals(p1.getX(), 2);
        assertEquals(p1.getY(), 8);
        
        
    }
}
