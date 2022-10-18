package com.example.CRUDConValidacion.profesor.infraestructure.controller;

import com.example.CRUDConValidacion.profesor.application.ProfesorService;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import com.example.CRUDConValidacion.profesor.domain.ProfesorFeign;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController.ProfesorOutPutDto;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("profesor/{id}")
    public ProfesorOutPutDto getProfesor(@PathVariable String id) throws Exception {
        return profesorService.getProfesorById(id);
    }

    @GetMapping("profesor/feign/{id}")
    public ProfesorOutPutDto getProfesorFeign(@PathVariable String id){

        ProfesorFeign profesorFeign = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(Profesor.class))
                .logLevel(Logger.Level.FULL)
                .target(ProfesorFeign.class, "http://localhost:8080");

        return profesorFeign.findById(id);
    }
}
