package com.example.CRUDConValidacion.infrestructure.repository;

import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.domain.PersonaPage;
import com.example.CRUDConValidacion.persona.domain.PersonaSearchCriteria;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaCriteriaRepository;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class personaCriteriaRepositoryTest {

    @Mock
    public PersonaRepository personaRepository;

    @InjectMocks
    PersonaCriteriaRepository personaCriteriaRepository;

    @Test
    void canFindAll(){
        PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
                "rafael", "castro",
                "rafael@gmail.com", "rafael@gmail.com", "malaga",
                true, new Date(), null, null);

        Persona persona = personaInputDto.personaInPut();

        PersonaPage personaPage = new PersonaPage(1,null);

        Date actualDate = new Date();

        PersonaSearchCriteria personaSearchCriteria = new PersonaSearchCriteria(
                "RaCasLop", "rafael", "castro", actualDate);

        Page<Persona> paginacion = personaCriteriaRepository.findAllWithFilters(personaPage,personaSearchCriteria);

        assertThat(paginacion.getTotalPages()).isEqualTo(0);

    }
}
