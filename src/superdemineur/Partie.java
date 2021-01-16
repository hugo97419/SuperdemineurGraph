/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superdemineur;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @assssuthor Hugo
 */
public class Partie {
    
   Joueur J1 = new Joueur(null,3); //joueur sans pseudo avc 3PV
    Grille grilleDeJeu = new Grille(); // grille qui fait chier

int menu_joueur() { // // on veut le choix qui determinera la structure de la grille
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel mode de jeu souhaitez vous ?");
        System.out.println("1) Débutant");
        System.out.println("2) Intermédiaire");
        System.out.println("3) Expert");
        int choix = sc.nextInt();
        while (choix > 3 || choix < 1) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        return choix;
    
    }

    void initialiserPartie() {
        int choix;
        
        //Création du joueur
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du pseudo:");
        J1.Nom=(sc.nextLine());// on a donné un pseudo à J1
        System.out.println("Milestone1");
        choix = menu_joueur(); // on demande la difficulté, on reçoit la variable
        System.out.println("Milestone2");
        //on definit le coté en fonction du choix
        valeurcoté(choix);
        System.out.println("Milestone3");
        // on définit le nb de mine en fonction du choix
        nombreMines(choix);
        System.out.println("Milestone4");
        // on definit le nb de Kit en fonction du choix
        nombreKits(choix);
        System.out.println("Milestone5");
        // on place les mines dans la grille
        grilleDeJeu.répartitionMine();// a adapter a la grille dyna
        System.out.println("Milestone6");
        // on place les Kits dans la grille
        grilleDeJeu.répartitionKit(); // a adapter a la grille dyna
        System.out.println("Milestone7");
       	// on attribue les proximines
        grilleDeJeu.PlacerProxi();// a adapter a la grille dyna
        System.out.println("Milestone8");
        // on affiche la grille
        grilleDeJeu.afficherGrillesurConsole();// a adapter a la grille dyna
    }
   
        
    
    void CliqueDroit (int lignes, int colonnes){
        grilleDeJeu.Cellules[lignes][colonnes].drapeau = grilleDeJeu.Cellules[lignes][colonnes].presenceDrapeau() != true;
       }
    
   void debuterPartie() {
       int a = 0;
       a=menu_joueur();
        initialiserPartie();
        
}
   
   void valeurcoté (int ch_oix){ // dimensions de la grille en fonction du mode (grille carrée) 
    if (ch_oix==1){ //grille 8x8 = 64cases, 420 (nice) cases en moins
        grilleDeJeu.coté=8;
    }else{
        if (ch_oix==2){ //grille 16x16=256, 228cases en moins
            grilleDeJeu.coté=16;
        }else{
            if(ch_oix==3){ //grille 22x22 par défaut= 484cases
                grilleDeJeu.coté=22;
            }
        }
    }
}
void nombreMines (int cho_ix){ // nb de mine en fonction du mode 
    if (cho_ix==1){
        grilleDeJeu.nombremines=10;
    }else{
        if (cho_ix==2){
            grilleDeJeu.nombremines=40;
        }else{
            if(cho_ix==3){
                grilleDeJeu.nombremines=99;
            }
        }
    }
}
void nombreKits (int cho_ix){ // nb de KIT en fonction du mode 
    if (cho_ix==1){
        grilleDeJeu.nombrekits=4;
    }else{
        if (cho_ix==2){
            grilleDeJeu.nombrekits=15;
        }else{
            if(cho_ix==3){
                grilleDeJeu.nombrekits=33;
            }
        }
    }
}
}