package domein;

import repository.ReductiebonDao;
import repository.ReductiebonDaoJpa;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReductiebonBeheerder {

    private ReductiebonDao reductiebonDao;
    private List<Reductiebon> reductiebonLijst;

    public ReductiebonBeheerder() {
        reductiebonDao = new ReductiebonDaoJpa();
        reductiebonLijst = reductiebonDao.findAll();
    }

    public List<Reductiebon> getReductiebonLijst() {
        return reductiebonLijst;
    }

    // VRAAG1
    public List<String> geefReductiebonCodes(int percentage) {
        return reductiebonLijst.stream().filter(str -> str.getPercentage() > percentage).map(Reductiebon::getReductiebonCode).collect(Collectors.toList());
    }

    // VRAAG2
    public void sorteerReductiebonnen() {
        reductiebonLijst.sort(Comparator.comparing(Reductiebon::getPercentage).thenComparing(Comparator.comparing(Reductiebon::getReductiebonCode).reversed()));
    }

    // VRAAG3
    public double geefGemPercVanBonnenInToekomst() {
        double gem = reductiebonLijst.stream().filter(bon -> bon.getEinddatum().isAfter(LocalDate.now())).mapToDouble(Reductiebon::getPercentage).average().getAsDouble();
        return gem;
    }

    // VRAAG4
    public List<LocalDate> geefUniekeEinddatums() {
        return reductiebonLijst.stream().map(Reductiebon::getEinddatum).distinct().sorted().collect(Collectors.toList());
    }

}
