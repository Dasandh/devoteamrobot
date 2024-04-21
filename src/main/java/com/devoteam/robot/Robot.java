package com.devoteam.robot;

import java.text.MessageFormat;

import com.devoteam.exceptions.OutOfBoundsException;
import com.devoteam.grid.Grid;

public class Robot {
    private Grid grid;
    private int pos_x;
    private int pos_y;
    private char orientation;

    public Robot() {

    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getX() {
        return pos_x;
    }

    public int getY() {
        return pos_y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setX(int x) {
        this.pos_x = x;
    }

    public void setY(int y) {
        this.pos_y = y;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public void turnLeft() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'N';
                break;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
        }
    }

    public void moveForward() throws OutOfBoundsException {
        switch (orientation) {
            case 'N':
                pos_y++;
                if (pos_y > grid.getHeight()) {
                    throw new OutOfBoundsException(
                            MessageFormat.format("ERROR: Out of bounds at {0} {1}", pos_x, pos_y));
                }
                break;
            case 'E':
                pos_x++;
                if (pos_x > grid.getWidth()) {
                    throw new OutOfBoundsException(
                            MessageFormat.format("ERROR: Out of bounds at {0} {1}", pos_x, pos_y));
                }
                break;
            case 'S':
                pos_y--;
                if (pos_x < grid.getHeight()) {
                    throw new OutOfBoundsException(
                            MessageFormat.format("ERROR: Out of bounds at {0} {1}", pos_x, pos_y));
                }
                break;
            case 'W':
                pos_x--;
                if (pos_x < grid.getWidth()) {
                    throw new OutOfBoundsException(
                            MessageFormat.format("ERROR: Out of bounds at {0} {1}", pos_x, pos_y));
                }
                break;
        }
    }

    public String reportLocation() {
        String report = MessageFormat.format("Report: {0} {1} {2}", pos_x, pos_y, orientation);
        return report;
    }

}
