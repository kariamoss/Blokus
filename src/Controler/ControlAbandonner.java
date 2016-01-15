package Controler;

import Model.General_m;
import Model.Joueur_m;
import Model.Piece_m;
import Vue.General_v;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class ControlAbandonner {
    private General_m modelGeneral;
    private General_v vueGeneral;
    protected Joueur_m joueur;

    public ControlAbandonner(General_m modelGeneral, General_v vueGeneral) {
        this.modelGeneral = modelGeneral;
        this.vueGeneral = vueGeneral;

        //vueGeneral.boutonsControleJeu.setAbandonButtonControler(this);
    }

    public void abandon(){
        joueur = modelGeneral.selectJoueurActif();

        //Message de dialogue
        //TODO Appeller la vue pour faire le popup  : OK
        vueGeneral.informationMessage(joueur.getNom() + " abandonne", "Abandon");

        //On indique le joueur comme hors jeu
        joueur.setEnJeu(false);
        modelGeneral.setNbJoueuEnJeu();


        //On remet l'overview à null
        vueGeneral.overview.overviewButton.setIcon(null);
        vueGeneral.overview.overviewButton.setBorderPainted(false);





        if (modelGeneral.getNbJoueuEnJeu()>0){
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


    private void finDePartie(){

        //Joueur_m vainqueur = modelGeneral.selectJoueurActif();
        String tabNom[] = new String[4];
        int tabScore[] = new int[4];

        //Tri des joueur :
        for (int i = 0;i<4;i++)
        {
            Joueur_m joueur = modelGeneral.getJoueur(i);
            tabScore[i] = joueur.getScore();
            tabNom[i] = joueur.getNom();
        }

        Arrays.sort(tabScore);

        String result = "Fin de partie\n\n";
        for (int i=3;i>=0;i--){
            result+=modelGeneral.getJoueurByScore(tabScore[i]).getNom() +  " : " + tabScore[i] + "pts\n";
            System.out.println(modelGeneral.getJoueurByScore(tabScore[i]).getNom() +  " : " + tabScore[i] + "pts");
        }

        JOptionPane victoire = new JOptionPane();
        JOptionPane.showMessageDialog(null, result, "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
