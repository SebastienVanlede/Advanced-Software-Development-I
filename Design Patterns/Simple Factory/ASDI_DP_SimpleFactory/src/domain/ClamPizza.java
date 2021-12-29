package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class ClamPizza extends Pizza {

    public ClamPizza() {
        super("Clam Pizza", "Thin crust", "White garlic sauce",
                new ArrayList<>(Arrays.asList(new String[]{
            "Clams",
            "Grated parmesan cheese"})));
    }

}
