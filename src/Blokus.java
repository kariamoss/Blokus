import Controler.ControlAccueil;
import Controler.ControlGroup;
import Model.Accueil_m;
import Model.General_m;
import Vue.Accueil_v;

import java.io.IOException;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */

public class Blokus {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable(){

            public void run() {
                Accueil_m accueil_m = new Accueil_m();
                Accueil_v accueil_v = new Accueil_v();
            }
        });
    }
}