package Vue;

import Model.General_m;
import Model.Inventaire_m;
import Model.Joueur_m;

import javax.swing.*;
import java.awt.*;


public class General_v extends JFrame {
    protected General_m modelGeneral;
    protected Inventaire_m modelInventaire;
    protected BoutonsControleJeu_v fenetreControle;
    protected Inventaire_v fenetreInventaire;
    //protected Joueur_v fenetreJoueur = new Joueur_v();
    //protected VuePiece_v fenetreVuePiece = new VuePiece_v();
    //protected VueProgressBar_v fenetreProgressBar = new VueProgressBar();

    protected Overview_v overview_v;
    protected JPanel panel_principal;
    protected JPanel fenetre_Grille;
    protected JPanel panel_droite;

    public General_v(General_m modelGeneral, Inventaire_m modelInventaire){
        this.modelInventaire = modelInventaire;
        this.modelGeneral = modelGeneral;
        fenetreControle = new BoutonsControleJeu_v(modelGeneral);
        overview_v = new Overview_v(modelGeneral);
        setTitle("Blokus");
        initAttribute(modelGeneral);

        fenetreControle.init();
        fenetreControle.dessinerBoutons();
        setSize(900, 650);
        setContentPane(panel_principal);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public void initAttribute(General_m modelGeneral) {
        panel_principal = new JPanel();
        fenetre_Grille = new JPanel();
        panel_droite = new JPanel(new GridLayout(5,1));
        fenetre_Grille.setPreferredSize(new Dimension(600, 600));
        panel_droite.setPreferredSize(new Dimension(265, 600));

        //panel_droite.add(fenetreJoueur.getJoueur());

        Joueur_m tabJoueur[] = new Joueur_m[4];
        for (int i =0;i<4;i++)
            tabJoueur[i] = modelGeneral.getJoueur(i);


        //panel_droite.add(new BoutonsControleJeu_v().getPanelDeControle());
        panel_droite.add(new GameStats_v(tabJoueur).getGameStats());
        panel_droite.add(fenetreControle.getPanelDeControle());

        //fenetreControle.getPanelDeControle().setBorder(new LineBorder(Color.DARK_GRAY, 1));


        //fenetreInventaire.getInventaire().setBorder(new LineBorder(Color.DARK_GRAY, 1));
        fenetreInventaire = new Inventaire_v(modelGeneral, modelInventaire);
        panel_droite.add(fenetreInventaire.getInventaire());
        panel_droite.add(fenetreControle.getPanelRetourner());
        panel_droite.add(overview_v.getOverview());


        //panel_droite.add(fenetreVuePiece.getVuePiece());

        //panel_droite.add(fenetreProgressBar.getProgressBar());

        fenetre_Grille.add(new Grille_v(600, 20, modelGeneral).getGrille());
        panel_principal.add(fenetre_Grille);
        panel_principal.add(panel_droite);
    }



    public void display() {
        setVisible(true);
    }

    public BoutonsControleJeu_v getFenetreControle() {
        return fenetreControle;
    }
}
