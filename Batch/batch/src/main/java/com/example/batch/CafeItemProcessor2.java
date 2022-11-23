package com.example.batch;

import org.springframework.batch.item.ItemProcessor;

public class CafeItemProcessor2 implements ItemProcessor<Cafe, Cafe> {
    @Override
    public Cafe process(Cafe cafe) throws Exception {
        Cafe cafe1 = new Cafe();
        cafe1.setNombre(cafe.getNombre().toLowerCase());
        cafe1.setOrigen(cafe.getOrigen().toLowerCase());
        cafe1.setCaracteristica(cafe.getCaracteristica().toLowerCase());
        System.out.println("hola desde ItemProcessor2");
        return cafe1;
    }
}

