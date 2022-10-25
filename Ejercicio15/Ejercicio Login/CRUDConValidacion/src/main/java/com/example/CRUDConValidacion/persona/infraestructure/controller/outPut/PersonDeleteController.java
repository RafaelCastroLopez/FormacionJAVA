package com.example.CRUDConValidacion.persona.infraestructure.controller.outPut;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonDeleteController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) throws Exception{
        personaService.deletePersonaById(id);
    }
}
