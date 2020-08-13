package com.hillel.figure.triangle.impl;

import com.hillel.figure.triangle.Triangle;
import com.hillel.figure.triangle.sort.TrianglesCriteria;

public class Equilateral implements TrianglesCriteria {

    public boolean isMatchCriteria(Triangle triangle) {
        boolean isEquilateral;
        if (triangle.getSide1() == triangle.getSide2() && triangle.getSide2() == triangle.getSide3()) {
            return true;
        } else {
            return false;
        }
    }

}
