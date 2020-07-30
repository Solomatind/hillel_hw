import java.text.DecimalFormat;

public class Triangle {
    
    private Dot d1;
    private Dot d2;
    private Dot d3;
    private double side1;
    private double side2;
    private double side3;
    private double perimeter;
    private double area;
    
    Triangle(Dot d1, Dot d2, Dot d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
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
    
    public void makeTriangle() {
      side1 = Math.sqrt(Math.pow(d1.getX() - d2.getX(), 2) + Math.pow(d1.getY() - d2.getY(), 2));
      side2 = Math.sqrt(Math.pow(d2.getX() - d3.getX(), 2) + Math.pow(d2.getY() - d3.getY(), 2)); 
      side3 = Math.sqrt(Math.pow(d1.getX() - d3.getX(), 2) + Math.pow(d1.getY() - d3.getY(), 2)); 
    }
    
    public void calculatePerimeter() {
        perimeter = side1 + side2 + side3;
        new DecimalFormat("####.##").format(perimeter);
    }
    
    public void calculateArea() {
        double halfPerimeter = perimeter / 2;
        area = Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) *
                        (halfPerimeter - side3));
        new DecimalFormat("####.##").format(area);
    }

}
