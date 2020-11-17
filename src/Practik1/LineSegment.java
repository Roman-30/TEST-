package Practik1;

public class LineSegment {
    public String name;
    public Figure type;
    public double x0;
    public double y0;
    public double x1;
    public double y1;

    public LineSegment(double x0, double y0, double x1, double y1, String name) {
        this.x0 = Math.min(x0, x1);
        this.y0 = Math.min(y0, y1);
        this.x1 = Math.max(x1, x0);
        this.y1 = Math.max(y1, y0);
        this.name = name;
    }

    public Figure setType() {
        return type = Figure.Line_segment;
    }

    public String getName() {
        return name;
    }

    public boolean isPointInside(double x, double y) {

        double AO = Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0));
        double AB = Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
        double AC = Math.sqrt((x1 - x) * (x1 - x) + (y1 - x) * (y1 - x));
        double dx1 = x1 - x0;
        double dy1 = y1 - y0;
        double dx = x - x0;
        double dy = y - y0;
        double S = dx1 * dy - dx * dy1;

        return (((x0 == x) && (y0 == y)) || ((x1 == x) && (y1 == y)) || ((S == 0) && (AB >= AC && AB >= AO)));
    }
}

