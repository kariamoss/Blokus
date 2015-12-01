package Vue;

import Controler.ControlButton;
import Model.General_m;
import Model.Inventaire_m;
import Model.Piece_m;

import javax.swing.*;
import java.awt.*;

/**
 * Created by remi on 01/12/15.
 */
public class Overview_v {

    JPanel panelOverview;
    Inventaire_m model_Inventaire;
    General_m model_General;
    ControlButton controlOverview;

    public Overview_v(General_m model_General, Inventaire_m model_Inventaire){

        this.model_Inventaire = model_Inventaire;
        this.model_General = model_General;
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
        model_Inventaire.overviewButton = new JButton();

        model_Inventaire.overviewButton.setOpaque(false);
        panelOverview = new JPanel();
        panelOverview.add(model_Inventaire.overviewButton);


    }

    public JPanel getOverview(){

        return panelOverview;
    }
}
