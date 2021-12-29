package domein;

public class RedheadDuck extends Duck {

//    public RedheadDuck() {
//        setQuackBehavior(new Quack());
//        setFlyBehavior(new FlyWithWings());
//    }


    public RedheadDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }


    @Override
    public String display() {
        return "Ik lijk op een roodkuifeend";
    }

}
