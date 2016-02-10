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


    public int[] getCoordCase(String orientation, int i, int j, int k, int l) {
        int[] tab = new int[2];
        switch (orientation){
            case "Ouest" :
                tab[0]=i+k; tab[1]=j+l;
                break;
            case "Est" :
                tab[0]=i-k; tab[1]=j-l;
                break;
            case "Sud" :
                tab[0]=i-l; tab[1]=j+k;
                break;
            case "Nord" :
                tab[0]=i+l; tab[1]=j-k;
                break;
        }
        return tab;
    }


    public void setColorPreview(int a, int b, Piece_m piece, boolean preview){
        int[] tab = new int[2];
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            tab = getCoordCase(piece.getOrientation(), a, b, k, l);
            //On vérifie si la case est sur le plateau
            if (verifInGrid(tab[0], tab[1])) {
                if(preview){
                    //On enlève l'image de prévisualisation sur le bouton
                    vuePlateau.tabButton[tab[0]][tab[1]].setIcon(null);
                    //On passe le contenu du bouton à faux si il n'y a pas de case posée
                    if (modelPlateau.getCase(tab[0], tab[1]).getCouleur().equals("White"))
                        vuePlateau.tabButton[tab[0]][tab[1]].setContentAreaFilled(false);
                }
                else {
                    //On passe le contenu du bouton à vrai
                    vuePlateau.tabButton[tab[0]][tab[1]].setContentAreaFilled(true);
                    //On set l'image de prévisualisation sur le bouton
                    vuePlateau.tabButton[tab[0]][tab[1]].setIcon(previewImage);
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
