package Controler;

import Helper.Helper_Preview;
import Model.*;
import Vue.General_v;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlButton implements ActionListener {


    General_m modelGeneral;
    General_v vueGeneral;
    Helper_Preview helper_preview;

    int i;

    public ControlButton(General_v vueGeneral, General_m modelGeneral){
        this.modelGeneral = modelGeneral;
        this.vueGeneral = vueGeneral;
        helper_preview = vueGeneral.helper_preview;

        vueGeneral.inventaire.setInventaireButtonControler(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(modelGeneral.partieReseau){
            if(!modelGeneral.networkManager.canPlay())
                return;
        }



        for (int i = 0; i < 20; i++) {
            if (e.getSource() == vueGeneral.inventaire.tabButtonInventaire[i]){
                this.i = i;
            }
        }

        Joueur_m joueur = modelGeneral.selectJoueurActif();
        String nomJoueur = joueur.getNom();


        System.out.println("Joueur : " + nomJoueur + " / Selection de la pièce : " + i);


        //Récupérer la pièce active actuellement
        //Récupérer son orentation et sa position
        //Faire un décolorPreview de cette piece

        Piece_m pieceActuelle = joueur.getInventaire().selectPieceActive();

        if (pieceActuelle!=null)
        {
            int a = pieceActuelle.getPositionI();
            int b = pieceActuelle.getPositionJ();
            helper_preview.setColorPreview(a, b, pieceActuelle, true);

        }

        joueur.getInventaire().selectPiece(i);

        Piece_m pieceSelectionnee = joueur.getInventaire().selectPieceActive();
        ImageIcon imageIcon = new ImageIcon(pieceSelectionnee.getImage());
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(105, 105, java.awt.Image.SCALE_SMOOTH) ;
        ImageIcon icon = new ImageIcon(newImage);

        vueGeneral.overview.overviewButton.setIcon(icon);

        vueGeneral.overview.overviewButton.setBorderPainted(true);
    }
    
}
