package domein;

public class LandStatistiek {
    private final String landCode;
    private final double verhouding;

    LandStatistiek(String landCode, double verhouding){
        this.landCode = landCode;
        this.verhouding = verhouding;
    }

    public String getLandCode(){
        return landCode;
    }

    public double getVerhouding(){
        return verhouding;
    }
}
