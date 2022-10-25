package com.example.CRUDConValidacion.profesor.infraestructure.controller;

import com.example.CRUDConValidacion.profesor.application.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProfesorController {

    @Autowired
    ProfesorService profesorService;

    @DeleteMapping("profesor/{id}")
    public void deleteProfesor(@PathVariable String id) throws Exception {
        profesorService.deleteProfesor(id);
    }
}
