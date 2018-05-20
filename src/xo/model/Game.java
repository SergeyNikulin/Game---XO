package xo.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Game implements Iterable<Player> {

    private final String name;

    private final Player[] players;

    private final Field field;

    public Game(final String name, final Field field, final Player[] players) {
        this.name = name;
        this.players = players;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    @Override
    public Iterator<Player> iterator() {
        List playersList = Arrays.asList(players);
        return playersList.iterator();
    }
}
