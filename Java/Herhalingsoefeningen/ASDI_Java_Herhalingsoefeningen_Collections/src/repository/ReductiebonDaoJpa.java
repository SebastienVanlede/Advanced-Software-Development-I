package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domein.Reductiebon;

public class ReductiebonDaoJpa implements ReductiebonDao {

	@Override
	public List<Reductiebon> findAll() {
		List<Reductiebon> reductiebonnen = new ArrayList<>();

		reductiebonnen.add(new Reductiebon("R10", 20, LocalDate.of(2021, 5, 15)));
		reductiebonnen.add(new Reductiebon("R11", 35, LocalDate.of(2021, 10, 26)));
		reductiebonnen.add(new Reductiebon("R12", 50, LocalDate.of(2021, 9, 20)));
		reductiebonnen.add(new Reductiebon("R13", 35, LocalDate.of(2021, 10, 26)));
		reductiebonnen.add(new Reductiebon("R14", 5, LocalDate.of(2021, 6, 1)));
		reductiebonnen.add(new Reductiebon("R15", 20, LocalDate.of(2021, 9, 20)));

		return reductiebonnen;
	}

}
