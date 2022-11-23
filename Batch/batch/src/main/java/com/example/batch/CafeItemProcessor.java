package com.example.batch;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class CafeItemProcessor implements ItemProcessor<Cafe, Cafe> {

    @Override
    public Cafe process(Cafe cafe) throws Exception {
        Cafe cafe1 = new Cafe();
        cafe1.setNombre(cafe.getNombre().toUpperCase());
        cafe1.setOrigen(cafe.getOrigen().toUpperCase());
        cafe1.setCaracteristica(cafe.getCaracteristica().toUpperCase());
        System.out.println("hola desde ItemProcessor");
        return cafe1;
    }
}
