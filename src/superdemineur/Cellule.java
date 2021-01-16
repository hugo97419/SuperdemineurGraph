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
public class Cellule {
boolean mine;
boolean drapeau;
int proxiMine;
boolean ouverture;
boolean kitDeDeminage;
boolean celluleVide;

Cellule() {
mine = false;
drapeau = false;
proxiMine = 0;
ouverture = false;
kitDeDeminage = false;
}

boolean placerMine(){
    if (mine) {
        return false;
        }
    mine = true;
    return true;
}
        
        
boolean presenceMine() {
    return mine; 
}

boolean activerMine() {
    if (mine) {
        mine = false;
        kitDeDeminage = false;
        return true;
    }
    return false;
}

boolean placerKitDeminage() {
    if (kitDeDeminage) {
        kitDeDeminage = false;
        return false;
    }
    kitDeDeminage = true;
    return true;
}

boolean presenceKit() {
    return kitDeDeminage;
}

boolean recupererKit() {
    if(presenceKit()){
            kitDeDeminage = false;
            return true;
        }
        return false;
}

boolean presenceDrapeau() {
    return drapeau;
}

}