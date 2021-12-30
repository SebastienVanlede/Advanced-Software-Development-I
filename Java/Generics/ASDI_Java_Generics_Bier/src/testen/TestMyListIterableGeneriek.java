package testen;

import domein.MyListIterable;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMyListIterableGeneriek {

    private MyListIterable<String> woordenLijst;

    @BeforeEach
    public void before() {
        woordenLijst = new MyListIterable<>("woordenlijst");
    }

    @Test
    public void toonLijst() {
        woordenLijst.insertAtFront("lekker");
        woordenLijst.insertAtFront("zijn");
        woordenLijst.insertAtFront("wafels");
        String zin = woordenLijst.toString().replaceAll("\\s+", " ").trim();
        Assertions.assertEquals("The woordenlijst is: wafels zijn lekker", zin);
    }

    @Test
    public void toonLegeLijst() {
        String zin = woordenLijst.toString().replaceAll("\\s+", " ").trim();
        Assertions.assertEquals("woordenlijst is empty", zin);
    }

}
