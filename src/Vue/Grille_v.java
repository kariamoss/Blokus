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
        initGrid(600/3, 20, true);
    }

    public Grille_v(int sizeInPixels, int nbButtonsPerRow, boolean borders){
        initGrid(sizeInPixels, nbButtonsPerRow, borders);
    }



    private void initGrid(int sizeInPixels, int nbButtonsPerRow, boolean borders){

        grille= new JPanel( new GridLayout(nbButtonsPerRow,nbButtonsPerRow));
        grille.setPreferredSize(new Dimension(sizeInPixels, sizeInPixels));
        grille.setOpaque(false);

        mountGrid(nbButtonsPerRow, borders);

    }



    public JPanel getGrille(){ return grille; }


    private void mountGrid(int nbButtonsPerRow, boolean borders){
        int nbButtons= nbButtonsPerRow*nbButtonsPerRow;

        for (int i= 0; i < nbButtons; i++){
            JButton button= new JButton();

            if (borders){
                button.setBorder(new LineBorder(Color.DARK_GRAY,1));
            }
            else {
                button.setBorder(new LineBorder(Color.DARK_GRAY,0));
            }
            grille.add(button);

        }

    }




}
