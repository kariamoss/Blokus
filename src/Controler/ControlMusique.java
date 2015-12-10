package Controler;

import Model.General_m;
import Model.Musique_m;
import Vue.BoutonsControleJeu_v;
import Vue.General_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMusique
{
    General_m model;
    BoutonsControleJeu_v vue;
    private Musique_m musique;


    public ControlMusique(General_m model, BoutonsControleJeu_v vue)
    {
        this.model = model;
        this.vue = vue;
        musique = new Musique_m(model.getMusiquePath());
        musique.start();
    }

    public void pause() {
        model.setMusiqueEtat(false);
        musique.suspend();
    }

    public void play()
    {
        model.setMusiqueEtat(true);
        musique.resume();
    }
}