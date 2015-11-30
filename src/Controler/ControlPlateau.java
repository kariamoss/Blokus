package Controler;

import Model.Case_m;
import Model.Joueur_m;
import Model.Piece_m;
import Model.Plateau_m;
import Vue.Color_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jehan on 26/11/2015.
 */
public class ControlPlateau implements ActionListener {


    private Plateau_m plateau;
    int i;
    int j;
    static int compteur = 0;

    public ControlPlateau(Plateau_m plateau){
        this.plateau = plateau;
    }

    public ControlPlateau(Plateau_m plateau, int i, int j){
        this.plateau = plateau;
        this.i = i;
        this.j = j;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Clique en "+i+";"+j+".");
        //plateau.getCase(i,j).setCouleur("Blue");
        //Color_v color = new Color_v(plateau.getCase(i, j).getCouleur());
        //plateau.tabButton[i][j].setBackground(color.getColor());

        Joueur_m j1 = new Joueur_m("Red","j1");
        j1.getInventaire().selectPiece(compteur);
        Piece_m piece = j1.getInventaire().selectPieceActive();
        positionnementOuest(i, j, piece);
        for (int i=0;i<20;i++) {
            for (int j=0;j<20;j++) {
                Color_v color = new Color_v(plateau.getCase(i, j).getCouleur());
                plateau.tabButton[i][j].setBackground(color.getColor());
            }
        }
        compteur++;
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

        if (checkPositionnementOuest(i, j, piece)){
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
        else
        {
            System.out.println("Placement impossible");
        }
    }

    public boolean checkPositionnementOuest(int i, int j, Piece_m piece){
        boolean free = true;
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            if (!verifCase(i + k, j + l)) {
                free = false;
            }
        }
            return free;
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
