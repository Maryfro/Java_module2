package telran.app;

import telran.data.*;

public class App {
    public static void main(String[] args) {
        Shape shape = new Circle(Color.BLACK, 2.5);
        Circle circle1 = new Circle(Color.BLUE, 5.5);
        Shape square = new Square(Color.BLUE, 3);
        ((Square) square).changeColor(Color.YELLOW);

        Circle circle2 = new Circle(Color.GREEN, 2.2);
        Square square1 = new Square(Color.RED, 7.5);
        Square square2 = new Square(Color.BLUE, 10);
        Rectangular rect1 = new Rectangular(Color.RED, 12, 3);
        Rectangular rect2 = new Rectangular(Color.YELLOW, 3, 5.5);
        Triangle triangle1 = new RightTriangle(Color.GREEN, 3, 4);
        Triangle triangle2 = new EquilateralTriangle(Color.BLACK, 5);
        RightTriangle triangle3 = new RightTriangle(Color.BLUE, 7, 3);
        EquilateralTriangle triangle4 = new EquilateralTriangle(Color.GREEN, 4.25);

        Shape[] shapes = {shape, circle1, circle2, square, square1, square2, rect1, rect2, triangle1,
                triangle2, triangle3, triangle4};
        Shape.displayAreaOfShapes(shapes);
        System.out.println(Shape.getMaxArea(shapes));
        System.out.println("-------------------");
        Shape.displayArr(Shape.getShapesByColor(shapes, Color.GREEN));
        System.out.println("-------------------");
        Shape.displayArr(Shape.getShapesByShape(shapes, "rectangular"));
        System.out.println("-------------------");
        Shape.displayArr(Shape.getShapesByShape(shapes, "Circle"));
        System.out.println("-------------------");
        Shape.displayArr(Shape.getShapesByShape(shapes, "right triangle"));
        System.out.println("-------------------");
        Shape.displayArr(Shape.getShapesByShape(shapes, "Triangle"));

    }

}
