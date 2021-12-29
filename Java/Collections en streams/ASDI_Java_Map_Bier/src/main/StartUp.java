package main;

import domein.DomeinController;
import ui.BierApplicatie;

public class StartUp {
	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		new BierApplicatie(dc).run();
	}
}
