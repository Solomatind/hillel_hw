
public class Triangle {

    private double side1;
    private double side2;
    private double side3;
    private double perimeter;
    private double area;
    private String typeOfTriangle;

    Triangle(Dot d1, Dot d2, Dot d3) {
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
        defineTypeOfTriangle();
    }

    public void calculateArea() {
        double halfPerimeter = perimeter / 2;
        area = Util.round(Math.sqrt(halfPerimeter * (halfPerimeter - side1) * 
                (halfPerimeter - side2) * (halfPerimeter - side3)));
    }

    private void defineTypeOfTriangle() {
        if (side1 == side2 && side2 == side3) {
            typeOfTriangle = "Equilateral";
            return;
        } else if ((side1 == side2 && side2 != side3) || (side2 == side3 && side3 != side1)
                || (side1 == side3 && side3 != side2)) {
            typeOfTriangle = "Isosceles";
            return;
        } else if (Math.round(Math.pow(side3, 2)) == (Math.pow(side1, 2) + Math.pow(side2, 2))) {
            typeOfTriangle = "Right";
            return;
        } else {
            typeOfTriangle = "Random";
        }
    }
    
    public String toString() {
        return "Perimeter: " + perimeter + " Area: " + area + " Type: " + typeOfTriangle + "\n";
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

    public void calculatePerimeter() {
        perimeter = Util.round(side1 + side2 + side3);
    }
    
    public void setTypeOfTriangle(String typeOfTriangle) {
        this.typeOfTriangle = typeOfTriangle;
    }
    
    public String getTypeOfTriangle() {
        return typeOfTriangle;
    }

}
