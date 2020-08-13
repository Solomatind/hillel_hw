package com.hillel.figure.triangle.test;

import java.util.Arrays;
import com.hillel.figure.Dot;
import com.hillel.figure.triangle.Triangle;
import com.hillel.figure.triangle.processor.Processor;

public class Runner {

    public static void main(String[] args) {
        Triangle t1[] = { new Triangle(new Dot(1, 0), new Dot(0, 0), new Dot(0, 1)),
                new Triangle(new Dot(0, 0), new Dot(3, 2), new Dot(3, 0)),
                new Triangle(new Dot(3, 5), new Dot(9, 5), new Dot(1, 0)),
                new Triangle(new Dot(5, 0), new Dot(0, 0), new Dot(0, 5)),
                new Triangle(new Dot(1, 2), new Dot(6, 8), new Dot(6, 2)),
                new Triangle(new Dot(3, 2), new Dot(6, Math.sqrt(27) + 2), new Dot(9, 2)),
                new Triangle(new Dot(7, 1), new Dot(0, 6), new Dot(3, 7)),
                new Triangle(new Dot(2, 0), new Dot(4, 4), new Dot(6, 0)),
                new Triangle(new Dot(5, 5), new Dot(3, 8), new Dot(1, 0)),
                new Triangle(new Dot(0, 0), new Dot(1.5, Math.sqrt(6.75)), new Dot(3, 0)), };
        for (Triangle triangle : t1) {
            triangle.calculatePerimeter();
            triangle.calculateArea();
        }
        System.out.println(Arrays.toString(t1));
        Processor proc = new Processor(t1);
        int[] countOfTrianglesEachType;
        countOfTrianglesEachType = proc.CountOfTrianglesEachType();
        System.out.println("Equilateral, " + "Isosceles, " + "Rectangular, " + "Arbitrary");
        System.out.println(Arrays.toString(countOfTrianglesEachType));
        /*
         * Equilateral: maxArea maxPerimeter minArea minPerimeter Isosceles: ...
         * Rectangular: ... Arbitrary: ...
         */
        Triangle[][] minMaxTriangles = proc.findMinMaxAreaAndPerimeterOfEachType();
        for (Triangle[] triangle : minMaxTriangles) {
            System.out.println(Arrays.toString(triangle));
        }
    }

}
