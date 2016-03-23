package Helper;

import java.io.*;

/**
 * Created by Jehan on 08/02/2016.
 */
public class Sauvegarde {
    File fichier = new File("sauvegarde/save.txt");

    PrintWriter pw = null;
    BufferedWriter bw = null;
    FileWriter fw = null;
    boolean fileOpen;

    public Sauvegarde(){
        try {
            fw = new FileWriter(fichier,true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            fileOpen = true;

        } catch (IOException exception) {
            System.out.println("File can't be open. Err code : 1.");
            fileOpen = false;
        }
    }

    public void sauvegardeCase(int i, int j, Color_v color, int numero){
        if(fileOpen){
            try {
                pw.println(i + ";"+ j + ";" + color.getCouleur() + ";" + (numero-1));
                pw.flush();
            }catch(Exception e){
                System.out.println("File can't be write in. Err code : 3.");
                e.printStackTrace();
            }
        }
    }

    public void sauvegardeEtatAbandonJoueur(String color){
        save("Abandon",color);
    }
    public void sauvegardeEtatTourJoueur(String color){
        save("Tour", color);
    }
    public void sauvegardeEtatJoueurIA(String color){ save("IA", color);}
    public void sauvegardeNomJoueur(String color, String name){ save("Nom;"+color, name);}

    public void save(String msg, String color){
        if(fileOpen){
            try {
                pw.println(msg + ';' + color);
                pw.flush();
            }catch(Exception e){
                System.out.println("File can't be write in. Err code : 3.");
                e.printStackTrace();
            }
        }
    }

    public void delete(){
        fichier.delete();
    }
}