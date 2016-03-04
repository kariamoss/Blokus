package Controler;

import Helper.Chargement;
import Helper.Sauvegarde;
import Model.Accueil_m;
import Model.General_m;
import Vue.Accueil_v;
import Vue.General_v;
import Vue.ParamPartie_v;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlGroup {
    public General_m model;
    public General_v vue;
    public ControlAbandonner controlAbandonner;
    public ControlButton controlButton;
    public ControlPlateau controlPlateau;
    public Accueil_v accueil_v;
    public ControlAccueil controlAccueil;
    public ControlParamPartie controlParamPartie;
    public ParamPartie_v paramPartie_v;

    public ControlGroup(General_m modelGeneral, boolean chargement) {
        if(chargement){
            this.model = modelGeneral;
        }
        else{
            this.model = modelGeneral;
           // vue = new General_v(model);
            paramPartie_v = new ParamPartie_v(modelGeneral);
            //controlAbandonner = new ControlAbandonner(model, vue);
           // controlButton = new ControlButton(vue, model);
           // controlPlateau = new ControlPlateau (model, vue);

            paramPartie_v.display();
        }
    }
}
