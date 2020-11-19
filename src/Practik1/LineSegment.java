package Practik1;

public class LineSegment {
    private final String name;
    private final Figure type = Figure.Line_segment;
    private final double x0;
    private final double y0;
    private final double x1;
    private final double y1;

    public LineSegment(double x0, double y0, double x1, double y1, String name) {
        this.x0 = Math.min(x0, x1);
        this.y0 = Math.min(y0, y1);
        this.x1 = Math.max(x1, x0);
        this.y1 = Math.max(y1, y0);
        this.name = name;
    }

    public Figure getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean isPointInside(double x, double y) {

        double segmentLength0 = Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0));
        double segmentLength = Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
        double segmentLength1 = Math.sqrt((x1 - x) * (x1 - x) + (y1 - x) * (y1 - x));
        double dx1 = x1 - x0;
        double dy1 = y1 - y0;
        double dx = x - x0;
        double dy = y - y0;
        double S = dx1 * dy - dx * dy1;

        return ((x0 == x) && (y0 == y)) || ((x1 == x) && (y1 == y)) || ((S == 0) && segmentLength >= segmentLength1 && segmentLength >= segmentLength0);
    }
}

