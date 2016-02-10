package Helper;

import Model.General_m;
import Model.Piece_m;
import Vue.General_v;

import java.io.*;

/**
 * Created by Jehan on 08/02/2016.
 */
public class Sauvegarde {
    File fichier = new File("sauvegarde/save.txt");

    PrintWriter pw = null;
    BufferedWriter bw = null;
    FileWriter fw = null;
    boolean bool;

    public Sauvegarde(){
        try {
            fw = new FileWriter(fichier,true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            bool = true;

        } catch (IOException exception) {
            System.out.println("File can't be open");
            bool = false;
        }
    }

    public void sauvegardeCase(int i, int j, Color_v color, int numero){
        if(bool){
            try {
                pw.println(i + ";"+ j + ";" + color.getCouleur() + ";" + (numero-1));
                pw.flush();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
