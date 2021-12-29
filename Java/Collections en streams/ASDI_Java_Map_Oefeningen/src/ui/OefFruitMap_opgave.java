package ui;

import java.util.*;
import java.util.stream.Collectors;

public class OefFruitMap_opgave {

    public static void main(String args[]) {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
                {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
                {"peche", "lichi", "kriek", "kers", "papaya"}};

        List<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        List<String> list1 = Arrays.stream(kist).
                flatMap(Arrays::stream).collect(Collectors.toList());


        //declaratie + creatie map
        //------------------------------
        for (String[] k : kist) {
            list.addAll(Arrays.asList(k));
        }

        /*Berg de fruit list van vorige oefeningen in een boom
 op zodat dubbels ge�limineerd worden.
 Er moet ook de mogelijkheid zijn de bijhorende prijs
 (decimale waarde) bij te houden.*/
        //------------------------------------------------------------
        Map<String, Double> fruit = new TreeMap<>();
        list.forEach(el -> fruit.put(el, null));
        /*Doorloop de boom in lexicaal oplopende volgorde en vraag
 telkens de bijhorende prijs, die je mee in de boom opbergt.*/
        //------------------------------------------------------------
        fruit.forEach((k, v) -> {
            System.out.printf("Prijs van %s : ", k);
            double prijs = in.nextDouble();
            fruit.replace(k, prijs);
            //entry.setValue(prijs)
            System.out.println();
        });

        /*Druk vervolgens de volledige lijst in twee
 kolommen (naam : prijs) in lexicaal oplopende volgorde af
 op het scherm.*/
        //------------------------------------------------------------
        System.out.printf("%10s\t%10s\n", "NAAM", "PRIJS");
        fruit.forEach((k, v) -> System.out.printf("%10s\t%10.2f%n", k, v));
    }
}
