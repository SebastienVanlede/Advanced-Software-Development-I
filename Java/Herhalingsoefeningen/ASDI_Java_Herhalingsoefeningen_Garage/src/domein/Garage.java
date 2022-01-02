package domein;

import persistentie.PersistentieController;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Garage {

    private final File auto;
    private final File onderhoud;
    private Map<String, Auto> autoMap;
    private Map<String, List<Onderhoud>> autoOnderhoudMap;
    private List<Set<Auto>> overzichtLijstVanAutos;

    private final int AANTAL_OVERZICHTEN = 3;
    private int overzichtteller;

    public Garage(String bestandAuto, String bestandOnderhoud) {
        auto = new File(bestandAuto);
        onderhoud = new File(bestandOnderhoud);
        initGarage();
    }

    private void initGarage() {
        PersistentieController persistentieController = new PersistentieController(auto, onderhoud);

        //Set<Auto> inlezen - stap1
        Set<Auto> autoSet = new HashSet<>(persistentieController.geefAutos());
        autoSet.forEach(System.out::println);
        System.out.println("STAP 1");

        // Maak map van auto's: volgens nummerplaat - stap2
        autoMap = omzettenNaarAutoMap(autoSet);
        autoMap.forEach((key, value) -> System.out.printf("%s %s%n", key, value));
        System.out.println("STAP 2");

        // Onderhoud inlezen - stap3
        List<Onderhoud> onderhoudLijst = persistentieController.geefOnderhoudVanAutos();
        System.out.println("STAP 3 : ONDERHOUDLIJST" + onderhoudLijst);

        // lijst sorteren - stap4
        sorteren(onderhoudLijst);
        onderhoudLijst.forEach(System.out::println);
        System.out.println("STAP 4");

        // lijst samenvoegen - stap5
        aangrenzendePeriodenSamenvoegen(onderhoudLijst);
        onderhoudLijst.forEach(System.out::println);
        System.out.println("STAP 5");

        // Maak map van onderhoud: volgens nummerplaat - stap6
        autoOnderhoudMap = omzettenNaarOnderhoudMap(onderhoudLijst);
        autoOnderhoudMap.forEach((key, value) -> System.out.printf("%s %s%n", key, value));
        System.out.println("STAP 6");

        // Maak overzicht: set van auto's - stap7
        overzichtLijstVanAutos = maakOverzicht(autoOnderhoudMap);
        overzichtLijstVanAutos.forEach(System.out::println);
        System.out.println("STAP 7");
    }

    // Maak map van auto's: volgens nummerplaat - stap2
    private Map<String, Auto> omzettenNaarAutoMap(Set<Auto> autoSet) {
        return autoSet.stream().collect(Collectors.toMap(Auto::getNummerplaat, Function.identity()));
    }

    // lijst sorteren - stap4
    private void sorteren(List<Onderhoud> lijstOnderhoud) {
        lijstOnderhoud.sort(Comparator.comparing(Onderhoud::getNummerplaat).thenComparing(Onderhoud::getBegindatum));
    }

    // lijst samenvoegen - stap5
    private void aangrenzendePeriodenSamenvoegen(List<Onderhoud> lijstOnderhoud) {
        Iterator<Onderhoud> iterator = lijstOnderhoud.iterator();
        Onderhoud onderhoud = null;
        Onderhoud onderhoudNext = null;
        while (iterator.hasNext()) {
            onderhoud = onderhoudNext;
            onderhoudNext = iterator.next();
            if (onderhoud != null && onderhoud.getNummerplaat().equals(onderhoudNext.getNummerplaat())) {
                if (onderhoud.getEinddatum().plusDays(1).equals(onderhoudNext.getBegindatum())) {
                    onderhoud.setEinddatum(onderhoudNext.getEinddatum());
                    iterator.remove();
                    onderhoudNext = onderhoud;
                }
            }
        }
    }

    // Maak map van onderhoud: volgens nummerplaat - stap6
    private Map<String, List<Onderhoud>>
    omzettenNaarOnderhoudMap(List<Onderhoud> onderhoudLijst) {
        return onderhoudLijst.stream().collect(Collectors.groupingBy(Onderhoud::getNummerplaat));
    }

    //Hulpmethode - nodig voor stap 7        
    private int sizeToCategorie(int size) {
        return switch (size) {
            case 0, 1 -> 0;
            case 2, 3 -> 1;
            default -> 2;
        };
    }

    // Maak overzicht: set van auto's - stap7
    private List<Set<Auto>> maakOverzicht(Map<String, List<Onderhoud>> autoOnderhoudMap) {
        return autoOnderhoudMap.entrySet().stream().collect(Collectors.groupingBy(entry ->
                        sizeToCategorie(entry.getValue().size()),
                TreeMap::new,
                Collectors.mapping(entry -> autoMap.get(entry.getKey()), Collectors.toSet()))).values().stream().collect(Collectors.toList());
    }

    //Oefening DomeinController:
    public String autoMap_ToString() {
        return autoMap.values().stream().sorted(Comparator.comparing(Auto::getNummerplaat)).map(Auto::toString).collect(Collectors.joining("\n"));
    }

    public String autoOnderhoudMap_ToString() {
        return autoOnderhoudMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).map(e -> String.format("%s:%n%s", e.getKey(), e.getValue()
                        .stream().map(Onderhoud::toString).collect(Collectors.joining("\n")))).collect(Collectors.joining("\n"));

    }

    public String overzicht_ToString() {
        overzichtteller = 1;
        return overzichtLijstVanAutos.stream().map(setAuto -> String.format("%d%n%s", overzichtteller++, setAuto.stream()
                .map(Auto::toString).collect(Collectors.joining("\n")))).collect(Collectors.joining("\n"));
    }

}
