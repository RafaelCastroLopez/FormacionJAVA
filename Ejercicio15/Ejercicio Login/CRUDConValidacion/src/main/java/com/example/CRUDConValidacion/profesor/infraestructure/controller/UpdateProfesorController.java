package com.example.CRUDConValidacion.profesor.infraestructure.controller;

import com.example.CRUDConValidacion.profesor.application.ProfesorService;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.inputController.ProfesorInPutDto;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController.ProfesorOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UpdateProfesorController {

    @Autowired
    ProfesorService profesorService;

    @PutMapping("profesor/{id}")
    public ProfesorOutPutDto updateProfesor(@PathVariable String id, @RequestBody ProfesorInPutDto profesorInPutDto) throws Exception {
        return profesorService.updateProfesor(id,profesorInPutDto);
    }
}
