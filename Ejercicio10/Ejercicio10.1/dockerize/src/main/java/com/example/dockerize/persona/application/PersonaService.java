package com.example.dockerize.persona.application;

import com.example.dockerize.persona.infraestructure.controller.inPut.PersonaInputDto;
import com.example.dockerize.persona.infraestructure.controller.outPut.PersonaOutPutDto;

import java.util.List;

public interface PersonaService {

    public PersonaOutPutDto getPersona();

    public PersonaOutPutDto addPersona(PersonaInputDto personaInputDto) throws Exception;

    public PersonaOutPutDto updatePersona(PersonaInputDto personaInputDto, int id) throws Exception;

    public void deletePersonaById(int id) throws Exception;

    public PersonaOutPutDto getPersonaById(int id) throws Exception;

    public List<PersonaOutPutDto> getPersonaByName(String name);

    public List<PersonaOutPutDto> getAllPerson();

}
