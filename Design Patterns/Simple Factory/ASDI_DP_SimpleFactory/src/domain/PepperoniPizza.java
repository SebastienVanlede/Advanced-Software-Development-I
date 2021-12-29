package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class PepperoniPizza extends Pizza {

    public PepperoniPizza() {
        super("Pepperoni Pizza", "Crust", "Marinara sauce",
                new ArrayList<>(Arrays.asList(new String[]{
            "Sliced Pepperoni",
            "Sliced Onion",
            "Grated parmesan cheese"})));
    }

}
