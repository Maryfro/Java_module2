package de.maryfro.shapeswithspring.config;

import de.maryfro.shapeswithspring.entity.Line;
import de.maryfro.shapeswithspring.entity.Picture;
import de.maryfro.shapeswithspring.entity.Rectangle;
import de.maryfro.shapeswithspring.entity.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    final static char SYMBOL = '+';
    final static int LENGTH = 6;

    @Bean
    @Qualifier("lines")
    public Line line() {
        return new Line(SYMBOL, LENGTH);
    }


    @Bean
    @Qualifier("rectangles")
    public Rectangle rectangle() {
        return new Rectangle(SYMBOL, 5, LENGTH);
    }

    @Bean
    public Picture picture() {
        return new Picture(SYMBOL, new Shape[]{line(), line(), rectangle()});
    }
}
