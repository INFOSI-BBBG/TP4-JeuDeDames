/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.jeudedames;

import java.util.ArrayList;
import static java.util.Objects.isNull;
import java.util.Scanner;

/**
 *
 * @author grigm
 */
public class Partie {
    private ArrayList<Pion> listePions;
    
    public Partie(){
        listePions =new ArrayList<>();
    }

    public Partie(ArrayList<Pion> listePions) {
        this.listePions = listePions;
    }
    

    public ArrayList<Pion> getListePions() {
        return listePions;
    }
    
    /**
     * crée la position de départ d'une partie classique de dame
     */
    public void initPartie(){
        if(!listePions.isEmpty()){
            listePions=new ArrayList<>();
        }
        for(int lgnY=0; lgnY<4; lgnY++){
//            int indlgnBlanc=lgnY;
//            int indlgnNoir=lgnY+6;
            int decalage=0;
            if(lgnY%2==1){
                decalage=1;
            }
            
            for(int indPion=0; indPion<5; indPion++){
                Pion pionBlanc=new Pion(true, lgnY, decalage+(2*indPion));
                Pion pionNoir=new Pion(false, lgnY+6, decalage+(2*indPion));
                listePions.add(pionBlanc);
                listePions.add(pionNoir);
            }
        }
    }
    
    
    
    public void setListePions(ArrayList<Pion> listePions) {
        this.listePions = listePions;
    }
    
    /**
     * affiche une carte
     */
    public void afficher(){
        System.out.println(" --- --- --- --- --- --- --- --- --- --- ");
        for(int lgnY =9; lgnY>=0;lgnY--){
            for(int colX=0; colX<10;colX++){
                System.out.print("|");
                if((colX+lgnY)%2==0){
                    Pion contenuCase=verifierCase(lgnY, colX);
                    if(contenuCase==null){
                        System.out.print("   ");
                    }else{
                        if(contenuCase.isBlanc()){
                            if(contenuCase.isReine()){
                                System.out.print(" B ");
                            }else{
                                System.out.print(" b ");
                            }
                        }else{
                            if(contenuCase.isReine()){
                                System.out.print(" N ");
                            }else{
                                System.out.print(" n ");
                            }
                        }
                    }
                }else{
                    System.out.print(" ~ ");
                }
            }
            System.out.println("|");
            System.out.println(" --- --- --- --- --- --- --- --- --- --- ");
        }
    }
        
    
    /**
     * Vérifie si un pion est sur le case x,y 
     * @param x
     * @param y
     * @return  renvoie le pion sur la case sinon null 
     */
    public Pion verifierCase(int x, int y){
        
        for (int i = 0; i < this.getListePions().size(); i++) {
            if ((this.getListePions().get(i).getX()==x) && (this.getListePions().get(i).getY()==y)){
                return this.getListePions().get(i); 
            }
         }
        return null; 
    }
    
    
    /**
     * Demande au joueur sur quelle case il veut déplacer son pion, puis le déplace
     * @param pion
     * @return  un booléan en fonction de si le pion a mangé quelqu'un ou non
     */
    private boolean deplacement(Pion pion){
        Scanner scanner = new Scanner(System.in);
        String choix;
        int choixValeur = 1; //pour conserver le choix du joueur G/D, G= -1, D=+1
        boolean bouffon = true; //pour redemander au joueur de choisir une destination possible selon les règles 
        
        //on est sûr qu'il n'y a pas de pion en 1,0
        int newY = 1; 
        int newX = 0; 
        
        int sensPlateau; //pour déterminer le sens du plateau et de G/D
        
        boolean aMange= false; //on stocke si le pion à manger un pion 
        
        while (bouffon) {
        
        //si le pion est blanc, on se trouve "en bas" du plateau donc y doit faire +1
        //si le pion est noir, on se trouve "en haut" du plateau donc y doit faire -1 
        if (pion.isBlanc()) {
            sensPlateau = 1; 
        } else {
            sensPlateau = -1; 
        }
        
        boolean askFlag = true;
        do {
            //gauche et droite dépend de l'affichage du plateau
            System.out.println("Choix de déplacement du Pion Gauche ou Droite: G/D");
            choix = scanner.nextLine();
            
            askFlag = false;  // Tant que choix n'est pas validé, on suppose qu'il est valide
            
            switch (choix) {
                case "G":
                    newY=pion.getY() + sensPlateau; 
                    choixValeur= -1; 
                    newX=pion.getX() + choixValeur;  
                    break;
                    
                case "D":
                    newY=pion.getY() + sensPlateau; 
                    choixValeur= 1; 
                    newX=pion.getX() + choixValeur; 
                    break;
                    
                default:
                    askFlag = true;
            }
        } while (askFlag);
        
        //tester s'il y a un pion sur la case, et si on peut le manger       
        Pion pionAManger = verifierCase(newX, newY); 
        //s'il n'y a pas de pion sur la case, on s'y déplace
        if (isNull(pionAManger)){
            pion.setY(newY);
            pion.setX(newX); 
            bouffon = false; 
        } else { 
            //s'il y a un pion sur la case, on teste s'il est prenable
            Pion pionBloquant = verifierCase(newX + choixValeur, newY + sensPlateau); 
            // s'il est prenable, on mange le pion en le supprimant de la liste, on renvoie true 
            if (isNull(pionBloquant)){
                pion.setY(newY+sensPlateau); 
                pion.setX(newX+choixValeur); 
                
                // on supprime le pion mangé
                this.getListePions().remove(pionAManger); 
                aMange =true;
                bouffon = false; 
            } else {
                //si le pion est bloqué et ne peut pas se déplacer dans cette direction
                bouffon = true; //on redemande au joueur de choisir une direction
            }   
        }
        }
        return aMange; 
    }
}
