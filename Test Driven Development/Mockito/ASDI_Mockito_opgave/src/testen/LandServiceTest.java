package testen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import domein.Land;
import domein.LandService;
import domein.LandStatistiek;
import persistentie.PersistentieController;

@ExtendWith(MockitoExtension.class)
class LandServiceTest {

	@Mock
	private PersistentieController persistentieControllerDummy;

	@InjectMocks
	private LandService landService;

	private static final int oppervlakte = 110;

	@ParameterizedTest
	@CsvSource({ "BE, 10, 0.1", "NL, 22, 0.2", "DE, 78, 0.7" })
	public void testGeefLandStatistiekScenario(String landCode, int landOppervlakte, double verwachteResultaat) {
		Mockito.when(persistentieControllerDummy.findLand(landCode)).thenReturn(new Land(landCode, landOppervlakte));

		Mockito.when(persistentieControllerDummy.findOppervlakteAlleLanden()).thenReturn(oppervlakte);

		LandStatistiek stat = landService.geefLandStatistiek(landCode);

		Assertions.assertEquals(landCode, stat.getLandCode());

		Assertions.assertEquals(verwachteResultaat, stat.getVerhouding(), 0.01);

		Mockito.verify(persistentieControllerDummy).findLand(landCode);
		Mockito.verify(persistentieControllerDummy).findOppervlakteAlleLanden();

	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "        " })
	public void lege_spaties_nullCode(String landCode) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			landService.geefLandStatistiek(landCode);
		});
	}

	@Test
	public void landBestaatNiet() {
		final String CODE_GEEN_LAND = "GEEN_LAND";
		Mockito.when(persistentieControllerDummy.findLand(CODE_GEEN_LAND)).thenReturn(null);
		Mockito.lenient().when(persistentieControllerDummy.findOppervlakteAlleLanden()).thenReturn(100);

		Assertions.assertNull(landService.geefLandStatistiek(CODE_GEEN_LAND));

		Mockito.verify(persistentieControllerDummy).findLand(CODE_GEEN_LAND);

		Mockito.verify(persistentieControllerDummy,
		Mockito.times(0)).findOppervlakteAlleLanden();

	}

}