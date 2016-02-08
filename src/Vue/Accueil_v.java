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
    private JLabel imageFond;
    private JPanel panelNouvellePartie;
    private JPanel panelChargerPartie;
    private JPanel panelOptions;
    private JPanel panelQuitter;
    private ImageIcon imgBlokus;
    private PanelPerso panelFond;

    public BufferedImage buffImg;
    public Accueil_v(){
        setTitle("Blokus");
        initAttribute(modelGeneral);


        setSize(900, 660);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw();
    }

    public void initAttribute(General_m modelGeneral){
        this.modelGeneral = modelGeneral;
        controlAccueil = new ControlAccueil(accueil_m, this);
        imgBlokus = new ImageIcon("images/accueil/blokus1.jpg");
        imageFond = new JLabel(imgBlokus);
        try {
            buffImg = ImageIO.read(new File("images/accueil/blokus1.jpg"));
        }catch (IOException e){
            System.out.println("Background image error");
        }

    }
    public void display() {
        setVisible(true);
    }
    public void undisplay(){setVisible(false);}
    
    public void draw() {
        //panels
        panelGeneral = new JPanel();
        panelFond = new PanelPerso();
        panelNouvellePartie = new JPanel();
        panelChargerPartie = new JPanel();
        panelOptions = new JPanel();
        panelQuitter = new JPanel();

        //boutons
        nouvellePartie = new JButton("Nouvelle partie");
        chargerPartie = new JButton("Charger Partie");
        options = new JButton("Options");
        quitter = new JButton("Quitter");

        //action sur les boutons
        nouvellePartie.addActionListener(controlAccueil);

        //chargements des sous-panels
        panelChargerPartie.add(chargerPartie);
        panelNouvellePartie.add(nouvellePartie);
        panelOptions.add(options);
        panelQuitter.add(quitter);


        // ajout au panel general
        panelGeneral.setOpaque(false);
        imageFond.setBounds(0, 0, 900, 660);
       // panelGeneral.add(imageFond);
      //  imageFond.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelGeneral.setPreferredSize(new Dimension(900, 660));
        nouvellePartie.setBackground(new Color(255, 255, 0));
        nouvellePartie.setOpaque(false);
        panelGeneral.add(nouvellePartie);
        panelGeneral.add(panelChargerPartie);
        panelGeneral.add(panelOptions);
        panelGeneral.add(panelQuitter);
        panelGeneral.setLayout(new BoxLayout(panelGeneral, BoxLayout.Y_AXIS));


        setContentPane(panelGeneral);
       // panel.setLocation(150,200);

    }

}
