package com.devoteam;

import java.util.Scanner;

import com.devoteam.grid.Grid;
import com.devoteam.robot.Robot;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();
        Robot robot = new Robot();

        requestStartParameters(scanner, grid, robot);

        requestRobotMovement(scanner, grid, robot);

        System.out.println(robot.reportLocation());

    }

    public static void requestStartParameters(Scanner scanner, Grid grid, Robot robot) {
        String regex = "^[NWSE]$";
        try {

            // Read room dimensions
            System.out.println("Enter grid dimensions, as 'X Y'");
            if (scanner.hasNextInt()) {
                grid.setWidth(scanner.nextInt());
                grid.setHeight(scanner.nextInt());
            } else {
                scanner.next();
            }
            robot.setGrid(grid);

            // Read initial position and orientation
            System.out.println("Enter initial robot position and orientation, as X Y [N/W/S/E]");
            robot.setX(scanner.nextInt());
            robot.setY(scanner.nextInt());
            robot.setOrientation(scanner.next().charAt(0));
            while (!String.valueOf(robot.getOrientation()).matches(regex)) {
                System.out.println("Orientation input incorrect, please enter either N W S or E:");
                robot.setOrientation(scanner.next().charAt(0));
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void requestRobotMovement(Scanner scanner, Grid grid, Robot robot) {
        try {
            // Read navigation commands
            System.out.println("""
                    Enter robot movement instructions:
                    • L Turn left
                    • R Turn right
                    • F Walk forward
                    ex. LRFRFLF.""");

            String commands = scanner.next();

            for (char command : commands.toCharArray()) {
                switch (command) {
                    case 'L':
                        robot.turnLeft();
                        break;
                    case 'R':
                        robot.turnRight();
                        break;
                    case 'F':
                        robot.moveForward();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }
}
