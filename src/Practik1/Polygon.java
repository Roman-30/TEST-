package Practik1;

public class Polygon {
    public int n;
    public String name;
    public Figure type;
    public Point[] points;

    public Polygon(int n, Point[] points, String name) {
        this.n = n;
        this.points = points;
        this.name = name;
    }

    public static boolean definePolygon(Point[] points, int n) {
        int negative = 0;
        int positive = 0;

        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            int k = (i + 2) % n;
            double z = (points[j].x - points[i].x) * (points[k].y - points[j].y) - (points[j].y - points[i].y) * (points[k].x - points[j].x);
            if (z < 0) {
                negative += 1;
            } else if (z > 0) {
                positive += 1;
            }
        }
        return (negative == n) || (positive == n);
    }

    public String getName() {
        return name;
    }

    public Figure setType() {
        return type = Figure.Polygon;
    }

    public boolean isPointInside(double x, double y) {
        int resalt = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            int k = (i + 2) % n;
            double z1 = (points[i].x - x) * (points[j].y - points[i].y) - (points[j].x - points[i].x) * (points[i].y - y);
            double z2 = (points[j].x - x) * (points[k].y - points[j].y) - (points[k].x - points[j].x) * (points[j].y - y);
            double z3 = (points[k].x - x) * (points[i].y - points[k].y) - (points[i].x - points[k].x) * (points[k].y - y);

            if (condition(z1, z2, z3)) {
                resalt += 0;
            } else {
                resalt += 1;
            }
        }
        return resalt != n;
    }

    public boolean condition(double z1, double z2, double z3) {
        return (z1 > 0 && z2 > 0 && z3 > 0) ||
                (z1 < 0 && z2 < 0 && z3 < 0) ||
                (z1 == 0 || z2 == 0 || z3 == 0);

    }
}
