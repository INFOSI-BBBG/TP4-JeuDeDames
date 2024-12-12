/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.jeudedames;

import java.util.ArrayList;

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
        
    
    public Pion verifierCase(int x, int y){
        
        for (int i = 0; i < this.getListePions().size(); i++) {
            if ((this.getListePions().get(i).getX()==x) && (this.getListePions().get(i).getY()==y)){
                return this.getListePions().get(i); 
            }
         }
        return null; 
    }
}
