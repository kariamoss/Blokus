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


        modelGeneral.tabButtonInventaire = new JButton[20];

        for (int i = 0; i < 20; i++){
            modelGeneral.tabButtonInventaire[i] = new JButton();
            ControlButton controlInventaire = new ControlButton(modelGeneral,modelInventaire, i);
            modelGeneral.tabButtonInventaire[i].addActionListener(controlInventaire);


            modelGeneral.tabButtonInventaire[i].setBorder(new LineBorder(Color.DARK_GRAY, 2));
            modelGeneral.tabButtonInventaire[i].setPreferredSize(new Dimension(45,45));

            ImageIcon imageIcon = new ImageIcon(modelInventaire.getPiece(i).getImage());
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH ) ;
            ImageIcon icon = new ImageIcon(newImage);

            modelGeneral.tabButtonInventaire[i].setIcon(icon);
            panelInventaire.add(modelGeneral.tabButtonInventaire[i]);


            /**/
        }

    }

    public JPanel getInventaire(){
        return panelInventaire;
    }

}
