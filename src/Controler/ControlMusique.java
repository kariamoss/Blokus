package Controler;

import Model.General_m;
import Model.Musique_m;
import Vue.BoutonsControleJeu_v;
import Vue.General_v;

public class ControlMusique
{
    General_m modelGeneral;
    General_v vueGeneral;
    BoutonsControleJeu_v vue;
    private Musique_m musique;


    public ControlMusique(General_m model, General_v vue)
    {
        this.modelGeneral = model;
        vueGeneral = vue;
        this.vue = vueGeneral.boutonsControleJeu;
        musique = new Musique_m(model.getMusiquePath());
        musique.start();
    }

    public void pause() {
        modelGeneral.setMusiqueEtat(false);
        musique.suspend();
    }

    public void play()
    {
        modelGeneral.setMusiqueEtat(true);
        musique.resume();
    }
}