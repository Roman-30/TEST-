package Practik1;

public class TestFigure {
    public static boolean testMyFigures() {
        boolean resalt = true;

        Pictures picturesTest = new Pictures(
                new Polygon(4, setPoints(), "Poligon1"),
                new PointFigure(1, 1, "Point1"),
                new LineSegment(7, 7, 4, 4, "Line segment1"),
                new Circle(-5, -6, 2, "Circle1"));

        TestCase[] casePoints = new TestCase[4];
        casePoints[0] = new TestCase(1, 1, FigureType.Point, "Point1");
        casePoints[1] = new TestCase(7, 7, FigureType.Line_segment, "Line segment1");
        casePoints[2] = new TestCase(-5, -6, FigureType.Circle, "Circle1");
        casePoints[3] = new TestCase(-4, 0, FigureType.Polygon, "Poligon1");

        if (picturesTest.getPolygon().isPointInside(casePoints[3].getX(), casePoints[3].getY()) && (picturesTest.getPolygon().getType().equals(casePoints[3].getFigure()) && (picturesTest.getPolygon().getName().equals(casePoints[3].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", picturesTest.getPolygon().getType(), picturesTest.getPolygon().getName(), casePoints[3].getFigure(), casePoints[3].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", picturesTest.getPolygon().getType(), picturesTest.getPolygon().getName(), casePoints[3].getFigure(), casePoints[3].getName(), false);
            resalt = false;
        }

        if (picturesTest.getPointFigure().isPointInside(casePoints[0].getX(), casePoints[0].getY()) && (picturesTest.getPointFigure().getType().equals(casePoints[0].getFigure()) && (picturesTest.getPointFigure().getName().equals(casePoints[0].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", picturesTest.getPointFigure().getType(), picturesTest.getPointFigure().getName(), casePoints[0].getFigure(), casePoints[0].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", picturesTest.getPointFigure().getType(), picturesTest.getPointFigure().getName(), casePoints[0].getFigure(), casePoints[0].getName(), false);
            resalt = false;
        }

        if (picturesTest.getLineSegment().isPointInside(casePoints[1].getX(), casePoints[1].getY()) && (picturesTest.getLineSegment().getType().equals(casePoints[1].getFigure()) && (picturesTest.getLineSegment().getName().equals(casePoints[1].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", picturesTest.getLineSegment().getType(), picturesTest.getLineSegment().getName(), casePoints[1].getFigure(), casePoints[1].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n", picturesTest.getLineSegment().getType(), picturesTest.getLineSegment().getName(), casePoints[1].getFigure(), casePoints[1].getName(), false);
            resalt = false;
        }

        if (picturesTest.getCircle().isPointInside(casePoints[2].getX(), casePoints[2].getY()) && (picturesTest.getCircle().getType().equals(casePoints[2].getFigure()) && (picturesTest.getCircle().getName().equals(casePoints[2].getName())))) {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n \n", picturesTest.getCircle().getType(), picturesTest.getCircle().getName(), casePoints[2].getFigure(), casePoints[2].getName(), true);
        } else {
            System.out.printf("Expected type %1S and name %2S --> got type %3S name %4S %5S \n \n", picturesTest.getCircle().getType(), picturesTest.getCircle().getName(), casePoints[2].getFigure(), casePoints[2].getName(), false);
            resalt = false;
        }
        return resalt;
    }

    public static Point[] setPoints() {
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, -4);
        points[2] = new Point(-4, -4);
        points[3] = new Point(-4, 0);
        return points;
    }
}
