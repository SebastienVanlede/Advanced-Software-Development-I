package domein;

public class FlyNoWay implements FlyBehavior {

    @Override
    public String fly() {
        return "Ik kan niet vliegen";
    }
}
