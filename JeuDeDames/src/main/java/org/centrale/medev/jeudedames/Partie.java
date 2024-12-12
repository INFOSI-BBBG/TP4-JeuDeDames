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

    public ArrayList<Pion> getListePions() {
        return listePions;
    }

    public void setListePions(ArrayList<Pion> listePions) {
        this.listePions = listePions;
    }
    
        public void afficher(){
        System.out.println(" --- --- --- --- --- --- --- --- --- --- ");
        for(int lgnY =9; lgnY>=0;lgnY--){
            for(int colX=0; colX<10;colX++){
                System.out.print("|");
                if((colX+lgnY)%2==1){
                    Pion contenuCase=verifierCase(lgnY, colX);
                    if(contenuCase==null){
                        System.out.print(" ~ ");
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
                    System.out.print("   ");
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
    
    /**
     * Compte le nombre de pions d'un couleur
     * @param blanc Couleur à compter
     * @return      Nombre de pions
     */
    protected int compter(boolean blanc) {
        int compteur = 0;
        
        for (Pion pion: this.listePions) {
            if (pion.isBlanc() == blanc) {
                compteur++;
            }
        }
        
        return compteur;
    }
}
