package domain;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        setDescription("House Blend Coffee");
    }

    @Override
    public double cost() {
        return .89;
    }
}
