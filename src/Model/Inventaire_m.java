package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Inventaire_m {
    String couleur;
    String image;

    Piece_m piece1;
    Piece_m piece2;
    Piece_m piece3;
    Piece_m piece4;
    Piece_m piece5;
    Piece_m piece6;
    Piece_m piece7;
    Piece_m piece8;
    Piece_m piece9;
    Piece_m piece10;
    Piece_m piece11;
    Piece_m piece12;
    Piece_m piece13;
    Piece_m piece14;
    Piece_m piece15;
    Piece_m piece16;
    Piece_m piece17;
    Piece_m piece18;
    Piece_m piece19;
    Piece_m piece20;
    Piece_m piece21;

    List<Piece_m> listePiece = new ArrayList<>();

    public JButton[] tabButtonInventaire;

    public Inventaire_m(String couleur) {
        this.couleur = couleur;

        //Déclaration des cases
        //Si le chiffre est précédé de m, c'est une représentation d'un chiffre négatif
        Case_m case00 = new Case_m(couleur, 0, 0);
        Case_m case01 = new Case_m(couleur, 0, 1);
        Case_m case02 = new Case_m(couleur, 0, 2);
        Case_m case03 = new Case_m(couleur, 0, 3);
        Case_m case10 = new Case_m(couleur, 1, 0);
        Case_m case11 = new Case_m(couleur, 1, 1);
        Case_m case20 = new Case_m(couleur, 2, 0);
        Case_m casem10 = new Case_m(couleur, -1, 0);
        Case_m casem20 = new Case_m(couleur, -2, 0);
        Case_m case0m1 = new Case_m(couleur, 0, -1);
        Case_m case1m1 = new Case_m(couleur, 0, -1);
        Case_m case0m2 = new Case_m(couleur, 0, -2);
        Case_m casem11 = new Case_m(couleur, -1, 1);

        //Piece 1
        List<Case_m> caseL = new ArrayList<>();
        caseL.add(case00);
        image = "images/" + couleur + "/piece" + 1 + ".png";
        piece1 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece1);
        caseL.clear();

        //Piece 2
        caseL.add(case00);
        caseL.add(case01);
        image = "images/" + couleur + "/piece" + 2 + ".png";
        piece2 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece2);
        caseL.clear();

        //Piece 3
        caseL.add(case00);
        caseL.add(case0m1);
        caseL.add(case10);
        image = "images/" + couleur + "/piece" + 3 + ".png";
        piece3 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece3);
        caseL.clear();

        //Piece 4
        caseL.add(case00);
        caseL.add(case0m1);
        caseL.add(case01);
        image = "images/" + couleur + "/piece" + 4 + ".png";
        piece4 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece4);
        caseL.clear();

        //Piece 5
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case11);
        caseL.add(case10);
        image = "images/" + couleur + "/piece" + 5 + ".png";
        piece5 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece5);
        caseL.clear();

        //Piece 6
        caseL.add(case00);
        caseL.add(case0m1);
        caseL.add(case01);
        caseL.add(casem10);
        image = "images/" + couleur + "/piece" + 6 + ".png";
        piece6 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece6);
        caseL.clear();

        //Piece 7
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case02);
        caseL.add(case03);
        image = "images/" + couleur + "/piece" + 7 + ".png";
        piece7 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece7);
        caseL.clear();

        //Piece 8
        caseL.add(case00);
        caseL.add(case0m1);
        caseL.add(case0m2);
        caseL.add(casem10);
        image = "images/" + couleur + "/piece" + 8 + ".png";
        piece8 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece8);
        caseL.clear();

        //Piece 9
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case10);
        caseL.add(case1m1);
        image = "images/" + couleur + "/piece" + 9 + ".png";
        piece9 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece9);
        caseL.clear();

        //Piece 10
        caseL.add(case00);
        caseL.add(casem10);
        caseL.add(case01);
        caseL.add(case02);
        caseL.add(case03);
        image = "images/" + couleur + "/piece" + 10 + ".png";
        piece10 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece10);
        caseL.clear();

        //Piece 11
        caseL.add(case00);
        caseL.add(case0m1);
        caseL.add(case01);
        caseL.add(casem10);
        caseL.add(casem20);
        image = "images/" + couleur + "/piece" + 11 + ".png";
        piece11 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece11);
        caseL.clear();


        //Piece 12
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case02);
        caseL.add(casem10);
        caseL.add(casem20);
        image = "images/" + couleur + "/piece" + 12 + ".png";
        piece12 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece12);
        caseL.clear();

        //Piece 13
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case02);
        caseL.add(case10);
        caseL.add(case1m1);
        image = "images/" + couleur + "/piece" + 13 + ".png";
        piece13 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece13);
        caseL.clear();


        //Piece 14
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case0m1);
        caseL.add(case1m1);
        caseL.add(casem11);
        image = "images/" + couleur + "/piece" + 14 + ".png";
        piece14 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece14);
        caseL.clear();

        //Piece 15
        caseL.add(case00);
        caseL.add(casem10);
        caseL.add(casem20);
        caseL.add(case10);
        caseL.add(case20);
        image = "images/" + couleur + "/piece" + 15 + ".png";
        piece15 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece15);
        caseL.clear();

        //Piece 16
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(casem10);
        caseL.add(casem20);
        caseL.add(casem11);
        image = "images/" + couleur + "/piece" + 16 + ".png";
        piece16 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece16);
        caseL.clear();

        //Piece 17
        caseL.add(case00);
        caseL.add(casem10);
        caseL.add(casem11);
        caseL.add(case0m1);
        caseL.add(case1m1);
        image = "images/" + couleur + "/piece" + 17 + ".png";
        piece17 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece17);
        caseL.clear();

        //Piece 18
        caseL.add(case00);
        caseL.add(case10);
        caseL.add(case11);
        caseL.add(casem10);
        caseL.add(casem11);
        image = "images/" + couleur + "/piece" + 18 + ".png";
        piece18 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece18);
        caseL.clear();

        //Piece 19
        caseL.add(case00);
        caseL.add(case10);
        caseL.add(case0m1);
        caseL.add(casem10);
        caseL.add(casem11);
        image = "images/" + couleur + "/piece" + 19 + ".png";
        piece19 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece19);
        caseL.clear();

        //Piece 20
        caseL.add(case00);
        caseL.add(case0m1);
        caseL.add(case01);
        caseL.add(casem10);
        caseL.add(case10);
        image = "images/" + couleur + "/piece" + 20 + ".png";
        piece20 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece20);
        caseL.clear();

        //Piece 21
        caseL.add(case00);
        caseL.add(case0m1);
        caseL.add(case01);
        caseL.add(case02);
        caseL.add(casem10);
        image = "images/" + couleur + "/piece" + 21 + ".png";
        piece21 = new Piece_m(caseL, "Ouest", image);
        listePiece.add(piece21);
        caseL.clear();

    }

    public void selectPiece(int index){
        for(int i = 0; i< listePiece.size(); i++){
            listePiece.get(i).setPieceSelection(false);
        }
        listePiece.get(index).setPieceSelection(true);
    }
    public Piece_m selectPieceActive(){
        for(int i = 0; i< listePiece.size(); i++){
            if(listePiece.get(i).isSelected()){
                return listePiece.get(i);
            }
        }
        return null;
    }


    //Getters
    public Piece_m getPiece(int index) {
        return listePiece.get(index);
    }

    public List<Piece_m> getListPiece() {
        return listePiece;
    }

    public void setPieceToNull(Piece_m piece)
    {
        piece=null;
    }

    //Setters
    //TODO
}
