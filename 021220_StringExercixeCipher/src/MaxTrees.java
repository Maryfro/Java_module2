import java.util.*;

public class MaxTrees {

    public MaxTrees() {
    }

    private static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    int maxTrees(List<Point> points, double alpha) {
        if (points.isEmpty() || alpha == 0) {
            return 0;
        }
        ArrayList<Double> pointsAngles = new ArrayList<>();
        for (Point p : points) {
            double pointAngle = Math.atan2(p.y, p.x);
            pointsAngles.add(pointAngle);
        }
        Collections.sort(pointsAngles);
        System.out.println(pointsAngles);
        int max = 1;
        ArrayDeque<Double> pointsDeque = new ArrayDeque<>();
        for (Double point : pointsAngles) {
            pointsDeque.addLast(point);
            while (point - pointsDeque.getFirst() > alpha) {
                pointsDeque.removeFirst();
            }
            if (max < pointsDeque.size()) {
                max = pointsDeque.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0.5, 1.7));
        points.add(new Point(4.2, 0.2));
        points.add(new Point(1.5, 3.1));
        points.add(new Point(-8, -5));
        points.add(new Point(-10, -10));
        points.add(new Point(0.7, 17));
        double alpha = Math.PI;
        MaxTrees mt = new MaxTrees();
        System.out.println(mt.maxTrees(points, alpha));
    }
}

//We have an angle of visibility, and a forest. How many trees can we see from one point?
// We have method int maxTrees(List<Point> points, int/double(in radians) alpha)
//Class Point{
// double x;
// double y;}
//we need to transform coordinates into angle
//-> need to create a List of points from 0 to 360
//left end should come to 360-> 360 + alpha
//Math.arctn()
//tangens = y1/x1;
//Math.arctn(tangens);

