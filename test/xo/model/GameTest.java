package xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGetName() {
        final String inputValue = "XO";
        final String expectedValue = inputValue;

        Game game = new Game(inputValue, null, null);

        final String actualValue = game.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetNameWhenIsNull() {
        Game game = new Game(null, null, null);

        final String actualValue = game.getName();

        assertNull(actualValue);
    }

    @Test
    public void testGetPlayers() {
        final Player[] inputValue = new Player[2];
        final Player[] expectedValue = inputValue;
        expectedValue[0] = new Player("Sergey", Figure.X);
        expectedValue[1] = new Player("Andrey", Figure.O);

        Game game = new Game(null, null, inputValue);

        final Player[] actualValue = game.getPlayers();

        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetPlayersWhenIsNull() {
        Game game = new Game(null, null, null);

        final Player[] actualValue = game.getPlayers();

        assertNull(actualValue);
    }

    @Test
    public void testGetField() {
        final Field inputValue = new Field(3);
        final Field expectedValue = inputValue;

        Game game = new Game(null, inputValue, null);

        final Field actualValue = game.getField();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFieldWhenIsNull() {
        Game game = new Game(null, null, null);

        final Field actualValue = game.getField();

        assertNull(actualValue);
    }
}