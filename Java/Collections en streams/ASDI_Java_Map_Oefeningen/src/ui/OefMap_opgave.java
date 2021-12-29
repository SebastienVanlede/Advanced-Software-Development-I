package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Auteur {

    private String naam, voornaam;

    public Auteur(String naam, String voornaam) {
        setNaam(naam);
        setVoornaam(voornaam);
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    @Override
    public String toString() {
        return String.format("%s %s", naam, voornaam);
    }
}

public class OefMap_opgave {

    public OefMap_opgave() {

// we zullen een hashmap gebruiken waarbij auteursid de sleutel is en
// de waarde is naam en voornaam van Auteur.
        //Cre�er de lege hashMap "auteurs"; de sleutel is van type Integer, de waarde van type Auteur
        //----------------------------------------------------------------------------------
        Map<Integer, Auteur> auteurs = new HashMap<>();

        //Voeg toe aan de hashmap: auteursID = 9876, naam = Gosling, voornaam = James
        //Voeg toe aan de hashmap: auteursID = 5648, naam = Chapman, voornaam = Steve
        //-------------------------------------------------------------------------------
        auteurs.put(9876, new Auteur("Gosling", "James"));
        auteurs.put(5648, new Auteur("Chapman", "Steve"));

        //Wijzig de voornaam van Chapman: John ipv Steve
        //----------------------------------------------
        auteurs.get(5648).setVoornaam("John");

        //Komt de auteursID 1234 voor in de hashmap
        //-----------------------------------------
        if (auteurs.containsKey(1234))
            System.out.println("auteursID 1234 komt voor\n");
        else
            System.out.println("auteursID 1234 komt niet voor\n");
        //Toon de naam en voornaam van auteursID 5648
        //-------------------------------------------
        Auteur auteur = auteurs.get(5648);
        if (auteur != null)
            System.out.println(auteur);
        toonAlleAuteurs(auteurs);

        //Alle auteursID's worden in stijgende volgorde weergegeven.
        //  1) de hashMap copi�ren naar een treeMap (= 1 instructie)
        //  2) roep de methode toonAlleSleutels op.
        //  3) roep de methode toonAlleAuteurs op.
        //---------------------------------------------------------------
        Map<Integer, Auteur> treeMap = new TreeMap<>(auteurs);
        toonAlleSleutels(treeMap);
        System.out.println("Alle auteurs");
        toonAlleAuteurs(treeMap);

    }

    public void toonAlleSleutels(Map<Integer, Auteur> map) {
        //Alle sleutels van de map worden op het scherm weergegeven.
        //---------------------------------------------------------------
        System.out.println(map.keySet());
        System.out.println();
    }

    public void toonAlleAuteurs(Map<Integer, Auteur> map) {
        /*Alle gegevens van de map worden op het scherm weergegeven.
		Per lijn wordt een auteursnr, naam en voornaam weergegeven.*/
        //---------------------------------------------------------------
        map.forEach((key, value) -> System.out.printf("%s %s%n", key, value));

        System.out.println();
    }

    public static void main(String args[]) {
        new OefMap_opgave();
    }
}
