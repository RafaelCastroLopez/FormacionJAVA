package com.example.dockerize.persona.infraestructure.controller.outPut;

import com.example.dockerize.persona.application.PersonaService;
import com.example.dockerize.persona.infraestructure.controller.inPut.PersonaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonCreateController {

    @Autowired
    PersonaService personaService;

    @PostMapping("persona")
    public PersonaOutPutDto addPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception{
        return personaService.addPersona(personaInputDto);
    }
}
