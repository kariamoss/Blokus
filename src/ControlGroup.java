/**
 * Created by Jehan Milleret on 14/11/2015.
 */
public class ControlGroup {
    private Model model;
    private Vue vue;
    public ControlButton controlButton;
    public ControlMenu controlMenu;

    public ControlGroup(Model model){
        this.model = model;
        vue = new Vue(model);
        //ControlButton controlButton = new ControlButton(model, vue);
        //ControlMenu controlMenu = new ControlMenu(model, vue);

        vue.display();

    }
}
