package main;

import domein.Geweer;
import domein.Held;
import domein.Mes;

public class main {
    public static void main(String[] args) {
        new main().run();
    }

    private void run() {
        Held held = new Held();
        held.valAan();
        held.setWapen(new Geweer());
        held.valAan();
        held.setWapen(new Mes());
        held.valAan();
    }
}
