package com.example.mongodb.person.infraestructure.controller;

import com.example.mongodb.person.application.PersonaService;
import com.example.mongodb.person.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePersonController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("persona/{id}")
    public String deletePersona(@PathVariable String id){
        return personaService.deletePersona(id);
    }
}
