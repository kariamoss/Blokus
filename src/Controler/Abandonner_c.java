package Controler;
import Model.General_m;
import Model.Joueur_m;
import Vue.General_v;

import java.awt.event.*;

import java.awt.event.ActionListener;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class Abandonner_c implements ActionListener {
    private General_m general_m;
    protected Joueur_m joueur_m;
    protected General_v vue = new General_v(general_m);

    public Abandonner_c(General_v vue) {


    }

    public void actionPerformed(ActionEvent e) {
       /* if(e.getSource()==vue.getBtAbandonner()){
            joueur_m.setTourDeJeu(false);
            joueur_m.setEnJeu(false);
            System.out.print("coucou");
        }*/
    }
}
