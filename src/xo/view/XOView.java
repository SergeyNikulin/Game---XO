package xo.view;

import xo.controller.CurrentMoveController;
import xo.controller.MoveController;
import xo.controller.WinnerController;
import xo.model.Field;
import xo.model.Figure;
import xo.model.Game;
import xo.model.Player;
import xo.model.exceptions.AlreadOccupiedException;
import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class XOView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final MoveController moveController = new MoveController();

    private final WinnerController winnerController = new WinnerController();

    public void show (Game game) {
        Field field = game.getField();
        showInfoGame(game);
        for (int index = 0; index < field.getSize(); index++) {
            if (index !=0) {
                separatedLine();
            }
            showLine(field, index);
        }
    }

    public boolean move (Game game)  {
        final Field field = game.getField();

        final Figure figureWinner = winnerController.getWinner(field);
        final Figure figureMove = currentMoveController.currentMove(field);

        if (figureWinner != null) {
            System.out.println("Win in game - " + figureWinner);
            return false;
        }

        if (figureMove == null) {
            System.out.println("This is draw");
            return false;
        }

        System.out.println("Enter move point - " + figureMove);

        final Point point = askPoint();

        try {
            System.out.println(point);
            System.out.println(figureMove);
            moveController.applyFigure(field, point, figureMove);
        } catch (InvalidCoordinateException e) {
            System.out.println("coordinate is invalid");
            System.out.println();
        } catch (AlreadOccupiedException e) {
            System.out.println("coordinate is occupied");
            System.out.println();
        }

        return true;
    }

    private Point askPoint() {
        Point point = new Point(askCoordinate("Line") - 1, askCoordinate("Column") - 1);
        return point;
    }

    private int askCoordinate(String coordinate) {
        System.out.println("Enter coordinate - " + coordinate);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Coordinate is not integer");
            System.out.println();
            return askCoordinate(coordinate);
        }
    }

    private void separatedLine () {
        System.out.println("~~~~~~~~~~~");
    }

    private void showLine (Field field, int line) {
        for (int column = 0; column < field.getSize(); column++) {
           Point point = new Point(line, column);
            final Figure figure;
            try {
                figure = field.getFigure(point);
            } catch (final InvalidCoordinateException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            if (column != 0) {
               System.out.print("|");
           }

           System.out.print(" ");

           if (figure == null) {
               System.out.print(" ");
           } else {
               System.out.print(figure);
           }

            System.out.print(" ");
        }
        System.out.println();
    }

    private void showInfoGame (Game game) {
        System.out.println("Game name: " + game.getName());
        for (Player player: game) {
            System.out.format("Player: %s Figure: %s \n",  player.getName(), player.getFigure());
        }
        System.out.println();
    }
}
