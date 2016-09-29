package org.webonise.polygon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Application {
    private final PolygonCalculator polygonCalculator;
    private final Polygon polygon;
    private final Scanner input;
    private static final int MIN_SIDES = 3;
    private static final int MAX_SIDES = 10;
    private final Logger logger;

    @Autowired
    public Application(PolygonCalculator polygonCalculator, Polygon polygon) {
        logger = Logger.getLogger(Application.class.getName());
        this.polygonCalculator = polygonCalculator;
        this.polygon = polygon;
        input = new Scanner(System.in);
    }

    public void start() {

        try {
            startApplication();
        } catch (IllegalArgumentException | InputMismatchException illegalArgumentException) {
            logger.log(Level.INFO, illegalArgumentException.getMessage());
        }
    }

    private void startApplication() throws IllegalArgumentException, InputMismatchException {

        logger.log(Level.INFO, "========Polygon Calculator========");

        logger.log(Level.INFO, "enter no of sides(int) of Polygon: ");
        int noOfSides = input.nextInt();

        checkNoOfSidesLimit(noOfSides);

        logger.log(Level.INFO, "enter length of side(double) of Polygon: ");
        double sideLength = input.nextDouble();

        setPolygonParameters(noOfSides, sideLength);

        logger.log(Level.INFO, "Menu \n\t1) Perimeter \n\t2) Sum of Interior Angles");
        logger.log(Level.INFO, "Enter option(1 or 2): ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                perimeterMenu(noOfSides, sideLength);
                break;

            case 2:
                sumOfInteriorAnglesMenu(noOfSides, sideLength);
                break;

            default:
                throw new IllegalArgumentException("Entered Invalid Option");
        }
    }

    private void setPolygonParameters(int noOfSides, double sideLength) {
        polygon.setNoOfSides(noOfSides);
        polygon.setSideLength(sideLength);
    }

    private void checkNoOfSidesLimit(int noOfSides) {
        if (isNoOfSidesValid(noOfSides)) {
            logger.log(Level.INFO, "No of Sides within limit");
        } else {
            logger.log(Level.INFO, "No of Sides should be >= " + MIN_SIDES + " and " + "<= " + MAX_SIDES);
            System.exit(0);
        }

    }

    private boolean isNoOfSidesValid(int noOfSides) {
        if (noOfSides < MIN_SIDES || noOfSides > MAX_SIDES) {
            return false;
        }

        return true;
    }

    private void perimeterMenu(int noOfSides, double sideLength) throws IllegalArgumentException, InputMismatchException {

        logger.log(Level.INFO, "==========Perimeter==========");
        logger.log(Level.INFO, "Calculating Permeter by \n\t1)passing value  2) by polygon object");
        logger.log(Level.INFO, "Enter option(1 or 2): ");
        int option = input.nextInt();
        double perimeter = 0;

        switch (option) {
            case 1:
                perimeter = polygonCalculator.getPerimeter(noOfSides, sideLength);
                break;

            case 2:
                perimeter = polygonCalculator.getPerimeter(polygon);
                break;

            default:
                throw new IllegalArgumentException("Error: Entered Invalid Option");
        }

        logger.log(Level.INFO, "perimeter is " + perimeter);
    }

    private void sumOfInteriorAnglesMenu(int noOfSides, double sideLength) throws IllegalArgumentException, InputMismatchException {

        logger.log(Level.INFO, "==========Sum Of Interior Angles==========");
        logger.log(Level.INFO, "Calculating Sum by \n\t1)passing value  2) by polygon object");
        logger.log(Level.INFO, "Enter option(1 or 2): ");
        int option = input.nextInt();
        double sum = 0;

        switch (option) {
            case 1:
                sum = polygonCalculator.getSumOfInteriorAngles(noOfSides);
                break;

            case 2:
                sum = polygonCalculator.getSumOfInteriorAngles(polygon);
                break;

            default:
                throw new IllegalArgumentException("Error: Entered Invalid Option");
        }

        logger.log(Level.INFO, "Sum of Interior Angles is " + sum);
    }
}
