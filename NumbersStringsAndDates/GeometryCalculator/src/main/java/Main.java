public class Main {
    public static void main(String[] args) {
        /* triangle square */
        boolean isPossible = GeometryCalculator.isTrianglePossible(5.0, 7.0, 9.0);
        if (isPossible) {
            double triangleSquare = GeometryCalculator.getTriangleSquare(5.0, 7.0, 9.0);
            System.out.println("triangle square = " + Math.ceil(triangleSquare));
        } else {
            System.out.println("triangle is impossible");
        }
        /* circle square , sphere volume */
        double radius = 17.0;
        double circleSquare = GeometryCalculator.getCircleSquare(radius);
        System.out.println("circle square = " + Math.ceil(circleSquare));
        double sphereVolume = GeometryCalculator.getSphereVolume(radius);
        System.out.println("sphere volume = " + Math.ceil(sphereVolume));
    }
}
