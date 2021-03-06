package xo.controller;

import xo.model.Field;
import xo.model.Figure;
import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove (final Field field)  {
        int countFigure = 0;

        for (int indexLine = 0 ; indexLine < field.getSize(); indexLine++) {
            for (int indexColumn = 0; indexColumn < field.getSize(); indexColumn++) {
                try {
                    if (field.getFigure(new Point(indexLine, indexColumn)) != null) {
                        countFigure +=1;
                    }
                } catch (InvalidCoordinateException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

        if (countFigure == 9) {
            return null;
        }
        if (countFigure == 0 || countFigure % 2 == 0) {
            return Figure.X;
        }
        return Figure.O;
    }

}
