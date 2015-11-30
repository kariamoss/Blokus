package Vue;

import Controler.ControlPlateau;
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
    General_m model;

    public Grille_v(){
        initGrid(600/3, 20);
    }

    public Grille_v(int sizeInPixels, int nbButtonsPerRow, General_m model){
        initGrid(sizeInPixels, nbButtonsPerRow);
        this.model = model;
    }



    private void initGrid(int sizeInPixels, int nbButtonsPerRow){

        grille= new JPanel( new GridLayout(nbButtonsPerRow,nbButtonsPerRow));
        grille.setPreferredSize(new Dimension(sizeInPixels, sizeInPixels));
        grille.setOpaque(false);

        mountGrid(nbButtonsPerRow);

    }



    public JPanel getGrille(){ return grille; }


    private void mountGrid(int nbButtonsPerRow){
        /*int nbButtons= nbButtonsPerRow*nbButtonsPerRow;

        for (int i= 0; i < nbButtons; i++){
            JButton button= new JButton();

            if (borders){
                button.setBorder(new LineBorder(Color.DARK_GRAY,1));
            }
            else {
                button.setBorder(new LineBorder(Color.DARK_GRAY,0));
            }
            grille.add(button);

        }*/


        Plateau_m plateau = new Plateau_m();
        plateau.tabButton = new JButton[nbButtonsPerRow][nbButtonsPerRow];
        for (int i=0;i<nbButtonsPerRow;i++){
            for (int j=0;j<nbButtonsPerRow;j++){
                plateau.tabButton[i][j] = new JButton();

                // Ajoute le controleur au bouton :
                ControlPlateau controlButton = new ControlPlateau(plateau, i, j);
                plateau.tabButton[i][j].addActionListener(controlButton);
                plateau.tabButton[i][j].setBorder(new LineBorder(Color.DARK_GRAY,1));

                grille.add(plateau.tabButton[i][j]);
            }
        }

    }




}
