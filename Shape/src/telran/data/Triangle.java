package telran.data;

public abstract class Triangle extends Shape {
    private double side;

    public Triangle(Color color, double size) {
        super(color);
        this.side = size;
    }

    public double getSide() {
        return side;
    }
}
