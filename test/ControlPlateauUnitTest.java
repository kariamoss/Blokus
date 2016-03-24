import Controler.ControlAbandonner;
import Controler.ControlPlateau;
import Model.General_m;
import Model.Joueur_m;
import Model.Piece_m;
import Model.Plateau_m;
import Vue.General_v;
import org.junit.Assert;
import org.junit.Test;


public class ControlPlateauUnitTest {

    @Test
    public void verifCaseTest(){
        General_m modelGeneral = new General_m();
        /*General_v vueGeneral = new General_v(modelGeneral);
        modelGeneral.selectJoueur(1);
        Joueur_m j1 = modelGeneral.selectJoueurActif();
        Plateau_m plateau = new Plateau_m(modelGeneral);
        ControlPlateau controlPlateau = new ControlPlateau(modelGeneral,vueGeneral);
        plateau.getCase(0,0).setCouleur("Red");
        Assert.assertFalse(controlPlateau.verifCase(0,0));
        Assert.assertFalse(controlPlateau.verifCase(-1,20));
        Assert.assertFalse(controlPlateau.verifCase(20,20));
        Assert.assertTrue(controlPlateau.verifCase(19,19));*/
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
        General_m modelGeneral = new General_m();
        modelGeneral.selectJoueur(1);
        /*General_v vueGeneral = new General_v(modelGeneral);
        Joueur_m j1 = modelGeneral.selectJoueurActif();
        Plateau_m plateau = new Plateau_m(modelGeneral);
        ControlPlateau plateau_c = new ControlPlateau(modelGeneral,vueGeneral);
        j1.getInventaire().selectPiece(18);
        Piece_m p1 = j1.getInventaire().selectPieceActive();
        Assert.assertEquals(p1.getOrientation(),"Ouest");
        p1.rotateRight();
        Assert.assertEquals(p1.getOrientation(),"Nord");

        plateau_c.positionnement(10,10,p1);

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

    @Test
    public void joueurSuivantTest()
    {
        General_m modelGeneral = new General_m();

        modelGeneral.selectJoueur(0);



        System.out.println("Joueur 0 : "+modelGeneral.selectJoueurActif().getNom());
        Assert.assertEquals(modelGeneral.selectJoueurActif(), modelGeneral.getJoueur(0));

        modelGeneral.joueurSuivant();
        Assert.assertEquals(modelGeneral.selectJoueurActif(), modelGeneral.getJoueur(1));
        System.out.println("Joueur 1 : "+modelGeneral.selectJoueurActif().getNom());

        modelGeneral.joueurSuivant();
        System.out.println("Joueur 2 : "+modelGeneral.selectJoueurActif().getNom());

        modelGeneral.joueurSuivant();
        System.out.println("Joueur 3 : "+modelGeneral.selectJoueurActif().getNom());

        modelGeneral.joueurSuivant();
        System.out.println("Joueur 0 : "+modelGeneral.selectJoueurActif().getNom());

    }

    @Test
    public void augmenteScoreJoueurTest()
    {
        General_m modelGeneral = new General_m();
        modelGeneral.selectJoueur(0);

        Joueur_m joueur = modelGeneral.selectJoueurActif();

        Assert.assertEquals(joueur.getScore(), 0);
        joueur.setScore(modelGeneral.selectJoueurActif().getScore()+joueur.getInventaire().getPiece(5).getListeCase().size());
        Assert.assertEquals(joueur.getScore(), 4);
        joueur.setScore(modelGeneral.selectJoueurActif().getScore()+joueur.getInventaire().getPiece(19).getListeCase().size());
        Assert.assertEquals(joueur.getScore(), 9);

    }
}
