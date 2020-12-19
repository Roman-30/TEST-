package Practik1;

public class PointFigure {
    private final double x0;
    private final double y0;
    private final String name;
    private final FigureType type = FigureType.Point;

    public PointFigure(double x0, double y0, String name) {
        this.x0 = x0;
        this.y0 = y0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FigureType getType() {
        return type;
    }

    public boolean isPointInside(double x, double y) {
        return x0 == x && y0 == y;
    }
}
