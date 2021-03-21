package de.maryfro.shapeswithspring;

import de.maryfro.shapeswithspring.entity.Line;
import de.maryfro.shapeswithspring.entity.Picture;
import de.maryfro.shapeswithspring.entity.Rectangle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShapeFlow implements ApplicationRunner {
    Line line;
    List<Line> lines;
    Rectangle rectangle;
    List<Rectangle> rectangles;
    Picture picture;

    public ShapeFlow(Line line, Rectangle rectangle, Picture picture,
                     @Qualifier("lines") List<Line> lines,
                     @Qualifier("rectangles") List<Rectangle> rectangles) {
        this.line = line;
        this.rectangle = rectangle;
        this.picture = picture;
        this.lines = lines;
        this.rectangles = rectangles;

    }

    @Override
    public void run(ApplicationArguments args) {
        for (int i = 0; i < 2; i++) { // one line is already in the list
            lines.add(line);
        }
            rectangles.add(rectangle);

        for (Line line : lines) {
            line.draw();
        }
        picture.draw();
    }
}
