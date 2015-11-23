package Vue;

import Model.General_m;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jehan Milleret on 29/04/2015.
 */
public class General_v extends JFrame {
    protected General_m model;
    protected BoutonsControleJeu_v fenetreControle = new BoutonsControleJeu_v();
    protected JPanel fenetre;

    public General_v(General_m model){
        this.model = model;
        setTitle("Blokus");
        initAttribute();
        fenetreControle.init();
        fenetreControle.dessinerBoutons();
        setSize(800, 600);
        setContentPane(fenetre);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAttribute() {
        
        fenetre = new JPanel();
        fenetre.setBackground(Color.GRAY);
        fenetre.add(new Grille_v().getGrille());
        fenetre.add(fenetreControle.getPanelDeControle());

    }

    public void display() {

        setVisible(true);
    }

}
