package Controler;

import Model.Accueil_m;
import Model.General_m;
import Vue.Accueil_v;
import Vue.General_v;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Mathieu on 02/02/2016.
 */
public class ControlAccueil implements ActionListener {
    protected Accueil_v accueil_v;
    protected Accueil_m accueil_m;

    public ControlAccueil(Accueil_m accueil_m, Accueil_v accueil_v) {
        this.accueil_m = accueil_m;
        this.accueil_v = accueil_v;

        accueil_v.display();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == accueil_v.nouvellePartie) {
            suppressionSauvegarde();
            General_m modelGeneral = new General_m();
            //La vue est créée immédiatement
            ControlGroup control = new ControlGroup(modelGeneral, false);
            accueil_v.undisplay();
        }
        if(e.getSource() == accueil_v.chargerPartie) {
            General_m modelGeneral = new General_m();
            //La vue sera créée après l'actualisation du model lors du chargement de la partie
            ControlGroup control = new ControlGroup(modelGeneral, true);
            modelGeneral.chargement.chargementCase(accueil_v);
        }
        if(e.getSource() == accueil_v.quitter){
            System.exit(0);
        }
    }
    public void suppressionSauvegarde(){
        try {
            File file = new File( "sauvegarde/save.txt");
            String path = file.getCanonicalPath();
            File filePath = new File(path);

            //On créé un flux pour prendre le controle sur le fichier et le réinitialiser
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.close();
            /*if(!filePath.delete()) System.out.println("File can't be suppress at "
                    +path+". Err code : 6B.");*/

        } catch (NoSuchFileException x) {
            System.out.println(" no such  file or directory");
        } catch (IOException x) {
            System.out.println("File can't be found. Err code : 6.");
        }
    }
}
