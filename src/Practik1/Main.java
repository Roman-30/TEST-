package Practik1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------TEST---------- \n");
        if (TestFigure.testMyFigures()) {
            System.out.println("------TEST IS DONE------ \n");

            PointFigure pointFigure = new PointFigure(readCoordinate("Enter coordinate X figure point: "), readCoordinate("Enter coordinate Y figure point: "), readName("Enter figure point name: "));
            LineSegment lineSegment = new LineSegment(readCoordinate("Enter first coordinate X line segment: "), readCoordinate("Enter first coordinate Y line segment: "), readCoordinate("Enter second coordinate X line segment: "), readCoordinate("Enter second coordinate Y line segment: "), readName("Enter line segment name: "));
            Circle circle = new Circle(readCoordinate("Enter the coordinate X of the center of the circle: "), readCoordinate("Enter the coordinate Y of the center of the circle: "), readCoordinate("Enter radius of the circle: "), readName("Enter circle name: "));
            int countOfVertices = readSomething("Enter the number of vertices: ");
            Polygon poligon = new Polygon(countOfVertices, Polygon.setPolygonPoints(countOfVertices), readName("Enter poligon name: "));

            setPointToCheck(pointFigure, lineSegment, circle, poligon);
        } else {
            System.out.println("Error. The program does not work correctly!\n");
        }
    }

    public static void setPointToCheck(PointFigure pointFigure, LineSegment lineSegment, Circle circle, Polygon poligon) {
        int restart = 1;
        while (restart == 1) {
            double x = readCoordinate("Enter X coordinate check: ");
            double y = readCoordinate("Enter Y coordinate check: ");
            System.out.println(" ");

            printAnswer(x, y, pointFigure, lineSegment, circle, poligon);

            restart = readSomething("If you wanted re-start program input '1' if you wanted finish program input '0' : ");
            System.out.println(" ");

            if (restart == 0) {
                System.out.println("Finish.");
            }
        }
    }

    public static void printAnswer(double x, double y, PointFigure pointFigure, LineSegment lineSegment, Circle circle, Polygon poligon) {
        System.out.println("You hit the figure area :");
        if (pointFigure.isPointInside(x, y)) {
            System.out.println("Type: " + pointFigure.getType() + ", Name: " + pointFigure.getName());
        }
        if (lineSegment.isPointInside(x, y)) {
            System.out.println("Type: " + lineSegment.getType() + ", Name: " + lineSegment.getName());
        }
        if (circle.isPointInside(x, y)) {
            System.out.println("Type: " + circle.getType() + ", Name: " + circle.getName());
        }
        if (poligon.isPointInside(x, y)) {
            System.out.println("Type: " + poligon.getType() + ", Name: " + poligon.getName());
        }
        if (!pointFigure.isPointInside(x, y) && !lineSegment.isPointInside(x, y) && !circle.isPointInside(x, y) && !poligon.isPointInside(x, y)) {
            System.out.println("You are not in any of the figure areas");
        }
        System.out.println(" ");
    }

    public static int readSomething(String name) {
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
}
