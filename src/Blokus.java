import Controler.ControlGroup;
import Model.General_m;

import java.io.IOException;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */

public class Blokus {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable(){

            public void run() {
                General_m modelGeneral = new General_m();
                try {
                    ControlGroup control = new ControlGroup(modelGeneral);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}