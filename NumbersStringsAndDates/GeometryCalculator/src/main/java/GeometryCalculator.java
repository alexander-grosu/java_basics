public class GeometryCalculator {
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(Math.abs(radius), 2);
    }

    public static double getSphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(Math.abs(radius), 3);
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        return ((a + b) > c && (a + c) > b && (b + c) > a && a > 0 && b > 0 && c > 0);
    }

    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c))
            return Math.sqrt(((a + b + c) / 2) * (((a + b + c) / 2) - a) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - c));
        else return -1;
    }
}
