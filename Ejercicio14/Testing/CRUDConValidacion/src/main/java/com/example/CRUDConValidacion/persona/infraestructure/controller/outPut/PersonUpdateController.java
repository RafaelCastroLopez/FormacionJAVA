package com.example.CRUDConValidacion.persona.infraestructure.controller.outPut;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonUpdateController {

    @Autowired
    PersonaService personaService;

    @PutMapping("{id}")
    public PersonaOutPutDto updatePerson(@PathVariable int id, @RequestBody PersonaInputDto personaInputDto) throws Exception {
        return personaService.updatePersona(personaInputDto, id);
    }
}
