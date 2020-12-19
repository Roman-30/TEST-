package Practik1;

class Pictures {
    private final Polygon polygon;
    private final PointFigure pointFigure;
    private final LineSegment lineSegment;
    private final Circle circle;

    public Pictures(Polygon polygon, PointFigure pointFigure, LineSegment lineSegment, Circle circle) {
        this.polygon = polygon;
        this.pointFigure = pointFigure;
        this.lineSegment = lineSegment;
        this.circle = circle;

    }

    public Polygon getPolygon() {
        return polygon;
    }

    public PointFigure getPointFigure() {
        return pointFigure;
    }

    public LineSegment getLineSegment() {
        return lineSegment;
    }

    public Circle getCircle() {
        return circle;
    }
}
