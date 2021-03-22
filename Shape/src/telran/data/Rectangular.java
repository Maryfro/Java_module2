package telran.data;

public class Rectangular extends Shape {
    private double width;
    private double height;

    public Rectangular(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return super.toString() + "Rectangular: " + getColor() +
                ", width: " + width +
                ", height: " + height + getArea();
    }
}
