package domain;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return .15 + getBeverage().cost();
    }
}
