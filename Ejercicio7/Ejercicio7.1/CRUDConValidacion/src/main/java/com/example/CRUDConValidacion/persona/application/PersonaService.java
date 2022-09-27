package com.example.CRUDConValidacion.persona.application;

import com.example.CRUDConValidacion.exceptions.EntityNotFoundException;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.domain.PersonaPage;
import com.example.CRUDConValidacion.persona.domain.PersonaSearchCriteria;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import com.example.CRUDConValidacion.persona.infraestructure.controller.outPut.PersonaOutPutDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonaService {

    public PersonaOutPutDto getPersona();

    public PersonaOutPutDto addPersona(PersonaInputDto personaInputDto) throws Exception;

    public PersonaOutPutDto updatePersona(PersonaInputDto personaInputDto, int id) throws Exception;

    public void deletePersonaById(int id) throws Exception;

    public PersonaOutPutDto getPersonaById(int id) throws Exception;

    public List<PersonaOutPutDto> getPersonaByName(String name);

    public List<PersonaOutPutDto> getAllPerson();

    public Page<PersonaOutPutDto> getPersonasCriteria(PersonaPage personaPage, PersonaSearchCriteria personaSearchCriteria);

}
