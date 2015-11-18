package Controler;

import Model.General_m;
import Vue.General_v;

/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlGroup {
    private General_m model;
    private General_v vue;
    public ControlButton controlButton;
    public ControlMenu controlMenu;

    public ControlGroup(General_m model){
        this.model = model;
        vue = new General_v(model);
        //Controler.ControlButton controlButton = new Controler.ControlButton(generalm, vue);
        //Controler.ControlMenu controlMenu = new Controler.ControlMenu(generalm, vue);

        vue.display();
    }
}
