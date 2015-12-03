package Controler;

import Model.General_m;
import Model.Piece_m;
import Vue.BoutonsControleJeu_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lucas on 01/12/2015.
 */
public class ControlRotationButton implements ActionListener
{
    General_m modelGeneral;
    BoutonsControleJeu_v vue;
    int i;

    public ControlRotationButton(General_m modelGeneral, BoutonsControleJeu_v vue, int i){
        this.modelGeneral = modelGeneral;
        this.vue = vue;
        this.i=i;
    }

    public void actionPerformed(ActionEvent f) {

        Piece_m piece = modelGeneral.selectJoueurActif().getInventaire().selectPieceActive();
        if (piece!=null)
        {
            //System.out.println("caca");
            /*if (f.getSource() == vue.btRetournerGauche) {
                System.out.println("Rotation vers la gauche");
            }
            if (f.getSource() == vue.btRetournerDroite) {
                System.out.println("Rotation vers la droite");
            }*/

            if (i==1) {
                System.out.print("Rotation vers la gauche / Orientation : ");
                piece.rotateLeft();
            }
            if (i==2) {
                System.out.print("Rotation vers la droite / Orientation : ");
                piece.rotateRight();
            }
            System.out.println(piece.getOrientation());

        }
        else
        {
            System.out.println("Aucune pièce sélectionnée");
        }

    }
}