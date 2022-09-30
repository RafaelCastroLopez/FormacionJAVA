package com.example.mongodb.person.infraestructure.controller;

import com.example.mongodb.person.application.PersonaService;
import com.example.mongodb.person.infraestructure.controller.input.PersonInputDTO;
import com.example.mongodb.person.infraestructure.controller.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddPersonController {

    @Autowired
    PersonaService personaService;

    @PostMapping("persona")
    public PersonOutputDTO addPersona(@RequestBody PersonInputDTO personInputDTO){
        return personaService.addPersona(personInputDTO);
    }
}
