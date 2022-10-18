package com.example.CRUDConValidacion.profesor.infraestructure.controller;

import com.example.CRUDConValidacion.profesor.application.ProfesorService;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.inputController.ProfesorInPutDto;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController.ProfesorOutPutDto;
import com.example.CRUDConValidacion.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateProfesorController {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("profesor")
    public ProfesorOutPutDto addProfesor(@RequestBody ProfesorInPutDto profesorInPutDto) throws Exception {
        return profesorService.addProfesor(profesorInPutDto);
    }
}
