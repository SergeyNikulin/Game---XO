package xo.controller;

import xo.model.Field;
import xo.model.Figure;
import xo.model.exceptions.AlreadOccupiedException;
import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;

public class MoveController {

    public void applyFigure (final Field field, final Point point, final Figure figure) throws InvalidCoordinateException,
                                                                                               AlreadOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadOccupiedException();
        }
       field.setFigure(point, figure);
    }
}
