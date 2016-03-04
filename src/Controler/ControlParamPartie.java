package Controler;

import Model.Accueil_m;
import Model.General_m;
import Model.Joueur_m;
import Model.ParamPartie_m;
import Vue.Accueil_v;
import Vue.General_v;
import Vue.ParamPartie_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mathi on 02/03/2016.
 */
public class ControlParamPartie implements ActionListener {
    private  ControlButton controlButton;
    private  ControlAbandonner controlAbandonner;
    private  ControlPlateau controlPlateau;
    private General_m modelGeneral;
    private ParamPartie_v vue;
    private Accueil_m accueil_m;
    public General_v general_v;



    public ControlParamPartie(ParamPartie_m paramPartie_m, ParamPartie_v paramPartie_v){
        this.vue = paramPartie_v;
        accueil_m = new Accueil_m();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vue.retourAccueil) {
            vue.undisplay();
            Accueil_v accueil_v = new Accueil_v();
            ControlAccueil controlAccueil = new ControlAccueil(accueil_m, accueil_v);
        }

        if (e.getSource() == vue.reseauCB) {
            vue.humainJoueur2.setEnabled(false);
            vue.humainJoueur3.setEnabled(false);
            vue.humainJoueur4.setEnabled(false);
            vue.iaJoueur1.setEnabled(false);
            vue.iaJoueur2.setEnabled(false);
            vue.iaJoueur3.setEnabled(false);
            vue.iaJoueur4.setEnabled(false);
        }

        if(e.getSource() == vue.localCB){
            vue.humainJoueur2.setEnabled(true);
            vue.humainJoueur3.setEnabled(true);
            vue.humainJoueur4.setEnabled(true);
            vue.iaJoueur1.setEnabled(true);
            vue.iaJoueur2.setEnabled(true);
            vue.iaJoueur3.setEnabled(true);
            vue.iaJoueur4.setEnabled(true);

        }

        if(e.getSource()==vue.valider){
            modelGeneral = new General_m();
            //met dans le modele le nom des joueurs
            String nom= vue.textFieldNomJoueur1.getText();
            modelGeneral.setNomJoueur0(nom);
            nom = vue.textFieldNomJoueur2.getText();
            modelGeneral.setNomJoueur1(nom);
            nom = vue.textFieldNomJoueur3.getText();
            modelGeneral.setNomJoueur2(nom);
            nom = vue.textFieldNomJoueur4.getText();
            modelGeneral.setNomJoueur3(nom);
            general_v = new General_v(modelGeneral);
            controlAbandonner = new ControlAbandonner(modelGeneral, general_v);
            controlButton = new ControlButton(general_v, modelGeneral);
            controlPlateau = new ControlPlateau (modelGeneral, general_v);
            vue.undisplay();
            general_v.display();
        }
    }
}
