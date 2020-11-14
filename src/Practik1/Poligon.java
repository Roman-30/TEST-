package Practik1;

public class Poligon {
    public double n;
    public String name;
    Point[] points;

    public Poligon(double n, Point[] points, String name) {
        this.n = n;
        this.points = points;
        this.name = name;
    }

    public static int definePolygon(Point[] points, int n, int Convex) {
        int Concave = 0;
        int value = 0;

        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            int k = (i + 2) % n;
            double z = (points[j].x - points[i].x) * (points[k].y - points[j].y);
            z -= (points[j].y - points[i].y) * (points[k].x - points[j].x);
            if (z < 0) {
                value |= 1;
            } else if (z > 0) {
                value |= 2;
            }
            if (value == 3)
                return (Concave);
        }
        if (value != 0) {
            return (Convex);
        } else {
            return (Concave);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isPointInside(double x, double y) {
        int f = (int) n;
        int resalt = 0;
        for (int i = 0; i < f; i++) {
            int j = (i + 1) % f;
            int k = (i + 2) % f;
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
