package Helper;
import java.awt.*;

/**
 * Created by Fox Mc-Tag on 29/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class Color_v {
    private Color color;




    public Color_v(){
        color= new Color(58, 58, 58);
    }

    public Color_v(int redLevel, int greenLevel, int blueLevel){
        color= new Color(redLevel, greenLevel, blueLevel);
    }

    public Color_v(String color){
        switch (color){


            case "Blue":
                this.color= Color.BLUE;
                break;
            case "Bleu":
                this.color= Color.BLUE;
                break;

            case "Red":
                this.color= Color.RED;
                break;
            case "Rouge":
                this.color= Color.RED;
                break;

            case "Yellow":
                this.color= Color.YELLOW;
                break;
            case "Jaune":
                this.color= Color.YELLOW;
                break;

            case "Green":
                this.color= Color.GREEN;
                break;
            case "Vert":
                this.color= Color.GREEN;
                break;


        }
    }

    public Color_v(Color colorToRecycle){
        color= colorToRecycle;
    }



    public Color getColor(){ return this.color; }




}