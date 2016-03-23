package Controler;



import Model.Accueil_m;
import Vue.Accueil_v;
import Vue.General_v;
import Vue.Menu_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlMenu implements ActionListener {

    public Menu_v menu_v;
    private General_v general_v;

    public ControlMenu(Menu_v menu_v, General_v vueGeneral){
        this.menu_v = menu_v;
        general_v = vueGeneral;
    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource() == menu_v.quitter){
            System.exit(0);
        }
        if (e.getSource() == menu_v.accueil){
            general_v.undisplay();
            Accueil_v accueil_v = new Accueil_v();
            Accueil_m accueil_m = new Accueil_m();
            accueil_v.display();
        }
    }
}
