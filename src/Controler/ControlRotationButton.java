package Controler;

import Model.Case_m;
import Model.General_m;
import Model.Piece_m;
import Model.Plateau_m;
import Vue.BoutonsControleJeu_v;

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
    BoutonsControleJeu_v vue;
    int i;

    Plateau_m modelPlateau;

    public ControlRotationButton(General_m modelGeneral, BoutonsControleJeu_v vue, int i){
        this.modelGeneral = modelGeneral;
        this.modelPlateau = modelGeneral.getModelPlateau();
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

            //Rotation de la pièce
            //récupérer l'orientation d'origine ->

            //Récupérer la position de la pièce
            int i = piece.getPositionI();
            int j = piece.getPositionJ();

            System.out.println("Coordonnées de la pièce : " + i + ";" + j);

            //Enlever la prévisualisation
            switch (orientation){
                case "Ouest" :
                    decolorPreviewOuest(i, j, piece);
                    break;
                case "Est" :
                    decolorPreviewEst(i, j, piece);
                    break;
                case "Sud" :
                    decolorPreviewSud(i, j, piece);
                    break;
                case "Nord" :
                    decolorPreviewNord(i, j, piece);
                    break;
            }


            //Récupérer la nouvelle orientation
            orientation = piece.getOrientation();

            //Mettre la prévisualisation
            switch (orientation){
                case "Ouest" :
                    colorPreviewOuest(i, j, piece);
                    break;
                case "Est" :
                    colorPreviewEst(i, j, piece);
                    break;
                case "Sud" :
                    colorPreviewSud(i, j, piece);
                    break;
                case "Nord" :
                    colorPreviewNord(i, j, piece);
                    break;
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


    public void colorPreviewOuest(int a, int b, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a+k, b+l)) {
                //On passe le contenu du bouton à vrai
                modelPlateau.tabButton[a+k][b+l].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a+k][b+l].setIcon(previewImage);
            }
        }
    }

    public void decolorPreviewOuest(int a, int b, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a+k, b+l)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a+k][b+l].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a+k, b+l).getCouleur()=="White")
                {
                    modelPlateau.tabButton[a+k][b+l].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewEst(int a, int b, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a - k, b - l)) {
                //On passe le contenu du bouton à vrai
                modelPlateau.tabButton[a - k][b - l].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a - k][b - l].setIcon(previewImage);
            }
        }
    }

    public void decolorPreviewEst(int a, int b, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a - k, b - l)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a- k][b - l].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a - k, b - l).getCouleur()=="White")
                {
                    modelPlateau.tabButton[a - k][b - l].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewSud(int a, int b, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a-l,b+k)) {
                //On passe le contenu du bouton à vrai
                modelPlateau.tabButton[a-l][b+k].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a-l][b+k].setIcon(previewImage);
            }
        }
    }

    public void decolorPreviewSud(int a, int b, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a-l,b+k)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a-l][b+k].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a-l,b+k).getCouleur()=="White")
                {
                    modelPlateau.tabButton[a-l][b+k].setContentAreaFilled(false);
                }
            }
        }
    }

    public void colorPreviewNord(int a, int b, Piece_m piece){

        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a+l,b-k)) {
                //On passe le contenu du bouton à vrai
                modelPlateau.tabButton[a+l][b-k].setContentAreaFilled(true);
                //On set l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a+l][b-k].setIcon(previewImage);
            }
        }
    }

    public void decolorPreviewNord(int a, int b, Piece_m piece)
    {
        for(Case_m caseIt : piece.getListeCase()) {
            //Récupère la position de la case dans la pièce
            int k = caseIt.getPosI();
            int l = caseIt.getPosJ();

            //On vérifie si la case est sur le plateau
            if (verifInGrid(a+l,b-k)) {

                //On enlève l'image de prévisualisation sur le bouton
                modelPlateau.tabButton[a+l][b-k].setIcon(null);
                //On passe le contenu du bouton à faux si il n'y a pas de case posée
                if (modelPlateau.getCase(a+l,b-k).getCouleur()=="White")
                {
                    modelPlateau.tabButton[a+l][b-k].setContentAreaFilled(false);
                }
            }
        }
    }

    public boolean verifInGrid(int i, int j)
    {
        if(i>=0 && i<20 && j>=0 && j<20){
            return true ;
        }
        return false;
    }
}