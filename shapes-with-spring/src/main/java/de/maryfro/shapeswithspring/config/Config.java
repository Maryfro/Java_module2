package de.maryfro.shapeswithspring.config;

import de.maryfro.shapeswithspring.entity.Line;
import de.maryfro.shapeswithspring.entity.Picture;
import de.maryfro.shapeswithspring.entity.Rectangle;
import de.maryfro.shapeswithspring.entity.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class Config {
    final static char SYMBOL = '+';
    final static int LENGTH = 6;

    @Bean
    public Line line() {
        return new Line(SYMBOL, LENGTH);
    }
    @Bean
    @Qualifier("picture")
    @Order(2)
    public Line line1() {
        return new Line('?', LENGTH);
    }
    @Bean
    @Qualifier("picture")
    @Order(1)
    public Line line2() {
        return new Line('<', LENGTH);
    }


    @Bean
    @Qualifier("picture")
    @Order(3)
    public Rectangle rectangle() {
        return new Rectangle(SYMBOL, 5, LENGTH);
    }

    @Bean
    public Rectangle rectangle1() {
        return new Rectangle('#', 5, LENGTH);
    }

    @Bean
    public Picture picture(@Qualifier ("picture") Shape[] shapes) {
        return new Picture(SYMBOL, shapes);
    }
}
