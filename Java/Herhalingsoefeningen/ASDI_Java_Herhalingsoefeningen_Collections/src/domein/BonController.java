package domein;

import java.time.LocalDate;
import java.util.List;

public class BonController {
    private ReductiebonBeheerder reductiebonBeheerder;

    public BonController() {
        reductiebonBeheerder = new ReductiebonBeheerder();
    }

    public void init() {
        //versie A dient te werken
//        reductiebonBeheerder.storeBon(new Reductiebon("kerstbon", 50, LocalDate.of(2021, 12, 10)));
//        reductiebonBeheerder.storeBon(new Actiebon("Kerstdagen", "kerst", 15, LocalDate.of(2021, 12, 31)));


        //versie B dient te werken
//        List<Reductiebon> bonnen = List.of(new Reductiebon("kerstbon", 50, LocalDate.of(2021, 12, 10)),
//                new Actiebon("Kerstdagen", "kerst", 15, LocalDate.of(2021, 12, 31)));
//        reductiebonBeheerder.addReeks(bonnen);


        //versie C dient te werken

        List<Actiebon> bonnen = List.of(new Actiebon("Paasdagen", "paas", 50, LocalDate.of(2022, 4, 1)),
                new Actiebon("Kerstdagen", "kerst", 15, LocalDate.of(2021, 12, 31)));
        reductiebonBeheerder.addReeks(bonnen);


        Reductiebon bon = reductiebonBeheerder.retrieveBon();
        System.out.println(bon);
        Reductiebon bon2 = reductiebonBeheerder.retrieveBon();
        System.out.println(bon2);
    }
}
