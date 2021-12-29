package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super("Veggie Pizza", "Crust", "Marinara sauce",
                new ArrayList<>(Arrays.asList(new String[]{
            "Shredded mozzarella",
            "Grated parmesan",
            "Diced onion",
            "Sliced mushrooms",
            "Sliced red pepper",
            "Sliced black olives"})));
    }

}
