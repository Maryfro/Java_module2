package com.example.demo.config;

import com.example.demo.entity.Auto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;

@Configuration
public class Config {


    //this bean will be placed into ApplicationContext and its name is opel
    @Bean
    @Qualifier("simpleAutos")
    @Order(2)
    public Auto opel(){
      return new Auto(1, "Opel", "grey",
                LocalDate.of(2015, 1, 1), 50000);
    }

    @Bean
    @Qualifier("simpleAutos")
    @Order(1)
    public Auto mazda(){
        return new Auto(2, "Mazda", "red",
                LocalDate.of(2010, 1, 1), 30000);
    }
    @Bean("tesla")
    public Auto tesla(){
        return new Auto(3, "Tesla", "black",
                LocalDate.of(2020, 1, 1), 10000);
    }

   /* @Bean
    public OrderFlow orderFlow(@Qualifier("simpleAutos")
                                           List<Auto> simpleAutos,
                               Auto tesla,
                               AutoService autoService){
        return new OrderFlow(simpleAutos, tesla, autoService);
    }*/


}
