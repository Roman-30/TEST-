package Practik1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PointFigure pointFigure = new PointFigure(readSomething("Enter coordinate X point: "), readSomething("Enter coordinate Y point: "), readName("Enter point name: "));
        LineSegment lineSegment = new LineSegment(readSomething("Enter first coordinate X line segment: "), readSomething("Enter first coordinate Y line segment: "), readSomething("Enter second coordinate X line segment: "), readSomething("Enter second coordinate X line segment: "), readName("Enter line segment name: "));
        Circle circle = new Circle(readSomething("Enter the coordinate X of the center of the circle: "), readSomething("Enter the coordinate Y of the center of the circle: "), readSomething("Enter radius of the center of the circle: "), readName("Enter circle name: "));
        Poligon poligon = new Poligon(readSomething("Enter the number of sides: "), getPoligonPoints(readSomething("Enter the number of sides: ")), readName("Enter poligon name: "));

        startProgram(pointFigure, lineSegment, circle, poligon);
    }

    private static Point[] getPoligonPoints(double n) {
        int Convex = 1;
        Point[] points = new Point[(int) n];

        for (int i = 0; i < n; i++) {
            double x = readSomething("Enter coordinate X poligon: ");
            double y = readSomething("Enter coordinate Y poligon: ");

            Point point = new Point(x, y);
            points[i] = point;
        }
        if (n == 3) {
            return points;
        } else if (n >= 4 && Poligon.definePolygon(points, (int) n, Convex) == Convex) {
            System.out.println("Polygon convex");
            return points;
        } else {
            System.out.println("Error, poligon concave! Re-enter vertex coordinates.");
            return getPoligonPoints(n);
        }
    }
  /*
    public static void setTestPoint() {
       PointFigure pointFigureTest = new PointFigure(1, 1, "Point1");
       LineSegment lineSegment1Test = new LineSegment(9, 9, 6, 6, "Line segment1");
       Circle circleTest = new Circle(-8, -8, 2, "Circle1");
       Poligon poligonTest = new Poligon(4, getTestPoligonPoints(4), "Poligon1");
    }

    public static boolean testPoint(PointFigure pointFigureTest, LineSegment lineSegmentTest, Circle circleTest, Poligon poligonTest) {
        for (int i = 0; ) {
        TestCase[] points1 = new TestCase[4];
        points1[0] = new TestCase(1, 1, Figure.Point, "Point1");
        points1[1] = new TestCase(7, 7, Figure.Line_segment, "Line segment1");
        points1[2] = new TestCase(-8, -8, Figure.Circle, "Circle1");
        points1[3] = new TestCase(1, 3, Figure.Poligon, "Poligon1");

        
            Point point = new Point(test.getX(), test.getY());

       if (pointFigureTest.isPointInside(test.getX(), test.getY())) {
       }
        }
    }

    public static Point[] getTestPoligonPoints(double n) {
        Point[] points = new Point[4];
        points[0] = new Point(0, 3);
        points[1] = new Point(0, 0);
        points[2] = new Point(3, 0);
        points[3] = new Point(3, 3);
        return points;
    }
          */
    public static void startProgram(PointFigure pointFigure, LineSegment lineSegment, Circle circle, Poligon poligon) {
        double x = readSomething("Enter coordinate X check: ");
        double y = readSomething("Enter coordinate Y check: ");

        printAnswer(x, y, pointFigure, lineSegment, circle, poligon);
    }

    public static double readSomething(String name) {
        Scanner scn = new Scanner(System.in);
        System.out.print(name);
        return scn.nextDouble();
    }

    public static String readName(String name) {
        Scanner enter = new Scanner(System.in);
        System.out.print(name);
        return enter.nextLine();
    }

    public static void printAnswer(double x, double y, PointFigure pointFigure, LineSegment lineSegment, Circle circle, Poligon poligon) {
        if (pointFigure.isPointInside(x, y)) {
            System.out.println("Type: " + Figure.Point + ", Name: " + pointFigure.getName());
        }
        if (lineSegment.isPointInside(x, y)) {
            System.out.println("Type: " + Figure.Line_segment + ", Name: " + lineSegment.getName());
        }
        if (circle.isPointInside(x, y)) {
            System.out.println("Type: " + Figure.Circle + ", Name: " + circle.getName());
        }
        if (poligon.isPointInside(x, y)) {
            System.out.println("Type: " + Figure.Poligon + ", Name: " + poligon.getName());
        }
        if (!pointFigure.isPointInside(x, y) && !lineSegment.isPointInside(x, y) && !circle.isPointInside(x, y) && !poligon.isPointInside(x, y)) {
            System.out.println("You are not in any of the figure areas");
        }
    }
}
