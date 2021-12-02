package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domein.Reductiebon;
import domein.Sporter;;

public class SporterDaoJpa implements SporterDao {

	@Override
	public List<Sporter> findAll() {
		 List<Sporter> sporters = new ArrayList<>();

		 sporters.add(new Sporter(1, "Joe", "Blondeel", "joe@gmail.com"));
		 sporters.add(new Sporter(2, "Kristof", "Roose", "kristof@gmail.com"));
		 sporters.add(new Sporter(3, "Ann", "Vanderstene", "stene@hogent.be"));
		 sporters.add(new Sporter(4, "Christel", "Hereman", "christel@gmail.com"));
		 sporters.add(new Sporter(5, "Emiel", "Beulens", "emiel@hogent.be"));
		 sporters.add(new Sporter(6, "Ilias", "Keters", "ilias@gmail.com"));
		 
		 sporters.get(0).voegReductieBonToe(new Reductiebon("R31", 10, LocalDate.of(2021, 11, 30)));
		 sporters.get(0).voegReductieBonToe(new Reductiebon("R311", 60, LocalDate.of(2022, 5, 10)));
		 
		 sporters.get(1).voegReductieBonToe(new Reductiebon("R32", 30, LocalDate.now()));
		 sporters.get(1).voegReductieBonToe(new Reductiebon("R322", 40, LocalDate.now()));
		 
		 sporters.get(3).voegReductieBonToe(new Reductiebon("R34", 10, LocalDate.of(2023, 1, 1)));
		 
		 sporters.get(5).voegReductieBonToe(new Reductiebon("R36", 10, LocalDate.of(2022, 4, 1)));

	     return sporters;
	}
}
