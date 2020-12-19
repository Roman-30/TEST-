package Practik1;

public class Polygon {
    private final int num;
    private final String name;
    private final FigureType type = FigureType.Polygon;
    private final Point[] points;

    public Polygon(int n, Point[] points, String name) {
        this.num = n;
        this.points = points;
        this.name = name;
    }

    public static Point[] setPolygonPoints(int n) {
        int f = 0;
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {

            f++;
            double x0 = Main.readCoordinate("Enter " + f + " coordinate X poligon: ");
            double y0 = Main.readCoordinate("Enter " + f + " coordinate Y poligon: ");

            Point point = new Point(x0, y0);
            points[i] = point;
        }

        if (n == 3) {
            return points;
        } else if (n >= 4 && definePolygon(points, n)) {
            System.out.println("Polygon convex");
            return points;
        } else {
            System.out.println("Error, poligon concave! Re-enter vertex coordinates.");
            return setPolygonPoints(n);
        }
    }

    public static boolean definePolygon(Point[] points, int n) {
        int negative = 0;
        int positive = 0;

        for (int i = 0; i < n; i++) {
            int s = (i + 1) % n;
            int t = (i + 2) % n;
            double z = (points[s].getX() - points[i].getX()) * (points[t].getY() - points[s].getY()) - (points[s].getY() - points[i].getY()) * (points[t].getX() - points[s].getX());
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

    public FigureType getType() {
        return type;
    }

    public boolean isPointInside(double x, double y) {
        int resalt = 0;
        int digit = 0;
        for (int i = 0; i < num; i++) {
            int s = (i + 1) % num;
            int t = (i + 2) % num;
            double z1 = (points[i].getX() - x) * (points[s].getY() - points[i].getY()) - (points[s].getX() - points[i].getX()) * (points[i].getY() - y);
            double z2 = (points[s].getX() - x) * (points[t].getY() - points[s].getY()) - (points[t].getX() - points[s].getX()) * (points[s].getY() - y);
            double z3 = (points[t].getX() - x) * (points[i].getY() - points[t].getY()) - (points[i].getX() - points[t].getX()) * (points[t].getY() - y);

            if (checkCondition(x, y, z1, z2, z3, i, s, t)) {
                resalt += 0;
                digit += 1;
            } else {
                resalt += 1;
                digit += 0;
            }
        }
        return (resalt != num) || (digit > 0);
    }

    public boolean checkCondition(double x, double y, double z1, double z2, double z3, int i, int j, int k) {
        return (z1 > 0 && z2 > 0 && z3 > 0) ||
                (z1 < 0 && z2 < 0 && z3 < 0) ||
                (z1 == 0 && z2 == 0 && z3 == 0) ||
                (z1 == 0 && z2 > 0 && z3 > 0) ||
                (z1 > 0 && z2 == 0 && z3 > 0) ||
                (z1 > 0 && z2 > 0 && z3 == 0) ||
                (z1 == 0 && z2 < 0 && z3 < 0) ||
                (z1 < 0 && z2 == 0 && z3 < 0) ||
                (z1 < 0 && z2 < 0 && z3 == 0) ||
                (points[i].getX() == x && points[i].getY() == y) ||
                (points[j].getX() == x && points[j].getY() == y) ||
                (points[k].getX() == x && points[k].getY() == y);
    }
}
