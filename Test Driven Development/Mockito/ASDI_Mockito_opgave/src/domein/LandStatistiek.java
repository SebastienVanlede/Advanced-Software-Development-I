package domein;

public class LandStatistiek {

    private String landCode;
    private double verhouding;

    LandStatistiek(String landCode, double verhouding) {
        this.landCode = landCode;
        this.verhouding = verhouding;
    }

    public String getLandCode() {
        return landCode;
    }

    public double getVerhouding() {
        return verhouding;
    }
}
