package com.example.CRUDConValidacion.persona.application;

import com.example.CRUDConValidacion.exceptions.EntityNotFoundException;
import com.example.CRUDConValidacion.exceptions.UnprocessableEntityException;
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
            throw new UnprocessableEntityException("el usuario no puede ser nulo", 422);
        }
        if (personaInputDto.getUsuario().length()>10){
            throw new UnprocessableEntityException("no puede tener mas de 10 caracteres", 422);
        }
        if (personaInputDto.getUsuario().length()<6){
            throw new UnprocessableEntityException("no puede tener menos de 6 caracteres", 422);
        }
        if (personaInputDto.getPassword()==null){
            throw new UnprocessableEntityException("la contraseña no puede ser vacia", 422);
        }
        if(personaInputDto.getName()==null){
            throw new UnprocessableEntityException("no puede ser null el nombre", 422);
        }
        if (personaInputDto.getCompany_email()==null){
            throw new UnprocessableEntityException("no puede ser null el email de compañia", 422);
        }
        if (!personaInputDto.getCompany_email().contains("@")){
            throw new UnprocessableEntityException("debe de ser un email", 422);
        }
        if (personaInputDto.getPersonal_email()==null){
            throw  new UnprocessableEntityException("no puede ser null el email personal", 422);
        }
        if (!personaInputDto.getPersonal_email().contains("@")){
            throw new UnprocessableEntityException("debe de ser un email", 422);
        }
        if(personaInputDto.getCity()==null){
            throw new UnprocessableEntityException("por favor introduzca una ciudad", 422);
        }
        if (personaInputDto.getActive()==null){
            throw new UnprocessableEntityException("introduzca un valor", 422);
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
           throw new EntityNotFoundException("No se ha encontrado el registro", 404);
        }

        personaInputDto.setCreated_date(new Date());

        if (personaInputDto.getUsuario()==null){
            throw new UnprocessableEntityException("el usuario no puede ser nulo", 422);
        }
        if (personaInputDto.getUsuario().length()>10){
            throw new UnprocessableEntityException("no puede tener mas de 10 caracteres", 422);
        }
        if (personaInputDto.getUsuario().length()<6){
            throw new UnprocessableEntityException("no puede tener menos de 6 caracteres", 422);
        }
        if (personaInputDto.getPassword()==null){
            throw new UnprocessableEntityException("la contraseña no puede ser vacia", 422);
        }
        if(personaInputDto.getName()==null){
            throw new UnprocessableEntityException("no puede ser null el nombre", 422);
        }
        if (personaInputDto.getCompany_email()==null){
            throw new UnprocessableEntityException("no puede ser null el email de compañia", 422);
        }
        if (!personaInputDto.getCompany_email().contains("@")){
            throw new UnprocessableEntityException("debe de ser un email", 422);
        }
        if (personaInputDto.getPersonal_email()==null){
            throw  new UnprocessableEntityException("no puede ser null el email personal", 422);
        }
        if (!personaInputDto.getPersonal_email().contains("@")){
            throw new UnprocessableEntityException("debe de ser un email", 422);
        }
        if(personaInputDto.getCity()==null){
            throw new UnprocessableEntityException("por favor introduzca una ciudad", 422);
        }
        if (personaInputDto.getActive()==null){
            throw new UnprocessableEntityException("introduzca un valor", 422);
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
    public void deletePersonaById(int id) throws Exception {

        Optional<Persona> personaOpt = personaRepository.findById(id);

        if(personaOpt.isEmpty()){
            throw new EntityNotFoundException("no se ha encontrado la persona ha eliminar", 404);
        }

        personaRepository.deleteById(id);

    }

    @Override
    public PersonaOutPutDto getPersonaById(int id) throws Exception {
        Optional<Persona> personaOpt = personaRepository.findById(id);

        if(personaOpt.isEmpty()){
            throw new EntityNotFoundException("no se encontro la persona", 404);
        }

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
