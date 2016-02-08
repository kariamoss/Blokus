package Controler;

import Helper.Color_v;
import Helper.Helper_Preview;
import Model.Case_m;
import Model.General_m;
import Model.Piece_m;
import Model.Plateau_m;
import Vue.General_v;

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
    private General_v vueGeneral;
    int i;
    int j;

    Helper_Preview helper_preview;


    static Piece_m previousPiece = null;
    static int previousCoord[] = {-1, -1};


    public ControlPlateau(General_m modelGeneral, General_v vueGeneral)
    {
        this.modelGeneral = modelGeneral;
        this.vueGeneral = vueGeneral;

        helper_preview = vueGeneral.helper_preview;

        this.modelPlateau = modelGeneral.modelPlateau;

        vueGeneral.plateau.setButtonControler(this);

    }

    public void actionPerformed(ActionEvent e) {

        boolean positionnementOk = false;
        Piece_m piece = modelGeneral.selectJoueurActif().getInventaire().selectPieceActive();

        //TODO Chercher i et j (utiliser e.getSource() : OK
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (e.getSource() == vueGeneral.plateau.tabButton[i][j]) {
                    this.i = i;
                    this.j = j;
                }
            }
        }


        if (piece!=null) {
            //Si la pièce actuelle est différente de la pièce précédente
            if (piece != previousPiece) {
                //On passe le clique à faux
                modelPlateau.setClickToFalse(i, j);
            }
            //Sinon si l'orientation actuelle est différente de la pièce précédente
            else if (piece.getOrientation() != previousPiece.getOrientation()) {
                //On passe le clique à faux
                modelPlateau.setClickToFalse(i, j);
            }

            //On clique une première fois sur la case
            if (!modelPlateau.getCase(i, j).isClicked()) {

                // on passe indique que cette case est cliqué
                modelPlateau.setClickToTrue(i, j);

                //on colorie la prévisualisation
                colorPreview(i, j, piece);

                //On enregistre la pièce cliqué pour le futur clique
                previousPiece = piece;
                previousCoord[0] = i;
                previousCoord[1] = j;

                piece.setPositionI(i);
                piece.setPositionJ(j);

                System.out.println("Cliquez une seconde fois pour confirmer");

            } else {

                System.out.println("Clique en " + i + ";" + j + ".");

                //On repasse la case cliqué à faux
                modelPlateau.setClickToFalse(i, j);

                //On récupère l'orientation de la pièce précédente pour pouvoir enelver la prévisualisation
                String orientation = previousPiece.getOrientation();
                int a = previousCoord[0];
                int b = previousCoord[1];
                switch (orientation) {
                    case "Ouest":
                        helper_preview.decolorPreviewOuest(a, b, previousPiece);
                        break;
                    case "Est":
                        helper_preview.decolorPreviewEst(a, b, previousPiece);
                        break;
                    case "Sud":
                        helper_preview.decolorPreviewSud(a, b, previousPiece);
                        break;
                    case "Nord":
                        helper_preview.decolorPreviewNord(a, b, previousPiece);
                        break;
                }

                //On récupère l'orientation de la pièce active pour la positioner sur le plateau (ou pas)
                orientation = piece.getOrientation();

                if (modelGeneral.selectJoueurActif().getScore()==0){
                    switch (orientation) {
                        case "Ouest":
                            positionnementOk = firstOuest(i, j, piece);
                            break;
                        case "Est":
                            positionnementOk = firstEst(i, j, piece);
                            break;
                        case "Sud":
                            positionnementOk = firstSud(i, j, piece);
                            break;
                        case "Nord":
                            positionnementOk = firstNord(i, j, piece);
                            break;
                    }
                }
                else
                {
                    switch (orientation) {
                        case "Ouest":
                            positionnementOk = positionnementOuest(i, j, piece);
                            break;
                        case "Est":
                            positionnementOk = positionnementEst(i, j, piece);
                            break;
                        case "Sud":
                            positionnementOk = positionnementSud(i, j, piece);
                            break;
                        case "Nord":
                            positionnementOk = positionnementNord(i, j, piece);
                            break;
                    }
                }

            }
        }
        else {
            System.out.println("Aucune pièce sélectionnée");
        }



        if (positionnementOk){
            System.out.println("Positionnement OK\n\n");

            //On augmente le score du joueur
            modelGeneral.selectJoueurActif().setScore(modelGeneral.selectJoueurActif().getScore()+piece.getListeCase().size());
            System.out.println(modelGeneral.selectJoueurActif().getNom() + " : "+ modelGeneral.selectJoueurActif().getScore() + "pts.\n\n");
            modelGeneral.setGameStats();

            //On marque la pièce comme selectionnée
            piece.setUsed(true);

            //Déselectionne la pièce
            piece.setPieceSelection(false);

            //On remet l'overview à null
            vueGeneral.overview.overviewButton.setIcon(null);
            vueGeneral.overview.overviewButton.setBorderPainted(false);

            //On passe au joueur suivant
            modelGeneral.joueurSuivant();

            //On remet la pièce précédente à null
            previousPiece=null;

            //On set la position de la pièce
            piece.setPositionI(i);
            piece.setPositionJ(j);

            System.out.println("Coordonnées de la pièce : " + piece.getPositionI() + ";" + piece.getPositionJ());


            //On change d'inventaire
            List<Piece_m> listPiece = modelGeneral.selectJoueurActif().getInventaire().getListPiece();

            for (int i =0;i<listPiece.size()-1;i++)
            {
                vueGeneral.inventaire.tabButtonInventaire[i].setEnabled(true);
                if(modelGeneral.selectJoueurActif().getInventaire().getPiece(i).isUsed())
                {
                    vueGeneral.inventaire.tabButtonInventaire[i].setEnabled(false);
                }
                ImageIcon imageIcon = new ImageIcon(listPiece.get(i).getImage());
                Image image = imageIcon.getImage();
                Image newImage = image.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH) ;
                ImageIcon icon = new ImageIcon(newImage);

                vueGeneral.inventaire.tabButtonInventaire[i].setIcon(icon);
            }


        }
    }




    public void colorPreview(int i, int j, Piece_m piece)
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
                    helper_preview.colorPreviewOuest(i, j, piece);
                    break;
                case "Est" :
                    helper_preview.colorPreviewEst(i, j, piece);
                    break;
                case "Sud" :
                    helper_preview.colorPreviewSud(i, j, piece);
                    break;
                case "Nord" :
                    helper_preview.colorPreviewNord(i, j, piece);
                    break;
            }

        }
        else
        {
            System.out.println("Il y a une pièce précédente");
            //Récupérer l'orientation de la pièce précédente
            //Récupérer les coordonnées de la pièce précédente
            //Enlever le background et l'icon de la pièce précédente en fonction de l'orientation et de previousCoord

            String previousOrientation = previousPiece.getOrientation();
            System.out.println("Orientation de la pièce précédente :"+previousOrientation);
            int a = previousCoord[0];
            int b = previousCoord[1];
            System.out.println("Coordonnées précédente : a="+a+" / b="+b);

            switch (previousOrientation){
                case "Ouest" :
                    helper_preview.decolorPreviewOuest(a, b, previousPiece);
                    break;
                case "Est" :
                    helper_preview.decolorPreviewEst(a, b, previousPiece);
                    break;
                case "Sud" :
                    helper_preview.decolorPreviewSud(a, b, previousPiece);
                    break;
                case "Nord" :
                    helper_preview.decolorPreviewNord(a, b, previousPiece);
                    break;
            }

            //Récupérer l'orientation de la pièce
            //Colorier le plateau en fonction de l'orientation de la pièce : couleur : orange
            //Si on sort du plateau, ignorer

            String orientation = piece.getOrientation();

            switch (orientation){
                case "Ouest" :
                    helper_preview.colorPreviewOuest(i, j, piece);
                    break;
                case "Est" :
                    helper_preview.colorPreviewEst(i, j, piece);
                    break;
                case "Sud" :
                    helper_preview.colorPreviewSud(i, j, piece);
                    break;
                case "Nord" :
                    helper_preview.colorPreviewNord(i, j, piece);
                    break;
            }

        }
    }

    public boolean verifCase(int i, int j){

        //Vérifie si grille[i][j] est dans le tableau
        //Si oui, vérifie que la case n'est pas déjà occupé
        if(i>=0 && i<20 && j>=0 && j<20){
            if (modelPlateau.getCase(i,j).getCouleur()=="White"){
                System.out.println("Couleur case : " +modelPlateau.getCase(i, j).getCouleur());
                return true ;
            }
            System.out.println("Couleur case : " +modelPlateau.getCase(i, j).getCouleur());
        }
        return false;
    }


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //                    SUD
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    public boolean firstSud(int i, int j, Piece_m piece){
        boolean bool = false;
        boolean free;

        for(Case_m caseIt : piece.getListeCase()) {

            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            free = verifCase(i-l, j+k);

            if(!free){
                return free;
            }


        }

        for(Case_m caseIt : piece.getListeCase()) {

            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            if((i-l==0 && j+k==0) || (i-l==19 && j+k==0) || (i-l==0 && j+k==19) || (i-l==19 && j+k==19) ) {
                bool = true;
                break;
            }
        }

        if (bool) {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i-l,j+k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                vueGeneral.plateau.tabButton[i-l][j+k].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i-l,j+k).getCouleur());
                vueGeneral.plateau.tabButton[i-l][j+k].setBackground(color.getColor());
            }


            return true;
        }

        return false;
    }


    public boolean positionnementSud(int i, int j, Piece_m piece){
        if (checkPositionnementSud(i, j, piece))
        {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i-l,j+k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                vueGeneral.plateau.tabButton[i-l][j+k].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i-l,j+k).getCouleur());
                vueGeneral.plateau.tabButton[i-l][j+k].setBackground(color.getColor());
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
            free = verifCase(i-l, j+k);

            if (!free)
                return free;

            //Vérifie si les 4 bords de la case caseIt sont ide
            free = helper_preview.checkBordCase(i-l, j+k, caseIt);

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

            free = helper_preview.checkCoinCase(i-l, j+k, caseIt);

            c++;
        }

        return free;
    }


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //                    OUEST
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////

    public boolean firstOuest(int i, int j, Piece_m piece){
        boolean bool = false;
        boolean free;

        for(Case_m caseIt : piece.getListeCase()) {

            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            free = verifCase(i+k, j+l);

            if(!free){
                return free;
            }

        }

        for(Case_m caseIt : piece.getListeCase()) {

            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            if ((i + k == 0 && j + l == 0) || (i + k == 19 && j + l == 0) || (i + k == 0 && j + l == 19) || (i + k == 19 && j + l == 19)) {
                bool = true;
                break;
            }
        }

        if (bool) {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i+k,j+l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                vueGeneral.plateau.tabButton[i+k][j+l].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i+k,j+l).getCouleur());
                vueGeneral.plateau.tabButton[i+k][j+l].setBackground(color.getColor());
            }


            return true;
        }

        return false;
    }

    public boolean positionnementOuest(int i, int j, Piece_m piece){

        if (checkPositionnementOuest(i, j, piece))
        {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i+k,j+l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                System.out.print("Couleur piece : " + modelPlateau.getCase(i+k, j+l).getCouleur() + "   ");
                vueGeneral.plateau.tabButton[i+k][j+l].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i+k, j+l).getCouleur());
                vueGeneral.plateau.tabButton[i+k][j+l].setBackground(color.getColor());

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

            if (!free)
                return free;

            //Vérifie si les 4 bords de la case caseIt sont ide
            free = helper_preview.checkBordCase(i+k, j+l, caseIt);

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

            free = helper_preview.checkCoinCase(i+k, j+l, caseIt);

            c++;
        }

        return free;
    }


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //                    EST
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////

    public boolean firstEst(int i, int j, Piece_m piece){
        boolean bool = false;
        boolean free;

        for(Case_m caseIt : piece.getListeCase()) {

            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            free = verifCase(i - k, j - l);

            if(!free){
                return free;
            }


        }

        for(Case_m caseIt : piece.getListeCase()) {

            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            if((i - k==0 && j - l==0) || (i - k==19 && j - l==0) || (i - k==0 && j - l==19) || (i - k==19 && j - l==19) ) {
                bool = true;
                break;
            }
        }

        if (bool) {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i - k,j - l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                vueGeneral.plateau.tabButton[i - k][j - l].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i - k,j - l).getCouleur());
                vueGeneral.plateau.tabButton[i - k][j - l].setBackground(color.getColor());
            }


            return true;
        }

        return false;
    }

    public boolean positionnementEst(int i, int j, Piece_m piece){
        if (checkPositionnementEst(i, j, piece)) {
            for (Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i - k, j - l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                vueGeneral.plateau.tabButton[i-k][j-l].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i-k, j-l).getCouleur());
                vueGeneral.plateau.tabButton[i-k][j-l].setBackground(color.getColor());

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
            free = verifCase(i -k, j-l);

            if (!free)
                return free;

            //Vérifie si les 4 bords de la case caseIt sont ide
            free = helper_preview.checkBordCase(i-k, j-l, caseIt);

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

            free = helper_preview.checkCoinCase(i-k, j-l, caseIt);

            c++;
        }

        return free;
    }


    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //                    NORD
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////

    public boolean firstNord(int i, int j, Piece_m piece){
        boolean bool = false;
        boolean free;

        for(Case_m caseIt : piece.getListeCase()) {

            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //Vérifie si la case est sur le plateau et vide
            free = verifCase(i+l, j-k);

            if (!free)
                return free;

        }

        for(Case_m caseIt : piece.getListeCase()) {
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            if((i+l==0 && j-k==0) || (i+l==19 && j-k==0) || (i+l==0 && j-k==19) || (i+l==19 && j-k==19) ) {
                bool = true;
                break;
            }
        }

        if (bool) {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i+l,j - k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                vueGeneral.plateau.tabButton[i+l][j-k].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i+l,j-k).getCouleur());
                vueGeneral.plateau.tabButton[i+l][j-k].setBackground(color.getColor());
            }

            return true;
        }

        return false;
    }

    public boolean positionnementNord(int i, int j, Piece_m piece){
        if (checkPositionnementNord(i, j, piece))
        {
            for(Case_m caseIt : piece.getListeCase()) {
                //Récupère la position de la case dans la pièce
                int k = caseIt.getPosI();
                int l = caseIt.getPosJ();

                //On actualise la couleur de la case sur la grille
                modelPlateau.getCase(i+l,j-k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
                vueGeneral.plateau.tabButton[i+l][j-k].setContentAreaFilled(true);
                Color_v color = new Color_v(modelPlateau.getCase(i+l,j-k).getCouleur());
                vueGeneral.plateau.tabButton[i+l][j-k].setBackground(color.getColor());
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
            free = verifCase(i+l, j-k);

            if (!free)
                return free;

            //Vérifie si les 4 bords de la case caseIt sont ide
            free = helper_preview.checkBordCase(i+l, j-k, caseIt);

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

            free = helper_preview.checkCoinCase(i+l, j-k, caseIt);

            c++;
        }

        return free;
    }

}
