package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class CollectionOperaties {

    //methode verwijderOpLetter
    //-------------------------
    public static boolean verwijderOpLetter(List<String> list, char letter) {
        return list.removeIf(el -> el.startsWith(String.valueOf(letter)));
    }

    //methode verwijderSequence
    //-------------------------
    public static boolean verwijderSequence(List<String> list, String s) {
        int first = list.indexOf(s);
        if (first < 0)
            return false;
        int last = list.lastIndexOf(s);
        list.subList(first, last + 1).clear();
        return true;
    }

    //uitbreiding opgave Fruit addOrdered
    //-------------------------------------
    public static boolean addOrdered(List<String> list, String s) {
        int index = Collections.binarySearch(list, s);
        if (index >= 0) {
            list.add(index * -1 - 1, s);
            return false;
        } else return true;
    }
}

public class OefFruit_opgave {

    public static void main(String args[]) {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
                {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
                {"peche", "lichi", "kriek", "kers", "papaya"}};

        List<String> list = new ArrayList<>();
        String mand[];

        //Voeg de verschillende kisten samen in een ArrayList list.
        //--------------------------------------------------------
        list = Arrays.stream(kist).flatMap(Arrays::stream).collect(Collectors.toList());


        CollectionOperaties.verwijderOpLetter(list, 'p');
        System.out.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        System.out.println("na verwijder sequence (kiwi) : " + list + "\n");

        CollectionOperaties.addOrdered(list, "sapodilla");
        System.out.printf("na toevoegen sapodilla: %s%n", list);

        //Plaats het resultaat terug in een array mand en sorteer die oplopend.
        //---------------------------------------------------------------------
        mand = list.toArray(new String[0]);
        Arrays.sort(mand);


        //Geef de inhoud van de array "mand" terug
        //----------------------------------------
        System.out.println(mand);


    }
}
