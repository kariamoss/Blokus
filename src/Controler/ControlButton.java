package Controler;

import Model.General_m;
import Model.Joueur_m;
import Model.Piece_m;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlButton implements ActionListener {


    General_m modelGeneral;

    int i;

    public ControlButton(){

    }

    public ControlButton(General_m modelGeneral, int i){
        this.modelGeneral = modelGeneral;
        this.i = i;
    }

    public void actionPerformed(ActionEvent e)
    {
        Joueur_m joueur = modelGeneral.selectJoueurActif();
        String nomJoueur = joueur.getNom();

        if (!joueur.getInventaire().getPiece(i).isUsed())
        {
            System.out.println("Joueur : " + nomJoueur + " / Selection de la pièce : " + i);

            joueur.getInventaire().selectPiece(i);

            Piece_m pieceSelectionnee = joueur.getInventaire().selectPieceActive();
            ImageIcon imageIcon = new ImageIcon(pieceSelectionnee.getImage());
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(105, 105, java.awt.Image.SCALE_SMOOTH) ;
            ImageIcon icon = new ImageIcon(newImage);

            modelGeneral.overviewButton.setIcon(icon);

            modelGeneral.overviewButton.setBorderPainted(true);
        }
        else
        {
            System.out.println("La pièce "+ i + " a déjà été posée");
        }


        // RAJOUTER LES METHODE POUR LA ROTATION
    }

}
