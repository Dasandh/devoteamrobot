package com.devoteam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devoteam.robot.Robot;
import com.devoteam.grid.Grid;

public class RobotTest {
    final Robot robot = new Robot();
    final Grid grid = new Grid();

    @BeforeEach
    public void setUp() {

        grid.setHeight(3);
        grid.setWidth(3);
        robot.setGrid(grid);
        robot.setX(2);
        robot.setY(2);
        robot.setOrientation('N');
    }

    @Test
    public void testTurnLeft() {
        robot.turnLeft();
        assertEquals('W', robot.getOrientation());

        robot.turnLeft();
        assertEquals('S', robot.getOrientation());

        robot.turnLeft();
        assertEquals('E', robot.getOrientation());

        robot.turnLeft();
        assertEquals('N', robot.getOrientation());
    }

    @Test
    public void testTurnRight() {
        try {
            robot.turnRight();
            assertEquals('E', robot.getOrientation());

            robot.turnRight();
            assertEquals('S', robot.getOrientation());

            robot.turnRight();
            assertEquals('W', robot.getOrientation());

            robot.turnRight();
            assertEquals('N', robot.getOrientation());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void testMoveForward() {
        try {
            robot.moveForward();
            assertEquals(2, robot.getX());
            assertEquals(3, robot.getY());

            robot.turnRight();
            robot.moveForward();
            assertEquals(3, robot.getX());
            assertEquals(3, robot.getY());

            robot.turnRight();
            robot.moveForward();
            assertEquals(3, robot.getX());
            assertEquals(2, robot.getY());

            robot.turnRight();
            robot.moveForward();
            assertEquals(2, robot.getX());
            assertEquals(2, robot.getY());

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
