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

    ImageIcon previewImage = new ImageIcon(new ImageIcon("images/preview.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT ));
    private Plateau_m modelPlateau;
    private General_m modelGeneral;

    int i;
    int j;

    static Piece_m previousPiece = null;
    static int previousCoord[] = {-1, -1};


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

        //On clique une première fois sur la case
        if (!modelPlateau.getCase(i, j).isClicked()){
            if (piece!=null){

                // on passe indique que cette case est cliqué
                modelPlateau.setClickToTrue(i, j);

                //on colorie la prévisualisation
                colorPreview(i, j, piece, previousPiece);

                //On enregistre la pièce cliqué pour le futur clique
                previousPiece=piece;
                previousCoord[0]=i;
                previousCoord[1]=j;

                System.out.println("Cliquez une seconde fois pour confirmer");
            }
            else{
                System.out.println("Aucune pièce sélectionnée");
            }

        }
        else
        {
            //On clique une seconde fois
            if (piece!=null){

                System.out.println("Clique en "+i+";"+j+".");

                //On repasse la case cliqué à faux
                modelPlateau.setClickToFalse(i, j);

                //On récupère l'orientation de la pièce précédente pour pouvoir enelver la prévisualisation
                String orientation = previousPiece.getOrientation();

                switch (orientation){
                    case "Ouest" :
                        decolorPreviewOuest(previousCoord[0], previousCoord[1], previousPiece);
                        break;
                    case "Est" :
                        decolorPreviewEst(previousCoord[0], previousCoord[1], previousPiece);
                        break;
                    case "Sud" :
                        decolorPreviewSud(previousCoord[0], previousCoord[1], previousPiece);
                        break;
                    case "Nord" :
                        decolorPreviewNord(previousCoord[0], previousCoord[1], previousPiece);
                        break;
                }

                //On récupère l'orientation de la pièce active pour la positioner sur le plateau (ou pas)
                orientation = piece.getOrientation();

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
            else {
                System.out.println("Aucune pièce sélectionnée");
            }


            if (positionnementOk){
                System.out.println("Positionnement OK\n\n");

            /*for (int k=0;k<20;k++) {
                    for (int l = 0; l < 20; l++) {
                        System.out.print(modelPlateau.getCase(k, l).getCouleur() + "\t");
                    }
                System.out.println("");
            }*/

                //On augmente le score du joueur
                modelGeneral.selectJoueurActif().setScore(modelGeneral.selectJoueurActif().getScore()+piece.getListeCase().size());
                System.out.println(modelGeneral.selectJoueurActif().getNom() + " : "+ modelGeneral.selectJoueurActif().getScore() + "pts.\n\n");

                //On marque la pièce comme selectionnée
                piece.setUsed(true);

                //Déselectionne la pièce
                piece.setPieceSelection(false);

                //On remet l'overview à null
                modelGeneral.overviewButton.setIcon(null);
                modelGeneral.overviewButton.setBorderPainted(false);

                //On passe au joueur suivant
                modelGeneral.joueurSuivant();

                //On remet la pièce précédente à null
                previousPiece=null;

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

    }


    public void colorPreview(int i, int j, Piece_m piece, Piece_m previousPiece)
    {
        if (previousPiece==null)
        {
            System.out.println("Pas de pièce précédente");
            //Récupérer l'orientation de la pièce
            //Colorier le plateau en fonction de l'orientation de la pièce : couleur : orange
            //Si on sort du plateau, ignorer

            String orientation = piece.getOrientation();

            switch (orientation){
                case "Ouest" :
                    colorPreviewOuest(i, j, piece);
                    break;
                case "Est" :
                    colorPreviewEst(i, j, piece);
                    break;
                case "Sud" :
                    colorPreviewSud(i, j, piece);
                    break;
                case "Nord" :
                    colorPreviewNord(i, j, piece);
                    break;
            }

        }
        else
        {
            System.out.println("Il y a une pièce précédente");
            //Récupérer l'orientation de la pièce précédente
            //Récupérer les coordonnées de la pièce précédente
            //Enlever le background et l'icon de la pièce précédente en fonction de l'orientation et de previousCoord

            String orientation = previousPiece.getOrientation();
            System.out.println("Orientation de la pièce précédente :"+orientation);
            int a = previousCoord[0];
            int b = previousCoord[1];
            System.out.println("Coordonnées précédente : a="+a+" / b="+b);

            switch (orientation){
                case "Ouest" :
                    decolorPreviewOuest(a, b, previousPiece);
                    break;
                case "Est" :
                    decolorPreviewEst(a, b, previousPiece);
                    break;
                case "Sud" :
                    decolorPreviewSud(a, b, previousPiece);
                    break;
                case "Nord" :
                    decolorPreviewNord(a, b, previousPiece);
                    break;
            }


            //Récupérer l'orientation de la pièce
            //Colorier le plateau en fonction de l'orientation de la pièce : couleur : orange
            //Si on sort du plateau, ignorer

            orientation = piece.getOrientation();

            switch (orientation){
                case "Ouest" :
                    colorPreviewOuest(i, j, piece);
                    break;
                case "Est" :
                    colorPreviewEst(i, j, piece);
                    break;
                case "Sud" :
                    colorPreviewSud(i, j, piece);
                    break;
                case "Nord" :
                    colorPreviewNord(i, j, piece);
                    break;
            }

        }
    }


    public void colorPreviewOuest(int i, int j, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(i+k, j+l)) {
                //On passe le contenu du bouton à vrai
                modelPlateau.tabButton[i+k][j+l].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[i+k][j+l].setIcon(previewImage);
            }
        }
    }

    public void decolorPreviewOuest(int i, int j, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(i+k, j+l)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[i+k][j+l].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(i+k, j+l).getCouleur()=="White")
                {
                    modelPlateau.tabButton[i+k][j+l].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewEst(int i, int j, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(i - k, j + l)) {
                //On passe le contenu du bouton à vrai
                modelPlateau.tabButton[i - k][j + l].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[i - k][j + l].setIcon(previewImage);
            }
        }
    }

    public void decolorPreviewEst(int i, int j, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(i - k, j + l)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[i - k][j + l].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(i - k, j + l).getCouleur()=="White")
                {
                    modelPlateau.tabButton[i - k][j + l].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewSud(int i, int j, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(i+l,j-k)) {
                //On passe le contenu du bouton à vrai
                modelPlateau.tabButton[i+l][j-k].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[i+l][j-k].setIcon(previewImage);
            }
        }
    }

    public void decolorPreviewSud(int i, int j, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(i+l,j-k)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[i+l][j-k].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(i+l,j-k).getCouleur()=="White")
                {
                    modelPlateau.tabButton[i+l][j-k].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewNord(int i, int j, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(i-l,j+k)) {
                //On passe le contenu du bouton à vrai
                modelPlateau.tabButton[i-l][j+k].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[i-l][j+k].setIcon(previewImage);
            }
        }
    }

    public void decolorPreviewNord(int i, int j, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(i-l,j+k)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[i-l][j+k].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(i-l,j+k).getCouleur()=="White")
                {
                    modelPlateau.tabButton[i-l][j+k].setContentAreaFilled(false);
                }
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

    public boolean verifInGrid(int i, int j)
    {
        if(i>=0 && i<20 && j>=0 && j<20){
            return true ;
        }
        return false;
    }

    public boolean checkBordCase(int i, int j, Case_m caseIt)
    {
        boolean free = true;

        if (verifInGrid(i, j - 1)) {
            if (modelPlateau.getCase(i, j - 1).getCouleur() == caseIt.getCouleur())
                free = false;
        }
        if (verifInGrid(i - 1, j)) {
            if (modelPlateau.getCase(i- 1, j).getCouleur() == caseIt.getCouleur())
                free = false;
        }
        if (verifInGrid(i, j + 1)) {
            if (modelPlateau.getCase(i, j + 1).getCouleur() == caseIt.getCouleur())
                free = false;
        }
        if (verifInGrid(i + 1, j)) {
            if (modelPlateau.getCase(i + 1, j).getCouleur() == caseIt.getCouleur())
                free = false;
        }

        return free;
    }

    public boolean checkCoinCase(int i, int j, Case_m caseIt)
    {
        boolean free = false;

        if (verifInGrid(i-1, j-1)) {
            if (modelPlateau.getCase(i-1,j-1).getCouleur()==caseIt.getCouleur())
                free = true;
        }
        if (verifInGrid(i- 1, j + 1)) {
            if (modelPlateau.getCase(i - 1, j + 1).getCouleur() == caseIt.getCouleur())
                free = true;
        }
        if (verifInGrid(i + 1, j - 1)) {
            if (modelPlateau.getCase(i + 1, j - 1).getCouleur() == caseIt.getCouleur())
                free = true;
        }
        if (verifInGrid(i + 1, j + 1)) {
            if (modelPlateau.getCase(i + 1, j + 1).getCouleur() == caseIt.getCouleur())
                free = true;
        }

        return free;
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
                modelPlateau.tabButton[i+l][j-k].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i+l,j-k).getCouleur());
                modelPlateau.tabButton[i+l][j-k].setBackground(color.getColor());
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
            free = verifCase(i+l, j-k);

            //Vérifie si les 4 bords de la case caseIt sont ide
            free = checkBordCase(i+l, j-k, caseIt);

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

            free = checkCoinCase(i+l, j-k, caseIt);

            c++;
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
                Color_v color = new Color_v(modelPlateau.getCase(i+k, j+l).getCouleur());
                modelPlateau.tabButton[i+k][j+l].setBackground(color.getColor());

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
            free = checkBordCase(i+k, j+l, caseIt);

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

            free = checkCoinCase(i+k, j+l, caseIt);

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
                modelPlateau.tabButton[i-k][j+l].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i-k, j+l).getCouleur());
                modelPlateau.tabButton[i-k][j+l].setBackground(color.getColor());

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
            free = verifCase(i - k, j+l);

            //Vérifie si les 4 bords de la case caseIt sont ide
            free = checkBordCase(i-k, j+l, caseIt);

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

            free = checkCoinCase(i-k, j+l, caseIt);

            c++;
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
                modelPlateau.tabButton[i-l][j+k].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i-l,j+k).getCouleur());
                modelPlateau.tabButton[i-l][j+k].setBackground(color.getColor());
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
            free = verifCase(i-l, j+k);
            //Vérifie si les 4 bords de la case caseIt sont ide
            free = checkBordCase(i-l, j+k, caseIt);

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

            free = checkCoinCase(i-l, j+k, caseIt);

            c++;
        }

        return free;
    }




}
