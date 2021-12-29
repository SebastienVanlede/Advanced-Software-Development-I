package domein;

import persistentie.PersistentieController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BierWinkel {

    private final List<Bier> bieren;
    private PersistentieController pc = new PersistentieController();

    public BierWinkel() {
        bieren = pc.inlezenBieren("bieren.txt");
    }

    public Map<String, Bier> opzettenOverzichtBierPerNaam() {
        return bieren.stream().collect(Collectors.toMap(Bier::getNaam, Function.identity()));
    }


    public Map<String, List<Bier>> opzettenOverzichtBierenPerSoort() {
        return bieren.stream().collect(Collectors.groupingBy(Bier::getSoort, TreeMap::new, Collectors.toList()));
    }

    public Map<String, Long> opzettenAantalBierenPerSoort() {
        return bieren.stream().collect(Collectors.groupingBy(Bier::getSoort, TreeMap::new, Collectors.counting()));
    }

}
