package testen;

import domein.BowlingGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BowlingGameTest {
    private BowlingGame game;

    @BeforeEach
    public void before() {
        game = new BowlingGame();
    }

    @Test
    public void testAllZeros() {
        rollMany(20, 0);
        Assertions.assertEquals(0, game.score());

    }

    public void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++)
            game.roll(pins);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 20"})
    public void testSameNumberOfPins(int number, int expected) {
        rollMany(20, number);
        Assertions.assertEquals(expected, game.score());
    }


    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        Assertions.assertEquals(20, game.score());

    }

    @Test
    public void testOneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        Assertions.assertEquals(16, game.score());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    @Test
    public void testOneStrike(){
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        Assertions.assertEquals(24, game.score());
    }

    private void rollStrike(){
        game.roll(10);
    }
}
