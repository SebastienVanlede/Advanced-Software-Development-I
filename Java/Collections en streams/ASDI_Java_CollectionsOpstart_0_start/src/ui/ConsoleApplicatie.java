package ui;

import domein.SportclubController;

public class ConsoleApplicatie {
	private SportclubController sportClubController;

	public ConsoleApplicatie(SportclubController sportClubController) {
		this.sportClubController = sportClubController;
		start();
	}

	private void start() {
		
//TODO uncomment OEF GENERICS
//		System.out.println("\nOverzicht sporters per lidnummer:\n" + sportClubController.geefSportersPerLidnr());
//		System.out.println("\nOverzicht sporters per aantal reductiebonnen\n"
//				+ sportClubController.geefSportersPerAantalReductiebonnen());
//		System.out.println("\nOverzicht sporters:\n" + sportClubController.geefSporters());
	}

}
