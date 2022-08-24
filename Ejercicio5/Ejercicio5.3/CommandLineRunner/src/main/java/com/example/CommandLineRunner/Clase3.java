package com.example.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Component
public class Clase3 implements CommandLineRunner {

    @Override
    public void run(String... arg0){
        System.out.println("Soy la tercera clase");
    }
}
