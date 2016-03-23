package Vue;

import Controler.ControlAbandonner;
import Helper.Chargement;
import Helper.Helper_Preview;
import Model.General_m;
import Model.Joueur_m;

import javax.swing.*;
import java.awt.*;


public class General_v extends JFrame {
    protected General_m modelGeneral;

    public Helper_Preview helper_preview;

    public BoutonsControleJeu_v boutonsControleJeu;
    public Inventaire_v inventaire;
    public GameStats_v gameStats;
    public Overview_v overview;
    public Plateau_v plateau;
    public Menu_v menu;
    public PlayerCard_v playerCard;

    protected JPanel panel_principal;
    protected JPanel fenetre_Grille;
    protected JPanel panel_droite;

    public General_v(General_m modelGeneral){
        this.modelGeneral = modelGeneral;

        overview = new Overview_v(modelGeneral);
        inventaire = new Inventaire_v(modelGeneral);
        plateau = new Plateau_v(modelGeneral, this);
        menu = new Menu_v(this);
        helper_preview = new Helper_Preview(this, modelGeneral);
        boutonsControleJeu = new BoutonsControleJeu_v(modelGeneral, this);


        setTitle("Blokus");
        initAttribute(modelGeneral);

        boutonsControleJeu.init();
        boutonsControleJeu.dessinerBoutons();
        setSize(900, 670);
        setContentPane(panel_principal);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }



    public void initAttribute(General_m modelGeneral) {
        panel_principal = new JPanel();
        fenetre_Grille = new JPanel();
        panel_droite = new JPanel(new GridLayout(5,1));
        fenetre_Grille.setPreferredSize(new Dimension(610, 610));
        panel_droite.setPreferredSize(new Dimension(265, 600));

        //panel_droite.add(fenetreJoueur.getJoueur());

        Joueur_m tabJoueur[] = new Joueur_m[4];
        for (int i =0;i<4;i++)
            tabJoueur[i] = modelGeneral.getJoueur(i);


        //panel_droite.add(new BoutonsControleJeu_v().getPanelDeControle());
        GameStats_v gameStats = new GameStats_v(tabJoueur);
        panel_droite.add(gameStats.getGameStats());
        modelGeneral.gameStats = gameStats;
        panel_droite.add(boutonsControleJeu.getPanelDeControle());

        //fenetreControle.getPanelDeControle().setBorder(new LineBorder(Color.DARK_GRAY, 1));


        //fenetreInventaire.getInventaire().setBorder(new LineBorder(Color.DARK_GRAY, 1));
        panel_droite.add(inventaire.getInventaire());
        panel_droite.add(boutonsControleJeu.getPanelRetourner());
        panel_droite.add(overview.getOverview());


        //panel_droite.add(fenetreVuePiece.getVuePiece());

        //panel_droite.add(fenetreProgressBar.getProgressBar());

        fenetre_Grille.add(plateau.getGrille());
        panel_principal.add(fenetre_Grille);
        panel_principal.add(panel_droite);
        setJMenuBar(menu.barre_menu);
    }

    public void actualise(){
        this.validate();
        this.repaint();
        this.display();
    }


    public void display() {
        setVisible(true);
    }

    public void undisplay(){setVisible(false);}

    public BoutonsControleJeu_v getFenetreControle() {
        return boutonsControleJeu;
    }

    public void informationMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title , JOptionPane.INFORMATION_MESSAGE);
    }

}
