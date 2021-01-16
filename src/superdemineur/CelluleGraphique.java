/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superdemineur;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Hugo
 */
public class CelluleGraphique extends JButton {
    Cellule celluleassociée;
    ImageIcon img_mine = new javax.swing.ImageIcon(getClass().getResource("/Image/bombe_decouvert.png"));
    ImageIcon img_mineDecouverte = new javax.swing.ImageIcon(getClass().getResource("/Image/bombe_decouvert.png"));
    ImageIcon img_case = new javax.swing.ImageIcon(getClass().getResource("/Image/case.png"));
    ImageIcon img_casevide = new javax.swing.ImageIcon(getClass().getResource("/Image/case_vide.png"));
    ImageIcon img_drapeau = new javax.swing.ImageIcon(getClass().getResource("/Image/drapeau.png"));
    ImageIcon img_kit = new javax.swing.ImageIcon(getClass().getResource("/Image/kit.jpg"));
    
    public CelluleGraphique(Cellule uneCellule){
        celluleassociée = uneCellule;
    }

   @Override
   public void paintComponent (Graphics G) {
       super.paintComponent(G);
       if (celluleassociée.presenceMine() == true){
           setIcon(img_mine);
       }
       
       else if (celluleassociée.presenceKit() == true){
           setIcon(img_kit);
          
       }
       else if (celluleassociée.proxiMine ==1) {
           setIcon(img_case);
       }
       
       
   }
    
    }







