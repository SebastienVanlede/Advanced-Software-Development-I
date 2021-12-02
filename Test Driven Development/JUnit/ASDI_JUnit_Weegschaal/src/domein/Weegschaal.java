package domein;

import java.math.BigInteger;

public class Weegschaal {

    private BigInteger gewicht = BigInteger.ZERO;

    public BigInteger getGewicht() {
        return this.gewicht;
    }

    public void vermeerder(BigInteger nieuwGewicht) {
        if (nieuwGewicht == null || nieuwGewicht.signum() < 0)
            throw new IllegalArgumentException("ongeldige waarde");
        gewicht = gewicht.add(nieuwGewicht);
    }

}