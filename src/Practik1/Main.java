package Practik1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------TEST---------- \n");
        if (TestFigure.testMyFigures()) {
            System.out.println("------TEST IS DONE------ \n");
            int vertex = readSomething("Enter the number of vertices of the polygon: ");
            Pictures pictures = new Pictures(
                    new Polygon(vertex, Polygon.setPolygonPoints(vertex), readName("Enter poligon name: ")),
                    new PointFigure(readCoordinate("Enter coordinate X figure point: "), readCoordinate("Enter coordinate Y figure point: "), readName("Enter figure point name: ")),
                    new LineSegment(readCoordinate("Enter first coordinate X line segment: "), readCoordinate("Enter first coordinate Y line segment: "), readCoordinate("Enter second coordinate X line segment: "), readCoordinate("Enter second coordinate Y line segment: "), readName("Enter line segment name: ")),
                    new Circle(readCoordinate("Enter the coordinate X of the center of the circle: "), readCoordinate("Enter the coordinate Y of the center of the circle: "), readCoordinate("Enter radius of the circle: "), readName("Enter circle name: ")));

            setPointToCheck(pictures);
        } else {
            System.out.println("Error. The program does not work correctly!\n");
        }
    }

    public static void setPointToCheck(Pictures pictures) {
        int restart = 1;
        while (restart == 1) {
            double x = readCoordinate("Enter X coordinate check: ");
            double y = readCoordinate("Enter Y coordinate check: ");
            System.out.println(" ");

            printAnswer(x, y, pictures);

            restart = readSomething("If you wanted re-start program input '1' if you wanted finish program input '0' : ");
            System.out.println(" ");

            if (restart == 0) {
                System.out.println("Finish.");
            }
        }
    }

    public static void printAnswer(double x, double y, Pictures pictures) {
        System.out.println("You hit the figure area :");
        if (pictures.getPolygon().isPointInside(x, y)) {
            System.out.printf("Type: %s, Name: %s. \n", pictures.getPolygon().getType(), pictures.getPolygon().getName());
        }
        if (pictures.getPointFigure().isPointInside(x, y)) {
            System.out.printf("Type: %s, Name: %s. \n", pictures.getPointFigure().getType(), pictures.getPointFigure().getName());
        }
        if (pictures.getLineSegment().isPointInside(x, y)) {
            System.out.printf("Type: %s, Name: %s. \n", pictures.getLineSegment().getType(), pictures.getLineSegment().getName());
        }
        if (pictures.getCircle().isPointInside(x, y)) {
            System.out.printf("Type: %s, Name: %s. \n", pictures.getCircle().getType(), pictures.getCircle().getName());
        }
        if (!pictures.getPointFigure().isPointInside(x, y) && !pictures.getLineSegment().isPointInside(x, y) && !pictures.getCircle().isPointInside(x, y) && !pictures.getPolygon().isPointInside(x, y)) {
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
