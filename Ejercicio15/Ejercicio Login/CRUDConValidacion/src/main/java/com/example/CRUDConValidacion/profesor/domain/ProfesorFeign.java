package com.example.CRUDConValidacion.profesor.domain;


import com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController.ProfesorOutPutDto;
import feign.Param;
import feign.RequestLine;

public interface ProfesorFeign {

    @RequestLine("GET profesor/{id}")
    ProfesorOutPutDto findById(@Param("id") String id);
}
