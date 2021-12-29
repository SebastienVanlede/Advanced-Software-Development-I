package domein;

import java.util.stream.Collectors;

public class DomeinController {

    private final BierWinkel bierWinkel;

    public DomeinController() {
        bierWinkel = new BierWinkel();
    }

    public String opzettenBierPerNaam() {
        return bierWinkel.opzettenOverzichtBierPerNaam().entrySet().stream().map(e -> String.format("%s = %s", e.getKey(), e.getValue())).collect(Collectors.joining("\n"));
    }

    public String opzettenAantalBierenPerSoort() {
        return bierWinkel.opzettenAantalBierenPerSoort().entrySet().stream().map(e -> String.format("%s = %s", e.getKey(), e.getValue())).collect(Collectors.joining("\n"));
    }

    public String opzettenOverzichtBierenPerSoort() {
        return bierWinkel.opzettenOverzichtBierenPerSoort().entrySet().stream().map(e -> String.format("%s = %s", e.getKey(), e.getValue())).collect(Collectors.joining("\n"));
    }


    //TODO na hoofdstuk generics 
    //--> generieke oplossing "overzichtToString" methode
    //


}
