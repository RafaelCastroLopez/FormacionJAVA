package com.example.CommandLineRunner;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClaseInicial {
    @PostConstruct
    public void run(){
        System.out.println("Hola desde la clase Inicial");
    }
}
