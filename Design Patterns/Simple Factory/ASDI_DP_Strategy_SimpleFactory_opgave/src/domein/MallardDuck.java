package domein;

public class MallardDuck extends Duck {

//    public MallardDuck() {
//        setQuackBehavior(new Quack());
//        setFlyBehavior(new FlyWithWings());
//    }


    public MallardDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }


    @Override
    public String display() {
        return "Ik ben een echte wilde eend";
    }

}
