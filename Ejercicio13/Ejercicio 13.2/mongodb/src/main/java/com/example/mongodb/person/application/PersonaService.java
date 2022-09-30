package com.example.mongodb.person.application;

import com.example.mongodb.person.infraestructure.controller.input.PersonInputDTO;
import com.example.mongodb.person.infraestructure.controller.output.PersonOutputDTO;
import org.springframework.data.domain.Page;

public interface PersonaService {

    public PersonOutputDTO addPersona (PersonInputDTO personInputDTO);

    public PersonOutputDTO updatePersona (String id, PersonInputDTO personInputDTO);

    public PersonOutputDTO getPersona (String id);

    public Page<PersonOutputDTO> getAll(Integer page);

    String deletePersona (String id);
}
