package Vue;

import Model.General_m;

import javax.swing.*;
import java.awt.*;


public class General_v extends JFrame {
    protected General_m model;
    protected BoutonsControleJeu_v fenetreControle = new BoutonsControleJeu_v();
    protected Inventaire_v fenetreInventaire = new Inventaire_v();
    //protected Joueur_v fenetreJoueur = new Joueur_v();
    //protected VuePiece_v fenetreVuePiece = new VuePiece_v();
    //protected VueProgressBar_v fenetreProgressBar = new VueProgressBar();


    protected JPanel panel_principal;
    protected JPanel fenetre_Grille;
    protected JPanel panel_droite;
    protected JPanel panel_retourner;





    public General_v(General_m model){
        this.model = model;
        setTitle("Blokus");
        initAttribute();
        fenetreControle.init();
        fenetreControle.dessinerBoutons();
        setSize(900, 650);
        setContentPane(panel_principal);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void initAttribute() {
        panel_principal = new JPanel();
        fenetre_Grille = new JPanel();
        panel_retourner= new JPanel();
        panel_droite = new JPanel(new GridLayout(5,1));
        fenetre_Grille.setPreferredSize(new Dimension(600, 600));
        panel_droite.setPreferredSize(new Dimension(265, 600));

        //panel_droite.add(fenetreJoueur.getJoueur());

        //panel_droite.add(new BoutonsControleJeu_v().getPanelDeControle());7
        panel_droite.add(new GameStats_v().getGameStats());
        panel_droite.add(fenetreControle.getPanelDeControle());

        //fenetreControle.getPanelDeControle().setBorder(new LineBorder(Color.DARK_GRAY, 1));


        //fenetreInventaire.getInventaire().setBorder(new LineBorder(Color.DARK_GRAY, 1));
        panel_droite.add(fenetreInventaire.getInventaire());
        panel_droite.add(fenetreControle.getPanelRetourner());


        //panel_droite.add(fenetreVuePiece.getVuePiece());

        //panel_droite.add(fenetreProgressBar.getProgressBar());

        fenetre_Grille.add(new Grille_v(600, 20, model).getGrille());
        panel_principal.add(fenetre_Grille);
        panel_principal.add(panel_droite);
    }



    public void display() {
        setVisible(true);
    }





}
