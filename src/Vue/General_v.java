package Vue;

import Model.General_m;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class General_v extends JFrame {
    protected General_m model;
    protected BoutonsControleJeu_v fenetreControle = new BoutonsControleJeu_v();
    protected Inventaire_v fenetreInventaire = new Inventaire_v();
    //protected Joueur_v fenetreJoueur = new Joueur_v();
    //protected VuePiece_v fenetreVuePiece = new VuePiece_v();
    //protected VueProgressBar_v fenetreProgressBar = new VueProgressBar();


    protected JPanel panel_principal;
    protected JPanel fenetre_Grille;
    protected JPanel panel_gauche;

    public General_v(General_m model){
        this.model = model;
        setTitle("Blokus");
        initAttribute();
        fenetreControle.init();
        fenetreControle.dessinerBoutons();
        setSize(900, 650);
        setContentPane(panel_principal);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAttribute() {
        panel_principal = new JPanel();
        fenetre_Grille = new JPanel();
        panel_gauche = new JPanel(new GridLayout(5,1));
        fenetre_Grille.setPreferredSize(new Dimension(600, 600));
        panel_gauche.setPreferredSize(new Dimension(265, 600));

        //panel_gauche.add(fenetreJoueur.getJoueur());

        //panel_gauche.add(new BoutonsControleJeu_v().getPanelDeControle());
        panel_gauche.add(fenetreControle.getPanelDeControle());
        //fenetreControle.getPanelDeControle().setBorder(new LineBorder(Color.DARK_GRAY, 1));


        //fenetreInventaire.getInventaire().setBorder(new LineBorder(Color.DARK_GRAY, 1));
        panel_gauche.add(fenetreInventaire.getInventaire());

        //panel_gauche.add(fenetreVuePiece.getVuePiece());

        //panel_gauche.add(fenetreProgressBar.getProgressBar());

        fenetre_Grille.add(new Grille_v(600, 20, true).getGrille());
        panel_principal.add(fenetre_Grille);
        panel_principal.add(panel_gauche);
    }

    public void display() {
        setVisible(true);
    }

}
