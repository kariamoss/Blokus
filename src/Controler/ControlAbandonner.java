package Controler;

import Model.General_m;
import Model.Joueur_m;
import Model.Piece_m;
import Helper.Comparateur;
import Vue.General_v;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class ControlAbandonner {
    private General_m modelGeneral;
    private General_v vueGeneral;
    protected Joueur_m joueur;
    private static final int NB_JOUEUR = 4;

    public ControlAbandonner(General_m modelGeneral, General_v vueGeneral) {
        this.modelGeneral = modelGeneral;
        this.vueGeneral = vueGeneral;

        //vueGeneral.boutonsControleJeu.setAbandonButtonControler(this);
    }

    public void abandon(){
        joueur = modelGeneral.selectJoueurActif();

        //Message de dialogue
        vueGeneral.informationMessage(joueur.getNom() + " abandonne", "Abandon");

        //On indique le joueur comme hors jeu
        joueur.setEnJeu(false);
        modelGeneral.getSauvegarde().sauvegardeEtatAbandonJoueur(joueur.getCouleur());


        //On remet l'overview à null
        vueGeneral.overview.overviewButton.setIcon(null);
        vueGeneral.overview.overviewButton.setBorderPainted(false);

        if (modelGeneral.getNbJoueurEnJeu()>0){
            //On passe au joueur suivant
            modelGeneral.joueurSuivant();

            //On change d'inventaire
            List<Piece_m> listPiece = modelGeneral.selectJoueurActif().getInventaire().getListPiece();

            for (int i =0;i<listPiece.size()-1;i++)
            {
                vueGeneral.inventaire.tabButtonInventaire[i].setEnabled(true);
                if(modelGeneral.selectJoueurActif().getInventaire().getPiece(i).isUsed())
                {
                    vueGeneral.inventaire.tabButtonInventaire[i].setEnabled(false);
                }
                ImageIcon imageIcon = new ImageIcon(listPiece.get(i).getImage());
                Image image = imageIcon.getImage();
                Image newImage = image.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH) ;
                ImageIcon icon = new ImageIcon(newImage);

                vueGeneral.inventaire.tabButtonInventaire[i].setIcon(icon);
            }
        }
        else
        {
            finDePartie();
        }
    }

    /**
     * FinDePartie permet de gérer les actions à faire à la fin de la partie
     * et principalement l'affichage de score et l'appel de la nouvelle partie
     */

    private void finDePartie(){

        //Tri des joueur :
        List <Integer> triScore = new ArrayList<Integer>();
        List <String> triNom = new ArrayList<String>();

        for (int i = 0;i<NB_JOUEUR;i++)
        {
            Joueur_m joueur = modelGeneral.getJoueur(i);
            triScore.add(joueur.getScore());
            triNom.add( joueur.getNom());
        }

        trier_croissant(triScore, triNom);

        String result = "Fin de partie ! \n\n";

        for (int i = 0;i<NB_JOUEUR;i++)
        {
            result += triNom.get(i) + ": ";
            result += triScore.get(i) + "pts\n";
        }

        JOptionPane.showMessageDialog(null, result, "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);

        modelGeneral.getSauvegarde().delete();


        System.exit(0); //TODO Revenir à l'ecran d'accueil
    }


    /**
     * Trier_croissant permet de trier les deux listes envoyées en paramètre dans l'ordre
     * Gère les variables de même valeur
     * @param triScore
     * @param triNom
     */
    static void trier_croissant(List<Integer> triScore, List<String> triNom){
        int valeurAvantScore;
        String valeurAvantNom;
        int valeurScore;
        String valeurNom;
        int echangeScore = 0;
        String echangeNom = "";

        // i n'est jamais appellé : permet uniquement de faire le nb de boucles
        // nécessaire
        for(int i=0; i < NB_JOUEUR; i++){
            // Initialisation des variables pour que le premier tour soit forcément
            // faux au if et ainsi éviter le j-1 et ArrayOutOfBound
            valeurAvantScore =999;
            valeurAvantNom = "";
            // Tri simple : les deux listes sont triées grâce à la premiere
            for(int j=0; j < NB_JOUEUR; j++){
                valeurScore = triScore.get(j);
                valeurNom = triNom.get(j);

                if (valeurScore >valeurAvantScore){
                    echangeScore =valeurScore;
                    echangeNom = valeurNom;

                    triScore.set(j, triScore.get(j-1));
                    triNom.set(j, triNom.get(j-1));

                    triScore.set(j-1,echangeScore);
                    triNom.set(j-1, echangeNom);
                }
                valeurAvantScore =triScore.get(j);
                valeurAvantNom = triNom.get(j);
            }
        }
    }
}
