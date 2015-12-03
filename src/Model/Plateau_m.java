package Model;

import javax.swing.*;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class Plateau_m {
    private int taillePlateau = 20;
    private Case_m[][] plateau;
    public JButton[][] tabButton;

    General_m modelGeneral;


    public Plateau_m(General_m modelGeneral){
        genererPlateau(taillePlateau);
        this.modelGeneral = modelGeneral;

    }

    public Case_m[][] genererPlateau(int taillePlateau){
        plateau = new Case_m[taillePlateau][taillePlateau];
        for(int i=0; i<taillePlateau;i++){
            for(int j=0; j<taillePlateau;j++){
                plateau[i][j]= new Case_m("White",i,j);
                System.out.print(plateau[i][j].getCouleur() + "\t");
            }
            System.out.println("");
        }
        return plateau;

    }

    public Case_m getCase(int i, int j){
        return plateau[i][j];
    }


    public int getTaillePlateau() {
        return taillePlateau;
    }


    public void posePremieresPiece()
    {
        int i;
        int j;

        //getCase(5, 7).setCouleur("Red");
        //Joueur 0
        modelGeneral.selectJoueur(0);
        Joueur_m joueur0 = modelGeneral.selectJoueurActif();

        //Piece 19 orientation Sud en haut à gauche
        i=1;
        j=1;
        Piece_m pieceJ0 = joueur0.getInventaire().getPiece(18);

        for(Case_m caseIt : pieceJ0.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            getCase(i+l,j-k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
        }

        pieceJ0.setUsed(true);

        for (int c =0;c<joueur0.getInventaire().listePiece.size()-1;c++) {
            modelGeneral.tabButtonInventaire[c].setEnabled(true);
            if (modelGeneral.selectJoueurActif().getInventaire().getPiece(c).isUsed()) {
                modelGeneral.tabButtonInventaire[c].setEnabled(false);
            }

        }

        //Joueur 1
        modelGeneral.selectJoueur(1);
        Joueur_m joueur1 = modelGeneral.selectJoueurActif();

        //Piece 12 orientation Est en haut à droite
        i=0;
        j=19;
        Piece_m pieceJ1 = joueur1.getInventaire().getPiece(11);
        for(Case_m caseIt : pieceJ1.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            getCase(i - k, j - l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
        }
        pieceJ1.setUsed(true);

        for (int c =0;c<joueur1.getInventaire().listePiece.size()-1;c++) {
            modelGeneral.tabButtonInventaire[c].setEnabled(true);
            if (modelGeneral.selectJoueurActif().getInventaire().getPiece(c).isUsed()) {
                modelGeneral.tabButtonInventaire[c].setEnabled(false);
            }

        }



        //Joueur 2
        modelGeneral.selectJoueur(2);
        Joueur_m joueur2 = modelGeneral.selectJoueurActif();

        //Piece 12 orientation Ouest en bas à gauche
        i=19;
        j=0;
        Piece_m pieceJ2 = joueur2.getInventaire().getPiece(11);
        for(Case_m caseIt : pieceJ2.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            getCase(i + k, j + l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
        }
        pieceJ2.setUsed(true);

        for (int c =0;c<joueur2.getInventaire().listePiece.size()-1;c++) {
            modelGeneral.tabButtonInventaire[c].setEnabled(true);
            if (modelGeneral.selectJoueurActif().getInventaire().getPiece(c).isUsed()) {
                modelGeneral.tabButtonInventaire[c].setEnabled(false);
            }

        }



        //Joueur 3
        modelGeneral.selectJoueur(3);
        Joueur_m joueur3 = modelGeneral.selectJoueurActif();

        //Piece 17 orientation Nord en bas à droite
        i=18;
        j=18;
        Piece_m pieceJ3 = joueur3.getInventaire().getPiece(16);
        for(Case_m caseIt : pieceJ3.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            getCase(i - l, j + k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
        }
        pieceJ3.setUsed(true);

        for (int c =0;c<joueur3.getInventaire().listePiece.size()-1;c++) {
            modelGeneral.tabButtonInventaire[c].setEnabled(true);
            if (modelGeneral.selectJoueurActif().getInventaire().getPiece(c).isUsed()) {
                modelGeneral.tabButtonInventaire[c].setEnabled(false);
            }

        }
    }
}