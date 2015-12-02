import Model.General_m;
import Model.Joueur_m;
import Model.Plateau_m;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mathieu on 13/11/2015.
 */
public class PlateauUnitTest {
    @Test
    public void testGenererPlateau(){
        General_m modelGeneral = new General_m();
        Plateau_m plateau = new Plateau_m(modelGeneral);

        Assert.assertEquals(plateau.getTaillePlateau(),20);
        Assert.assertEquals(plateau.getCase(0,0).getCouleur(), "White");
        plateau.getCase(19,19).setCouleur("Red");
        Assert.assertEquals(plateau.getCase(19,19).getCouleur(), "Red");

    }

    @Test
    public void getJoueurTest(){
        General_m modelGeneral = new General_m();
        Plateau_m plateau = new Plateau_m(modelGeneral);
        modelGeneral.selectJoueur(1);
        Joueur_m joueur = modelGeneral.getJoueur(1);
        Assert.assertEquals(joueur, modelGeneral.selectJoueurActif());

    }
}