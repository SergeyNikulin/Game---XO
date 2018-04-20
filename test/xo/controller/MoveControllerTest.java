package xo.controller;

import org.junit.Test;
import xo.model.Field;
import xo.model.Figure;
import xo.model.exceptions.AlreadOccupiedException;
import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;

import static org.junit.Assert.*;

public class MoveControllerTest {

    @Test
    public void testApplyFigure() throws InvalidCoordinateException, AlreadOccupiedException {
        final int filedSize = 3;
        final int coordX = 0;
        final int coordY = 0;

        MoveController moveController = new MoveController();
        Field field = new Field(filedSize);
        Point point = new Point(coordX, coordY);
        Figure figure = Figure.X;

        moveController.applyFigure(field,point,figure);
        Figure actuallyValue = field.getFigure(point);

        assertEquals(figure, actuallyValue);
    }

    @Test
    public void testApplyFigureWhenIsOccupiedAlready() throws InvalidCoordinateException, AlreadOccupiedException {
        final int filedSize = 3;
        final int coordX = 0;
        final int coordY = 0;

        MoveController moveController = new MoveController();
        Field field = new Field(filedSize);
        Point point = new Point(coordX, coordY);
        Figure figure = Figure.X;

        moveController.applyFigure(field,point,figure);

        try {
            moveController.applyFigure(field,point,figure);
            fail();
        } catch (AlreadOccupiedException e) {
        }
    }
}