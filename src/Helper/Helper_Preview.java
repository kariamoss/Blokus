package Helper;

import Model.Case_m;
import Model.General_m;
import Model.Piece_m;
import Model.Plateau_m;
import Vue.General_v;
import Vue.Plateau_v;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lucas on 16/12/2015.
 */
public class Helper_Preview {

    Plateau_v vuePlateau; //TODO Changer model en vue pour les tabButton : OK
    Plateau_m modelPlateau;
    ImageIcon previewImage = new ImageIcon(new ImageIcon("images/preview.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT ));

    public Helper_Preview(General_v vueGeneral, General_m modelGeneral)
    {
        modelPlateau = modelGeneral.modelPlateau;
        vuePlateau = vueGeneral.plateau;
    }

    public void colorPreviewOuest(int a, int b, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a+k, b+l)) {
                //On passe le contenu du bouton à vrai
                vuePlateau.tabButton[a+k][b+l].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                vuePlateau.tabButton[a+k][b+l].setIcon(previewImage);
            }
        }
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
                vuePlateau.tabButton[a+k][b+l].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a+k, b+l).getCouleur()=="White")
                {
                    vuePlateau.tabButton[a+k][b+l].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewEst(int a, int b, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a - k, b - l)) {
                //On passe le contenu du bouton à vrai
                vuePlateau.tabButton[a - k][b - l].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                vuePlateau.tabButton[a - k][b - l].setIcon(previewImage);
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
                vuePlateau.tabButton[a- k][b - l].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a - k, b - l).getCouleur()=="White")
                {
                    vuePlateau.tabButton[a - k][b - l].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewSud(int a, int b, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a-l,b+k)) {
                //On passe le contenu du bouton à vrai
                vuePlateau.tabButton[a-l][b+k].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                vuePlateau.tabButton[a-l][b+k].setIcon(previewImage);
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
                vuePlateau.tabButton[a-l][b+k].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a-l,b+k).getCouleur()=="White")
                {
                    vuePlateau.tabButton[a-l][b+k].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewNord(int a, int b, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a+l,b-k)) {
                //On passe le contenu du bouton à vrai
                vuePlateau.tabButton[a+l][b-k].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                vuePlateau.tabButton[a+l][b-k].setIcon(previewImage);
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
                vuePlateau.tabButton[a+l][b-k].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a+l,b-k).getCouleur()=="White")
                {
                    vuePlateau.tabButton[a+l][b-k].setContentAreaFilled(false);
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

    public boolean checkBordCase(int i, int j, String color)
    {
        boolean free = true;

        if (verifInGrid(i, j - 1)) {
            if (modelPlateau.getCase(i, j - 1).getCouleur().equals(color))
                free = false;
        }
        if (verifInGrid(i - 1, j)) {
            if (modelPlateau.getCase(i- 1, j).getCouleur().equals(color))
                free = false;
        }
        if (verifInGrid(i, j + 1)) {
            if (modelPlateau.getCase(i, j + 1).getCouleur().equals(color))
                free = false;
        }
        if (verifInGrid(i + 1, j)) {
            if (modelPlateau.getCase(i + 1, j).getCouleur().equals(color))
                free = false;
        }

        return free;
    }

    public boolean checkCoinCase(int i, int j, String color)
    {
        boolean free = false;

        if (verifInGrid(i-1, j-1)) {
            if (modelPlateau.getCase(i-1,j-1).getCouleur().equals(color))
                free = true;
        }
        if (verifInGrid(i- 1, j + 1)) {
            if (modelPlateau.getCase(i - 1, j + 1).getCouleur().equals(color))
                free = true;
        }
        if (verifInGrid(i + 1, j - 1)) {
            if (modelPlateau.getCase(i + 1, j - 1).getCouleur().equals(color))
                free = true;
        }
        if (verifInGrid(i + 1, j + 1)) {
            if (modelPlateau.getCase(i + 1, j + 1).getCouleur().equals(color))
                free = true;
        }
        return free;
    }
}
