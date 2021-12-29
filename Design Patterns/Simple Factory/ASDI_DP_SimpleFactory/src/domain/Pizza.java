package domain;

import java.util.List;

public abstract class Pizza {

    private String name;
    private String dough;
    private String sauce;
    private List<String> toppings;

    public Pizza(String name, String dough, String sauce, List<String> toppings) {
        this.name = name;
        this.dough = dough;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    public String getName() {
        return name;
    }

    public void prepare() {
        System.out.printf("Preparing %s", name);
    }

    public void bake() {
        System.out.printf("Baking %s", name);
    }

    public void cut() {
        System.out.printf("Cutting %s", name);
    }

    public void box() {
        System.out.printf("Boxing %s", name);
    }

    @Override
    public String toString() {
        // code to display pizza name and ingredients
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(name).append(" ----\n");
        display.append(dough).append("\n");
        display.append(sauce).append("\n");
        for (String topping : toppings) {
            display.append(topping).append("\n");
        }
        return display.toString();
    }

}
