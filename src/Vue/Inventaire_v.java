package Vue;

import Model.General_m;
import Model.Inventaire_m;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class Inventaire_v {

    JPanel panelInventaire;
    Inventaire_m modelInventaire;
    General_m modelGeneral;

    public JButton[] tabButtonInventaire;

    public Inventaire_v(General_m modelGeneral){
        this.modelGeneral = modelGeneral;
        initInventaire();
    }

    private void initInventaire(){

        panelInventaire = new JPanel(new GridLayout(4,5));
        panelInventaire.setOpaque(false);
        fillInventaire();
    }

    private void fillInventaire(){


        tabButtonInventaire = new JButton[20];

        for (int i = 0; i < 20; i++){
            tabButtonInventaire[i] = new JButton();

           // TODO Set ActionListener dans une fonction : OK


            tabButtonInventaire[i].setBorder(new LineBorder(Color.DARK_GRAY, 1));
            tabButtonInventaire[i].setContentAreaFilled(false);
            tabButtonInventaire[i].setPreferredSize(new Dimension(45,45));

            ImageIcon imageIcon = new ImageIcon(modelGeneral.selectJoueurActif().getInventaire().getPiece(i).getImage());
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH ) ;
            ImageIcon icon = new ImageIcon(newImage);

            tabButtonInventaire[i].setIcon(icon);
            panelInventaire.add(tabButtonInventaire[i]);

        }

    }

    public JPanel getInventaire(){
        return panelInventaire;
    }

    public void setInventaireButtonControler(ActionListener actionListener){
        for (int i = 0; i < 20; i++) {
            tabButtonInventaire[i].addActionListener(actionListener);
        }
    }

}
