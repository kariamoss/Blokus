package Controler;

import Model.General_m;
import Vue.BoutonsControleJeu_v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lucas on 01/12/2015.
 */
public class ControlRotationButton implements ActionListener
{
    General_m modelGeneral;
    BoutonsControleJeu_v vue;


    public ControlRotationButton(General_m modelGeneral, BoutonsControleJeu_v vue){
        this.modelGeneral = modelGeneral;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e)
    {

    }
}
