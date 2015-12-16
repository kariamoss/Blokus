package Controler;

import Helper.Helper_Preview;
import Model.General_m;
import Model.Piece_m;
import Model.Plateau_m;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
    ImageIcon previewImage = new ImageIcon(new ImageIcon("images/preview.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT ));

    General_m modelGeneral;
    Plateau_m modelPlateau;
    int i;
    Helper_Preview helper_preview;

    public ControlRotationButton(General_m modelGeneral, int i){
        this.modelGeneral = modelGeneral;
        this.modelPlateau = modelGeneral.getModelPlateau();
        this.i=i;
        helper_preview = new Helper_Preview(modelGeneral);
    }

    public void actionPerformed(ActionEvent f) {

        Piece_m piece = modelGeneral.selectJoueurActif().getInventaire().selectPieceActive();
        if (piece!=null)
        {

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

            //Redimensionnement à 110*110 (coéficient de 0.85 par rapport à l'image d'origine
            double scale = 0.85;
            AffineTransform tx = new AffineTransform();
            tx.scale(scale, scale);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage biNew = new BufferedImage((int)(w*scale), (int)(h*scale), image.getType());
            image = op.filter(image, biNew);

            String orientation = piece.getOrientation();

            if (i==1) {

                System.out.println("Rotation vers la gauche / Orientation avant : " + orientation);

                //Rotation de la modélisation
                piece.rotateLeft();

                //Rotation de l'image
                switch (orientation){
                    case "Ouest" :
                        //Sud - 270
                        image = rotate(image, 270);
                        break;
                    case "Sud" :
                        //Est - 180
                        image = rotate(image, 180);
                        break;
                    case "Est" :
                        //Nord - 90
                        image = rotate(image, 90);
                        break;
                }

            }

            if (i==2) {

                System.out.println("Rotation vers la droite / Orientation avant : " + orientation);
                piece.rotateRight();

                switch (orientation){
                    case "Ouest" :
                        //Nord - 90
                        image = rotate(image, 90);
                        break;
                    case "Nord" :
                        //Est - 180
                        image = rotate(image, 180);
                        break;
                    case "Est" :
                        //Sud - 270
                        image = rotate(image, 270);
                        break;
                }

            }

            //Rotation de la pièce
            //récupérer l'orientation d'origine ->

            //Récupérer la position de la pièce
            int i = piece.getPositionI();
            int j = piece.getPositionJ();

            System.out.println("Coordonnées de la pièce : " + i + ";" + j);

            if (i!=-1 && j!=-1)
            {
                //Enlever la prévisualisation
                switch (orientation){
                    case "Ouest" :
                        helper_preview.decolorPreviewOuest(i, j, piece);
                        break;
                    case "Est" :
                        helper_preview.decolorPreviewEst(i, j, piece);
                        break;
                    case "Sud" :
                        helper_preview.decolorPreviewSud(i, j, piece);
                        break;
                    case "Nord" :
                        helper_preview.decolorPreviewNord(i, j, piece);
                        break;
                }


                //Récupérer la nouvelle orientation
                orientation = piece.getOrientation();

                //Mettre la prévisualisation
                switch (orientation){
                    case "Ouest" :
                        helper_preview.colorPreviewOuest(i, j, piece);
                        break;
                    case "Est" :
                        helper_preview.colorPreviewEst(i, j, piece);
                        break;
                    case "Sud" :
                        helper_preview.colorPreviewSud(i, j, piece);
                        break;
                    case "Nord" :
                        helper_preview.colorPreviewNord(i, j, piece);
                        break;
                }
            }



            ImageIcon icon = new ImageIcon(image);
            modelGeneral.overviewButton.setIcon(icon);

            System.out.println("Orientation après : " + orientation);

        }
        else
        {
            System.out.println("Aucune pièce sélectionnée");
        }

    }

    public BufferedImage rotate(BufferedImage originalImg, int angle) {
        BufferedImage rotateImage = null;
        try {
            rotateImage = new BufferedImage(originalImg.getWidth(), originalImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
            AffineTransform a90 = AffineTransform.getRotateInstance(Math.toRadians(angle),originalImg.getWidth() / 2
                    , originalImg.getHeight() / 2);
            AffineTransformOp op90 = new AffineTransformOp(a90, AffineTransformOp.TYPE_BILINEAR);
            op90.filter(originalImg, rotateImage);
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return rotateImage;
    }
}