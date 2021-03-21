package de.maryfro.shapeswithspring.entity;

public class Rectangle extends Shape {
    private int height;
    private int width;


    public Rectangle(char symbol, int height, int width) {
        super(symbol);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i > 0 && j > 0 && j < height && i < height - 1)
                    System.out.print(" ");
                else
                    System.out.print(symbol);

            }
            System.out.println();
        }
    }


}
