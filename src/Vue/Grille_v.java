package Vue;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Fox Mc-Tag on 19/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class Grille_v {
    private JPanel grille;

    public Grille_v(){
        initGrid(600/3, 20);
    }

    public Grille_v(int sizeInPixels, int nbButtonsPerRow){
        initGrid(sizeInPixels, nbButtonsPerRow);
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

        JButton[][] tabButton = new JButton[nbButtonsPerRow][nbButtonsPerRow];

        for (int i=0;i<nbButtonsPerRow;i++){
            for (int j=0;j<nbButtonsPerRow;j++){
                tabButton[i][j] = new JButton();

                tabButton[i][j].setBorder(new LineBorder(Color.DARK_GRAY,1));

                grille.add(tabButton[i][j]);
            }
        }

    }




}
