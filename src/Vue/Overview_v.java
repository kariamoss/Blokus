package Vue;

import Model.General_m;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by remi on 01/12/15.
 */
public class Overview_v {

    JPanel panelOverview;
    General_m modelGeneral;

    public JButton overviewButton;

    public Overview_v(General_m modelGeneral){

        this.modelGeneral = modelGeneral;
        initOverview();
    }

    public void initOverview(){

        fillOverview();
    }

    public void fillOverview(){

        overviewButton = new JButton();
        Dimension d = new Dimension(110, 110);
        overviewButton.setPreferredSize(d);

        overviewButton.setOpaque(false);
        overviewButton.setContentAreaFilled(false);
        overviewButton.setBorderPainted(false);
        panelOverview = new JPanel();
        panelOverview.add(overviewButton);


    }

    public JPanel getOverview(){

        return panelOverview;
    }

    public void setButtonControler(ActionListener actionListener) {

        overviewButton.addActionListener(actionListener);
    }
}
