package testen;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domein.Weegschaal;


public class WeegschaalTest {
    @Test
    public void gewichtVermeerderen(){
        BigInteger gewicht = new BigInteger("15");
        Weegschaal weegschaal = new Weegschaal();
        weegschaal.vermeerder(gewicht);
        Assertions.assertEquals(gewicht, weegschaal.getGewicht());
    }

    @Test
    public void nieuweWeegschaalGewichtNul(){
        Weegschaal weegschaal = new Weegschaal();
        Assertions.assertEquals(BigInteger.ZERO, weegschaal.getGewicht());
    }

}
