import Model.Plateau_m;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mathieu on 13/11/2015.
 */
public class PlateauUnitTest {
    @Test
    public void testGenererPlateau(){
        Plateau_m plateau = new Plateau_m();

        Assert.assertEquals(plateau.getTaillePlateau(),20);
        Assert.assertEquals(plateau.getCase(0,0).getCouleur(), "White");
        plateau.getCase(19,19).setCouleur("Red");
        Assert.assertEquals(plateau.getCase(19,19).getCouleur(), "Red");


    }
}