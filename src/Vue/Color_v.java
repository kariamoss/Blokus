package Vue;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Fox Mc-Tag on 29/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class Color_v {
    Color color;




    public Color_v(){
        color= new Color(58, 58, 58);
    }

    public Color_v(int redLevel, int greenLevel, int blueLevel){
        color= new Color(redLevel, greenLevel, blueLevel);
    }

    public Color_v(Color colorToRecycle){
        color= colorToRecycle;
    }



    public Color getColor(){
        return this.color;
    }




}
