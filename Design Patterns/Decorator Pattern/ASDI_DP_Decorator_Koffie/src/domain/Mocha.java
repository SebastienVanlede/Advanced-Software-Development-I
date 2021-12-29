package domain;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + getBeverage().cost();
    }
}
