package main;

import domein.DomeinController;

public class GenericPersistApp {

    public static void main(String arg[]) {
        new DomeinController().persisteerBierGegevensAlsObject("bieren.txt","bierenListObj.dat");
    }

}