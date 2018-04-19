package xo.model;

import xo.model.exceptions.InvalidCoordinateException;

import java.awt.*;

public class Field {

    private final int filedSize;

    private final Figure[][] field;

    public Field(final int fieldSize) {
        this.filedSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return filedSize;
    }

    public Figure getFigure (final Point point) throws InvalidCoordinateException {
        if (!checkPoint(point)) {
            throw new InvalidCoordinateException();
        }
        return field[point.x][point.y];
    }

    public void setFigure (final Point point, final Figure figure) throws InvalidCoordinateException {
        if (!checkPoint(point)) {
            throw new InvalidCoordinateException();
        }
        field[point.x][point.y] = figure;
    }

    private  boolean checkPoint (final Point point) {
        if (checkCoordinate(point.x) && checkCoordinate(point.y)) {
            return true;
        }
        return false;
    }

    private boolean checkCoordinate (final int coordinate) {
        if (coordinate >= 0 && coordinate < filedSize) {
            return true;
        }
        return false;
    }

}
