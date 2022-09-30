package com.example.mongodb.person.infraestructure.controller;

import com.example.mongodb.person.application.PersonaService;
import com.example.mongodb.person.infraestructure.controller.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPersonController {

    @Autowired
    PersonaService personaService;

    @GetMapping("persona/{id}")
    public PersonOutputDTO getPersonaById(@PathVariable String id){
        return personaService.getPersona(id);
    }

    @GetMapping("getAll/{page}")
    public Page<PersonOutputDTO> getAll(@PathVariable Integer page){
        return personaService.getAll(page);
    }
}
