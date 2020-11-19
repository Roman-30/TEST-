package Practik1;

public class TestCase {
    private final double x;
    private final double y;
    private final Figure figure;
    private final String name;

    public TestCase(double x, double y, Figure figure, String name) {
        this.x = x;
        this.y = y;
        this.figure = figure;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }
}
