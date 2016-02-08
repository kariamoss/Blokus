package Controler;

import Model.Accueil_m;
import Model.General_m;
import Vue.Accueil_v;
import Vue.General_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlGroup{
    private General_m model;
    private General_v vue;
    public ControlMusique controlMusique;
    public ControlRotationButton controlRotationButton;
    public Accueil_v accueil_v;
    public ControlAccueil controlAccueil;
    public Accueil_m accueil_m = new Accueil_m();

    public ControlGroup(General_m modelGeneral) throws IOException {
        this.model = modelGeneral;
        controlAccueil = new ControlAccueil(accueil_m,accueil_v);
        accueil_v = new Accueil_v();
        accueil_v.display();



       // vue = new General_v(modelGeneral);
        //Inventaire_m modelInventaire = modelGeneral.selectJoueurActif().getInventaire();//TODO Creer les inventaires ?


        //Créé directement dans initSound(), permet d'avoir les action listener direct
        //controlMusique = new ControlMusique(model, vue);
        //controlRotationButton = new ControlRotationButton(model, vue);

    }


}
