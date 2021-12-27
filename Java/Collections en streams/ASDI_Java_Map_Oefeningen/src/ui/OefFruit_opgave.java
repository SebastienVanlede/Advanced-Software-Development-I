package ui;

import java.util.*;

class CollectionOperaties {
    
    //methode verwijderOpLetter
    //-------------------------

    //methode verwijderSequence
    //-------------------------
	
	//uitbreiding opgave Fruit   addOrdered
	//-------------------------------------
}

public class OefFruit_opgave {

    public static void main(String args[]) {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
        {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
        {"peche", "lichi", "kriek", "kers", "papaya"}};

        List<String> list;
        String mand[];

//Voeg de verschillende kisten samen in een ArrayList list.
//--------------------------------------------------------


        CollectionOperaties.verwijderOpLetter(list, 'p');
        System.out.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        System.out.println("na verwijder sequence (kiwi) : " + list + "\n");

//Plaats het resultaat terug in een array mand en sorteer die oplopend.
//---------------------------------------------------------------------


//Geef de inhoud van de array "mand" terug
//----------------------------------------


    }
}
