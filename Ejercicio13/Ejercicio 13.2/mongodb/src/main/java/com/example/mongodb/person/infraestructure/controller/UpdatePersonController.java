package com.example.mongodb.person.infraestructure.controller;

import com.example.mongodb.person.application.PersonaService;
import com.example.mongodb.person.infraestructure.controller.input.PersonInputDTO;
import com.example.mongodb.person.infraestructure.controller.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePersonController {

    @Autowired
    PersonaService personaService;

    @PutMapping("persona/{id}")
    public PersonOutputDTO updatePersona(@PathVariable String id, @RequestBody PersonInputDTO personInputDTO){
        return personaService.updatePersona(id, personInputDTO);
    }
}
