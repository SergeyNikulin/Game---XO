import xo.model.Field;
import xo.model.Figure;
import xo.model.Game;
import xo.model.Player;
import xo.model.exceptions.InvalidCoordinateException;
import xo.view.XOView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        final Player player1 = new Player("Sergey", Figure.X);
        final Player player2 = new Player("Andrey", Figure.O);
        final int fieldSize = 3;

        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        Field field = new Field(fieldSize);

        Game game = new Game("XO", field, players);

        XOView xoView = new XOView();
        xoView.show(game);
        while(xoView.move(game)) {
            xoView.show(game);
        }

    }
}
