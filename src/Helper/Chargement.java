package Helper;

import Controler.ControlAbandonner;
import Controler.ControlAccueil;
import Controler.ControlButton;
import Controler.ControlPlateau;
import Model.General_m;
import Model.Piece_m;
import Vue.Accueil_v;
import Vue.General_v;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jehan on 08/02/2016.
 */
public class Chargement {
    BufferedReader br = null;
    FileReader fr = null;
    File fichier = new File("sauvegarde/save.txt");
    General_m model;
    General_v vue;
    public ControlAbandonner controlAbandonner;
    public ControlButton controlButton;
    public ControlPlateau controlPlateau;
    int nbAbandon = 0;


    public Chargement(General_m model){
        this.model = model;
    }

    public void chargementCase(Accueil_v vueAccueil){

        /*Ouverture du fichier uniquement si l'on veut lire pour ne pas bloquer
        l'acces au fichier*/
        try {
            fr = new FileReader(fichier);
            br = new BufferedReader(fr);

        }catch (FileNotFoundException exception) {
            System.out.println("Nothing to load");
        }

        String ligne;
        List<Integer> listI = new ArrayList<Integer>();
        List<Integer> listJ = new ArrayList<Integer>();
        List<Color_v> listColor = new ArrayList<Color_v>();

        try{
            while((ligne = br.readLine() ) != null){
                String[] split = ligne.split(";");

                //On vérifie si la ligne correspond à l'abandon d'un joueur
                if(split[0].equals("Abandon")){
                    model.getJoueurByColor(split[1]).setEnJeu(false);
                    nbAbandon++;
                    if(nbAbandon == 4){
                        //On libère le fichier pour être utiliser dans nouvelle partie
                        try{
                            br.close();
                            fr.close();
                            br = null;
                            fr = null;
                            fichier.delete();
                        }catch(Exception e){
                            e.printStackTrace();
                            System.out.println("File can't be close. Err code : 4.");
                        }

                        JOptionPane.showMessageDialog(null, "Vous n'avez aucune partie en cours"
                                , "Chargement impossible", JOptionPane.INFORMATION_MESSAGE);

                        return;
                    }
                }
                else if(split[0].equals("Tour")){
                    model.setJoueurActif(split[1]);
                }
                else{
                    int i = Integer.parseInt(split[0]);
                    int j = Integer.parseInt(split[1]);
                    String couleur = split[2];
                    int numero = Integer.parseInt(split[3]);

                    Piece_m piece = model.getJoueurByColor(couleur).getInventaire().getPiece(numero);

                    piece.setUsed(true);

                    model.modelPlateau.getCase(i, j).setCouleur(couleur);

                    Color_v color = new Color_v(model.modelPlateau.getCase(i, j).getCouleur());

                    model.getJoueurByColor(split[2]).setScore(model.getJoueurByColor(couleur).getScore()+1);

                    listI.add(i);
                    listJ.add(j);
                    listColor.add(color);

                }
            }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File can't be write in. Err code : 5.");
        }

        vueAccueil.undisplay();

        //Après le model recréé, on construit la vue
        vue = new General_v(model);
        vue.display();

        //Puis les controleurs qui en dépendent
        controlAbandonner = new ControlAbandonner(model, vue);
        controlButton = new ControlButton(vue, model);
        controlPlateau = new ControlPlateau(model, vue);

        //On ré-actualise la vue
        for(int k = 0; k < listI.size(); k++){
            vue.plateau.tabButton[listI.get(k)][listJ.get(k)].setContentAreaFilled(true);
            vue.plateau.tabButton[listI.get(k)][listJ.get(k)].setBackground(listColor.get(k).getColor());
        }

        //On supprime les boutons de l'inventaire indisponibles du premier joueur

        for (int k = 0 ;k<20 ; k++) {
            vue.inventaire.tabButtonInventaire[k].setEnabled(true);
            if (model.selectJoueurActif().getInventaire().getPiece(k).isUsed()) {
                vue.inventaire.tabButtonInventaire[k].setEnabled(false);
            }
        }
    }

}
