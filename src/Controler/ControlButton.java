package Controler;

import Model.General_m;
import Model.Inventaire_m;
import Model.Joueur_m;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlButton implements ActionListener {

    Inventaire_m modelInventaire;
    General_m modelGeneral;

    int i;

    public ControlButton(){

    }

    public ControlButton(General_m modelGeneral, Inventaire_m modelInventaire, int i){
        this.modelGeneral = modelGeneral;
        this.modelInventaire = modelInventaire;
        this.i = i;
    }

    public void actionPerformed(ActionEvent e)
    {
        Joueur_m joueur = modelGeneral.selectJoueurActif();
        String nomJoueur = joueur.getNom();

        if (!joueur.getInventaire().getPiece(i).isUsed())
        {
            System.out.println("Joueur : " + nomJoueur + " / Selection de la pièce : " + i);

            joueur.getInventaire().selectPiece(i);
        }
        else
        {
            System.out.println("La pièce "+ i + " a déjà été posée");
        }

        // RAJOUTER LES METHODE POUR LA ROTATION
    }

}
