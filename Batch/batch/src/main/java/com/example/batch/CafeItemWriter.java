package com.example.batch;


import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class CafeItemWriter implements ItemWriter<Cafe> {

    public CafeRepository cafeRepository;

    public CafeItemWriter(CafeRepository cafeRepository){
        this.cafeRepository = cafeRepository;
    }

    @Override
    public void write(List<? extends Cafe> list) throws Exception {
        list.forEach(cafe -> {cafeRepository.save(cafe);});
    }
}
