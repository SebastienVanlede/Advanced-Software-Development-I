package domein;

import repository.SporterDao;
import repository.SporterDaoJpa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SporterBeheerder {

    private SporterDao sporterDao;
    private Collection<Sporter> sportersLijst;


    private Map<Integer, Sporter> sportersPerLidnummer;
    private Map<Integer, List<Sporter>> sportersPerAantalReductieBonnen;

    public SporterBeheerder() {
        sporterDao = new SporterDaoJpa();
        sportersLijst = sporterDao.findAll();
        maakOverzichten();
    }

    public Collection<Sporter> getSportersLijst() {
        return Collections.unmodifiableCollection(sportersLijst);
    }

    public void maakOverzichten() {
        //Collectors.toMap count van stream == size map
        //Collectors.groupingby		count van stream <= size map ==> elementen worden gegroepeerd
        sportersPerLidnummer = sportersLijst.stream().collect(Collectors.toMap(Sporter::getLidNr, Function.identity()));
        sportersPerAantalReductieBonnen = sportersLijst.stream()
                .collect(Collectors.groupingBy(sporter -> sporter.getReductiebonLijst().size()));
        //groupby enkel keymapper ==> Map<K, List<element> > als HashMap
    }

    public Sporter geefSporter(int sporterLidnr) {
        return sportersPerLidnummer.get(sporterLidnr);
    }

    public List<Sporter> geefSportersMetEvenveelReductieBonnen(Sporter sporter) {
        return sportersPerAantalReductieBonnen.get(sporter.getReductiebonLijst().size());
    }

    // VRAAG 6
    public Sporter geefEenSporterMetGegevenReductiebon(Reductiebon bon) {
        return sportersLijst.stream().filter(sporter -> sporter.getReductiebonLijst().contains(bon)).findAny()
                .orElse(null);
    }

    // EXTRA vraag1
    public List<Reductiebon> geefAlleReductiebonnenMetKortingsPercentageX(List<Integer> kortingspercentage) {
        return sportersLijst.stream().map(Sporter::getReductiebonLijst).flatMap(Collection::stream)
                .filter(bon -> kortingspercentage.contains(bon.getPercentage())).collect(Collectors.toList());
    }

    // EXTRA vraag2
    public void verwijderAlleSportersMetReductiebonMetPercX(int perc) {
        sportersLijst.removeIf(
                s -> s.getReductiebonLijst().stream().filter(bon -> bon.getPercentage() == perc).count() != 0);
    }

    public String geefSportersPerLidnr() {
        return geefAlleSleutelswaarden(sportersPerLidnummer);
    }

    public String geefSportersPerAantalReductiebonnen() {
        return geefAlleSleutelswaarden(sportersPerAantalReductieBonnen);
    }

    public <K, V> String geefAlleSleutelswaarden(Map<K, V> eenMap) {
        Map<K, V> gesorteerdeMap = new TreeMap<>();
        return gesorteerdeMap.entrySet()
                .stream()
                .map(entry -> String.format("%s: %s%n", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

}
