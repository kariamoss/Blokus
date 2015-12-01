package Controler;

import Model.General_m;
import Model.Inventaire_m;
import Vue.General_v;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlGroup {
    private General_m modelGeneral;
    private Inventaire_m modelInventaire;
    private General_v vue;
    public ControlButton controlButton;
    public ControlMenu controlMenu;

    public ControlGroup(General_m modelGeneral) {
        this.modelGeneral = modelGeneral;
        Inventaire_m modelInventaire = modelGeneral.selectJoueurActif().getInventaire();
        vue = new General_v(modelGeneral, modelInventaire);
        //Controler.ControlButton controlButton = new Controler.ControlButton(modelGeneral, vue);
        //Controler.ControlMenu controlMenu = new Controler.ControlMenu(generalm, vue);

        vue.display();
    }
}
