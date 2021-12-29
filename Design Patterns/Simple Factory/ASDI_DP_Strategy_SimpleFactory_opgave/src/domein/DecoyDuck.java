package domein;

public class DecoyDuck extends Duck {

//    public DecoyDuck() {
//        setQuackBehavior(new MuteQuack());
//        setFlyBehavior(new FlyNoWay());
//    }

    public DecoyDuck(QuackBehavior quack, FlyBehavior fly){
        super(quack, fly);
    }


    @Override
    public String display() {
        return "Ik ben een lokeend";
    }

}
