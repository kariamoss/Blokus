package Controler;

import Helper.Helper_Preview;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlButton implements ActionListener {


    General_m modelGeneral;
    Plateau_m modelPlateau;
    Helper_Preview helper_preview;

    int i;

    public ControlButton(){

    }

    public ControlButton(General_m modelGeneral, int i){
        this.modelGeneral = modelGeneral;
        this.modelPlateau = modelGeneral.getModelPlateau();
        this.i = i;
        helper_preview = new Helper_Preview(modelGeneral);
    }

    public void actionPerformed(ActionEvent e)
    {
        Joueur_m joueur = modelGeneral.selectJoueurActif();
        String nomJoueur = joueur.getNom();


        System.out.println("Joueur : " + nomJoueur + " / Selection de la pièce : " + i);


        //Récupérer la pièce active actuellement
        //Récupérer son orentation et sa position
        //Faire un décolorPreview de cette piece

        Piece_m pieceActuelle = joueur.getInventaire().selectPieceActive();

        if (pieceActuelle!=null)
        {
            String orientation  = pieceActuelle.getOrientation();
            int a = pieceActuelle.getPositionI();
            int b = pieceActuelle.getPositionJ();

            switch (orientation){
                case "Ouest" :
                    helper_preview.decolorPreviewOuest(a, b, pieceActuelle);
                    break;
                case "Est" :
                    helper_preview.decolorPreviewEst(a, b, pieceActuelle);
                    break;
                case "Sud" :
                    helper_preview.decolorPreviewSud(a, b, pieceActuelle);
                    break;
                case "Nord" :
                    helper_preview.decolorPreviewNord(a, b, pieceActuelle);
                    break;
            }
        }



        joueur.getInventaire().selectPiece(i);

        Piece_m pieceSelectionnee = joueur.getInventaire().selectPieceActive();
        ImageIcon imageIcon = new ImageIcon(pieceSelectionnee.getImage());
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(105, 105, java.awt.Image.SCALE_SMOOTH) ;
        ImageIcon icon = new ImageIcon(newImage);

        modelGeneral.overviewButton.setIcon(icon);

        modelGeneral.overviewButton.setBorderPainted(true);
    }
    
}
