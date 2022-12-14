package com.example.CRUDConValidacion.persona.infraestructure.controller.outPut;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonCreateController {

    @Autowired
    PersonaService personaService;

    @PostMapping("/addperson")
    @CrossOrigin
    public PersonaOutPutDto addPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception{
        return personaService.addPersona(personaInputDto);
    }
}
