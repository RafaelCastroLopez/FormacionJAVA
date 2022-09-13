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

    @GetMapping("persona/{id}")
    public PersonaOutPutDto getPersonaById(@PathVariable int id) throws Exception {
        return personaService.getPersonaById(id);
    }

    @GetMapping("persona/name/{name}")
    public List<PersonaOutPutDto> getPersonaByName(@PathVariable String name){
        return personaService.getPersonaByName(name);
    }

    @GetMapping("persona/todos")
    public List<PersonaOutPutDto> getAll(){
        return personaService.getAllPerson();
    }
}
