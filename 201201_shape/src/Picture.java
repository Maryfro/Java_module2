import java.util.Arrays;

public class Picture extends Shape {
    Shape[] shapes;

    public Picture(char symbol, Shape[] shapes) {
        super(symbol);
        this.shapes = shapes;
    }

    /**
     * draw all shapes
     */
    @Override
    public void draw() {
        drawBorder();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
        drawBorder();
    }

    void drawBorder() {
        for (int i = 0; i < 10; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

}
