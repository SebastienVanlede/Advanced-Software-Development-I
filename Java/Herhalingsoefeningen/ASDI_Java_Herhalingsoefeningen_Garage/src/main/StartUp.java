package main;

import domein.DomeinController;
import ui.ConsoleApplicatie;

public class StartUp {

    public static void main(String args[]) {
        new StartUp().run();
    }

    private void run() {
        new ConsoleApplicatie(new DomeinController()).run();
    }

}
