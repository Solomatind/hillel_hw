import java.util.Arrays;

public class Processor {

    Triangle[] triangles;

    public Processor(Triangle[] triangles) {
        this.triangles = triangles;
    }

    public Triangle[] groupTrianglesByType(String type) {
        Triangle[] findedTriangles = {};
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].getTypeOfTriangle() == type) {
                findedTriangles = extendArray(triangles[i], findedTriangles);
            }
        }
        return findedTriangles;
    }

    private Triangle[] extendArray(Triangle findedTriangle, Triangle[] coppiedArray) {
        if (coppiedArray.length == 0) {
            return new Triangle[] { findedTriangle };
        } else {
            Triangle[] extendedArray = new Triangle[coppiedArray.length + 1];
            for (int i = 0; i < coppiedArray.length; i++) {
                extendedArray[i] = coppiedArray[i];
            }
            extendedArray[coppiedArray.length] = findedTriangle;
            return extendedArray;
        }
    }

    public void showCountOfTrianglesEachType(Triangle[][] trianglesByType) {
        for (int i = 0; i < trianglesByType.length; i++) {
            int temp = 0;
            for (int j = 0; j < trianglesByType[i].length; j++) {
                temp = j;
            }
            System.out.print("Count of " + trianglesByType[i][temp].getTypeOfTriangle() + " = " + (temp + 1) + " ");
        }
        System.out.println();
    }

    public void showBiggestAndFewestTrianglesByPerimeterAndArea(Triangle[][] trianglesByType) {
        Triangle biggestTrianglesByPerimeter[] = new Triangle[4];
        Triangle fewestTrianglesByPerimeter[] = new Triangle[4];
        Triangle biggestTrianglesByArea[] = new Triangle[4];
        Triangle fewestTrianglesByArea[] = new Triangle[4];
        for (int i = 0; i < trianglesByType.length; i++) {
            biggestTrianglesByPerimeter[i] = Util.findBiggestPerimeter(trianglesByType[i]);
            fewestTrianglesByPerimeter[i] = Util.findFewestPerimeter(trianglesByType[i]);
            biggestTrianglesByArea[i] = Util.findBiggestArea(trianglesByType[i]);
            fewestTrianglesByArea[i] = Util.findFewestArea(trianglesByType[i]);
        }
        System.out.println("Biggest triangles by perimeter:\n" + Arrays.toString(biggestTrianglesByPerimeter));
        System.out.println("Fewest triangles by perimeter:\n" + Arrays.toString(fewestTrianglesByPerimeter));
        System.out.println("Biggest triangles by area:\n" + Arrays.toString(biggestTrianglesByArea));
        System.out.println("Fewest triangles by area:\n" + Arrays.toString(fewestTrianglesByArea));
    }

}
