package telran.data;

public abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void printMessage() {
        System.out.println("Hello");
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return "Shape ";
    }

    public static void displayAreaOfShapes(Shape[] shapes) {
        for (Shape sh : shapes) {
            System.out.println(sh.getArea());
        }
    }

    public static Shape getMaxArea(Shape[] shapes) {
        Shape max = shapes[0];
        double maxArea = max.getArea();
        for (Shape sh : shapes) {
            double area = sh.getArea();
            if (area > maxArea) {
                max = sh;
                maxArea = area;
            }
        }
        return max;
    }

    private static int countShapesByColor(Shape[] shapes, Color color) {
        int count = 0;
        for (Shape sh : shapes) {
            if (sh.getColor().equals(color)) {
                count++;
            }
        }
        return count;
    }

    public static Shape[] getShapesByColor(Shape[] shapes, Color color) {
        Shape[] shapesByColor = new Shape[countShapesByColor(shapes, color)];
        int index = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].getColor().equals(color)) {
                shapesByColor[index] = shapes[i];
                index++;
            }
        }
        return shapesByColor;
    }

    public static Shape[] getShapesByShape(Shape[] shapes, String shape) {
        Shape[] shapesByShape = new Shape[countShapesByShape(shapes, shape)];
        int index = 0;
        for (Shape sh: shapes) {
            if(sh.getClass().getSimpleName().equalsIgnoreCase(shape.replace(" ", ""))
            || sh.getClass().getSimpleName().contains(shape)){
                shapesByShape[index] = sh;
                index++;
            }
        }
        return shapesByShape;
    }

    private static int countShapesByShape(Shape[] shapes, String shape) {
        int count = 0;
        for (Shape sh: shapes) {
            if(sh.getClass().getSimpleName().equalsIgnoreCase(shape.replace(" ", "")) ||
            sh.getClass().getSimpleName().contains(shape)){
                count++;
            }
        }
        return count;
    }


    public static void displayArr(Object[] objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}
