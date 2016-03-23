package Vue;
import Controler.ControlAbandonner;
import Controler.ControlMusique;
import Controler.ControlRotationButton;
import Model.General_m;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class BoutonsControleJeu_v extends JFrame {
    protected JPanel panelDeControle;
    protected JPanel panelRetourner;
    public JButton btAbandonner;
    public JButton btPause;
    public JButton btPlay;
    public JButton btRetournerGauche;
    public JButton btRetournerDroite;
    public JButton btRetournerMiroir;
    protected ImageIcon imgAbandonner;
    protected ImageIcon imgPause;
    protected ImageIcon imgPlay;
    protected ImageIcon imgRetournerGauche;
    protected  ImageIcon imgRetournerDroite;
    protected  ImageIcon imgRetournerMiroir;

    ControlAbandonner controlAbandonner;
    ControlRotationButton controlRotationButton;
    ControlMusique controlMusique;

    General_m modelGeneral;
    General_v vueGeneral;


    public BoutonsControleJeu_v(General_m modelGeneral, General_v vueGeneral)
    {
        this.modelGeneral = modelGeneral;
        this.vueGeneral = vueGeneral;
        init();
        initSound();
        initRotation();
        initAbandon();
        dessinerBoutons();

    }
    public void btInvisible(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    public void init(){
        imgAbandonner = new ImageIcon(new ImageIcon("images/boutons_controle/giveup_PLS.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT ));
        imgPause = new ImageIcon(new ImageIcon("images/boutons_controle/pause31.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        imgPlay = new ImageIcon(new ImageIcon("images/boutons_controle/play.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        imgRetournerGauche = new ImageIcon(new ImageIcon("images/boutons_controle/rotationGauche.png").getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        imgRetournerDroite = new ImageIcon(new ImageIcon("images/boutons_controle/rotationDroite.png").getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        imgRetournerMiroir = new ImageIcon(new ImageIcon("images/boutons_controle/rotationMiroir.png").getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));


        btAbandonner = new JButton(imgAbandonner);
        btPause = new JButton(imgPause);
        btPlay = new JButton(imgPlay);
        btRetournerGauche = new JButton(imgRetournerGauche);
        btRetournerDroite = new JButton(imgRetournerDroite);
        btRetournerMiroir = new JButton(imgRetournerMiroir);

        btRetournerGauche.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        btRetournerGauche.setContentAreaFilled(false);
        btRetournerGauche.setPreferredSize(new Dimension(64, 64));
        btRetournerDroite.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        btRetournerDroite.setContentAreaFilled(false);
        btRetournerDroite.setPreferredSize(new Dimension(64, 64));
        btRetournerMiroir.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        btRetournerMiroir.setContentAreaFilled(false);
        btRetournerMiroir.setPreferredSize(new Dimension(64, 64));

        btInvisible(btAbandonner);
        btInvisible(btPause);
        btInvisible(btPlay);

        //controlRotationButton = new ControlRotationButton(modelGeneral, 1); //TODO Faire les actionsListeners : OK
        /*btRetournerGauche.addActionListener(controlRotationButton);

        //controlRotationButton = new ControlRotationButton(modelGeneral, 2);
        btRetournerDroite.addActionListener(controlRotationButton);

        //controlAbandonner = new ControlAbandonner(modelGeneral);
        btAbandonner.addActionListener(controlAbandonner);*/
    }

    public void initSound() {
        controlMusique = new ControlMusique(modelGeneral, vueGeneral); //TODO Regarder ça : OK
        btPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlMusique.play();
            } //TODO Faire les actionsListeners : OK
        });
        btPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlMusique.pause();
            }
        });
    }

    public void initRotation() {
        controlRotationButton = new ControlRotationButton(modelGeneral, vueGeneral);
        btRetournerGauche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlRotationButton.gauche();
            }
        });
        btRetournerDroite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlRotationButton.droite();
            }
        });
        btRetournerMiroir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlRotationButton.miroir();
            }
        });


    }

    public void initAbandon() {
        controlAbandonner = new ControlAbandonner(modelGeneral, vueGeneral);
        btAbandonner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlAbandonner.abandon();
            }
        });
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
        panelRetourner.add(btRetournerMiroir);



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
