package Practik1;

public class TestCase {
    public double x;
    public double y;
    public Figure figure;
    public String name;

    public TestCase(double x, double y, Figure figure, String name) {
        this.x = x;
        this.y = y;
        this.figure = figure;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }
}
