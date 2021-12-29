package domein;

public class Quack implements QuackBehavior {

    @Override
    public String quack() {
        return "Ik kwaak";
    }
}
