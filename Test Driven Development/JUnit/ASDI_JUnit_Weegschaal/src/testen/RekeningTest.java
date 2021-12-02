package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Rekening;

class RekeningTest {

    @ParameterizedTest
    @ValueSource(strings = {"001-0000001-77", "999-9999999-48","063-1547563-60"})
    void geldigRekeningnummer(String rekeningnummer) {
        Assertions.assertDoesNotThrow(() ->{ new Rekening(rekeningnummer);});
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"    ", "111-1111111-11", "063-1547563-060", "63-1547563-60","063*1547563+60","06-31547563-60", "000-0003333-35", "333-0000000-88", "000-0000000-00"})
    void ongeldigRekeningnummer(String rekeningnummer) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rekening(rekeningnummer);
        });
    }

}