package com.example.CRUDConValidacion.persona.infraestructure.controller.outPut;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import com.example.CRUDConValidacion.persona.domain.PersonaPage;
import com.example.CRUDConValidacion.persona.domain.PersonaSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PersonFindController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona/{id}")
    public PersonaOutPutDto getPersonaById(@PathVariable int id) throws Exception {
        return personaService.getPersonaById(id);
    }

    @GetMapping("/persona/name/{name}")
    public List<PersonaOutPutDto> getPersonaByName(@PathVariable String name){
        return personaService.getPersonaByName(name);
    }

    @GetMapping("/getall")
    @CrossOrigin
    public List<PersonaOutPutDto> getAll(){
        return personaService.getAllPerson();
    }

    @GetMapping("/criteria")
    public Page<PersonaOutPutDto> getCriteriaPerson (@RequestParam(required = false) String usuario,
                                                     @RequestParam(required = false) String name,
                                                     @RequestParam(required = false) String surname,
                                                     @RequestParam(required = false) Date created_date,
                                                     @RequestParam(required = false) String sortBy,
                                                     @RequestParam Integer page){
        return personaService.getPersonasCriteria(new PersonaPage(page, sortBy),
                new PersonaSearchCriteria(usuario, name, surname, created_date));
    }
}
