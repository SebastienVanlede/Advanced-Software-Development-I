package testen;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Reductiebon;
import domein.ReductiebonBeheerder;

class ReductiebonBeheerderTest {

	private ReductiebonBeheerder reductiebonBeheerder;

	@BeforeEach
	void before() {
		reductiebonBeheerder = new ReductiebonBeheerder();
	}

	@Test
	public void testVraag1() {
		List<String> reductiebonCodes = reductiebonBeheerder.geefReductiebonCodes(20);
		Assertions.assertEquals(3, reductiebonCodes.size());
		String[] verwachteResultaat = { "R11", "R12", "R13" };
		for (int i = 0; i < verwachteResultaat.length; i++)
			Assertions.assertEquals(verwachteResultaat[i], reductiebonCodes.get(i));

	}

	@Test
	public void testVraag2() {
		reductiebonBeheerder.sorteerReductiebonnen();
		List<Reductiebon> reductiebonnen = reductiebonBeheerder.getReductiebonLijst();
		Assertions.assertEquals(6, reductiebonnen.size());
		String[] verwachteResultaat = { "R14", "R15", "R10", "R13", "R11", "R12" };
		for (int i = 0; i < verwachteResultaat.length; i++)
			Assertions.assertEquals(verwachteResultaat[i], reductiebonnen.get(i).getReductiebonCode());
	}

	@Test
	public void testVraag3() {
		double gem = reductiebonBeheerder.geefGemPercVanBonnenInToekomst();
		Assertions.assertEquals(35, gem, 0.0);
	}

	@Test
	public void testVraag4() {
		List<LocalDate> lijstDatums = reductiebonBeheerder.geefUniekeEinddatums();
		Assertions.assertEquals(4, lijstDatums.size());
		LocalDate[] verwachteResultaat = { LocalDate.of(2021, 5, 15), LocalDate.of(2021, 6, 1),
				LocalDate.of(2021, 9, 20), LocalDate.of(2021, 10, 26) };
		for (int i = 0; i < verwachteResultaat.length; i++)
			Assertions.assertEquals(verwachteResultaat[i], lijstDatums.get(i));
	}
}
