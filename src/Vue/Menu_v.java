package Vue;

import Controler.ControlMenu;
import Model.Accueil_m;
import Model.General_m;

import javax.swing.*;

/**
 * Created by Lordloss on 04/03/2016.
 */
public class Menu_v extends JFrame {

    protected Accueil_m accueil_m;
    public General_v general_v;
    public ControlMenu controlMenu;
    public JMenuBar barre_menu;
    public JMenu retour_accueil;
    public JMenuItem quitter;
    public JMenuItem accueil;

    public Menu_v(General_v vueGeneral){
        general_v = vueGeneral;
        initAttribute();
        drawMenu();
    }

    public void initAttribute(){
        accueil_m = new Accueil_m();
        controlMenu = new ControlMenu(this, general_v);
    }

    public void drawMenu(){

        barre_menu = new JMenuBar();
        retour_accueil = new JMenu("Menu");
        quitter = new JMenuItem("Quitter le jeu");
        accueil = new JMenuItem("Accueil");

        barre_menu.add(retour_accueil);
        retour_accueil.add(quitter);
        retour_accueil.add(accueil);

        quitter.addActionListener(controlMenu);
        accueil.addActionListener(controlMenu);

    }

}
