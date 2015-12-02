package Controler;

import Helper.Color_v;
import Model.Case_m;
import Model.General_m;
import Model.Piece_m;
import Model.Plateau_m;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

            //On augmente le score du joueur
            modelGeneral.selectJoueurActif().setScore(modelGeneral.selectJoueurActif().getScore()+piece.getListeCase().size());
            System.out.println(modelGeneral.selectJoueurActif().getNom() + " : "+ modelGeneral.selectJoueurActif().getScore() + "pts.\n\n");

            //On maarque la pièce comme selectionnée
            piece.setUsed(true);

            //Déselectionne la pièce
            piece.setPieceSelection(false);

            //On remet l'overview à null
            modelGeneral.overviewButton.setIcon(null);

            modelGeneral.overviewButton.setBorderPainted(false);

           //On passe au joueur suivant
            modelGeneral.joueurSuivant();

            //On change d'inventaire
            List<Piece_m> listPiece = modelGeneral.selectJoueurActif().getInventaire().getListPiece();

            for (int i =0;i<listPiece.size()-1;i++)
            {
                modelGeneral.tabButtonInventaire[i].setEnabled(true);
                if(modelGeneral.selectJoueurActif().getInventaire().getPiece(i).isUsed())
                {
                    modelGeneral.tabButtonInventaire[i].setEnabled(false);
                }
                ImageIcon imageIcon = new ImageIcon(listPiece.get(i).getImage());
                Image image = imageIcon.getImage();
                Image newImage = image.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH) ;
                ImageIcon icon = new ImageIcon(newImage);

                modelGeneral.tabButtonInventaire[i].setIcon(icon);
            }


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
                modelPlateau.tabButton[i][j].setContentAreaFilled(true);
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
        if(free){
            //Si on a passé avec succès l'étape de vérification du positionnement,
            //On peut passer à l'étape suivante : vérification des bords
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On vérifie les bords de la pièce
                free = checkBordPiece(i +l, j -k, caseIt);
            }
            if (free){
                for(Case_m caseIt : piece.getListeCase()) {
                    //Récupère la position de la case dans la pièce
                    int k = caseIt.getPosI();
                    int l = caseIt.getPosJ();

                    //On vérifie les coin de la pièce
                    free = checkCoinPiece(i +l, j -k, caseIt);
                }
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

        if (checkPositionnementOuest(i, j, piece))
        {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i+k,j+l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                modelPlateau.tabButton[i+k][j+l].setContentAreaFilled(true);

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

        int c=0;
        boolean free = true;
        int k, l;

        //Tant qu'on a pas parcouru toute les cases et que le positionnement est libre
        while (c<piece.getListeCase().size() && free)
        {
            Case_m caseIt = piece.getListeCase().get(c);
            k = caseIt.getPosI();
            l = caseIt.getPosJ();

            //Vérifie si la case est sur le plateau et vide
            free = verifCase(i+k, j+l);

            //Vérifie si les 4 bords de la case caseIt sont ide
            if (verifInGrid(i+k, j+l - 1)) {
                if (modelPlateau.getCase(i+k, j+l - 1).getCouleur() == caseIt.getCouleur())
                    free = false;
            }
            if (verifInGrid(i+k - 1, j+l)) {
                if (modelPlateau.getCase(i+k- 1, j+l).getCouleur() == caseIt.getCouleur())
                    free = false;
            }
            if (verifInGrid(i+k, j+l + 1)) {
                if (modelPlateau.getCase(i+k, j+l + 1).getCouleur() == caseIt.getCouleur())
                    free = false;
            }
            if (verifInGrid(i+k + 1, j+k)) {
                if (modelPlateau.getCase(i+k + 1, j+l).getCouleur() == caseIt.getCouleur())
                    free = false;
            }
            c++;
        }

        if (!free)
            return free;


        // On parcours toute les cases à nouveau pour checker si on trouve au moins un coin de couleur piece
        c=0;
        free = false;
        while (c<piece.getListeCase().size() && !free)
        {
            Case_m caseIt = piece.getListeCase().get(c);
            k = caseIt.getPosI();
            l = caseIt.getPosJ();

            if (verifInGrid(i+k-1, j+l-1)) {
                if (modelPlateau.getCase(i+k-1,j+l-1).getCouleur()==caseIt.getCouleur())
                    free = true;
            }
            if (verifInGrid(i+k - 1, j+l + 1)) {
                if (modelPlateau.getCase(i+k - 1, j+l + 1).getCouleur() == caseIt.getCouleur())
                    free = true;
            }
            if (verifInGrid(i+k + 1, j+l - 1)) {
                if (modelPlateau.getCase(i+k + 1, j+l - 1).getCouleur() == caseIt.getCouleur())
                    free = true;
            }
            if (verifInGrid(i+k + 1, j+l + 1)) {
                if (modelPlateau.getCase(i+k + 1, j+l + 1).getCouleur() == caseIt.getCouleur())
                    free = true;
            }
            c++;
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
        if(free){
            //Si on a passé avec succès l'étape de vérification du positionnement,
            //On peut passer à l'étape suivante : vérification des bords
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On vérifie les bords de la pièce
                free = checkBordPiece(i - k, j + l, caseIt);
            }
            if (free){
                for(Case_m caseIt : piece.getListeCase()) {
                    //Récupère la position de la case dans la pièce
                    int k = caseIt.getPosI();
                    int l = caseIt.getPosJ();

                    //On vérifie les coin de la pièce
                    free = checkCoinPiece(i - k, j + l, caseIt);
                }
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
        if(free){
            //Si on a passé avec succès l'étape de vérification du positionnement,
            //On peut passer à l'étape suivante : vérification des bords
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On vérifie les bords de la pièce
                free = checkBordPiece(i - l, j + k, caseIt);
                if (!free)
                    return free;
            }
            if (free){
                for(Case_m caseIt : piece.getListeCase()) {
                    //Récupère la position de la case dans la pièce
                    int k = caseIt.getPosI();
                    int l = caseIt.getPosJ();

                    //On vérifie les coin de la pièce
                    free = checkCoinPiece(i - l, j + k, caseIt);
                    if (!free)
                        return free;
                }
            }
        }
        return free;
    }


    private boolean checkBordPiece(int i, int j, Case_m caseIt)
    {
        boolean touche = true;
        //Si on trouve une case plateau qui à la même couleur qu'une case pièce, on passe à faux
        if (verifInGrid(i, j - 1)) {
            if (modelPlateau.getCase(i, j - 1).getCouleur() == caseIt.getCouleur())
                touche = false;
        }
        if (verifInGrid(i - 1, j)) {
            if (modelPlateau.getCase(i - 1, j).getCouleur() == caseIt.getCouleur())
                touche = false;
        }
        if (verifInGrid(i, j + 1)) {
            if (modelPlateau.getCase(i, j + 1).getCouleur() == caseIt.getCouleur())
                touche = false;
        }
        if (verifInGrid(i + 1, j)) {
            if (modelPlateau.getCase(i + 1, j).getCouleur() == caseIt.getCouleur())
                touche = false;
        }

        //Touche doit être vrai
        return touche;
    }

    private boolean checkCoinPiece(int i, int j, Case_m caseIt)
    {
        boolean touche = false;
        if (verifInGrid(i-1, j-1)) {
            if (modelPlateau.getCase(i-1,j-1).getCouleur()==caseIt.getCouleur())
                touche = true;
        }
        if (verifInGrid(i - 1, j + 1)) {
            if (modelPlateau.getCase(i - 1, j + 1).getCouleur() == caseIt.getCouleur())
                touche = true;
        }
        if (verifInGrid(i + 1, j - 1)) {
            if (modelPlateau.getCase(i + 1, j - 1).getCouleur() == caseIt.getCouleur())
                touche = true;
        }
        if (verifInGrid(i + 1, j + 1)) {
            if (modelPlateau.getCase(i + 1, j + 1).getCouleur() == caseIt.getCouleur())
                touche = true;
        }


        //Touche doit être vrai
        return touche;
    }
    private boolean verifInGrid(int i, int j)
    {
        if(i>=0 && i<20 && j>=0 && j<20){
            return true ;
        }
        return false;
    }

}
