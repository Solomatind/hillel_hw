import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {

    public static double drawSide(Dot d1, Dot d2) {
        double side;
        side = Math.sqrt(Math.pow(d1.getX() - d2.getX(), 2) + Math.pow(d1.getY() - d2.getY(), 2));
        return side;
    }

    public static double[] sortByAscend(double ...sides) {
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

    public static double round(double value) {
        BigDecimal result = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        return value = result.doubleValue();
    }

    public static Triangle findBiggestPerimeter(Triangle[] trianglesByType) {
        double max = Double.MIN_VALUE;
        Triangle res = null;
        for (Triangle triangle : trianglesByType) {
            if (triangle.getPerimeter() > max) {
                max = triangle.getPerimeter();
                res = triangle;
            }
        }
        return res;
    }

    public static Triangle findFewestPerimeter(Triangle[] trianglesByType) {
        double min = Double.MAX_VALUE;
        Triangle res = null;
        for (Triangle triangle : trianglesByType) {
            if (triangle.getPerimeter() < min) {
                min = triangle.getPerimeter();
                res = triangle;
            }
        }
        return res;
    }

    public static Triangle findBiggestArea(Triangle[] trianglesByType) {
        double max = Double.MIN_VALUE;
        Triangle res = null;
        for (Triangle triangle : trianglesByType) {
            if (triangle.getArea() > max) {
                max = triangle.getArea();
                res = triangle;
            }
        }
        return res;
    }

    public static Triangle findFewestArea(Triangle[] trianglesByType) {
        double min = Double.MAX_VALUE;
        Triangle res = null;
        for (Triangle triangle : trianglesByType) {
            if (triangle.getArea() < min) {
                min = triangle.getArea();
                res = triangle;
            }
        }
        return res;
    }

}
