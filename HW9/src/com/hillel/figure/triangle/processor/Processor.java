package com.hillel.figure.triangle.processor;

import java.util.Arrays;

import com.hillel.figure.triangle.Triangle;
import com.hillel.figure.triangle.criteria.TrianglesCriteria;
import com.hillel.figure.triangle.impl.Equilateral;
import com.hillel.figure.triangle.impl.Isosceles;
import com.hillel.figure.triangle.impl.Rectangular;
import com.hillel.figure.triangle.util.Util;

public class Processor {

    Triangle[] triangles;

    public Processor(Triangle[] triangles) {
        this.triangles = triangles;
    }

    private Triangle[] extendArray(Triangle foundTriangle, Triangle[] coppiedArray) {
        if (coppiedArray.length == 0) {
            return new Triangle[] { foundTriangle };
        } else {
            Triangle[] extendedArray = new Triangle[coppiedArray.length + 1];
            for (int i = 0; i < coppiedArray.length; i++) {
                extendedArray[i] = coppiedArray[i];
            }
            extendedArray[coppiedArray.length] = foundTriangle;
            return extendedArray;
        }
    }

    public int[] CountOfTrianglesEachType() {
        /*
         * arrayOfCounts[0] = countOfEquilateral arrayOfCounts[1] = countOfIsosceles
         * arrayOfCounts[2] = countOfRectangular arrayOfCounts[3] = countOfArbitrary
         */
        int[] arrayOfCounts = new int[4];
        TrianglesCriteria equilateralCriteria = new Equilateral();
        TrianglesCriteria isoscelesCriteria = new Isosceles();
        TrianglesCriteria rectangularCriteria = new Rectangular();
        for (Triangle triangle : triangles) {
            if (equilateralCriteria.isMatchCriteria(triangle)) {
                arrayOfCounts[0]++;
            } else if (isoscelesCriteria.isMatchCriteria(triangle)) {
                arrayOfCounts[1]++;
            } else if (rectangularCriteria.isMatchCriteria(triangle)) {
                arrayOfCounts[2]++;
            } else {
                arrayOfCounts[3]++;
            }
        }
        return arrayOfCounts;
    }

    public Triangle[][] findMinMaxAreaAndPerimeterOfEachType() {
        Triangle[][] maxMinTrianglesByAreaAndPerimter = new Triangle[4][4];
        Triangle[] equilateral = {};
        Triangle[] isosceles = {};
        Triangle[] rectangular = {};
        Triangle[] arbitrary = {};
        TrianglesCriteria equilateralCriteria = new Equilateral();
        TrianglesCriteria isoscelesCriteria = new Isosceles();
        TrianglesCriteria rectangularCriteria = new Rectangular();
        for (Triangle triangle : triangles) {
            if (equilateralCriteria.isMatchCriteria(triangle)) {
                equilateral = extendArray(triangle, equilateral);
            } else if (isoscelesCriteria.isMatchCriteria(triangle)) {
                isosceles = extendArray(triangle, isosceles);
            } else if (rectangularCriteria.isMatchCriteria(triangle)) {
                rectangular = extendArray(triangle, rectangular);
            } else {
                arbitrary = extendArray(triangle, arbitrary);
            }
        }
        /*
         * maxArea maxPerimeter minArea minPerimeter
         */
        maxMinTrianglesByAreaAndPerimter[0] = Util.findBiggestAndFewestAreaAndPerimeter(equilateral);
        maxMinTrianglesByAreaAndPerimter[1] = Util.findBiggestAndFewestAreaAndPerimeter(isosceles);
        maxMinTrianglesByAreaAndPerimter[2] = Util.findBiggestAndFewestAreaAndPerimeter(rectangular);
        maxMinTrianglesByAreaAndPerimter[3] = Util.findBiggestAndFewestAreaAndPerimeter(arbitrary);
        return maxMinTrianglesByAreaAndPerimter;
    }

}
