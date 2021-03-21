package com.example.demo.service;

import com.example.demo.entity.Auto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {
    //AutoGarage garage;

    public void paint(Auto auto, String color) {
        auto.setColor(color);
    }

    public void print(List<Auto> autos) {
        autos.forEach(System.out::println);
    }

    public void print(Auto auto) {
        System.out.println(auto);
    }
}
