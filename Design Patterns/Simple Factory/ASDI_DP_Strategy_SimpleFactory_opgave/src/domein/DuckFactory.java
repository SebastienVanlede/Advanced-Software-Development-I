package domein;

public class DuckFactory {

    public Duck createDuck(DuckSpecies specie) {
        return switch (specie) {
            case REDHEAD -> new RedheadDuck(new Quack(), new FlyWithWings());
            case MALLARD -> new MallardDuck(new Quack(), new FlyWithWings());
            case RUBBER -> new RubberDuck(new Squeak(), new FlyNoWay());
            case DECOY -> new DecoyDuck(new MuteQuack(), new FlyNoWay());

        };
    }
}
