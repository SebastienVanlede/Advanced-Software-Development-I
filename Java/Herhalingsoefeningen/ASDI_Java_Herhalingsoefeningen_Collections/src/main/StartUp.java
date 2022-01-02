package main;

import domein.BonController;
import domein.SportclubController;
import ui.ConsoleApplicatie;

public class StartUp {
    public static void main(String[] args) {
        new ConsoleApplicatie(new SportclubController());
        BonController bc = new BonController();
        bc.init();
    }

}
