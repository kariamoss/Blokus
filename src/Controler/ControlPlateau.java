package Controler;

import Model.Case_m;
import Model.Piece_m;
import Model.Plateau_m;

import java.util.Iterator;

/**
 * Created by Jehan on 26/11/2015.
 */
public class ControlPlateau {


    private Plateau_m plateau;

    public ControlPlateau(Plateau_m plateau){
        this.plateau = plateau;
    }

    public boolean verifCase(int i, int j){

        //Vérifie si grille[i][j] est dans le tableau
        //Si oui, vérifie que la case n'est pas déjà occupé
        if(i>=0 && i<20 && j>=0 && j<20){
            if (plateau.getCase(i,j).getCouleur().equals("White")){
                return true ;
            }
        }
        return false;
    }

    public void positionnementSud(int i, int j, Piece_m piece){
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            if (verifCase(i+l, j-k))
            {
                plateau.getCase(i+l,j-k).setCouleur("Red");
            }
            else
            {
                System.out.println("Erreur pour la case "+i+","+j);
                break;
            }
        }
    }

    public void positionnementOuest(int i, int j, Piece_m piece){
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            if (verifCase(i+k, j+l))
            {
                plateau.getCase(i+k,j+l).setCouleur("Red");
            }
            else
            {
                System.out.println("Erreur pour la case "+i+","+j);
                break;
            }
        }
    }

    public void positionnementEst(int i, int j, Piece_m piece){
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            if (verifCase(i-k, j+l))
            {
                plateau.getCase(i-k,j+l).setCouleur("Red");
            }
            else
            {
                System.out.println("Erreur pour la case "+i+","+j);
                break;
            }
        }
    }

    public void positionnementNord(int i, int j, Piece_m piece){
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            if (verifCase(i-l, j+k))
            {
                plateau.getCase(i-l,j+k).setCouleur("Red");
            }
            else
            {
                System.out.println("Erreur pour la case "+i+","+j);
                break;
            }
        }
    }

}
