import java.util.*;

public class MaxTrees {

    public MaxTrees() {
    }

    public static class Point {
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
            if (pointAngle < 0) {
                pointAngle = 2 * Math.PI + pointAngle;
            }
            if (pointAngle < alpha) {
                pointsAngles.add(pointAngle + 2 * Math.PI);
            }
            pointsAngles.add(pointAngle);
        }
        Collections.sort(pointsAngles);
        return maxCoveredPoints(pointsAngles, alpha);
    }

    int maxCoveredPoints(List<Double> numbers, double cut) {
        if (numbers.isEmpty() || cut == 0) {
            return 0;
        }
        ArrayDeque<Double> cutDeque = new ArrayDeque<>();
        int max = 1;
        for (Double el : numbers) {
            cutDeque.addLast(el);
            while (el - cutDeque.getFirst() > cut) {
                cutDeque.removeFirst();
            }
            if (max < cutDeque.size()) {
                max = cutDeque.size();
            }
        }
        return max;
    }


    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 0));
        points.add(new Point(-1, 0));
        points.add(new Point(0, -1));
        points.add(new Point(0, 1));
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



//new task
//Prime number is a number which can be deleted over itself or 1. *2,3,5,7,11
// write a method which finds all prime numbers from 2 to n.
// 1 is not a prime number.
// List<Integer> getPrimes(int upperBound){}

