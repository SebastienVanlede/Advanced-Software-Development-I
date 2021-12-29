package domein;

public class RubberDuck extends Duck {

//    public RubberDuck() {
//        setQuackBehavior(new Squeak());
//        setFlyBehavior(new FlyNoWay());
//    }


    public RubberDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }


    @Override
    public String display() {
        return "Ik ben een badeend";
    }

}
