package Model;

import java.util.ArrayList;
import java.util.List;

public class Inventaire_m
{
    String couleur;
    List<Case_m> piece1= new ArrayList<>();
    List<Case_m> piece2= new ArrayList<>();
    List<Case_m> piece3= new ArrayList<>();
    List<Case_m> piece4= new ArrayList<>();
    List<Case_m> piece5= new ArrayList<>();
    List<Case_m> piece6= new ArrayList<>();
    List<Case_m> piece7= new ArrayList<>();
    List<Case_m> piece8= new ArrayList<>();
    List<Case_m> piece9= new ArrayList<>();
    List<Case_m> piece10= new ArrayList<>();
    List<Case_m> piece11= new ArrayList<>();
    List<Case_m> piece12= new ArrayList<>();
    List<Case_m> piece13= new ArrayList<>();
    List<Case_m> piece14= new ArrayList<>();
    List<Case_m> piece15= new ArrayList<>();
    List<Case_m> piece16= new ArrayList<>();
    List<Case_m> piece17= new ArrayList<>();
    List<Case_m> piece18= new ArrayList<>();
    List<Case_m> piece19= new ArrayList<>();
    List<Case_m> piece20= new ArrayList<>();
    List<Case_m> piece21= new ArrayList<>();

    public Inventaire_m(String couleur)
    {
        this.couleur=couleur;

        //Déclaration des cases
        Case_m case00= new Case_m(couleur,0,0);
        Case_m case01= new Case_m(couleur,0,1);
        Case_m case02= new Case_m(couleur,0,2);
        Case_m case03= new Case_m(couleur,0,3);
        Case_m case10= new Case_m(couleur,1,0);
        Case_m case11= new Case_m(couleur,1,1);
        Case_m case12= new Case_m(couleur,1,2 );
        Case_m case13= new Case_m(couleur,1,3 );
        Case_m case20= new Case_m(couleur,2,0 );
        Case_m case21= new Case_m(couleur,2,1 );
        Case_m case22= new Case_m(couleur,2,2 );
        Case_m case30= new Case_m(couleur,3,0 );
        Case_m case40= new Case_m(couleur,4,0 );

        //Piece 1
        piece1.add(case00);

        //Piece 2
        piece2.add(case00);
        piece2.add(case01);

        //Piece 3
        piece3.add(case00);
        piece3.add(case01);
        piece3.add(case11);

        //Piece 4
        piece4.add(case00);
        piece4.add(case01);
        piece4.add(case02);

        //Piece 5

        piece5.add(case00);
        piece5.add(case01);
        piece5.add(case11);
        piece5.add(case10);

        //Piece 6
        piece6.add(case01);
        piece6.add(case10);
        piece6.add(case11);
        piece6.add(case12);

        //Piece 7
        piece7.add(case03);
        piece7.add(case00);
        piece7.add(case01);
        piece7.add(case02);

        //Piece 8
        piece8.add(case12);
        piece8.add(case02);
        piece8.add(case11);
        piece8.add(case10);

        //Piece 9
        piece9.add(case01);
        piece9.add(case11);
        piece9.add(case10);
        piece9.add(case02);

        //Piece 10
        piece10.add(case13);
        piece10.add(case12);
        piece10.add(case11);
        piece10.add(case10);
        piece10.add(case00);

        //Piece 11
        piece11.add(case22);
        piece11.add(case20);
        piece11.add(case21);
        piece11.add(case01);
        piece11.add(case11);


        //Piece 12
        piece12.add(case20);
        piece12.add(case21);
        piece12.add(case22);
        piece12.add(case00);
        piece12.add(case10);

        //Piece 13
        piece13.add(case10);
        piece13.add(case11);
        piece13.add(case01);
        piece13.add(case02);
        piece13.add(case03);


        //Piece 14
        piece14.add(case10);
        piece14.add(case20);
        piece14.add(case11);
        piece14.add(case12);
        piece14.add(case02);

        //Piece 15
        piece15.add(case00);
        piece15.add(case10);
        piece15.add(case20);
        piece15.add(case30);
        piece15.add(case40);

        //Piece 16
        piece16.add(case00);
        piece16.add(case10);
        piece16.add(case20);
        piece16.add(case11);
        piece16.add(case21);

        //piece 17
        piece17.add(case11);
        piece17.add(case10);
        piece17.add(case20);
        piece17.add(case01);
        piece17.add(case02);

        //Piece 18
        piece18.add(case00);
        piece18.add(case01);
        piece18.add(case10);
        piece18.add(case20);
        piece18.add(case21);

        //Piece 19
        piece19.add(case10);
        piece19.add(case01);
        piece19.add(case11);
        piece19.add(case02);
        piece19.add(case21);

        //Piece 20
        piece20.add(case01);
        piece20.add(case11);
        piece20.add(case21);
        piece20.add(case10);
        piece20.add(case12);

        //Piece 21
        piece21.add(case01);
        piece21.add(case10);
        piece21.add(case11);
        piece21.add(case12);
        piece21.add(case13);
    }

    public List<Case_m> getPiece1() {
        return piece1;
    }

    public void setPiece1(List<Case_m> piece1) {
        this.piece1 = piece1;
    }

    public List<Case_m> getPiece2() {
        return piece2;
    }

    public void setPiece2(List<Case_m> piece2) {
        this.piece2 = piece2;
    }

    public List<Case_m> getPiece3() {
        return piece3;
    }

    public void setPiece3(List<Case_m> piece3) {
        this.piece3 = piece3;
    }

    public List<Case_m> getPiece4() {
        return piece4;
    }

    public void setPiece4(List<Case_m> piece4) {
        this.piece4 = piece4;
    }

    public List<Case_m> getPiece5() {
        return piece5;
    }

    public void setPiece5(List<Case_m> piece5) {
        this.piece5 = piece5;
    }

    public List<Case_m> getPiece6() {
        return piece6;
    }

    public void setPiece6(List<Case_m> piece6) {
        this.piece6 = piece6;
    }

    public List<Case_m> getPiece7() {
        return piece7;
    }

    public void setPiece7(List<Case_m> piece7) {
        this.piece7 = piece7;
    }

    public List<Case_m> getPiece8() {
        return piece8;
    }

    public void setPiece8(List<Case_m> piece8) {
        this.piece8 = piece8;
    }

    public List<Case_m> getPiece9() {
        return piece9;
    }

    public void setPiece9(List<Case_m> piece9) {
        this.piece9 = piece9;
    }

    public List<Case_m> getPiece10() {
        return piece10;
    }

    public void setPiece10(List<Case_m> piece10) {
        this.piece10 = piece10;
    }

    public List<Case_m> getPiece11() {
        return piece11;
    }

    public void setPiece11(List<Case_m> piece11) {
        this.piece11 = piece11;
    }

    public List<Case_m> getPiece12() {
        return piece12;
    }

    public void setPiece12(List<Case_m> piece12) {
        this.piece12 = piece12;
    }

    public List<Case_m> getPiece13() {
        return piece13;
    }

    public void setPiece13(List<Case_m> piece13) {
        this.piece13 = piece13;
    }

    public List<Case_m> getPiece14() {
        return piece14;
    }

    public void setPiece14(List<Case_m> piece14) {
        this.piece14 = piece14;
    }

    public List<Case_m> getPiece15() {
        return piece15;
    }

    public void setPiece15(List<Case_m> piece15) {
        this.piece15 = piece15;
    }

    public List<Case_m> getPiece16() {
        return piece16;
    }

    public void setPiece16(List<Case_m> piece16) {
        this.piece16 = piece16;
    }

    public List<Case_m> getPiece17() {
        return piece17;
    }

    public void setPiece17(List<Case_m> piece17) {
        this.piece17 = piece17;
    }

    public List<Case_m> getPiece18() {
        return piece18;
    }

    public void setPiece18(List<Case_m> piece18) {
        this.piece18 = piece18;
    }

    public List<Case_m> getPiece19() {
        return piece19;
    }

    public void setPiece19(List<Case_m> piece19) {
        this.piece19 = piece19;
    }

    public List<Case_m> getPiece20() {
        return piece20;
    }

    public void setPiece20(List<Case_m> piece20) {
        this.piece20 = piece20;
    }

    public List<Case_m> getPiece21() {
        return piece21;
    }

    public void setPiece21(List<Case_m> piece21) {
        this.piece21 = piece21;
    }
}
