
public class Runner {
    public static void main(String[] args) {
        Triangle t1 = new Triangle(new Dot(1,2), new Dot(3,7), new Dot(0,9));
        t1.makeTriangle();
        t1.calculatePerimeter();
        t1.calculateArea();
        System.out.println(t1.getArea() + " " + t1.getPerimeter());
    }

}
