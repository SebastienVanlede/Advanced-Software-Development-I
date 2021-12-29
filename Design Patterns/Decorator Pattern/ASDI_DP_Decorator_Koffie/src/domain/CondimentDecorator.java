package domain;

public abstract class CondimentDecorator extends Beverage {

    private final Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    protected Beverage getBeverage() {
        return beverage;
    }

    @Override
    public abstract String getDescription();

}
