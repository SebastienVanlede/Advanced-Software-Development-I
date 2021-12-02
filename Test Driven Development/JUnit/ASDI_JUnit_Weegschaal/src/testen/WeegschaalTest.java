package testen;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Weegschaal;

class WeegschaalTest {

    private Weegschaal weegschaal;

    @BeforeEach
    public void before() {
        weegschaal = new Weegschaal();
    }


    @Test
    public void gewichtVermeerderen() {
        BigInteger gewicht = new BigInteger("15");
        Weegschaal weegschaal = new Weegschaal();
        weegschaal.vermeerder(gewicht);
        Assertions.assertEquals(gewicht, weegschaal.getGewicht());
    }

    @Test
    public void nieuweWeegschaalGeeftGewichtNul() {
        Weegschaal weegschaal = new Weegschaal();
        Assertions.assertEquals(BigInteger.ZERO, weegschaal.getGewicht());
    }


    @Test
    public void gewichtVermeerderenMetNegatieveWaarde() {
        BigInteger gewicht = new BigInteger("-20");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                weegschaal.vermeerder(gewicht));
    }

    @Test
    public void gewichtVermeerderenMetNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            weegschaal.vermeerder(null);
        });
    }






}