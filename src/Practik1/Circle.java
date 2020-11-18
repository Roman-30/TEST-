package Practik1;

public class Circle {
    public double x0;
    public double y0;
    public double radius;
    public String name;
    public Figure type;

    public Circle(double x0, double y0, double radius, String name) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = Math.abs(radius);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Figure setType() {
        return type = Figure.Circle;
    }

    public boolean isPointInside(double x, double y) {
        double dx = x - x0;
        double dy = y - y0;
        double distance = Math.hypot(dx, dy);  //Math.sqrt(dx * dx + dy * dy);

        return distance <= radius;
    }
}

