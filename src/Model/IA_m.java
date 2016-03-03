package Model;

import Controler.ControlPlateau;
import Vue.General_v;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Created by Jehan on 03/03/2016.
 */
public class IA_m{
    General_v vueGeneral;
    General_m modelGeneral;
    Plateau_m modelPlateau;
    ControlPlateau controlPlateau;


    public IA_m(General_m modelGeneral, General_v vueGeneral, ControlPlateau controlPlateau )
    {
        this.modelGeneral = modelGeneral;
        this.vueGeneral = vueGeneral;
        this.modelPlateau = modelGeneral.modelPlateau;
        this.controlPlateau = controlPlateau;
    }

    public void runIA() {
        if (modelGeneral.selectJoueurActif().is_Ia()) {
            Joueur_m iA;
            iA = modelGeneral.selectJoueurActif();
            List<Piece_m> listPiece = iA.getInventaire().getListPiece();

            //TODO Booleens pour la gestion de l'hasard dans les parties
            Random random = new Random();

            boolean coteHaut = random.nextBoolean();
            boolean coteGauche = random.nextBoolean();
            boolean turnLeft = random.nextBoolean();
            boolean pieceBefore = random.nextBoolean();

            //On selectionne la piece la plus grosse
            for (int i = listPiece.size() -2; i >= 0; i--) {
                //Si la piece n'est pas déjà utilisée
                if (!listPiece.get(i).isUsed()) {
                    //On test les cases du tableau
                    for (int x = (coteHaut) ? 0 : 19; (coteHaut) ? x < 20 : x > 0; x = (coteHaut) ? x+1 : x-1) {
                        if(pieceBefore){
                            pieceBefore = false;
                            break;
                        }
                        for (int y = (coteGauche) ? 0 : 19; (coteGauche) ? y < 20 : y > 0; y = (coteGauche) ? y+1 : y-1) {

                            //On test pour chaque position de la piece
                            for (int z = 0; z < 4; z++) {
                                controlPlateau.control(x, y, listPiece.get(i));
                                listPiece.get(i).rotateLeft();
                                if(listPiece.get(i).isUsed()){
                                    System.out.println("IA "+ iA.getCouleur() + "joue la piece numéro" +i);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            iA.setEnJeu(false);
            modelGeneral.joueurSuivant();
            vueGeneral.informationMessage(iA.getNom() + " abandonne", "Abandon");
            if(modelGeneral.selectJoueurActif().is_Ia()) runIA();
            controlPlateau.dessinerInventaire();
        }
    }
}
