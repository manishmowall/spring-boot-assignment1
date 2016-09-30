package org.webonise.springbootpolygon;

import org.springframework.stereotype.Service;

/*INFO : singleton class by default*/
@Service
public class PolygonCalculator implements PerimeterCalculator, SumOfInteriorAnglesCalculator {

    @Override
    public double getPerimeter(int noOfSides, double sideLength) {
        return noOfSides * sideLength;
    }

    @Override
    public int getSumOfInteriorAngles(int noOfSides) {
        return 180 * (noOfSides - 2);
    }
}
