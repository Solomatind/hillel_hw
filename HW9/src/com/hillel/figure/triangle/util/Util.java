package com.hillel.figure.triangle.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.hillel.figure.Dot;
import com.hillel.figure.triangle.Triangle;

public class Util {

    public static double drawSide(Dot d1, Dot d2) {
        double side;
        side = Math.sqrt(Math.pow(d1.getX() - d2.getX(), 2) + Math.pow(d1.getY() - d2.getY(), 2));
        return side;
    }

    public static Triangle[] findBiggestAndFewestAreaAndPerimeter(Triangle[] trianglesByType) {
        double maxArea = Double.MIN_VALUE;
        double maxPerimeter = Double.MIN_VALUE;
        double minArea = Double.MAX_VALUE;
        double minPerimeter = Double.MAX_VALUE;
        Triangle resMaxArea = null;
        Triangle resMaxPerimeter = null;
        Triangle resMinArea = null;
        Triangle resMinPerimeter = null;
        for (Triangle triangle : trianglesByType) {
            if (triangle.getArea() > maxArea) {
                maxArea = triangle.getArea();
                resMaxArea = triangle;
            }
            if (triangle.getPerimeter() > maxPerimeter) {
                maxPerimeter = triangle.getPerimeter();
                resMaxPerimeter = triangle;
            }
            if (triangle.getArea() < minArea) {
                minArea = triangle.getArea();
                resMinArea = triangle;
            }
            if (triangle.getPerimeter() < minPerimeter) {
                minPerimeter = triangle.getPerimeter();
                resMinPerimeter = triangle;
            }
        }
        Triangle[] resultArray = { resMaxArea, resMaxPerimeter, resMinArea, resMinPerimeter };
        return resultArray;
    }

    public static double round(double value) {
        BigDecimal result = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        return value = result.doubleValue();
    }

    public static double[] sortByAscend(double... sides) {
        double temp;
        for (int i = 0; i < sides.length; i++) {
            for (int j = sides.length - 1; j > i; j--) {
                if (sides[j - 1] > sides[j]) {
                    temp = sides[j - 1];
                    sides[j - 1] = sides[j];
                    sides[j] = temp;
                }
            }
        }
        return sides;
    }

}
