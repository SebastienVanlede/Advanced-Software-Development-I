package testen;

import domein.BowlingGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++)
            bowlingGame.roll(pins);
    }

    private void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }

    @BeforeEach
    public void before() {
        bowlingGame = new BowlingGame();
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,20"})
    public void testSameNumberOfPins(int number, int expected) {
        rollMany(20, number);
        Assertions.assertEquals(expected, bowlingGame.score());
    }

    @Test
    public void testAllZeros() {
        rollMany(20, 0);
        Assertions.assertEquals(0, bowlingGame.score());
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        Assertions.assertEquals(20, bowlingGame.score());
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(17, 0);
        Assertions.assertEquals(16, bowlingGame.score());
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(16, 0);
        Assertions.assertEquals(24, bowlingGame.score());
    }

    @Test
    public void testAllStrikes() {
        for (int i = 0; i < 12; i++)
            rollStrike();
        Assertions.assertEquals(300, bowlingGame.score());
    }

    @Test
    public void testAllSpares_5_5() {
        for (int i = 0; i < 10; i++)
            rollSpare();
        bowlingGame.roll(5);
        Assertions.assertEquals(150, bowlingGame.score());
    }

    @Test
    public void testScenario(){
        int[] pins = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
        for (int i = 0; i < pins.length; i++)
            bowlingGame.roll(pins[i]);
        Assertions.assertEquals(133, bowlingGame.score());
    }
}
