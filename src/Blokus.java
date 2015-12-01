import Controler.ControlGroup;
import Model.General_m;
import Model.Inventaire_m;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */

public class Blokus {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable(){

            public void run() {
                General_m modelGeneral = new General_m();
                ControlGroup control = new ControlGroup(modelGeneral);

            }

        });
    }
}