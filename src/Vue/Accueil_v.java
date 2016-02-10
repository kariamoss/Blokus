package Vue;

import Controler.ControlAccueil;
import Controler.PanelPerso;
import Model.Accueil_m;
import Model.General_m;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mathieu on 23/01/2016.
 */
public class Accueil_v extends JFrame {
    protected General_m modelGeneral;
    public JPanel panelGeneral;
    public JButton nouvellePartie;
    public  JButton chargerPartie;
    public ControlAccueil controlAccueil;
    public JButton options;
    public JButton quitter;
    public Accueil_m accueil_m;
    private JPanel panelNouvellePartie;
    private JPanel panelChargerPartie;
    private JPanel panelOptions;
    private JPanel panelQuitter;
    public PanelPerso panelFond;
    public BufferedImage buffImg;
    public Font font;


    public Accueil_v(){
        setTitle("Blokus");
        initAttribute(modelGeneral);
        this.setLayout(null);


        setSize(900, 660);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw();
    }

    public void initAttribute(General_m modelGeneral){
        this.modelGeneral = modelGeneral;
        controlAccueil = new ControlAccueil(accueil_m, this);
       // font = new Font("font/Blokus.ttf",Font.BOLD,15);


    }
    public void display() {
        setVisible(true);
    }
    public void undisplay(){setVisible(false);}
    
    public void draw() {
        //panels
        loadImage();
        panelGeneral = new JPanel();
        panelNouvellePartie = new JPanel();
        panelChargerPartie = new JPanel();
        panelOptions = new JPanel();
        panelQuitter = new JPanel();
        panelFond = new PanelPerso(buffImg);
        //panelFond.setBounds(0,0,900,600);

        //boutons
        nouvellePartie = new JButton("Nouvelle partie");
        //nouvellePartie.setFont(font);
        chargerPartie = new JButton("Charger Partie");
        options = new JButton("Options");
        quitter = new JButton("Quitter");

        //action sur les boutons
        nouvellePartie.addActionListener(controlAccueil);
        chargerPartie.addActionListener(controlAccueil);
        quitter.addActionListener(controlAccueil);

        //chargements des sous-panels
        panelNouvellePartie.add(nouvellePartie);
        panelNouvellePartie.setOpaque(false);
        panelChargerPartie.add(chargerPartie);
        panelChargerPartie.setOpaque(false);
        panelOptions.add(options);
        panelOptions.setOpaque(false);
        panelQuitter.add(quitter);
        panelQuitter.setOpaque(false);


            JPanel panelTest = new JPanel();
        // ajout au panel general
        panelGeneral.add(panelNouvellePartie);
        panelGeneral.add(panelChargerPartie);
        panelGeneral.add(panelOptions);
        panelGeneral.add(panelQuitter);
        panelGeneral.setLayout(new BorderLayout());
        panelGeneral.add(Box.createVerticalStrut(150), BorderLayout.NORTH);
        panelGeneral.add(Box.createHorizontalGlue(), BorderLayout.EAST);
        panelGeneral.add(Box.createHorizontalStrut(200), BorderLayout.WEST);
        panelGeneral.setOpaque(false);
        panelGeneral.setLayout(new BoxLayout(panelGeneral, BoxLayout.X_AXIS));
        panelFond.setLayout(new BorderLayout());
        panelFond.add(panelGeneral,BorderLayout.SOUTH);

        setContentPane(panelFond);
    }

    public void loadImage(){
        try {
            buffImg = ImageIO.read(new File("images/accueil/blokus1.jpg"));
        }catch (IOException e){
            System.out.println("Background image error");
        }
    }
}
