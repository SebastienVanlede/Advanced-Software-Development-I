package testen;

import domein.Rekening;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RekeningTest {
    @Test
    public void nummerOk() {
        Assertions.assertDoesNotThrow(() -> new Rekening("063-1547563-60"));
    }

    @Test
    public void grootNummerOk() {
        Assertions.assertDoesNotThrow(() -> new Rekening("999-9999999-48"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"063-1547563-60", "999-9999999-48"})
    public void geldigRekeningnummer(String rekeningnummer) {
        Assertions.assertDoesNotThrow(() -> new Rekening(rekeningnummer));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"063-1547563-61", " ", "063-1547563", "063-1547563-601"})
    public void ongeldigRekeningnummer(String rekeningnummer) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Rekening(rekeningnummer));
    }

}
