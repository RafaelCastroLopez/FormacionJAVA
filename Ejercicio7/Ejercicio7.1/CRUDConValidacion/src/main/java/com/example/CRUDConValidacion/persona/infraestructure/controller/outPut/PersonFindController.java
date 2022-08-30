package com.example.CRUDConValidacion.persona.infraestructure.controller.outPut;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonFindController {

    @Autowired
    PersonaService personaService;

    @GetMapping("{id}")
    public PersonaOutPutDto getPersonaById(@PathVariable int id){
        return personaService.getPersonaById(id);
    }

    @GetMapping("/name/{name}")
    public List<PersonaOutPutDto> getPersonaByName(@PathVariable String name){
        return personaService.getPersonaByName(name);
    }

    @GetMapping("/todos")
    public List<PersonaOutPutDto> getAll(){
        return personaService.getAllPerson();
    }
}
