package Vue;

import Controler.ControlButton;
import Model.General_m;
import Model.Inventaire_m;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class Inventaire_v {

    JPanel panelInventaire;
    Inventaire_m modelInventaire;
    General_m modelGeneral;

    public Inventaire_v(General_m modelGeneral, Inventaire_m modelInventaire){
        this.modelInventaire = modelInventaire;
        this.modelGeneral = modelGeneral;
        initInventaire();
    }

    private void initInventaire(){

        panelInventaire = new JPanel(new GridLayout(4,5));
        panelInventaire.setOpaque(false);
        fillInventaire();
    }

    private void fillInventaire(){


        modelInventaire.tabButtonInventaire = new JButton[20];

        for (int i = 0; i < 20; i++){
            modelInventaire.tabButtonInventaire[i] = new JButton();
            ControlButton controlInventaire = new ControlButton(modelGeneral,modelInventaire, i);
            modelInventaire.tabButtonInventaire[i].addActionListener(controlInventaire);


            modelInventaire.tabButtonInventaire[i].setBorder(new LineBorder(Color.DARK_GRAY, 2));
            modelInventaire.tabButtonInventaire[i].setPreferredSize(new Dimension(45,45));

            ImageIcon imageIcon = new ImageIcon(modelInventaire.getPiece(i).getImage());
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH ) ;
            ImageIcon icon = new ImageIcon(newImage);

            modelInventaire.tabButtonInventaire[i].setIcon(icon);
            panelInventaire.add(modelInventaire.tabButtonInventaire[i]);


            /**/
        }

    }

    public JPanel getInventaire(){
        return panelInventaire;
    }

}
