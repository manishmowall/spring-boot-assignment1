package org.webonise.polygon;

public interface SumOfInteriorAnglesCalculator {

    int getSumOfInteriorAngles(int noOfSides);

    int getSumOfInteriorAngles(Polygon polygon);
}
