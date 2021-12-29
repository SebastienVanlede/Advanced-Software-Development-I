import domain.*;

public class StarbuzzCoffee {

    public static void main(String... args) {
        Beverage beverage = new Espresso();
        System.out.printf("%s $ %s\n", beverage.getDescription(), beverage.cost());

        Beverage beverage2 = new Whip(new Mocha(new Mocha(new DarkRoast())));
        System.out.printf("%s $ %s\n", beverage2.getDescription(), beverage2.cost());

        Beverage beverage3 = new Whip(new Mocha(new Soy(new HouseBlend())));
        System.out.printf("%s $ %s\n", beverage3.getDescription(), beverage3.cost());
    }
}