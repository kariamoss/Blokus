package Vue;

import Controler.ControlParamPartie;
import Model.General_m;
import Model.ParamPartie_m;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mathi on 01/03/2016.
 */
public class ParamPartie_v extends JFrame{
    public ControlParamPartie controlParamPartie;
    private ParamPartie_m paramPartie_m;

    private JPanel panelTypePartie;
    private JPanel panelGeneral;
    private JPanel panelJoueur1;
    public JPanel panelJoueur2;
    public JPanel panelJoueur3;
    public JPanel panelJoueur4;
    private JPanel panelJoueurs;
    private General_m modelGeneral;
    public JCheckBox reseauCB;
    public JCheckBox localCB;
    public JCheckBox iaJoueur1;
    public JCheckBox humainJoueur1;
    public JCheckBox iaJoueur2;
    public JCheckBox humainJoueur2;
    public JCheckBox iaJoueur3;
    public JCheckBox humainJoueur3;
    public JCheckBox iaJoueur4;
    public JCheckBox humainJoueur4;
    public ButtonGroup bgTypePartie;
    public ButtonGroup bgJoueur1;
    public ButtonGroup bgJoueur2;
    public ButtonGroup bgJoueur3;
    public ButtonGroup bgJoueur4;
    public JButton retourAccueil;
    public JButton valider;
    public JTextField textFieldNomJoueur1;
    public JTextField textFieldNomJoueur2;
    public JTextField textFieldNomJoueur3;
    public JTextField textFieldNomJoueur4;


    public ParamPartie_v(General_m modelGeneral){
        setTitle("Blokus");
        initAttribute(modelGeneral);
        this.setLayout(null);


        setSize(900, 660);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw();
    }

    public void initAttribute(General_m general_m){
        paramPartie_m = new ParamPartie_m();
        controlParamPartie = new ControlParamPartie(paramPartie_m,this);
        setLayout(new CardLayout());
        this.modelGeneral = general_m;
        bgTypePartie = new ButtonGroup();
        bgJoueur1 = new ButtonGroup();
        bgJoueur2 = new ButtonGroup();
        bgJoueur3 = new ButtonGroup();
        bgJoueur4 = new ButtonGroup();

        iaJoueur1= new JCheckBox();
        iaJoueur1.setEnabled(false);
        iaJoueur2= new JCheckBox();
        iaJoueur3= new JCheckBox();
        iaJoueur4= new JCheckBox();
        humainJoueur1= new JCheckBox();
        humainJoueur1.setSelected(true);
        humainJoueur2= new JCheckBox();
        humainJoueur2.setSelected(true);
        humainJoueur3= new JCheckBox();
        humainJoueur3.setSelected(true);
        humainJoueur4= new JCheckBox();
        humainJoueur4.setSelected(true);
        valider = new JButton("Créer la partie");
    }

    public void draw(){
        panelGeneral = new JPanel();
        panelTypePartie = new JPanel();
        panelJoueur1 = new JPanel();
        panelJoueur2 = new JPanel();
        panelJoueur3 = new JPanel();
        panelJoueur4 = new JPanel();
        panelJoueurs = new JPanel();

        retourAccueil = new JButton("Retour à l'accueil");

        reseauCB = new JCheckBox();
        localCB = new JCheckBox();
        localCB.setSelected(true);

        textFieldNomJoueur1 = new JTextField("Joueur1");
        textFieldNomJoueur2 = new JTextField("Joueur2");
        textFieldNomJoueur3 = new JTextField("Joueur3");
        textFieldNomJoueur4 = new JTextField("Joueur4");

        //panel du joueur 1
        bgJoueur1.add(humainJoueur1);
        bgJoueur1.add(iaJoueur1);
        panelJoueur1.add(new JLabel("Humain"));
        panelJoueur1.add(humainJoueur1);
        panelJoueur1.add(new JLabel("IA"));
        panelJoueur1.add(iaJoueur1);
        panelJoueur1.add(textFieldNomJoueur1);
        panelJoueur1.setBackground(Color.red);


        //panel du joueur 2
        bgJoueur2.add(humainJoueur2);
        bgJoueur2.add(iaJoueur2);
        panelJoueur2.add(new JLabel("Humain"));
        panelJoueur2.add(humainJoueur2);
        panelJoueur2.add(new JLabel("IA"));
        panelJoueur2.add(iaJoueur2);
        panelJoueur2.add(textFieldNomJoueur2);
        panelJoueur2.setBackground(Color.blue);

        // panel du joueur 3
        bgJoueur3.add(humainJoueur3);
        bgJoueur3.add(iaJoueur3);
        panelJoueur3.add(new JLabel("Humain"));
        panelJoueur3.add(humainJoueur3);
        panelJoueur3.add(new JLabel("IA"));
        panelJoueur3.add(iaJoueur3);
        panelJoueur3.add(textFieldNomJoueur3);
        panelJoueur3.setBackground(Color.yellow);

        // panel du joueur 4
        bgJoueur4.add(humainJoueur4);
        bgJoueur4.add(iaJoueur4);
        panelJoueur4.add(new JLabel("Humain"));
        panelJoueur4.add(humainJoueur4);
        panelJoueur4.add(new JLabel("IA"));
        panelJoueur4.add(iaJoueur4);
        panelJoueur4.add(textFieldNomJoueur4);
        panelJoueur4.setBackground(Color.green);

        //panel du type de la partie
        bgTypePartie.add(reseauCB);
        bgTypePartie.add(localCB);
        panelTypePartie.add(new JLabel("Partie en Réseau"));
        panelTypePartie.add(reseauCB);
        panelTypePartie.add(new JLabel("Partie Locale"));
        panelTypePartie.add(localCB);
        panelTypePartie.add(retourAccueil);
        panelTypePartie.setBackground(Color.white);


        //listeners
        reseauCB.addActionListener(controlParamPartie);
        localCB.addActionListener(controlParamPartie);
        retourAccueil.addActionListener(controlParamPartie);
        humainJoueur1.addActionListener(controlParamPartie);
        humainJoueur2.addActionListener(controlParamPartie);
        humainJoueur3.addActionListener(controlParamPartie);
        humainJoueur4.addActionListener(controlParamPartie);
        iaJoueur1.addActionListener(controlParamPartie);
        iaJoueur2.addActionListener(controlParamPartie);
        iaJoueur3.addActionListener(controlParamPartie);
        iaJoueur4.addActionListener(controlParamPartie);
        valider.addActionListener(controlParamPartie);

        //ajout des panels des joueurs en groupe
        panelJoueurs.add(panelJoueur1);
        panelJoueurs.add(panelJoueur2);
        panelJoueurs.add(panelJoueur3);
        panelJoueurs.add(panelJoueur4);



        // ajout des sous-panels au panel general
        panelGeneral.add(panelTypePartie);
        panelGeneral.add(panelJoueurs);
        panelGeneral.add(valider);

        //dessine le panel général
        setContentPane(panelGeneral);

    }

    public void display() {
        setVisible(true);
    }
    public void undisplay(){setVisible(false);}

}
