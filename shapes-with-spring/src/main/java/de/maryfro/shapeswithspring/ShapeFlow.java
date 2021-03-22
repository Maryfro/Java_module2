package de.maryfro.shapeswithspring;

import de.maryfro.shapeswithspring.entity.Line;
import de.maryfro.shapeswithspring.entity.Picture;
import de.maryfro.shapeswithspring.entity.Rectangle;
import de.maryfro.shapeswithspring.entity.Shape;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShapeFlow implements ApplicationRunner {
    private final List<Line> lines;
    private final Picture picture;

    public ShapeFlow(List<Line> lines, Picture picture) {
        this.lines = lines;
        this.picture = picture;
    }

    @Override
    public void run(ApplicationArguments args) {
        lines.forEach(Shape::draw);
        picture.draw();
    }
}
