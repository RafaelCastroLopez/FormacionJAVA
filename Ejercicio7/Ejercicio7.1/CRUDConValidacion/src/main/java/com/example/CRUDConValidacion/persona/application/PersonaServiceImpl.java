package com.example.CRUDConValidacion.persona.application;

import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import com.example.CRUDConValidacion.persona.infraestructure.controller.outPut.PersonaOutPutDto;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{

    PersonaInputDto personaInputDto = new PersonaInputDto();

    PersonaOutPutDto personaOutPutDto;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutPutDto getPersona() {
        return personaOutPutDto;
    }

    @Override
    public PersonaOutPutDto addPersona(PersonaInputDto personaInputDto) throws Exception {
        personaInputDto.setCreated_date(new Date());

        if (personaInputDto.getUsuario()==null){
            throw new Exception("el usuario no puede ser nulo");
        }
        if (personaInputDto.getUsuario().length()>10){
            throw new Exception("no puede tener mas de 10 caracteres");
        }
        if (personaInputDto.getUsuario().length()<6){
            throw new Exception("no puede tener menos de 6 caracteres");
        }
        if (personaInputDto.getPassword()==null){
            throw new Exception("la contraseña no puede ser vacia");
        }
        if(personaInputDto.getName()==null){
            throw new Exception("no puede ser null el nombre");
        }
        if (personaInputDto.getCompany_email()==null){
            throw new Exception("no puede ser null el email de compañia");
        }
        if (!personaInputDto.getCompany_email().contains("@")){
            throw new Exception("debe de ser un email");
        }
        if (personaInputDto.getPersonal_email()==null){
            throw  new Exception("no puede ser null el email personal");
        }
        if (!personaInputDto.getPersonal_email().contains("@")){
            throw new Exception("debe de ser un email");
        }
        if(personaInputDto.getCity()==null){
            throw new Exception("por favor introduzca una ciudad");
        }
        if (personaInputDto.getActive()==null){
            throw new Exception("introduzca un valor");
        }

        Persona persona = personaInputDto.personaInPut();

        personaRepository.save(persona);

        return new PersonaOutPutDto(persona);

    }

    @Override
    public PersonaOutPutDto updatePersona(PersonaInputDto personaInputDto, int id) throws Exception {
        Optional<Persona> personaOpt = personaRepository.findById(id);
        Persona persona;

        if(personaOpt.isEmpty()){
           throw new Exception("esta mal");
        }

        persona = personaOpt.get();
        persona.setUsuario(personaInputDto.getUsuario());
        persona.setPassword(personaInputDto.getPassword());
        persona.setName(personaInputDto.getName());
        persona.setSurname(personaInputDto.getSurname());
        persona.setCompany_email(personaInputDto.getCompany_email());
        persona.setPersonal_email(personaInputDto.getPersonal_email());
        persona.setCity(personaInputDto.getCity());
        persona.setActive(personaInputDto.getActive());
        persona.setCreated_date(personaInputDto.getCreated_date());
        persona.setImagen_url(personaInputDto.getImagen_url());

        personaRepository.save(persona);

        return new PersonaOutPutDto(persona);
    }

    @Override
    public void deletePersonaById(int id) {

        personaRepository.deleteById(id);

    }

    @Override
    public PersonaOutPutDto getPersonaById(int id) {
        Optional<Persona> personaOpt = personaRepository.findById(id);
        Persona persona = personaOpt.get();

        return new PersonaOutPutDto(persona);
    }

    @Override
    public List<PersonaOutPutDto> getPersonaByName(String name) {
        List<Persona> personas = personaRepository.findByName(name);
        List<PersonaOutPutDto> personasOutPutDto;

        personasOutPutDto = personas.stream().map(persona -> new PersonaOutPutDto(persona)).collect(Collectors.toList());

        return personasOutPutDto;
    }

    @Override
    public List<PersonaOutPutDto> getAllPerson(){
        List<Persona> personas = personaRepository.findAll();
        List<PersonaOutPutDto> personasOutPutDto;

        personasOutPutDto = personas.stream().map(persona -> new PersonaOutPutDto(persona)).collect(Collectors.toList());

        return personasOutPutDto;
    }
}
