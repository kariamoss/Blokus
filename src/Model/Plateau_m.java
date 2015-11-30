package Model;

import javax.swing.*;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class Plateau_m {
    private int taillePlateau = 20;
    private Case_m[][] plateau;
    public JButton[][] tabButton;


    public Plateau_m(){
        genererPlateau(taillePlateau);

    }

    public Case_m[][] genererPlateau(int taillePlateau){
        plateau = new Case_m[taillePlateau][taillePlateau];
        for(int i=0; i<taillePlateau;i++){
            for(int j=0; j<taillePlateau;j++){
                plateau[i][j]= new Case_m("White",i,j);
            }
        }
        return plateau;

    }

    public Case_m getCase(int i, int j){
        return plateau[i][j];
    }


    public int getTaillePlateau() {
        return taillePlateau;
    }
}