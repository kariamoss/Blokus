package Vue;
import Controler.ControlButton;
import Controler.ControlRotationButton;
import Model.General_m;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class BoutonsControleJeu_v extends JFrame {
    protected JPanel panelDeControle;
    protected JPanel panelRetourner;
    protected JButton btAbandonner;
    protected JButton btPause;
    protected JButton btPlay;
    public JButton btRetournerGauche;
    public JButton btRetournerDroite;
    protected ImageIcon imgAbandonner;
    protected ImageIcon imgPause;
    protected ImageIcon imgPlay;
    protected ImageIcon imgRetournerGauche;
    protected  ImageIcon imgRetournerDroite;
    protected ControlButton controlePlay;
    protected ControlButton controlePause;
    public ControlButton controleAbandonner;

    ControlRotationButton controlRotationButton;

    General_m modelGeneral;


    public BoutonsControleJeu_v(General_m modelGeneral)
    {
        this.modelGeneral = modelGeneral;
        init();
        dessinerBoutons();

    }

    public void init(){
        imgAbandonner = new ImageIcon(new ImageIcon("images/boutons_controle/giveup_PLS.jpg").getImage().getScaledInstance(65, 48, Image.SCALE_DEFAULT ));
        imgPause = new ImageIcon(new ImageIcon("images/boutons_controle/pause31.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        imgPlay = new ImageIcon(new ImageIcon("images/boutons_controle/play.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        imgRetournerGauche = new ImageIcon(new ImageIcon("images/boutons_controle/rotationGauche.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        imgRetournerDroite = new ImageIcon(new ImageIcon("images/boutons_controle/rotationDroite.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));


        btAbandonner = new JButton(imgAbandonner);
        btPause = new JButton(imgPause);
        btPlay = new JButton(imgPlay);
        btRetournerGauche = new JButton(imgRetournerGauche);
        btRetournerDroite = new JButton(imgRetournerDroite);


        btAbandonner.setOpaque(false);
        btAbandonner.setContentAreaFilled(false);
        btAbandonner.setBorderPainted(false);


        btPause.setOpaque(false);
        btPause.setContentAreaFilled(false);
        btPause.setBorderPainted(false);


        btPlay.setOpaque(false);
        btPlay.setContentAreaFilled(false);
        btPlay.setBorderPainted(false);



       /* btRetournerGauche.setOpaque(false);
        btRetournerGauche.setContentAreaFilled(false);
        btRetournerGauche.setBorderPainted(false);*/
        controlRotationButton = new ControlRotationButton(modelGeneral, this, 1);
        btRetournerGauche.addActionListener(controlRotationButton);

        /*btRetournerDroite.setOpaque(false);
        btRetournerDroite.setContentAreaFilled(false);
        btRetournerDroite.setBorderPainted(false);*/
        controlRotationButton = new ControlRotationButton(modelGeneral, this, 2);
        btRetournerDroite.addActionListener(controlRotationButton);

        controlePlay = new ControlButton();
        controleAbandonner = new ControlButton();
        controlePause = new ControlButton();







    }

    public void dessinerBoutons(){
        panelDeControle=new JPanel();
        panelDeControle.setLayout(new BoxLayout(panelDeControle, BoxLayout.X_AXIS));
        panelDeControle.add(btAbandonner);
        panelDeControle.add(btPause);
        panelDeControle.add(btPlay);

        panelRetourner = new JPanel();
        panelRetourner.add(btRetournerDroite);
        panelRetourner.add(btRetournerGauche);



       // btAbandonner.addActionListener(controleAbandonner);
        //btPlay.addActionListener(controlePlay);
        //btPause.addActionListener(controlePause);


    }

    public JPanel getPanelDeControle(){
        return panelDeControle;
    }
    public JButton getBtAbandonner(){return btAbandonner;}
    public JPanel getPanelRetourner(){return panelRetourner;}

}
