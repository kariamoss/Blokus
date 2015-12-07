package Controler;
import Model.General_m;
import Model.Joueur_m;
import Vue.General_v;

import java.awt.event.*;

import java.awt.event.ActionListener;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class ControlAbandonner implements ActionListener {
    private General_m modelGeneral;
    protected Joueur_m joueur;

    public ControlAbandonner(General_m modelGeneral) {
        this.modelGeneral = modelGeneral;

    }

    public void actionPerformed(ActionEvent e) {
       /* if(e.getSource()==vue.getBtAbandonner()){
            joueur_m.setTourDeJeu(false);
            joueur_m.setEnJeu(false);
        }*/
        System.out.print("coucou");
        joueur = modelGeneral.selectJoueurActif();
        joueur.setEnJeu(false);
    }
}
