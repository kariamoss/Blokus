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
    protected JButton btAbandonner;
    protected JButton btPause;
    protected JButton btPlay;
    protected ImageIcon imgAbandonner;
    protected ImageIcon imgPause;
    protected ImageIcon imgPlay;
    protected ControlButton controlePlay;
    protected ControlButton controlePause;
    protected ControlButton controleAbandonner;

    public BoutonsControleJeu_v(){
        init();
        dessinerBoutons();

    }

    public void init(){
        imgAbandonner = new ImageIcon(new ImageIcon("images/boutons_controle/giveup_PLS.jpg").getImage().getScaledInstance(40, 32, Image.SCALE_DEFAULT ));
        imgPause = new ImageIcon(new ImageIcon("images/boutons_controle/pause31.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        imgPlay = new ImageIcon(new ImageIcon("images/boutons_controle/play.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));


        btAbandonner = new JButton(imgAbandonner);
        btPause = new JButton(imgPause);
        btPlay = new JButton(imgPlay);


        btAbandonner.setOpaque(false);
        btAbandonner.setContentAreaFilled(false);
        btAbandonner.setBorderPainted(false);


        btPause.setOpaque(false);
        btPause.setContentAreaFilled(false);
        btPause.setBorderPainted(false);


        btPlay.setOpaque(false);
        btPlay.setContentAreaFilled(false);
        btPlay.setBorderPainted(false);

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

       // btAbandonner.addActionListener(controleAbandonner);
        //btPlay.addActionListener(controlePlay);
        //btPause.addActionListener(controlePause);


    }

    public JPanel getPanelDeControle(){
        return panelDeControle;
    }
    public JButton getBtAbandonner(){return btAbandonner;}

}
