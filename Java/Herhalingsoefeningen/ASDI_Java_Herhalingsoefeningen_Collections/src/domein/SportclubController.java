package domein;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SportclubController {

    private SporterBeheerder sporterBeheerder;

    public SportclubController() {
        sporterBeheerder = new SporterBeheerder();
    }

    public String geefSportersMetEvenveelReductiebonnen(int sporterLidNr) {
        Sporter sporter = sporterBeheerder.geefSporter(sporterLidNr);
        if (sporter == null) {
            return "ongekend lidnummer";
        }
        List<Sporter> sporters = sporterBeheerder.geefSportersMetEvenveelReductieBonnen(sporter);
        if (sporters.isEmpty()) {
            return "geen sporters met gelijk aantal kortingsbonnen";
        }
        return sporters.stream().map(Sporter::getNaam)
                .collect(Collectors.joining("-"));
    }

    public String geefSportersPerLidnr() {
        return sporterBeheerder.geefSportersPerLidnr();
    }

    public String geefSportersPerAantalReductiebonnen() {
        return sporterBeheerder.geefSportersPerAantalReductiebonnen();
    }

    public <T extends Comparable<T>> String geefGesorteerdeCollectie(Collection<T> collectie) {
        return collectie.stream().sorted().map(T::toString).collect(Collectors.joining("\n"));
    }

    public String geefSporters() {
        return geefGesorteerdeCollectie(sporterBeheerder.getSportersLijst());
    }
}
