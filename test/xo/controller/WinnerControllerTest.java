package xo.controller;

import org.junit.Test;
import xo.model.Field;
import xo.model.Figure;
import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerLine() throws InvalidCoordinateException {
        final int fieldSize = 3;

        WinnerController winnerController = new WinnerController();
        Field field = new Field(fieldSize);
        Figure figure = Figure.X;
        field.setFigure(new Point(0,0), figure);
        field.setFigure(new Point(0,1), figure);
        field.setFigure(new Point(0,2), figure);

        Figure actuallyValue = winnerController.getWinner(field);

        assertEquals(figure, actuallyValue);
    }

    @Test
    public void testGetWinnerColumn() throws InvalidCoordinateException {
        final int fieldSize = 3;

        WinnerController winnerController = new WinnerController();
        Field field = new Field(fieldSize);
        Figure figure = Figure.X;
        field.setFigure(new Point(0,0), figure);
        field.setFigure(new Point(1,0), figure);
        field.setFigure(new Point(2,0), figure);

        Figure actuallyValue = winnerController.getWinner(field);

        assertEquals(figure, actuallyValue);
    }

    @Test
    public void testGetWinnerDiagonal1() throws InvalidCoordinateException {
        final int fieldSize = 3;

        WinnerController winnerController = new WinnerController();
        Field field = new Field(fieldSize);
        Figure figure = Figure.X;
        field.setFigure(new Point(0,0), figure);
        field.setFigure(new Point(1,1), figure);
        field.setFigure(new Point(2,2), figure);

        Figure actuallyValue = winnerController.getWinner(field);

        assertEquals(figure, actuallyValue);
    }

    @Test
    public void testGetWinnerDiagonal2() throws InvalidCoordinateException {
        final int fieldSize = 3;

        WinnerController winnerController = new WinnerController();
        Field field = new Field(fieldSize);
        Figure figure = Figure.X;
        field.setFigure(new Point(0,2), figure);
        field.setFigure(new Point(1,1), figure);
        field.setFigure(new Point(2,0), figure);

        Figure actuallyValue = winnerController.getWinner(field);

        assertEquals(figure, actuallyValue);
    }

    @Test
    public void testGetWinnerNoWinner() throws InvalidCoordinateException {
        final int fieldSize = 3;

        WinnerController winnerController = new WinnerController();
        Field field = new Field(fieldSize);
        Figure figure = Figure.X;
        field.setFigure(new Point(0,1), figure);
        field.setFigure(new Point(1,1), figure);
        field.setFigure(new Point(1,2), figure);

        Figure actuallyValue = winnerController.getWinner(field);

        assertNull(actuallyValue);
    }
}