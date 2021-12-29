package domein;

public class MuteQuack implements QuackBehavior {

    @Override
    public String quack() {
        return "<<Stilte>>";
    }
}
