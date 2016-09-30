package org.webonise.springbootpolygon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Application {

    private static final int MIN_SIDES = 3;
    private static final int MAX_SIDES = 10;
    private final PolygonCalculator polygonCalculator;
    private final Scanner input;
    private final Logger logger;

    //final arguments for thread-safe best practice
    //@Qualifier to provide specific Bean
    @Autowired
    public Application(final PolygonCalculator polygonCalculator, @Qualifier("input") final Scanner input, @Qualifier("logger") final Logger logger) {
        this.polygonCalculator = polygonCalculator;
        this.input = input;
        this.logger = logger;
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


        double perimeter = polygonCalculator.getPerimeter(noOfSides, sideLength);
        logger.log(Level.INFO, "perimeter is " + perimeter);


        double sum = polygonCalculator.getSumOfInteriorAngles(noOfSides);
        logger.log(Level.INFO, "Sum of Interior Angles is " + sum);
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
}
