/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superdemineur;

import java.util.Random;
import java.util.ArrayList;
import static javax.swing.UIManager.get;
/**
 *
 * @author Hugo
 */
public class Grille {

int coté =22;
Cellule[][] Cellules = new Cellule[22][22];
int CaseDecouverte;
int nombremines;
int nombrekits;


Grille() { //on créé la grille avec chaque case du tableau en tant que cellule
    for (int i=0; i<22; i++) {
            for (int j=0; j<22; j++) {
                Cellules[i][j]=new Cellule();// initialisation du grand tableau
            }
        }
    }



int analyseMine(int lignes, int colonnes) { //on regarde si les lignes/colonnes sont valide et si la case a une mine
    if (lignes >= 0 && lignes <coté && colonnes >= 0 && colonnes < coté && Cellules[colonnes][lignes].mine == true) {
        return 1;
}
    else {
        return 0;
    }
}
void analyseMineAutour(int lignes, int colonnes) { // pour trouver proximine
   Cellules[lignes][colonnes].proxiMine= analyseMine(lignes+1, colonnes)+ analyseMine(lignes+1, colonnes-1)+analyseMine(lignes+1, colonnes+1)+analyseMine(lignes, colonnes-1)+analyseMine(lignes, colonnes+1)+analyseMine(lignes-1, colonnes)+analyseMine(lignes-1, colonnes-1)+analyseMine(lignes-1, colonnes+1);
   /*Cellules[lignes][colonnes].proxiMine += analyseMine(lignes+1, colonnes-1);
   Cellules[lignes][colonnes].proxiMine += analyseMine(lignes+1, colonnes+1);
   
   Cellules[lignes][colonnes].proxiMine += analyseMine(lignes, colonnes-1);
   Cellules[lignes][colonnes].proxiMine += analyseMine(lignes, colonnes+1);
  
   Cellules[lignes][colonnes].proxiMine += analyseMine(lignes-1, colonnes);
   Cellules[lignes][colonnes].proxiMine += analyseMine(lignes-1, colonnes-1);
   Cellules[lignes][colonnes].proxiMine += analyseMine(lignes-1, colonnes+1);
    //apparenté a proximine
 
}*/
}
void PlacerProxi (){
    for(int i=0;i<coté;i++){
        for(int j=0; j<coté;j++){
            analyseMineAutour(i,j);
}
    }
}
    
void decouvrirCellules(int lignes, int colonnes) {
    if (lignes >= 0 && lignes <coté && colonnes >= 0 && colonnes < coté) {// si coordonnées correctes
        Cellules[lignes][colonnes].ouverture = true; //on ouvre la cellule (on affiche proximine)
        CaseDecouverte ++; // on definit le nb de case definit
        if (Cellules[lignes][colonnes].proxiMine==0) {
         decouvrirCellules(lignes, colonnes +1);
         decouvrirCellules(lignes+1, colonnes);
         decouvrirCellules(lignes+1, colonnes +1);
         decouvrirCellules(lignes-1, colonnes);
         decouvrirCellules(lignes, colonnes-1);
         decouvrirCellules(lignes-1, colonnes-1);
         decouvrirCellules(lignes+1, colonnes-1);
         decouvrirCellules(lignes-1, colonnes+1);
     }
    }
}            

void viderGrille() {
        for (int i = 0; i < coté; i++) {
            for (int j = 0; j < coté; j++) {
                Cellules[i][j].mine = false;
                Cellules[i][j].proxiMine = 0;
                Cellules[i][j].kitDeDeminage = false;
                Cellules[i][j].ouverture=false;
                }
            }
        }
    
boolean placerMine(int ligne, int colonne) {
        if (!(Cellules[ligne][colonne].mine)) {
            Cellules[ligne][colonne].mine = true;
            return true;
        }else{
        return false;
    }
}

boolean placerKit(int ligne, int colonne) {
        if (!Cellules[ligne][colonne].kitDeDeminage || !Cellules[ligne][colonne].mine) {
            Cellules[ligne][colonne].kitDeDeminage = true;
            return true;
        }else{
        return false;
    }
}
void répartitionMine(){
    Random rand = new Random();
    for(int i=0; i<nombremines;i++){
        int ligne = rand.nextInt(coté);
        int colonne = rand.nextInt(coté);
        placerMine(ligne,colonne);
        //if (placerMine(ligne,colonne)==false){
         //   i--;
        //}
    }
}
void répartitionKit(){
    Random rand = new Random();
    for(int i=0; i<nombrekits;i++){
        int ligne = rand.nextInt(coté);
        int colonne = rand.nextInt(coté);
        placerKit(ligne, colonne);
        if (placerKit(ligne, colonne)==false){
            i--;
        }
    }
}

void afficherGrillesurConsole(){ // moi pas comprendre
    for (int i = 0; i<coté;i++) {
            for (int j = 0; j<coté;j++) {
                if(Cellules[i][j].mine){
                    System.out.print("M");
                }
                  else if (Cellules[i][j].kitDeDeminage) {// recuperer kit a faire
                    System.out.print("K");
                } else {
                    System.out.print(Cellules[i][j].proxiMine);
                } 
            }
            System.out.println(" ");
        }
}

}
