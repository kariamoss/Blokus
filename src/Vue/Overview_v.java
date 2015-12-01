package Vue;

import javax.swing.*;

/**
 * Created by Lucas on 01/12/2015.
 */
public class Overview_v {
    JPanel panelOverview;

    public Overview_v(){
        initOverview();
    }

    private void initOverview()
    {
        panelOverview = new JPanel();
        panelOverview.setOpaque(false);
    }

    public JPanel getOverview()
    {
        return panelOverview;
    }
}
