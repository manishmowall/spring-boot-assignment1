package org.webonise.polygon;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Polygon {
    private int noOfSides;
    private double sideLength;

    public void setNoOfSides(int noOfSides) {
        this.noOfSides = noOfSides;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public int getNoOfSides() {
        return noOfSides;
    }

    public double getSideLength() {
        return sideLength;
    }
}
