package Practik1;

public class Circle {
    private final double x0;
    private final double y0;
    private final double radius;
    private final String name;
    private final FigureType type = FigureType.Circle;

    public Circle(double x0, double y0, double radius, String name) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = Math.abs(radius);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FigureType getType() {
        return type;
    }

    public boolean isPointInside(double x, double y) {
        double dx = x - x0;
        double dy = y - y0;
        double distance = Math.hypot(dx, dy);  //Math.sqrt(dx * dx + dy * dy);

        return distance <= radius;
    }
}

