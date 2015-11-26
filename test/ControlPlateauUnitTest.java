import Model.Case_m;
import Model.Joueur_m;
import Model.Piece_m;
import Model.Plateau_m;
import Controler.ControlPlateau;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jehan on 26/11/2015.
 */
public class ControlPlateauUnitTest {

    @Test
    public void verifCaseTest(){
        Plateau_m plateau = new Plateau_m();
        ControlPlateau controlPlateau = new ControlPlateau(plateau);
        plateau.getCase(0,0).setCouleur("Red");
        Assert.assertFalse(controlPlateau.verifCase(0,0));
        Assert.assertFalse(controlPlateau.verifCase(-1,20));
        Assert.assertFalse(controlPlateau.verifCase(20,20));
        Assert.assertTrue(controlPlateau.verifCase(19,19));
    }

    @Test
    public void selectionPieceJoueurActifTest(){
        Joueur_m j1 = new Joueur_m("Red","j1");
        Joueur_m j2 = new Joueur_m("Yellow","j2");
        Joueur_m j3 = new Joueur_m("Blue","j3");
        Joueur_m j4 = new Joueur_m("Green","j4");

        j1.setTourDeJeu(true);
        j1.getInventaire().selectPiece(1);
        Piece_m p1 = j1.getInventaire().selectPieceActive();

        Assert.assertEquals(p1, j1.getInventaire().getPiece(1));
        Assert.assertFalse(p1 == j1.getInventaire().getPiece(2));
    }

    @Test
    public void getOrientationPieceSelectioneeTest(){
        Joueur_m j1 = new Joueur_m("Red","j1");

        j1.getInventaire().selectPiece(1);
        Piece_m p1 = j1.getInventaire().selectPieceActive();
        Assert.assertEquals(p1.getOrientation(),"Ouest");
        p1.rotateLeft();
        Assert.assertEquals(p1.getOrientation(),"Sud");
    }

    @Test
    public void positionnementTest(){
        Joueur_m j1 = new Joueur_m("Red","j1");
        Plateau_m plateau = new Plateau_m();
        ControlPlateau plateau_c = new ControlPlateau(plateau);
        j1.getInventaire().selectPiece(18);
        Piece_m p1 = j1.getInventaire().selectPieceActive();
        Assert.assertEquals(p1.getOrientation(),"Ouest");
        p1.rotateRight();
        Assert.assertEquals(p1.getOrientation(),"Nord");

        switch(p1.getOrientation()){
            case "Ouest":
                plateau_c.positionnementOuest(10,10,p1);
                break;
            case "Sud":
                plateau_c.positionnementSud(10,10,p1);
                break;
            case "Est":
                plateau_c.positionnementEst(10,10,p1);
                break;
            case "Nord":
                plateau_c.positionnementNord(10,10,p1);
                break;
        }

        for(int i = 0; i < plateau.getTaillePlateau(); i++){
            for(int j = 0; j < plateau.getTaillePlateau(); j++){
                if (plateau.getCase(i,j).getCouleur().equals( "Red")){
                    System.out.print("1");
                }
                else
                    System.out.print("0");
            }
            System.out.println("");
        }

        /*Assert.assertEquals("White",plateau.getCase(9,9).getCouleur());
        Assert.assertEquals("Red",plateau.getCase(9,10).getCouleur());
        Assert.assertEquals("White",plateau.getCase(9,11).getCouleur());
        Assert.assertEquals("White",plateau.getCase(10,9).getCouleur());
        Assert.assertEquals("Red",plateau.getCase(10,10).getCouleur());
        Assert.assertEquals("Red",plateau.getCase(10,11).getCouleur());
        Assert.assertEquals("White",plateau.getCase(11,9).getCouleur());
        Assert.assertEquals("Red",plateau.getCase(11,10).getCouleur());
        Assert.assertEquals("White",plateau.getCase(11,11).getCouleur());*/
    }
}
