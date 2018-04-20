package xo.controller;

import org.junit.Test;
import xo.model.Field;
import xo.model.Figure;
import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenZeroFigure() throws InvalidCoordinateException {
        int fieldSize = 3;

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Field field = new Field(fieldSize);

        Figure actuallyValue = currentMoveController.currentMove(field);

        assertEquals(Figure.X, actuallyValue);
    }

    @Test
    public void testCurrentMoveWhenX() throws InvalidCoordinateException {
        int fieldSize = 3;

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Field field = new Field(fieldSize);
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(2,1), Figure.X);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);

        Figure actuallyValue = currentMoveController.currentMove(field);

        assertEquals(Figure.X, actuallyValue);
    }

    @Test
    public void testCurrentMoveWhenO() throws InvalidCoordinateException {
        int fieldSize = 3;

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Field field = new Field(fieldSize);
        field.setFigure(new Point(0,1), Figure.X);
        field.setFigure(new Point(2,1), Figure.X);
        field.setFigure(new Point(0,2), Figure.X);

        Figure actuallyValue = currentMoveController.currentMove(field);

        assertEquals(Figure.O, actuallyValue);
    }

    @Test
    public void testCurrentMoveWhenNull() throws InvalidCoordinateException {
        int fieldSize = 3;

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Field field = new Field(fieldSize);
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.X);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,0), Figure.X);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(1,2), Figure.X);
        field.setFigure(new Point(2,0), Figure.X);
        field.setFigure(new Point(2,1), Figure.X);
        field.setFigure(new Point(2,2), Figure.X);

        Figure actuallyValue = currentMoveController.currentMove(field);

        assertNull(actuallyValue);
    }
}