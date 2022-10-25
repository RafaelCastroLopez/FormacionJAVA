package com.example.CRUDConValidacion;

import com.example.CRUDConValidacion.exceptions.EntityNotFoundException;
import com.example.CRUDConValidacion.exceptions.UnprocessableEntityException;
import com.example.CRUDConValidacion.persona.application.PersonaService;
import com.example.CRUDConValidacion.persona.application.PersonaServiceImpl;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.domain.PersonaPage;
import com.example.CRUDConValidacion.persona.domain.PersonaSearchCriteria;
import com.example.CRUDConValidacion.persona.infraestructure.controller.inPut.PersonaInputDto;
import com.example.CRUDConValidacion.persona.infraestructure.controller.outPut.PersonaOutPutDto;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaCriteriaRepository;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import com.example.CRUDConValidacion.profesor.application.ProfesorService;
import com.example.CRUDConValidacion.profesor.application.ProfesorServiceImp;
import com.example.CRUDConValidacion.profesor.infraestructure.repository.ProfesorRepository;
import com.example.CRUDConValidacion.student.infraestructure.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@SpringBootTest
class CrudConValidacionApplicationTests {

	@InjectMocks
	PersonaService personaService = new PersonaServiceImpl();

	@Mock
	PersonaRepository personaRepository;

	@Mock
	ProfesorRepository profesorRepository;

	@Mock
	StudentRepository studentRepository;

	@Mock
	PersonaCriteriaRepository personaCriteriaRepository;

	PersonaInputDto personaInputDto = null;

	@Test
	void addPersona() throws Exception {
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "malaga",
				true, new Date(), null, null);

		PersonaOutPutDto personaOutPutDto= personaService.addPersona(personaInputDto);

		assertThat(personaOutPutDto).isNotNull();
	}

	@Test
	void cantAddWithNullName() throws Exception {
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				null, "castro",
				"rafael@gmail.com", "rafael@gmail.com", "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithNullPass(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", null,
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithNullUsername(){
		PersonaInputDto personaInputDto = new PersonaInputDto(null, "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithLongUser(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLopalkjf", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithShortUser(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaC", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithNullComEmail(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				null, "rafael@gmail.com", "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithNullPerEmail(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", null, "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithBadFormatCompEmail(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafaelgmail.com", "rafael@gmail.com", "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithBadFormatPersEmail(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafaelgmail.com", "malaga",
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithNullCity(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", null,
				true, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canNotAddWithNullActive(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				null, new Date(), null, null);

		Persona persona = personaInputDto.personaInPut();

		assertThrows(UnprocessableEntityException.class, ()->personaService.addPersona(personaInputDto));

		verify(personaRepository, never()).save(persona);
	}

	@Test
	void canFindById() throws Exception {
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Integer id = 1;

		Persona persona = personaInputDto.personaInPut();

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaService.getPersonaById(id);

		verify(personaRepository).findById(id);
	}

	@Test
	void canNotFindById(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Integer id = 1;

		Persona persona = personaInputDto.personaInPut();

		given(personaRepository.findById(id)).willReturn(Optional.empty());

		assertThrows(EntityNotFoundException.class, ()->personaService.getPersonaById(id));
	}

	@Test
	void canFindPersonByUsername(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		String name = "rafael";
		Persona persona = personaInputDto.personaInPut();

		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(persona);

		given(personaRepository.findByName(name)).willReturn(listaPersonas);

		personaService.getPersonaByName(name);

		verify(personaRepository).findByName(name);
	}

	@Test
	void canGetAllPerson(){
		personaService.getAllPerson();

		verify(personaRepository).findAll();
	}

	@Test
	void canUpdatePerson() throws Exception {
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Integer id = 1;
		Persona persona = personaInputDto.personaInPut();


		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setUsuario("TheSlump");
		personaInputDto.setName("paco");
		personaInputDto.setCity("sevilla");

		Persona personaActualizada = personaInputDto.personaInPut();

		PersonaOutPutDto personaEsperada = new PersonaOutPutDto(personaActualizada);

		PersonaOutPutDto personaDevuelta = personaService.updatePersona(personaInputDto, id);

		assertThat(personaDevuelta.getUsuario()).isEqualTo(personaEsperada.getUsuario());
		assertThat(personaDevuelta.getName()).isEqualTo(personaEsperada.getName());
		assertThat(personaDevuelta.getCity()).isEqualTo(personaEsperada.getCity());
	}

	@Test
	void canNotUpdateThatNotExistPerson(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();
		Integer id = 1;

		given(personaRepository.findById(id)).willReturn(Optional.empty());

		personaInputDto.setName("paco");
		personaInputDto.setSurname("TheSlump");
		personaInputDto.setCity("Sevilla");

		assertThrows(EntityNotFoundException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullUsername(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setUsuario(null);

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullName(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setName(null);

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullPassword(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setPassword(null);

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullShortUsername(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setUsuario("RaC");

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullLongUsername(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setUsuario("RaCasLopezJfñkajhfaf");

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullComEmail(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setCompany_email(null);

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithBadFormatComEmail(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setCompany_email("companyemail.com");

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullPerEmail(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setPersonal_email(null);

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithBadFormatPersEmail(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setPersonal_email("personalEmail.com");

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullCity(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setCity(null);

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canNotUpdateWithNullActive(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();

		int id= 1;

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));

		personaInputDto.setActive(null);

		assertThrows(UnprocessableEntityException.class, ()->personaService.updatePersona(personaInputDto, id));

		verify(personaRepository, never()).save(personaInputDto.personaInPut());
	}

	@Test
	void canDeletePersona() throws Exception {
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Integer id = 1;
		Persona persona = personaInputDto.personaInPut();

		given(personaRepository.findById(id)).willReturn(Optional.of(persona));
		//willDoNothing().given(personaRepository).delete(persona);

		personaService.deletePersonaById(id);

		verify(personaRepository, times(1)).deleteById(id);
	}

	@Test
	void canNotDeleteNotExistingPerson(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();
		Integer id = 1;

		given(personaRepository.findById(id)).willReturn(Optional.empty());

		assertThrows(EntityNotFoundException.class, ()->personaService.deletePersonaById(id));

		verify(personaRepository, never()).delete(persona);
	}

	@Test
	void canGetData(){
		PersonaInputDto personaInputDto = new PersonaInputDto("RaCasLop", "hola",
				"rafael", "castro",
				"rafael@gmail.com", "rafael@gmail.com", "Malaga",
				true, new Date(), null, null);
		Persona persona = personaInputDto.personaInPut();
		Date actualDate = new Date();

		PersonaPage personaPage = new PersonaPage(0, "Usuario");
		PersonaSearchCriteria personaSearchCriteria = new PersonaSearchCriteria("RaCasLop", "rafael",
				"castro", actualDate);

		Sort sort = Sort.by(personaPage.getSortDirection(), personaPage.getSortBy());
		Pageable pageable = PageRequest.of(personaPage.getPageNumber(), personaPage.getPageSize(), sort);

		List<Persona> listaPersona = new ArrayList<>();
		listaPersona.add(persona);

		given(personaCriteriaRepository.findAllWithFilters(personaPage,personaSearchCriteria)).willReturn(new PageImpl<>(
				listaPersona, pageable, 1
		));

		List<PersonaOutPutDto> listaOutPutDTO = listaPersona.stream().map(PersonaOutPutDto::new).collect(Collectors.toList());
		Page<PersonaOutPutDto> expectedPersonOutputDTOPage = new PageImpl<>(listaOutPutDTO, pageable, 1);

		Page<PersonaOutPutDto> returnedPersonOutPutDTOPage = personaService.getPersonasCriteria(personaPage, personaSearchCriteria);

		assertThat(returnedPersonOutPutDTOPage.getContent()).isEqualTo(expectedPersonOutputDTOPage.getContent());
	}


}
