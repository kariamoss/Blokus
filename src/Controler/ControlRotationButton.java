package Controler;

import Model.General_m;
import Model.Piece_m;
import Vue.BoutonsControleJeu_v;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Lucas on 01/12/2015.
 */
public class ControlRotationButton implements ActionListener
{
    General_m modelGeneral;
    BoutonsControleJeu_v vue;
    ControlPlateau controlPlateau;
    int i;

    public ControlRotationButton(General_m modelGeneral, BoutonsControleJeu_v vue, int i){
        this.modelGeneral = modelGeneral;
        this.vue = vue;
        this.i=i;
    }

    public void actionPerformed(ActionEvent f) {

        Piece_m piece = modelGeneral.selectJoueurActif().getInventaire().selectPieceActive();
        if (piece!=null)
        {
            //System.out.println("caca");
            /*if (f.getSource() == vue.btRetournerGauche) {
                System.out.println("Rotation vers la gauche");
            }
            if (f.getSource() == vue.btRetournerDroite) {
                System.out.println("Rotation vers la droite");
            }*/

            //Chargement de l'image
            String urlImage = modelGeneral.selectJoueurActif().getInventaire().selectPieceActive().getImage();
            BufferedImage image = null;
            try{
                image = ImageIO.read(new File(urlImage));
            }
            catch(Exception e){
                System.err.println(e);
            }

            //Récupère les dimension de l'image d'origine
            int h = image.getHeight();
            int w = image.getWidth();

            System.out.println("Dimension de l'image d'origine : " + h +" / " + w);

            //Redimensionnement à 110*110 (coéficient de 0.85 par rapport à l'image d'origine
            double scale = 0.85;
            AffineTransform tx = new AffineTransform();
            tx.scale(scale, scale);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage biNew = new BufferedImage((int)(w*scale), (int)(h*scale), image.getType());
            image = op.filter(image, biNew);

            h = image.getHeight();
            w = image.getWidth();
            System.out.println("Dimension de l'image redimensionnée : " + h +" / " + w);

            String orientation = piece.getOrientation();

            if (i==1) {

                System.out.println("Rotation vers la gauche / Orientation avant : " + orientation);

                //Rotation de la modélisation
                piece.rotateLeft();

                //Rotation de l'image
                switch (orientation){
                    case "Ouest" :
                        //Sud - 270
                        image = rotate(h, w, image, 270);
                        break;
                    case "Sud" :
                        //Est - 180
                        image = rotate(h, w, image, 180);
                        break;
                    case "Est" :
                        //Nord - 90
                        image = rotate(h, w, image, 90);
                        break;
                }

            }

            if (i==2) {

                System.out.println("Rotation vers la droite / Orientation avant : " + orientation);
                piece.rotateRight();

                switch (orientation){
                    case "Ouest" :
                        //Nord - 90
                        image = rotate(h, w, image, 90);
                        break;
                    case "Nord" :
                        //Est - 180
                        image = rotate(h, w, image, 180);
                        break;
                    case "Est" :
                        //Sud - 270
                        image = rotate(h, w, image, 270);
                        break;
                }

            }

            ImageIcon icon = new ImageIcon(image);
            modelGeneral.overviewButton.setIcon(icon);

            System.out.println("Orientation après : " + piece.getOrientation());

        }
        else
        {
            System.out.println("Aucune pièce sélectionnée");
        }

    }

    public BufferedImage rotate(int h, int w, BufferedImage imageOrigine, int angle) {
        BufferedImage rotateImage = null;
        try {
            rotateImage = new BufferedImage(h, w, BufferedImage.TYPE_INT_RGB);
            AffineTransform a90 = AffineTransform.getRotateInstance(Math.toRadians(angle), h / 2, w / 2);
            AffineTransformOp op90 = new AffineTransformOp(a90, AffineTransformOp.TYPE_BILINEAR);
            op90.filter(imageOrigine, rotateImage);
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return rotateImage;
    }



    public void setControlPlateau(ControlPlateau controlPlateauToSet){
        controlPlateau= controlPlateauToSet;
    }




}