package testen;

import domein.Reductiebon;
import domein.Sporter;
import domein.SporterBeheerder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class SporterBeheerderTest {

	private SporterBeheerder sporterBeheerder;

	@BeforeEach
	void before() {
		sporterBeheerder = new SporterBeheerder();
	}

	@Test
	public void testVraag6_sporterBestaat() {
		Reductiebon bon = new Reductiebon("R311", 60, LocalDate.of(2022, 5, 10));
		Sporter sporter = sporterBeheerder.geefEenSporterMetGegevenReductiebon(bon);
		Assertions.assertEquals(1, sporter.getLidNr());
	}

	@Test
	public void testVraag6_sporterBestaatNiet() {
		Reductiebon bon = new Reductiebon("komtNietVoor", 60, LocalDate.of(2022, 5, 10));
		Sporter sporter = sporterBeheerder.geefEenSporterMetGegevenReductiebon(bon);
		Assertions.assertNull(sporter);
	}

	@Test
	public void testVraagExtra1_reductiebonnenMetKorting() {
		List<Reductiebon> bonnen = sporterBeheerder.geefAlleReductiebonnenMetKortingsPercentageX(List.of(10, 40));

		Set<String> resultaat = bonnen.stream().map(rb -> rb.getReductiebonCode()).collect(Collectors.toSet());

		Set<String> verwachteResultaat = new HashSet<>(Arrays.asList("R31", "R34", "R36", "R322"));
		Assertions.assertEquals(verwachteResultaat, resultaat);
	}

	@Test
	public void testVraagExtra2_verwijderSporters() {
		Assertions.assertEquals(6, sporterBeheerder.getSportersLijst().size());
		sporterBeheerder.verwijderAlleSportersMetReductiebonMetPercX(10);
		Assertions.assertEquals(3, sporterBeheerder.getSportersLijst().size());
	}
}
