package Controler;
import Model.General_m;
import Model.Joueur_m;
import Model.Piece_m;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class ControlAbandonner implements ActionListener {
    private General_m modelGeneral;
    protected Joueur_m joueur;

    public ControlAbandonner(General_m modelGeneral) {
        this.modelGeneral = modelGeneral;

    }

    public void actionPerformed(ActionEvent e) {
               //On indique le joueur comme hors jeu
        joueur.setEnJeu(false);

        //On remet l'overview à null
        modelGeneral.overviewButton.setIcon(null);
        modelGeneral.overviewButton.setBorderPainted(false);

        //On passe au joueur suivant
        modelGeneral.joueurSuivant();

        //On change d'inventaire
        List<Piece_m> listPiece = modelGeneral.selectJoueurActif().getInventaire().getListPiece();

        for (int i =0;i<listPiece.size()-1;i++)
        {
            modelGeneral.tabButtonInventaire[i].setEnabled(true);
            if(modelGeneral.selectJoueurActif().getInventaire().getPiece(i).isUsed())
            {
                modelGeneral.tabButtonInventaire[i].setEnabled(false);
            }
            ImageIcon imageIcon = new ImageIcon(listPiece.get(i).getImage());
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH) ;
            ImageIcon icon = new ImageIcon(newImage);

            modelGeneral.tabButtonInventaire[i].setIcon(icon);
        }
    }
}
