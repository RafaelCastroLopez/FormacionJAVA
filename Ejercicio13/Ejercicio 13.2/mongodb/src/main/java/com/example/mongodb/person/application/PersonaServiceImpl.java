package com.example.mongodb.person.application;

import com.example.mongodb.exceptions.EntityNotFoundfException;
import com.example.mongodb.exceptions.UnprocessableEntityException;
import com.example.mongodb.person.domain.Persona;
import com.example.mongodb.person.infraestructure.controller.input.PersonInputDTO;
import com.example.mongodb.person.infraestructure.controller.output.PersonOutputDTO;
import com.example.mongodb.person.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonOutputDTO addPersona(PersonInputDTO personInputDTO) {
        personInputDTO.setCreated_date(new Date());

        if (personInputDTO.getUsername() == null)
            throw new UnprocessableEntityException("Debe poner un username");
        if (personInputDTO.getName() == null)
            throw new UnprocessableEntityException("Debe poner un name");
        if (personInputDTO.getSurname() == null)
            throw new UnprocessableEntityException("Debe poner un surname");
        if (personInputDTO.getPassword() == null)
            throw new UnprocessableEntityException("Debe poner un password");
        if (personInputDTO.getCompany_email() == null)
            throw new UnprocessableEntityException("Debe poner un Company_email");
        if (personInputDTO.getPersonal_email() == null)
            throw new UnprocessableEntityException("Debe poner un personal_email");
        if (personInputDTO.getCity() == null)
            throw new UnprocessableEntityException("Debe poner un city");
        if (personInputDTO.getCreated_date() == null)
            throw new UnprocessableEntityException("Debe poner un Created_date");

        Persona persona = personInputDTO.inputDTOtoPerson();

        personaRepository.save(persona);

        return new PersonOutputDTO(persona);
    }

    @Override
    public PersonOutputDTO updatePersona(String id, PersonInputDTO personInputDTO) {

        if (personInputDTO.getUsername() == null)
            throw new UnprocessableEntityException("Debe poner un username");
        if (personInputDTO.getName() == null)
            throw new UnprocessableEntityException("Debe poner un name");
        if (personInputDTO.getSurname() == null)
            throw new UnprocessableEntityException("Debe poner un surname");
        if (personInputDTO.getCompany_email() == null)
            throw new UnprocessableEntityException("Debe poner un Company_email");
        if (personInputDTO.getPersonal_email() == null)
            throw new UnprocessableEntityException("Debe poner un personal_email");
        if (personInputDTO.getCity() == null)
            throw new UnprocessableEntityException("Debe poner un city");

        Optional<Persona> personaOPT = personaRepository.findById(id);

        Persona persona = personaOPT.get();

        persona.setUsername(personInputDTO.getUsername());
        persona.setName(personInputDTO.getName());
        persona.setSurname(personInputDTO.getSurname());
        persona.setCompany_email(personInputDTO.getCompany_email());
        persona.setPersonal_email(personInputDTO.getPersonal_email());
        persona.setCity(personInputDTO.getCity());

        personaRepository.save(persona);

        return new PersonOutputDTO(persona);
    }

    @Override
    public PersonOutputDTO getPersona(String id) {
        Optional<Persona> personaOPT = personaRepository.findById(id);

        if(personaOPT.isEmpty())
            throw new EntityNotFoundfException("la persona no existe");

        Persona persona = personaOPT.get();

        return new PersonOutputDTO(persona);
    }

    @Override
    public Page<PersonOutputDTO> getAll(Integer page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        Pageable pageable = PageRequest.of(page, 10 , sort);

        Page<Persona> personaPage = personaRepository.findAll(pageable);
        List<PersonOutputDTO> personOutputDTOList = personaPage.stream().map(PersonOutputDTO::new).collect(Collectors.toList());

        return new PageImpl<>(personOutputDTOList, pageable, personOutputDTOList.size());
    }


    @Override
    public String deletePersona(String id) {
        Optional<Persona> personaOPT = personaRepository.findById(id);

        if(personaOPT.isEmpty())
            throw new EntityNotFoundfException("la persona no existe");

        Persona persona = personaOPT.get();

        personaRepository.delete(persona);

        return "se ha borrado la persona";
    }
}
