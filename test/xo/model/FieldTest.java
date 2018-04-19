package xo.model;

import org.junit.Test;
import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    private Field field;

    @Test
    public void testGetSize() {
        final int inputValue = 3;
        final int expectedValue = inputValue;

        final Field field = new Field(inputValue);

        final int actualValue = field.getSize();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFigureIsNull() throws InvalidCoordinateException {
        final int fieldSize = 3;

        final Field field = new Field(fieldSize);
        final Point point = new Point(0,0);

        final Figure actualValue = field.getFigure(point);

        assertNull(actualValue);
    }

    @Test
    public void testGetFigureWhenXAndYEqualsZero() throws InvalidCoordinateException {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;
        final int fieldSize = 3;

        field = new Field(fieldSize);
        final Point point = new Point(0,0);
        field.setFigure(point, inputValue);

        final Figure actualValue = field.getFigure(point);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFigureWhenXAndYEqualsSize() throws InvalidCoordinateException {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;
        final int fieldSize = 3;

        field = new Field(fieldSize);
        final Point point = new Point(fieldSize-1,fieldSize-1);
        field.setFigure(point, inputValue);

        final Figure actualValue = field.getFigure(point);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFigureWhenXIsLessZero() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(MIN_COORDINATE-1,0);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessZero() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(0,MIN_COORDINATE-1);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testGetFigureWhenXAndYIsLessZero() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(MIN_COORDINATE-1,MIN_COORDINATE-1);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreSize() throws InvalidCoordinateException {
        final int fieldSize = 3;

        Field field = new Field(fieldSize);
        final Point point = new Point(fieldSize,0);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreSize() throws InvalidCoordinateException {
        final int fieldSize = 3;

        Field field = new Field(fieldSize);
        final Point point = new Point(0,fieldSize);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testGetFigureWhenXAndYIsMoreSize() throws InvalidCoordinateException {
        final int fieldSize = 3;

        Field field = new Field(fieldSize);
        final Point point = new Point(fieldSize,fieldSize);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testGetFigureWhenXIsLessZeroAndYIsMoreSize() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(MIN_COORDINATE-1,fieldSize);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreSizeAndYIsLessZero() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(fieldSize,MIN_COORDINATE-1);

        try {
            field.getFigure(point);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testSetFigureWhenXIsLessZero() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(MIN_COORDINATE-1,0);

        try {
            field.setFigure(point, null);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testSetFigureWhenYIsLessZero() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(0,MIN_COORDINATE-1);

        try {
            field.setFigure(point, null);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testSetFigureWhenXAndYIsLessZero() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(MIN_COORDINATE-1,MIN_COORDINATE-1);

        try {
            field.setFigure(point, null);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testSetFigureWhenXIsMoreSize() throws InvalidCoordinateException {
        final int fieldSize = 3;

        Field field = new Field(fieldSize);
        final Point point = new Point(fieldSize,0);

        try {
            field.setFigure(point, null);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testSetFigureWhenYIsMoreSize() throws InvalidCoordinateException {
        final int fieldSize = 3;

        Field field = new Field(fieldSize);
        final Point point = new Point(0,fieldSize);

        try {
            field.setFigure(point, null);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testSetFigureWhenXAndYIsMoreSize() throws InvalidCoordinateException {
        final int fieldSize = 3;

        Field field = new Field(fieldSize);
        final Point point = new Point(fieldSize,fieldSize);

        try {
            field.setFigure(point, null);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testSetFigureWhenXIsLessZeroAndYIsMoreSize() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(MIN_COORDINATE-1,fieldSize);

        try {
            field.setFigure(point, null);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }

    @Test
    public void testSetFigureWhenXIsMoreSizeAndYIsLessZero() throws InvalidCoordinateException {
        final int fieldSize = 3;
        final int MIN_COORDINATE = 0;

        Field field = new Field(fieldSize);
        final Point point = new Point(fieldSize,MIN_COORDINATE-1);

        try {
            field.setFigure(point, null);
            fail();
        } catch (final InvalidCoordinateException e) {}
    }




}