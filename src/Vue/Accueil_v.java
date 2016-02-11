package Vue;

import Controler.ControlAccueil;
import Controler.PanelPerso;
import Model.Accueil_m;
import Model.General_m;

import javax.imageio.ImageIO;
import javax.swing.*;
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
    public BufferedImage bgImg;
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
        /*try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("font/BLokus.ttf")).deriveFont(Font.BOLD,14);
        } catch(Exception e){
            e.printStackTrace();
        }*/
        font = new Font("Arial",Font.BOLD,14);


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
        panelFond = new PanelPerso(bgImg);
        //panelFond.setBounds(0,0,900,600);

        //boutons
        nouvellePartie = new JButton("Nouvelle partie");
        chargerPartie = new JButton("Charger Partie");
        options = new JButton("Options");
        quitter = new JButton("Quitter");
        boutonsAccueil(nouvellePartie);
        boutonsAccueil(chargerPartie);
        boutonsAccueil(options);
        boutonsAccueil(quitter);


        //param sur les boutons

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

        // ajout au panel general
        panelGeneral.add(panelQuitter);
        panelGeneral.add(panelOptions);
        panelGeneral.add(panelChargerPartie);
        panelGeneral.add(panelNouvellePartie);

        //params du panel general
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
            bgImg = ImageIO.read(new File("images/accueil/blokus1.jpg"));
        }catch (IOException e){
            System.out.println("Background not found. Err code : 12.");
        }


    }
    //gere la mise en forme des boutons de l'accueil
    public void boutonsAccueil(JButton button){
        button.setFont(font);
        button.setForeground(Color.white);
        button.setOpaque(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setBorderPainted(false);
    }

}
