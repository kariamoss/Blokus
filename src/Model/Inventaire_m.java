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

    
}
