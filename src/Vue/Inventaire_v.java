package Vue;

import Model.Inventaire_m;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class Inventaire_v {

    JPanel panelInventaire;
    Inventaire_m inventaire_m = new Inventaire_m("blue");

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

            ImageIcon imageIcon = new ImageIcon(inventaire_m.getPiece(i).getImage());
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH ) ;
            ImageIcon icon = new ImageIcon( newimg );

            inventaire[i].setIcon(icon);
            panelInventaire.add(inventaire[i]);


            /**/
        }

    }

    public JPanel getInventaire(){
        return panelInventaire;
    }

}
