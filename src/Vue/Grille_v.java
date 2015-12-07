package Vue;

import Controler.ControlPlateau;
import Helper.Color_v;
import Model.General_m;
import Model.Plateau_m;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Fox Mc-Tag on 19/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class Grille_v {
    private JPanel grille;
    General_m modelGeneral;
    Plateau_m modelPlateau;

    /*public Grille_v(){
        initGrid(600/3, 20);
    }*/

    public Grille_v(int sizeInPixels, int nbButtonsPerRow, General_m modelGeneral)
    {
        this.modelGeneral = modelGeneral;
        this.modelPlateau = modelGeneral.getModelPlateau();
        initGrid(modelGeneral, sizeInPixels, nbButtonsPerRow);
    }



    private void initGrid(General_m modelGeneral, int sizeInPixels, int nbButtonsPerRow){

        grille= new JPanel( new GridLayout(nbButtonsPerRow,nbButtonsPerRow));
        grille.setPreferredSize(new Dimension(sizeInPixels, sizeInPixels));
        grille.setOpaque(false);

        mountGrid(modelGeneral, nbButtonsPerRow);

    }


    public JPanel getGrille(){ return grille; }


    private void mountGrid(General_m modelGeneral, int nbButtonsPerRow){

        modelPlateau.posePremieresPiece();
        modelGeneral.selectJoueur(0);
        modelPlateau.tabButton = new JButton[nbButtonsPerRow][nbButtonsPerRow];
        for (int i=0;i<nbButtonsPerRow;i++){
            for (int j=0;j<nbButtonsPerRow;j++){
                modelPlateau.tabButton[i][j] = new JButton();

                // Ajoute le controleur au bouton :
                ControlPlateau controlButton = new ControlPlateau(modelGeneral, modelPlateau, i, j);
                modelPlateau.tabButton[i][j].addActionListener(controlButton);
                modelPlateau.tabButton[i][j].setBorder(new LineBorder(Color.DARK_GRAY,1));

                if (modelPlateau.getCase(i, j).getCouleur()!="White"){
                    modelPlateau.tabButton[i][j].setContentAreaFilled(true);
                    Color_v color = new Color_v(modelPlateau.getCase(i, j).getCouleur());
                    modelPlateau.tabButton[i][j].setBackground(color.getColor());
                }
                else {
                    modelPlateau.tabButton[i][j].setContentAreaFilled(false);
                }

                grille.add(modelPlateau.tabButton[i][j]);
            }
        }

    }


}