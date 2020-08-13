package com.hillel.figure.triangle.impl;

import com.hillel.figure.triangle.Triangle;
import com.hillel.figure.triangle.sort.TrianglesCriteria;

public class Isosceles implements TrianglesCriteria {

    public boolean isMatchCriteria(Triangle triangle) {
        boolean isIsosceles;
        if ((triangle.getSide1() == triangle.getSide2() && triangle.getSide2() != triangle.getSide3())
                || (triangle.getSide2() == triangle.getSide3() && triangle.getSide3() != triangle.getSide1())
                || (triangle.getSide1() == triangle.getSide3() && triangle.getSide3() != triangle.getSide2())) {
            return true;
        } else {
            return false;
        }
    }

}
