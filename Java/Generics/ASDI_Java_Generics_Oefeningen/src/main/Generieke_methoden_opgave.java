package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Generieke_methoden_opgave {

    public static void main(String args[]) {
        new Generieke_methoden_opgave();
    }

    public Generieke_methoden_opgave() {
        Double[] decGetallen = {3.0, 7.8, 9.0, 10.6};
        List<Double> doubleLijst = new ArrayList<>(Arrays.asList(decGetallen));

        Integer[] integer = {5, 8, 9, -6, 0, 7};
        List<Integer> integerLijst = new ArrayList<>(Arrays.asList(integer));

        String[] woorden = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "a"};
        List<String> stringLijst = new ArrayList<>(Arrays.asList(woorden));

//methode minimum oproepen
        Integer minGetal1 = minimum(integerLijst);
        Double minGetal2 = minimum(doubleLijst);

        System.out.printf("%s%d\n\n", "oplossing is -6, jouw oplossing = ", minGetal1);
        System.out.printf("%s%.1f\n\n", "oplossing is 3.0, jouw oplossing = ", minGetal2);

//methode geefAlleElementenKleinerDan oproepen
        List<Integer> lijstInteger = geefAlleElementenKleinerDan(integerLijst, 8);
        List<String> lijstString = geefAlleElementenKleinerDan(stringLijst, "ddd");

        weergevenLijst("oplossing : 5 -6 0 7", lijstInteger);
        weergevenLijst("oplossing : aaa bbb ccc a", lijstString);

    }

    public <E> void weergevenLijst(String oplossing, Collection<E> lijst) {

        System.out.printf("%s\n%s", oplossing, "            ");
        lijst.forEach(element -> System.out.printf("%s ", element));
        System.out.println("\n");
    }

    //------------------------------------------------------------------------
    //Schrijf de generieke methode "minimum" die het kleinste getal van een Collection
    //van type E teruggeeft.
    //------------------------------------------------------------------------
    public <E extends Comparable<E>> E minimum(Collection<E> lijst) {
        return lijst.stream().min(E::compareTo).get();
    }

    //-------------------------------------------------------------------------------------
    //Schrijf de generieke methode geefAlleElementenKleinerDan
    //De methode heeft twee argumenten: een Collection van type E "lijst" en een element van type E "grens"
    //De methode geeft een arrayList van type E terug; alle elementen van "lijst" die kleiner
    //zijn dan "grens" worden in de arrayList bewaard.
    //-------------------------------------------------------------------------------------
    public <E extends Comparable<E>> List<E> geefAlleElementenKleinerDan(Collection<E> lijst, E grens) {
        return lijst.stream().filter(e -> e.compareTo(grens) < 0).collect(Collectors.toList());
    }
}
