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