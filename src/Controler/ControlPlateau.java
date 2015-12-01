package Controler;

import Model.Case_m;
import Model.General_m;
import Model.Piece_m;
import Model.Plateau_m;
import Vue.Color_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jehan on 26/11/2015.
 */
public class ControlPlateau implements ActionListener {


    private Plateau_m modelPlateau;
    private General_m modelGeneral;

    int i;
    int j;


    public ControlPlateau(General_m modelGeneral, Plateau_m modelPlateau, int i, int j)
    {
        this.modelGeneral = modelGeneral;
        this.modelPlateau = modelPlateau;
        this.i = i;
        this.j = j;
    }

    public void actionPerformed(ActionEvent e) {
        boolean positionnementOk = false;
        Piece_m piece = modelGeneral.selectJoueurActif().getInventaire().selectPieceActive();
        if (piece!=null){

            System.out.println("Clique en "+i+";"+j+".");
            int indexPiece = modelGeneral.selectJoueurActif().getInventaire().getListPiece().indexOf(piece);
            String orientation = piece.getOrientation();


            switch (orientation){
                case "Ouest" :
                    positionnementOk = positionnementOuest(i, j, piece);
                    break;
                case "Est" :
                    positionnementOk = positionnementEst(i, j, piece);
                    break;
                case "Sud" :
                    positionnementOk = positionnementSud(i, j, piece);
                    break;
                case "Nord" :
                    positionnementOk = positionnementNord(i, j, piece);
                    break;

            }
        }
        else
        {
            System.out.println("Aucune pièce sélectionnée");
        }





        if (positionnementOk){

            //Parcours de la grille pour reset les bonne couleur
            for (int k=0;k<20;k++) {
                for (int l = 0; l < 20; l++) {
                    Color_v color = new Color_v(modelPlateau.getCase(k, l).getCouleur());
                    modelPlateau.tabButton[k][l].setBackground(color.getColor());
                }
            }

            piece.setUsed(true);
            //Déselectionne la pièce
            piece.setPieceSelection(false);

            //modelGeneral.selectJoueurActif().getInventaire().tabButtonInventaire[indexPiece].setBackground(Color.black);


            modelGeneral.joueurSuivant();

        }
    }

    public boolean verifCase(int i, int j){

        //Vérifie si grille[i][j] est dans le tableau
        //Si oui, vérifie que la case n'est pas déjà occupé
        if(i>=0 && i<20 && j>=0 && j<20){
            if (modelPlateau.getCase(i,j).getCouleur().equals("White")){
                return true ;
            }
        }
        return false;
    }


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //                    SUD
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////

    public boolean positionnementSud(int i, int j, Piece_m piece){
        if (checkPositionnementSud(i, j, piece))
        {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i+l,j-k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
            }
            return true;
        }
        else
        {
            System.out.println("Placement impossible");
            return false;
        }

    }

    public boolean checkPositionnementSud(int i, int j, Piece_m piece){
        boolean free = true;
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            if (!verifCase(i+l, j-k))
            {
                free = false;
            }
        }
        return free;
    }


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //                    OUEST
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////

    public boolean positionnementOuest(int i, int j, Piece_m piece){

        if (checkPositionnementOuest(i, j, piece)){
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i+k,j+l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());

            }
            return true;
        }
        else
        {
            System.out.println("Placement impossible");
            return false;
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


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //                    EST
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////

    public boolean positionnementEst(int i, int j, Piece_m piece){
        if (checkPositionnementEst(i, j, piece)) {
            for (Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i - k, j + l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());

            }
            return true;
        }
        else
        {
            System.out.println("Placement impossible");
            return false;
        }
    }

    public boolean checkPositionnementEst(int i, int j, Piece_m piece){
        boolean free = true;
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            if (!verifCase(i-k, j+l))
            {
                free = false;
            }
        }
        return free;
    }


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //                    NORD
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////

    public boolean positionnementNord(int i, int j, Piece_m piece){
        if (checkPositionnementNord(i, j, piece))
        {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i-l,j+k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
            }
            return true;
        }
        else
        {
            System.out.println("Placement impossible");
            return false;
        }
    }

    public boolean checkPositionnementNord(int i, int j, Piece_m piece){
        boolean free = true;
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            if (!verifCase(i-l, j+k))
            {
                free = false;
            }
        }
        return free;
    }

}
