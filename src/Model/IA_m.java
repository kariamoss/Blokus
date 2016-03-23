package Model;

import Controler.ControlAccueil;
import Controler.ControlPlateau;
import Vue.Accueil_v;
import Vue.General_v;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
    ThreadEcouteIA threadEcouteIA;

    private static final int NB_JOUEUR = 4;


    public IA_m(General_m modelGeneral, General_v vueGeneral, ControlPlateau controlPlateau )
    {
        this.modelGeneral = modelGeneral;
        this.vueGeneral = vueGeneral;
        this.modelPlateau = modelGeneral.modelPlateau;
        this.controlPlateau = controlPlateau;
        threadEcouteIA = new ThreadEcouteIA();
        threadEcouteIA.initThread(this, modelGeneral, vueGeneral);
        threadEcouteIA.start();
    }

    public void runIA() {
        if (modelGeneral.selectJoueurActif().is_Ia()) {
            Joueur_m iA;
            iA = modelGeneral.selectJoueurActif();
            List<Piece_m> listPiece = iA.getInventaire().getListPiece();

            Random random = new Random();

            //Random pour un léger côté aléatoire
            boolean coteHaut = random.nextBoolean();
            boolean coteGauche = random.nextBoolean();
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
                                listPiece.get(i).rotateLeft();
                                //On test pour chaque "miroir" de la piece
                                for(int w = 0; w < 2;w ++){
                                    controlPlateau.control(x, y, listPiece.get(i));
                                    listPiece.get(i).setMiroir(w==0);

                                    if(listPiece.get(i).isUsed()){
                                        System.out.println("IA "+ iA.getCouleur() + "joue la piece numéro" +i);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            vueGeneral.informationMessage(iA.getNom() + " abandonne", "Abandon");
            iA.setEnJeu(false);
            if (modelGeneral.getNbJoueurEnJeu()==0){
                finDePartie();
            }
            modelGeneral.joueurSuivant();
            controlPlateau.dessinerInventaire();
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

        vueGeneral.undisplay();
        Accueil_v accueil_v = new Accueil_v();
        Accueil_m accueil_m = new Accueil_m();
        ControlAccueil control = new ControlAccueil(accueil_m, accueil_v);
        accueil_v.display();
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
