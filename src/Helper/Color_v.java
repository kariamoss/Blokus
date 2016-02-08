package Helper;
import java.awt.*;

/**
 * Created by Fox Mc-Tag on 29/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class Color_v {
    private Color color;
    private String couleur;

    public Color_v(){
        color= new Color(58, 58, 58);
    }

    public Color_v(int redLevel, int greenLevel, int blueLevel){
        color= new Color(redLevel, greenLevel, blueLevel);
    }

    public Color_v(String color){
        switch (color){


            case "Blue":
                this.color= new Color(46,100,255);
                this.couleur = "Blue";
                break;
            case "Bleu":
                this.color= new Color(46,100,255);
                this.couleur = "Blue";
                break;

            case "Red":
                this.color= Color.RED;
                this.couleur = "Red";
                break;
            case "Rouge":
                this.color= Color.RED;
                this.couleur = "Red";
                break;

            case "Yellow":
                this.color= Color.YELLOW;
                this.couleur = "Yellow";
                break;
            case "Jaune":
                this.color= Color.YELLOW;
                this.couleur = "Yellow";
                break;

            case "Green":
                this.color= Color.GREEN;
                this.couleur = "Green";
                break;
            case "Vert":
                this.color= Color.GREEN;
                this.couleur = "Green";
                break;


        }
    }

    public Color_v(Color colorToRecycle){
        color= colorToRecycle;
    }



    public Color getColor(){ return this.color; }

    public String getCouleur(){ return  couleur;}



}
