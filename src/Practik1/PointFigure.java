package Practik1;

public class PointFigure {
    public double x0;
    public double y0;
    public String name;
    public Figure type;

    public PointFigure(double x0, double y0, String name) {
        this.x0 = x0;
        this.y0 = y0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Figure setType() {
        return type = Figure.Point;
    }

    public boolean isPointInside(double x, double y) {
        return x0 == x && y0 == y;
    }
}
