package main;

import domein.SportclubController;
import ui.ConsoleApplicatie;

public class StartUp {
	public static void main(String[] args) {
		new ConsoleApplicatie(new SportclubController());
	}

}
