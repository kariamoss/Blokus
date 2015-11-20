package Vue;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


/**
 * Created by remi on 20/11/15.
 */
public class Inventaire_v {

    JPanel panelInventaire;

    public Inventaire_v(){
        initInventaire();
    }

    private void initInventaire(){

        panelInventaire = new JPanel(new GridLayout(4,5));
        panelInventaire.setOpaque(false);
        fillInventaire();


    }

    private void fillInventaire(){

        JButton[] inventaire;
        inventaire = new JButton[20];

        for (int i = 0; i < 20; i++){
            inventaire[i] = new JButton();
            inventaire[i].setBorder(new LineBorder(Color.DARK_GRAY, 2));
            inventaire[i].setPreferredSize(new Dimension(45,45));
            panelInventaire.add(inventaire[i]);
        }


    }

    public JPanel getInventaire(){
        return panelInventaire;
    }

}
