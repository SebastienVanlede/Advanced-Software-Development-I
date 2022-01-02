package ui;

import domein.DomeinController;
import domein.KoopjesService;

public class ConsoleApplicatie {
    private final DomeinController domeinController;

    public ConsoleApplicatie(DomeinController dc) {
       domeinController=dc;
       new KoopjesService().start();
    }

    public void run() {
        System.out.printf("autoMap\n%s\n", domeinController.autoMap_ToString());
        System.out.printf("autoOnderhoudMap\n%s\n", domeinController.autoOnderhoudMap_ToString());
        System.out.printf("overzicht\n%s\n", domeinController.overzicht_ToString());
    }
    
}
