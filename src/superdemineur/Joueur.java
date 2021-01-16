/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superdemineur;

/**
 *
 * @author Hugo
 */
public class Joueur {
String Nom;
int pointDeVie;
int nbKit;

Joueur(String Name, int PdV) {
    Nom = Name;
    pointDeVie = PdV;
}

void obtenirKit() {
    nbKit ++;
}

void utiliserKit() {
    if (nbKit>0){
        nbKit--;
        System.out.println("Il reste "+nbKit+"Kits ");
} else { 
    System.out.println("Plus de Kits disponible");
}
    
}
        



}


