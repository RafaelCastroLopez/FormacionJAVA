package com.example.CRUDConValidacion.persona.application;

import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import com.example.CRUDConValidacion.persona.infraestructure.controller.outPut.PersonaOutPutDto;

import java.util.List;

public interface PersonaService {

    public PersonaOutPutDto getPersona();

    public PersonaOutPutDto addPersona(PersonaInputDto personaInputDto) throws Exception;

    public PersonaOutPutDto updatePersona(PersonaInputDto personaInputDto, int id) throws Exception;

    public void deletePersonaById(int id);

    public PersonaOutPutDto getPersonaById(int id);

    public List<PersonaOutPutDto> getPersonaByName(String name);

    public List<PersonaOutPutDto> getAllPerson();

}
