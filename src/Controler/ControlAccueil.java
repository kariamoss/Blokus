package Controler;

import Model.Accueil_m;
import Model.General_m;
import Vue.Accueil_v;
import Vue.General_v;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
            ControlGroup control = new ControlGroup(modelGeneral);
            accueil_v.undisplay();

        }
        if(e.getSource() == accueil_v.chargerPartie) {
            General_m modelGeneral = new General_m();
            ControlGroup control = new ControlGroup(modelGeneral);
            accueil_v.undisplay();
            control.vue.chargement.chargementCase();

        }
        if(e.getSource() == accueil_v.quitter){
            System.exit(0);
        }
    }
    public void suppressionSauvegarde(){

        Path path = FileSystems.getDefault().getPath("sauvegarde", "save.txt");
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }


    }


}
