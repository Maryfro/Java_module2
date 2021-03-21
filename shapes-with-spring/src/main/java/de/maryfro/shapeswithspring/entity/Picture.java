package de.maryfro.shapeswithspring.entity;

import java.util.Arrays;

public class Picture extends Shape {
    Shape[] shapes;

    public Picture(char symbol, Shape[] shapes) {
        super(symbol);
        this.shapes = shapes;
    }


    @Override
    public void draw() {
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
    }


}
