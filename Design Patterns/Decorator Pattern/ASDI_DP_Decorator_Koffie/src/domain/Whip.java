package domain;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .10 + getBeverage().cost();
    }
}
