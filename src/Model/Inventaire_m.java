package Model;

import java.util.ArrayList;
import java.util.List;

public class Inventaire_m
{
    String couleur;
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
        List<Case_m> caseL = new ArrayList<>();
        caseL.add(case00);
        piece1 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 2
        caseL.add(case00);
        caseL.add(case01);
        piece2 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 3
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case11);
        piece3 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 4
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case02);
        piece4 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 5

        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case11);
        caseL.add(case10);
        piece5 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 6
        caseL.add(case01);
        caseL.add(case10);
        caseL.add(case11);
        caseL.add(case12);
        piece6 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 7
        caseL.add(case03);
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case02);
        piece7 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 8
        caseL.add(case12);
        caseL.add(case02);
        caseL.add(case11);
        caseL.add(case10);
        piece8 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 9
        caseL.add(case01);
        caseL.add(case11);
        caseL.add(case10);
        caseL.add(case02);
        piece9 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 10
        caseL.add(case13);
        caseL.add(case12);
        caseL.add(case11);
        caseL.add(case10);
        caseL.add(case00);
        piece10 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 11
        caseL.add(case22);
        caseL.add(case20);
        caseL.add(case21);
        caseL.add(case01);
        caseL.add(case11);
        piece11 = new Piece_m(caseL, "Ouest");
        caseL.clear();


        //CaseL 12
        caseL.add(case20);
        caseL.add(case21);
        caseL.add(case22);
        caseL.add(case00);
        caseL.add(case10);
        piece12 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 13
        caseL.add(case10);
        caseL.add(case11);
        caseL.add(case01);
        caseL.add(case02);
        caseL.add(case03);
        piece13 = new Piece_m(caseL, "Ouest");
        caseL.clear();


        //CaseL 14
        caseL.add(case10);
        caseL.add(case20);
        caseL.add(case11);
        caseL.add(case12);
        caseL.add(case02);
        piece14 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 15
        caseL.add(case00);
        caseL.add(case10);
        caseL.add(case20);
        caseL.add(case30);
        caseL.add(case40);
        piece15 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 16
        caseL.add(case00);
        caseL.add(case10);
        caseL.add(case20);
        caseL.add(case11);
        caseL.add(case21);
        piece16 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //caseL 17
        caseL.add(case11);
        caseL.add(case10);
        caseL.add(case20);
        caseL.add(case01);
        caseL.add(case02);
        piece17 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 18
        caseL.add(case00);
        caseL.add(case01);
        caseL.add(case10);
        caseL.add(case20);
        caseL.add(case21);
        piece18 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 19
        caseL.add(case10);
        caseL.add(case01);
        caseL.add(case11);
        caseL.add(case02);
        caseL.add(case21);
        piece19 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 20
        caseL.add(case01);
        caseL.add(case11);
        caseL.add(case21);
        caseL.add(case10);
        caseL.add(case12);
        piece20 = new Piece_m(caseL, "Ouest");
        caseL.clear();

        //CaseL 21
        caseL.add(case01);
        caseL.add(case10);
        caseL.add(case11);
        caseL.add(case12);
        caseL.add(case13);
        piece21 = new Piece_m(caseL, "Ouest");
        caseL.clear();

    }

    public Piece_m getPiece1() {
        return piece1;
    }

    public void setPiece1(Piece_m piece1) {
        this.piece1 = piece1;
    }

    public Piece_m getPiece2() {
        return piece2;
    }

    public void setPiece2(Piece_m piece2) {
        this.piece2 = piece2;
    }

    public Piece_m getPiece3() {
        return piece3;
    }

    public void setPiece3(Piece_m piece3) {
        this.piece3 = piece3;
    }

    public Piece_m getPiece4() {
        return piece4;
    }

    public void setPiece4(Piece_m piece4) {
        this.piece4 = piece4;
    }

    public Piece_m getPiece5() {
        return piece5;
    }

    public void setPiece5(Piece_m piece5) {
        this.piece5 = piece5;
    }

    public Piece_m getPiece6() {
        return piece6;
    }

    public void setPiece6(Piece_m piece6) {
        this.piece6 = piece6;
    }

    public Piece_m getPiece7() {
        return piece7;
    }

    public void setPiece7(Piece_m piece7) {
        this.piece7 = piece7;
    }

    public Piece_m getPiece8() {
        return piece8;
    }

    public void setPiece8(Piece_m piece8) {
        this.piece8 = piece8;
    }

    public Piece_m getPiece9() {
        return piece9;
    }

    public void setPiece9(Piece_m piece9) {
        this.piece9 = piece9;
    }

    public Piece_m getPiece10() {
        return piece10;
    }

    public void setPiece10(Piece_m piece10) {
        this.piece10 = piece10;
    }

    public Piece_m getPiece11() {
        return piece11;
    }

    public void setPiece11(Piece_m piece11) {
        this.piece11 = piece11;
    }

    public Piece_m getPiece12() {
        return piece12;
    }

    public void setPiece12(Piece_m piece12) {
        this.piece12 = piece12;
    }

    public Piece_m getPiece13() {
        return piece13;
    }

    public void setPiece13(Piece_m piece13) {
        this.piece13 = piece13;
    }

    public Piece_m getPiece14() {
        return piece14;
    }

    public void setPiece14(Piece_m piece14) {
        this.piece14 = piece14;
    }

    public Piece_m getPiece15() {
        return piece15;
    }

    public void setPiece15(Piece_m piece15) {
        this.piece15 = piece15;
    }

    public Piece_m getPiece16() {
        return piece16;
    }

    public void setPiece16(Piece_m piece16) {
        this.piece16 = piece16;
    }

    public Piece_m getPiece17() {
        return piece17;
    }

    public void setPiece17(Piece_m piece17) {
        this.piece17 = piece17;
    }

    public Piece_m getPiece18() {
        return piece18;
    }

    public void setPiece18(Piece_m piece18) {
        this.piece18 = piece18;
    }

    public Piece_m getPiece19() {
        return piece19;
    }

    public void setPiece19(Piece_m piece19) {
        this.piece19 = piece19;
    }

    public Piece_m getPiece20() {
        return piece20;
    }

    public void setPiece20(Piece_m piece20) {
        this.piece20 = piece20;
    }

    public Piece_m getPiece21() {
        return piece21;
    }

    public void setPiece21(Piece_m piece21) {
        this.piece21 = piece21;
    }
}
