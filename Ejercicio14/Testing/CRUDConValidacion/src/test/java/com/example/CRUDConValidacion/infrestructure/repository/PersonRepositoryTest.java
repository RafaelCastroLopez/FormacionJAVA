package com.example.CRUDConValidacion.infrestructure.repository;

import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    public PersonaRepository personaRepository;

    @AfterEach
    void tearDown(){
        personaRepository.deleteAll();
    }

    @Test
    void itShouldFindByUsername(){
        PersonaInputDto personaInputDto = new PersonaInputDto(null, "hola",
                "rafael", "castro",
                "rafael@gmail.com", "rafael@gmail.com", "malaga",
                true, new Date(), null, null);

        Persona persona = personaInputDto.personaInPut();

        personaRepository.save(persona);

        List<Persona> listaPersona = personaRepository.findByName("rafael");

        assertThat(listaPersona.size()).isEqualTo(1);
    }

    @Test
    void isShouldNotFindAnyByUsername(){
        List<Persona> listaPersona = personaRepository.findByName("rafael");

        assertThat(listaPersona.size()).isEqualTo(0);
    }
}
