package Practik1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------TEST----------");
        if (testMyFigures()) {

            PointFigure pointFigure = new PointFigure(readCoordinate("Enter coordinate X point: "), readCoordinate("Enter coordinate Y point: "), readName("Enter point name: "));
            LineSegment lineSegment = new LineSegment(readCoordinate("Enter first coordinate X line segment: "), readCoordinate("Enter first coordinate Y line segment: "), readCoordinate("Enter second coordinate X line segment: "), readCoordinate("Enter second coordinate X line segment: "), readName("Enter line segment name: "));
            Circle circle = new Circle(readCoordinate("Enter the coordinate X of the center of the circle: "), readCoordinate("Enter the coordinate Y of the center of the circle: "), readCoordinate("Enter radius of the circle: "), readName("Enter circle name: "));
            Polygon poligon = new Polygon(readTheNumberVertices("Enter the number of vertices: "), getPoligonPoints(readTheNumberVertices("Enter the number of vertices: ")), readName("Enter poligon name: "));

            startProgram(pointFigure, lineSegment, circle, poligon);
        } else {
            System.out.println("Error. The program does not work correctly!\n");
        }
    }

    private static Point[] getPoligonPoints(int n) {
        int f = 0;
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {

            f++;
            double x = readCoordinate("Enter " + f + " coordinate X poligon: ");
            double y = readCoordinate("Enter " + f + " coordinate Y poligon: ");

            Point point = new Point(x, y);
            points[i] = point;
        }
        if (n == 3) {
            return points;
        } else if (n >= 4 && Polygon.definePolygon(points, n)) {
            System.out.println("Polygon convex");
            return points;
        } else {
            System.out.println("Error, poligon concave! Re-enter vertex coordinates.");
            return getPoligonPoints(n);
        }
    }

    public static boolean testMyFigures() {
        boolean resalt = true;

        PointFigure pointFigureTest = new PointFigure(1, 1, "Point1");
        LineSegment lineSegmentTest = new LineSegment(7, 7, 4, 4, "Line segment1");
        Circle circleTest = new Circle(-5, -6, 2, "Circle1");
        Polygon poligonTest = new Polygon(4, getPoints(), "Poligon1");

        TestCase[] casePoints = new TestCase[4];
        casePoints[0] = new TestCase(1, 1, Figure.Point, "Point1");
        casePoints[1] = new TestCase(7, 7, Figure.Line_segment, "Line segment1");
        casePoints[2] = new TestCase(-5, -6, Figure.Circle, "Circle1");
        casePoints[3] = new TestCase(-4, 0, Figure.Polygon, "Poligon1");

        if (pointFigureTest.isPointInside(casePoints[0].x, casePoints[0].y) && (pointFigureTest.setType().equals(casePoints[0].getFigure()) && (pointFigureTest.getName().equals(casePoints[0].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", pointFigureTest.setType(), pointFigureTest.getName(), casePoints[0].getFigure(), casePoints[0].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", pointFigureTest.setType(), pointFigureTest.getName(), casePoints[0].getFigure(), casePoints[0].getName(), false);
            resalt = false;
        }

        if (lineSegmentTest.isPointInside(casePoints[1].x, casePoints[1].y) && (lineSegmentTest.setType().equals(casePoints[1].getFigure()) && (lineSegmentTest.getName().equals(casePoints[1].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", lineSegmentTest.setType(), lineSegmentTest.getName(), casePoints[1].getFigure(), casePoints[1].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", lineSegmentTest.setType(), lineSegmentTest.getName(), casePoints[1].getFigure(), casePoints[1].getName(), false);
            resalt = false;
        }

        if (circleTest.isPointInside(casePoints[2].x, casePoints[2].y) && (circleTest.setType().equals(casePoints[2].getFigure()) && (circleTest.getName().equals(casePoints[2].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", circleTest.setType(), circleTest.getName(), casePoints[2].getFigure(), casePoints[2].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", circleTest.setType(), circleTest.getName(), casePoints[2].getFigure(), casePoints[2].getName(), false);
            resalt = false;
        }

        if (poligonTest.isPointInside(casePoints[3].x, casePoints[3].y) && (poligonTest.setType().equals(casePoints[3].getFigure()) && (poligonTest.getName().equals(casePoints[3].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n \n", poligonTest.setType(), poligonTest.getName(), casePoints[3].getFigure(), casePoints[3].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", poligonTest.setType(), poligonTest.getName(), casePoints[3].getFigure(), casePoints[3].getName(), false);
            resalt = false;
        }

        return resalt;
    }

    public static Point[] getPoints() {
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, -4);
        points[2] = new Point(-4, -4);
        points[3] = new Point(-4, 0);
        return points;
    }

    public static void startProgram(PointFigure pointFigure, LineSegment lineSegment, Circle circle, Polygon poligon) {
        double x = readCoordinate("Enter coordinate X check: ");
        double y = readCoordinate("Enter coordinate Y check: ");

        printAnswer(x, y, pointFigure, lineSegment, circle, poligon);
    }

    public static int readTheNumberVertices(String name) {
        Scanner scn3 = new Scanner(System.in);
        System.out.print(name);
        return scn3.nextInt();
    }

    public static double readCoordinate(String name) {
        Scanner scn2 = new Scanner(System.in);
        System.out.print(name);
        return scn2.nextDouble();
    }

    public static String readName(String name) {
        Scanner scn1 = new Scanner(System.in);
        System.out.print(name);
        return scn1.nextLine();
    }

    public static void printAnswer(double x, double y, PointFigure pointFigure, LineSegment lineSegment, Circle circle, Polygon poligon) {
        if (pointFigure.isPointInside(x, y)) {
            System.out.println("Type: " + pointFigure.setType() + ", Name: " + pointFigure.getName());
        }
        if (lineSegment.isPointInside(x, y)) {
            System.out.println("Type: " + lineSegment.setType() + ", Name: " + lineSegment.getName());
        }
        if (circle.isPointInside(x, y)) {
            System.out.println("Type: " + circle.setType() + ", Name: " + circle.getName());
        }
        if (poligon.isPointInside(x, y)) {
            System.out.println("Type: " + poligon.setType() + ", Name: " + poligon.getName());
        }
        if (!pointFigure.isPointInside(x, y) && !lineSegment.isPointInside(x, y) && !circle.isPointInside(x, y) && !poligon.isPointInside(x, y)) {
            System.out.println("You are not in any of the figure areas");
        }
    }
}
