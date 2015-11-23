package Vue;
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

    public BoutonsControleJeu_v(){
        init();
        dessinerBoutons();

    }

    public void init(){
        btAbandonner = new JButton("Abandonner");
        btPause = new JButton("Pause");
        btPlay = new JButton("Play");

    }

    public void dessinerBoutons(){
        panelDeControle=new JPanel();
        panelDeControle.setLayout(new BoxLayout(panelDeControle, BoxLayout.X_AXIS));
        panelDeControle.add(btAbandonner);
        panelDeControle.add(btPause);
        panelDeControle.add(btPlay);


    }

    public JPanel getPanelDeControle(){
        return panelDeControle;
    }

}
