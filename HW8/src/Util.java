import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {

    public static double drawSide(Dot d1, Dot d2) {
        double side;
        side = Math.sqrt(Math.pow(d1.getX() - d2.getX(), 2) + Math.pow(d1.getY() - d2.getY(), 2));
        return side;
    }

    public static double[] sortByAscend(double side1, double side2, double side3) {
        double[] ascendingArray = { side1, side2, side3 };
        double temp;
        for (int i = 0; i < ascendingArray.length; i++) {
            for (int j = ascendingArray.length - 1; j > i; j--) {
                if (ascendingArray[j - 1] > ascendingArray[j]) {
                    temp = ascendingArray[j - 1];
                    ascendingArray[j - 1] = ascendingArray[j];
                    ascendingArray[j] = temp;
                }
            }
        }
        return ascendingArray;
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
