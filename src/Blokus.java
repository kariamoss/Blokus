/**
 * Created by Jehan Milleret on 14/11/2015.
 */

public class Blokus {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable(){

            public void run() {
                Model model = new Model();
                ControlGroup control = new ControlGroup(model);

            }

        });
    }
}