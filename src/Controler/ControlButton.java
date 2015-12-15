package Controler;

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

    int i;

    public ControlButton(){

    }

    public ControlButton(General_m modelGeneral, int i){
        this.modelGeneral = modelGeneral;
        this.modelPlateau = modelGeneral.getModelPlateau();
        this.i = i;
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
                    decolorPreviewOuest(a, b, pieceActuelle);
                    break;
                case "Est" :
                    decolorPreviewEst(a, b, pieceActuelle);
                    break;
                case "Sud" :
                    decolorPreviewSud(a, b, pieceActuelle);
                    break;
                case "Nord" :
                    decolorPreviewNord(a, b, pieceActuelle);
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

    public void decolorPreviewOuest(int a, int b, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a+k, b+l)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a+k][b+l].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a+k, b+l).getCouleur()=="White")
                {
                    modelPlateau.tabButton[a+k][b+l].setContentAreaFilled(false);
                }
            }
        }
    }



    public void decolorPreviewEst(int a, int b, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a - k, b - l)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a- k][b - l].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a - k, b - l).getCouleur()=="White")
                {
                    modelPlateau.tabButton[a - k][b - l].setContentAreaFilled(false);
                }
            }
        }
    }

    public void decolorPreviewSud(int a, int b, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a-l,b+k)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a-l][b+k].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a-l,b+k).getCouleur()=="White")
                {
                    modelPlateau.tabButton[a-l][b+k].setContentAreaFilled(false);
                }
            }
        }
    }

    public void decolorPreviewNord(int a, int b, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a+l,b-k)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a+l][b-k].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a+l,b-k).getCouleur()=="White")
                {
                    modelPlateau.tabButton[a+l][b-k].setContentAreaFilled(false);
                }
            }
        }
    }
    public boolean verifInGrid(int i, int j)
    {
        if(i>=0 && i<20 && j>=0 && j<20){
            return true ;
        }
        return false;
    }


}
