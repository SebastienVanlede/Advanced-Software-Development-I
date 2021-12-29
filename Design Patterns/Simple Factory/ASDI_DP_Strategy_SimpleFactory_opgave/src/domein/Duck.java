package domein;

public abstract class Duck {

    private QuackBehavior quackBehavior;

    private FlyBehavior flyBehavior;

    public Duck(QuackBehavior quack, FlyBehavior fly){
        setQuackBehavior(quack);
        setFlyBehavior(fly);
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public String performQuack() {
        return quackBehavior.quack();
    }

    public String performFly() {
        return flyBehavior.fly();
    }

    public String swim() {
        return ("Alle eenden drijven, ook lokeenden");
    }

    public abstract String display();

    public void ANDERE_eend_achtige_methoden() {
    }

}
