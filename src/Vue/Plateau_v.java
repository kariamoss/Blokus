package Vue;

import Helper.Color_v;
import Model.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Fox Mc-Tag on 19/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class Plateau_v {
    private JPanel grille;
    General_m modelGeneral;
    Plateau_m modelPlateau;
    public JButton tabButton[][];
    private General_v vueGeneral;

    int sizeInPixels;
    int nbButtonsPerRow;


    public Plateau_v (General_m modelGeneral, General_v vue)
    {
        this.modelGeneral = modelGeneral;
        this.modelPlateau = modelGeneral.getModelPlateau();
        vueGeneral = vue;
        sizeInPixels = 610;
        nbButtonsPerRow = 20;
        initGrid();
    }



    private void initGrid(){

        grille= new JPanel( new GridLayout(nbButtonsPerRow,nbButtonsPerRow));
        grille.setPreferredSize(new Dimension(sizeInPixels, sizeInPixels));
        grille.setOpaque(false);

        mountGrid();

    }


    public JPanel getGrille(){ return grille; }


    private void mountGrid(){

        //posePremieresPiece();
        modelGeneral.selectJoueur(0);
        tabButton = new JButton[nbButtonsPerRow][nbButtonsPerRow];
        for (int i=0;i<nbButtonsPerRow;i++){
            for (int j=0;j<nbButtonsPerRow;j++){
                tabButton[i][j] = new JButton();


                // Ajoute le controleur au bouton :
                //TODO Creer fonction pour le controleur : OK
                //ControlPlateau controlButton = new ControlPlateau(modelGeneral, modelPlateau, i, j);
                //tabButton[i][j].addActionListener(controlButton);
                tabButton[i][j].setBorder(new LineBorder(Color.DARK_GRAY,1));

                if (modelPlateau.getCase(i, j).getCouleur()!="White"){
                    tabButton[i][j].setContentAreaFilled(true);
                    Color_v color = new Color_v(modelPlateau.getCase(i, j).getCouleur());
                    tabButton[i][j].setBackground(color.getColor());
                }
                else {
                    tabButton[i][j].setContentAreaFilled(false);
                }

                grille.add(tabButton[i][j]);
            }
        }

    }


    public void posePremieresPiece()
    {
        int i;
        int j;

        //Joueur 0
        modelGeneral.selectJoueur(0);
        Joueur_m joueur0 = modelGeneral.selectJoueurActif();

        //Piece 12 orientation Nord en haut à gauche
        i=0;
        j=0;
        Piece_m pieceJ0 = joueur0.getInventaire().getPiece(11);

        for(Case_m caseIt : pieceJ0.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            modelGeneral.modelPlateau.getCase(i+l,j-k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
        }

        pieceJ0.setUsed(true);

        for (int c =0;c<joueur0.getInventaire().listePiece.size()-1;c++) {
            vueGeneral.inventaire.tabButtonInventaire[c].setEnabled(true);
            if (modelGeneral.selectJoueurActif().getInventaire().getPiece(c).isUsed()) {
                vueGeneral.inventaire.tabButtonInventaire[c].setEnabled(false);
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
            modelGeneral.modelPlateau.getCase(i - k, j - l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
        }
        pieceJ1.setUsed(true);

        for (int c =0;c<joueur1.getInventaire().listePiece.size()-1;c++) {
            vueGeneral.inventaire.tabButtonInventaire[c].setEnabled(true);
            if (modelGeneral.selectJoueurActif().getInventaire().getPiece(c).isUsed()) {
                vueGeneral.inventaire.tabButtonInventaire[c].setEnabled(false);
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
            modelGeneral.modelPlateau.getCase(i + k, j + l).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
        }
        pieceJ2.setUsed(true);

        for (int c =0;c<joueur2.getInventaire().listePiece.size()-1;c++) {
            vueGeneral.inventaire.tabButtonInventaire[c].setEnabled(true);
            if (modelGeneral.selectJoueurActif().getInventaire().getPiece(c).isUsed()) {
                vueGeneral.inventaire.tabButtonInventaire[c].setEnabled(false);
            }

        }



        //Joueur 3
        modelGeneral.selectJoueur(3);
        Joueur_m joueur3 = modelGeneral.selectJoueurActif();

        //Piece 17 orientation Sud en bas à droite
        i=19;
        j=19;
        Piece_m pieceJ3 = joueur3.getInventaire().getPiece(11);
        for(Case_m caseIt : pieceJ3.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On actualise la couleur de la case sur la grille
            modelGeneral.modelPlateau.getCase(i - l, j + k).setCouleur(modelGeneral.selectJoueurActif().getCouleur());
        }
        pieceJ3.setUsed(true);

        for (int c =0;c<joueur3.getInventaire().listePiece.size()-1;c++) {
            vueGeneral.inventaire.tabButtonInventaire[c].setEnabled(true);
            if (modelGeneral.selectJoueurActif().getInventaire().getPiece(c).isUsed()) {
                vueGeneral.inventaire.tabButtonInventaire[c].setEnabled(false);
            }
        }

        //On affiche l'inventaire du premier joueur
        modelGeneral.selectJoueur(0);
        java.util.List<Piece_m> listPiece = modelGeneral.selectJoueurActif().getInventaire().getListPiece();

        for (i =0;i<listPiece.size()-1;i++)
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


    public void setButtonControler(ActionListener actionListener) {
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                tabButton[i][j].addActionListener(actionListener);
            }
        }
    }
}