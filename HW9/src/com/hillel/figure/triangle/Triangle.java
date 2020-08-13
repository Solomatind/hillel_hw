package com.hillel.figure.triangle;

import com.hillel.figure.Dot;
import com.hillel.figure.triangle.util.Util;

public class Triangle {

    private double side1;
    private double side2;
    private double side3;
    private double perimeter;
    private double area;

    public Triangle(Dot d1, Dot d2, Dot d3) {
        if ((d1.getX() != d2.getX() | d2.getX() != d3.getX()) && (d1.getY() != d2.getY() | d2.getY() != d3.getY())) {
            side1 = Util.drawSide(d1, d2);
            side2 = Util.drawSide(d2, d3);
            side3 = Util.drawSide(d1, d3);
            double sides[];
            sides = Util.sortByAscend(side1, side2, side3);
            side1 = sides[0];
            side2 = sides[1];
            side3 = sides[2];
        } else {
            System.out.println("Can't make a triangle with this dots");
        }
    }

    public void calculateArea() {
        double halfPerimeter = perimeter / 2;
        area = Util.round(
                Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3)));
    }

    public void calculatePerimeter() {
        perimeter = Util.round(side1 + side2 + side3);
    }

    public String toString() {
        return "Perimeter: " + perimeter + " Area: " + area + "\n";
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

}
