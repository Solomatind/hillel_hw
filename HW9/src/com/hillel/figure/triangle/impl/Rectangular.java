package com.hillel.figure.triangle.impl;

import com.hillel.figure.triangle.Triangle;
import com.hillel.figure.triangle.sort.TrianglesCriteria;

public class Rectangular implements TrianglesCriteria {

    public boolean isMatchCriteria(Triangle triangle) {
        boolean isRectangular;
        if (Math.round(Math.pow(triangle.getSide3(), 2)) == (Math.pow(triangle.getSide1(), 2)
                + Math.pow(triangle.getSide2(), 2))) {
            return true;
        } else {
            return false;
        }
    }

}