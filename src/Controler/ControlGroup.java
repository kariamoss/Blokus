package Controler;

import Model.General_m;
import Vue.General_v;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlGroup {
    private General_m model;
    private General_v vue;
    public ControlAbandonner controlAbandonner;
    public ControlButton controlButton;
    public ControlMusique controlMusique;
    public ControlPlateau controlPlateau;
    public ControlRotationButton controlRotationButton;

    public ControlGroup(General_m modelGeneral) {
        this.model = modelGeneral;
        vue = new General_v(modelGeneral);
        //Inventaire_m modelInventaire = modelGeneral.selectJoueurActif().getInventaire();//TODO Creer les inventaires ?


        //Créé directement dans initSound(), permet d'avoir les action listener direct
        //controlMusique = new ControlMusique(model, vue);
        controlAbandonner = new ControlAbandonner(model, vue);
        controlButton = new ControlButton(vue, model);
        controlPlateau = new ControlPlateau (model, vue);
        //controlRotationButton = new ControlRotationButton(model, vue);

        vue.display();
    }
}
