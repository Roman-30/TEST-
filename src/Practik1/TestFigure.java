package Practik1;

public class TestFigure {
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

        if (pointFigureTest.isPointInside(casePoints[0].getX(), casePoints[0].getY()) && (pointFigureTest.getType().equals(casePoints[0].getFigure()) && (pointFigureTest.getName().equals(casePoints[0].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", pointFigureTest.getType(), pointFigureTest.getName(), casePoints[0].getFigure(), casePoints[0].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", pointFigureTest.getType(), pointFigureTest.getName(), casePoints[0].getFigure(), casePoints[0].getName(), false);
            resalt = false;
        }

        if (lineSegmentTest.isPointInside(casePoints[1].getX(), casePoints[1].getY()) && (lineSegmentTest.getType().equals(casePoints[1].getFigure()) && (lineSegmentTest.getName().equals(casePoints[1].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", lineSegmentTest.getType(), lineSegmentTest.getName(), casePoints[1].getFigure(), casePoints[1].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", lineSegmentTest.getType(), lineSegmentTest.getName(), casePoints[1].getFigure(), casePoints[1].getName(), false);
            resalt = false;
        }

        if (circleTest.isPointInside(casePoints[2].getX(), casePoints[2].getY()) && (circleTest.getType().equals(casePoints[2].getFigure()) && (circleTest.getName().equals(casePoints[2].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", circleTest.getType(), circleTest.getName(), casePoints[2].getFigure(), casePoints[2].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", circleTest.getType(), circleTest.getName(), casePoints[2].getFigure(), casePoints[2].getName(), false);
            resalt = false;
        }

        if (poligonTest.isPointInside(casePoints[3].getX(), casePoints[3].getY()) && (poligonTest.getType().equals(casePoints[3].getFigure()) && (poligonTest.getName().equals(casePoints[3].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n \n", poligonTest.getType(), poligonTest.getName(), casePoints[3].getFigure(), casePoints[3].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n \n", poligonTest.getType(), poligonTest.getName(), casePoints[3].getFigure(), casePoints[3].getName(), false);
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
}
