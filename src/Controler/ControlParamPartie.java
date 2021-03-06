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
    private boolean partieReseau;



    public ControlParamPartie(General_m modelGeneral, ParamPartie_m paramPartie_m, ParamPartie_v paramPartie_v){
        this.modelGeneral = modelGeneral;
        this.vue = paramPartie_v;
        accueil_m = new Accueil_m();
        partieReseau = false;

    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == vue.retourAccueil) {
            vue.undisplay();
            Accueil_v accueil_v = new Accueil_v();
            ControlAccueil controlAccueil = new ControlAccueil(accueil_m, accueil_v);
        }

        if (e.getSource() == vue.reseauCB) {
            vue.humainJoueur2.setSelected(false);
            vue.humainJoueur3.setSelected(false);
            vue.humainJoueur4.setSelected(false);
            vue.humainJoueur2.setEnabled(false);
            vue.humainJoueur3.setEnabled(false);
            vue.humainJoueur4.setEnabled(false);
            vue.iaJoueur1.setEnabled(false);
            vue.iaJoueur2.setEnabled(false);
            vue.iaJoueur3.setEnabled(false);
            vue.iaJoueur4.setEnabled(false);
            vue.panelJoueur2.setVisible(false);
            vue.panelJoueur3.setVisible(false);
            vue.panelJoueur4.setVisible(false);
            vue.valider.setEnabled(false);
            partieReseau = true;

        }

        if(e.getSource() == vue.localCB){
            vue.humainJoueur2.setEnabled(true);
            vue.humainJoueur3.setEnabled(true);
            vue.humainJoueur4.setEnabled(true);
            vue.iaJoueur1.setEnabled(true);
            vue.iaJoueur2.setEnabled(true);
            vue.iaJoueur3.setEnabled(true);
            vue.iaJoueur4.setEnabled(true);
            vue.panelJoueur2.setVisible(true);
            vue.panelJoueur3.setVisible(true);
            vue.panelJoueur4.setVisible(true);
            vue.valider.setEnabled(true);
            partieReseau = false;

        }

        if(e.getSource()==vue.valider){
            modelGeneral = new General_m();
            //met dans le modele le nom des joueurs

            String nom= vue.textFieldNomJoueur1.getText();
            modelGeneral.getJoueurByColor("Red").setNom(nom);
            modelGeneral.getJoueurByColor("Red").set_Ia(vue.iaJoueur1.isSelected());
            modelGeneral.getSauvegarde().sauvegardeNomJoueur("Red",nom);
            if(modelGeneral.getJoueurByColor("Red").is_Ia()){
                modelGeneral.getSauvegarde().sauvegardeEtatJoueurIA("Red");
            }

            nom = vue.textFieldNomJoueur2.getText();
            modelGeneral.getJoueurByColor("Blue").setNom(nom);
            modelGeneral.getJoueurByColor("Blue").set_Ia(vue.iaJoueur2.isSelected());
            modelGeneral.getSauvegarde().sauvegardeNomJoueur("Blue",nom);
            if(modelGeneral.getJoueurByColor("Blue").is_Ia()){
                modelGeneral.getSauvegarde().sauvegardeEtatJoueurIA("Blue");
            }

            nom = vue.textFieldNomJoueur3.getText();
            modelGeneral.getJoueurByColor("Yellow").setNom(nom);
            modelGeneral.getJoueurByColor("Yellow").set_Ia(vue.iaJoueur3.isSelected());
            modelGeneral.getSauvegarde().sauvegardeNomJoueur("Yellow",nom);
            if(modelGeneral.getJoueurByColor("Yellow").is_Ia()){
                modelGeneral.getSauvegarde().sauvegardeEtatJoueurIA("Yellow");
            }

            nom = vue.textFieldNomJoueur4.getText();
            modelGeneral.getJoueurByColor("Green").setNom(nom);
            modelGeneral.getJoueurByColor("Green").set_Ia(vue.iaJoueur4.isSelected());
            modelGeneral.getSauvegarde().sauvegardeNomJoueur("Green",nom);
            if(modelGeneral.getJoueurByColor("Green").is_Ia()){
                modelGeneral.getSauvegarde().sauvegardeEtatJoueurIA("Green");
            }

            vue.undisplay();
            general_v = new General_v(modelGeneral);
            general_v.display();
            controlButton = new ControlButton(general_v, modelGeneral);
            controlPlateau = new ControlPlateau (modelGeneral, general_v);

        }

    }
}
