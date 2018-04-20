package xo.controller;

import xo.model.Field;
import xo.model.Figure;
import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner (Field field) throws InvalidCoordinateException {
        if (winnerLine(field, Figure.X) ||
                winnerColumn(field, Figure.X) ||
                winnerDiagonal1(field, Figure.X) ||
                winnerDiagonal2(field, Figure.X)) {
            return Figure.X;
        }
        if (winnerLine(field, Figure.O) ||
                winnerColumn(field, Figure.O) ||
                winnerDiagonal1(field, Figure.O) ||
                winnerDiagonal2(field, Figure.O)) {
            return Figure.O;
        }
        return null;
    }

    private boolean winnerLine(final Field field, final Figure figure) throws InvalidCoordinateException {
        int counter;

        for (int countLine = 0; countLine < field.getSize(); countLine++) {
            counter = 0;
            for (int countColumn = 0; countColumn < field.getSize(); countColumn++) {
                if (field.getFigure(new Point(countLine, countColumn)) == figure) {
                    counter += 1;
                }
            }
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean winnerColumn(final Field field, final Figure figure) throws InvalidCoordinateException {
        int counter;

        for (int countColumn = 0; countColumn < field.getSize(); countColumn++) {
            counter = 0;
            for (int countLine = 0; countLine < field.getSize(); countLine++) {
                if (field.getFigure(new Point(countLine, countColumn)) == figure) {
                    counter += 1;
                }
            }
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean winnerDiagonal2(final Field field, final Figure figure) throws InvalidCoordinateException {
        int counter = 0;
        for (int count = 0; count < field.getSize(); count++) {
            if (field.getFigure(new Point(count,count)) == figure) {
                counter +=1;
            }
        }
        if (counter == 3) {
            return true;
        }
        return false;
    }

    private boolean winnerDiagonal1(final Field field, final Figure figure) throws InvalidCoordinateException {
        int counter = 0;
        for (int count = 0; count < field.getSize(); count++) {
            if (field.getFigure(new Point(count,field.getSize() - 1 - count)) == figure) {
                counter +=1;
            }
        }
        if (counter == 3) {
            return true;
        }
        return false;
    }

}
