package Controler;

import Model.Accueil_m;
import Model.General_m;
import Vue.Accueil_v;
import Vue.General_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mathieu on 02/02/2016.
 */
public class ControlAccueil implements ActionListener {
    protected Accueil_v accueil_v;
    protected Accueil_m accueil_m;
    public ControlAbandonner controlAbandonner;
    public ControlButton controlButton;
    public ControlPlateau controlPlateau;
    public General_m general_m = new General_m();
    public General_v general_v = new General_v(general_m);

    public ControlAccueil(Accueil_m accueil_m, Accueil_v accueil_v) {
        this.accueil_m = accueil_m;
        this.accueil_v = accueil_v;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == accueil_v.nouvellePartie) {
            accueil_v.undisplay();
            general_v.display();
             controlAbandonner = new ControlAbandonner(general_m, general_v);
            controlButton = new ControlButton(general_v, general_m);
            controlPlateau = new ControlPlateau (general_m, general_v);

        }
    }


}
