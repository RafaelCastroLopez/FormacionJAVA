package com.example.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Order(1)
@Component
public class Clase2 implements CommandLineRunner {

    @Override
    public void run(String... arg0){
        System.out.println("Hola desde clase secundaria");
    }

}
