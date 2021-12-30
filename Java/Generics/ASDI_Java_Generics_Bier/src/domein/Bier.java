package domein;

import java.io.Serializable;

public class Bier implements Serializable {

    private String bierNaam;
    private double alcohol;

    public Bier(String bierNaam, double alcohol) {
        this.bierNaam = bierNaam;
        this.alcohol = alcohol;
    }

    public String getBierNaam() {
        return bierNaam;
    }

    public void setBierNaam(String bierNaam) {
        this.bierNaam = bierNaam;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

}
