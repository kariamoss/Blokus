package Model;

import Vue.Accueil_v;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mathieu on 02/02/2016.
 */
public class Accueil_m {
    public BufferedImage buffImg;
    // img
    public Accueil_m(){
        loadImage();
    }

    public void loadImage(){
        try {
            buffImg = ImageIO.read(new File("images/accueil/blokus1.jpg"));
        }catch (IOException e){
            System.out.println("Background image error");
        }
    }

    public BufferedImage getBuffImg(){ return buffImg;}
}
