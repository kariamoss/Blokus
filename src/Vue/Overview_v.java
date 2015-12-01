package Vue;

import Controler.ControlButton;
import Model.General_m;

import javax.swing.*;
import java.awt.*;

/**
 * Created by remi on 01/12/15.
 */
public class Overview_v {

    JPanel panelOverview;
    General_m modelGeneral;
    ControlButton controlOverview;

    public Overview_v(General_m modelGeneral){

        this.modelGeneral = modelGeneral;
        initOverview();
    }

    public void initOverview(){

        fillOverview();
    }

    public void fillOverview(){

        /*Piece_m pieceSelectionnee = model_General.selectJoueurActif().getInventaire().selectPieceActive();
        //controlOverview = new ControlButton(model_General, model_Inventaire, i);
        //model_Inventaire.tabButtonInventaire[i].addActionListener(controlOverview);

        ImageIcon imageIcon = new ImageIcon(pieceSelectionnee.getImage());
        Image image = imageIcon.getImage();
        ImageIcon icon = new ImageIcon(image);*/
        modelGeneral.overviewButton = new JButton();
        Dimension d = new Dimension(110, 110);
        modelGeneral.overviewButton.setPreferredSize(d);

        modelGeneral.overviewButton.setOpaque(false);
        modelGeneral.overviewButton.setContentAreaFilled(false);
        modelGeneral.overviewButton.setBorderPainted(false);
        panelOverview = new JPanel();
        panelOverview.add(modelGeneral.overviewButton);


    }

    public JPanel getOverview(){

        return panelOverview;
    }
}
