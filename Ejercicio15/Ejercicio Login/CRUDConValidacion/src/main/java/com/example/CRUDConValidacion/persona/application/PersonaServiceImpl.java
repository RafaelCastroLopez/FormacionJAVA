package com.example.CRUDConValidacion.persona.application;

import com.example.CRUDConValidacion.exceptions.EntityNotFoundException;
import com.example.CRUDConValidacion.exceptions.UnprocessableEntityException;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.domain.PersonaPage;
import com.example.CRUDConValidacion.persona.domain.PersonaSearchCriteria;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import com.example.CRUDConValidacion.persona.infraestructure.controller.outPut.PersonaOutPutDto;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaCriteriaRepository;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService, UserDetailsService {

    PersonaInputDto personaInputDto;

    PersonaOutPutDto personaOutPutDto;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    PersonaCriteriaRepository personaCriteriaRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public PersonaOutPutDto getPersona() {
        return personaOutPutDto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Persona persona = personaRepository.findByUsername(username).get(0);

        if(persona == null){
            throw new UsernameNotFoundException("La persona no existe");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if(persona.isAdmin())
            authorities.add(new SimpleGrantedAuthority("admin"));
        else
            authorities.add(new SimpleGrantedAuthority("user"));

        return new org.springframework.security.core.userdetails.User(persona.getUsername(), persona.getPassword(), authorities);
    }

    @Override
    public PersonaOutPutDto addPersona(PersonaInputDto personaInputDto) throws Exception {
        personaInputDto.setCreated_date(new Date());

        if (personaInputDto.getUsername()==null){
            throw new UnprocessableEntityException("el usuario no puede ser nulo", 422);
        }
        if (personaInputDto.getUsername().length()>10){
            throw new UnprocessableEntityException("no puede tener mas de 10 caracteres", 422);
        }
        if (personaInputDto.getUsername().length()<6){
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
        persona.setPassword(passwordEncoder.encode(persona.getPassword()));

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

        if (personaInputDto.getUsername()==null){
            throw new UnprocessableEntityException("el usuario no puede ser nulo", 422);
        }
        if (personaInputDto.getUsername().length()>10){
            throw new UnprocessableEntityException("no puede tener mas de 10 caracteres", 422);
        }
        if (personaInputDto.getUsername().length()<6){
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
        persona.setUsername(personaInputDto.getUsername());
        persona.setPassword(passwordEncoder.encode(personaInputDto.getPassword()));
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

    @Override
    public Page<PersonaOutPutDto> getPersonasCriteria(PersonaPage personaPage, PersonaSearchCriteria personaSearchCriteria){

        Page<Persona> pagePersona = personaCriteriaRepository.findAllWithFilters(personaPage, personaSearchCriteria);
        List<PersonaOutPutDto> listPersonaCriteria = pagePersona.getContent().stream().map(PersonaOutPutDto::new).collect(Collectors.toList());

        return new PageImpl<>(listPersonaCriteria, pagePersona.getPageable(), pagePersona.getTotalElements());
    }

}
