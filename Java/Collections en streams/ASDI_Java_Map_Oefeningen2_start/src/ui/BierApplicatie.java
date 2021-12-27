package ui;

import domein.DomeinController;

public class BierApplicatie {
    private DomeinController domeinController;
   
    public BierApplicatie(DomeinController dc) {
        this.domeinController = dc;
    }
    public void run() {
    	System.out.println(domeinController.opzettenBierPerNaam());
    	System.out.println();
        System.out.println(domeinController.opzettenAantalBierenPerSoort());
    	System.out.println();
        System.out.println(domeinController.opzettenOverzichtBierenPerSoort());
    }
}
