package Helper;

import Model.General_m;
import Model.Piece_m;
import Vue.General_v;

import java.io.*;

/**
 * Created by Jehan on 08/02/2016.
 */
public class Chargement {
    BufferedReader br = null;
    FileReader fr = null;
    File fichier = new File("sauvegarde/save.txt");
    General_m model;
    General_v vue;

    public Chargement(General_m model, General_v vue){

        try {
            fr = new FileReader(fichier);
            br = new BufferedReader(fr);

        }catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }

        this.model = model;
        this.vue = vue;
    }

    public void chargementCase(){
        String ligne;
        try{
            while((ligne = br.readLine() ) != null){
                String[] split = ligne.split(";");

                int i = Integer.parseInt(split[0]);
                int j = Integer.parseInt(split[1]);
                String couleur = split[2];
                int numero = Integer.parseInt(split[3]);

                Piece_m piece = model.getJoueurByColor(couleur).getInventaire().getPiece(numero);

                piece.setUsed(true);

                model.modelPlateau.getCase(i, j).setCouleur(couleur);
                vue.plateau.tabButton[i][j].setContentAreaFilled(true);
                Color_v color = new Color_v(model.modelPlateau.getCase(i, j).getCouleur());
                vue.plateau.tabButton[i][j].setBackground(color.getColor());

                model.getJoueurByColor(split[2]).setScore(model.getJoueurByColor(couleur).getScore()+1);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        for (int k = 0 ;k<20 ; k++) {
            vue.inventaire.tabButtonInventaire[k].setEnabled(true);
            if (model.getJoueurByColor("Red").getInventaire().getPiece(k).isUsed()) {
                vue.inventaire.tabButtonInventaire[k].setEnabled(false);
            }
        }
    }

}
