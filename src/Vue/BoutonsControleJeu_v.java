package Vue;
import Controler.ControlButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class BoutonsControleJeu_v extends JFrame {
    protected JPanel panelDeControle;
    protected JPanel panelRetourner;
    protected JButton btAbandonner;
    protected JButton btPause;
    protected JButton btPlay;
    protected JButton btRetourner;
    protected ImageIcon imgAbandonner;
    protected ImageIcon imgPause;
    protected ImageIcon imgPlay;
    protected ImageIcon imgRetourner;
    protected ControlButton controlePlay;
    protected ControlButton controlePause;
    protected ControlButton controleAbandonner;

    public BoutonsControleJeu_v(){
        init();
        dessinerBoutons();

    }

    public void init(){
        imgAbandonner = new ImageIcon(new ImageIcon("images/boutons_controle/giveup_PLS.jpg").getImage().getScaledInstance(48, 40, Image.SCALE_DEFAULT ));
        imgPause = new ImageIcon(new ImageIcon("images/boutons_controle/pause31.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        imgPlay = new ImageIcon(new ImageIcon("images/boutons_controle/play.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        imgRetourner = new ImageIcon(new ImageIcon("images/boutons_controle/rotation.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));


        btAbandonner = new JButton(imgAbandonner);
        btPause = new JButton(imgPause);
        btPlay = new JButton(imgPlay);
        btRetourner = new JButton(imgRetourner);


        btAbandonner.setOpaque(false);
        btAbandonner.setContentAreaFilled(false);
        btAbandonner.setBorderPainted(false);


        btPause.setOpaque(false);
        btPause.setContentAreaFilled(false);
        btPause.setBorderPainted(false);


        btPlay.setOpaque(false);
        btPlay.setContentAreaFilled(false);
        btPlay.setBorderPainted(false);

        btRetourner.setOpaque(false);
        btRetourner.setContentAreaFilled(false);
        btRetourner.setBorderPainted(false);

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
        panelRetourner.add(btRetourner);


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
