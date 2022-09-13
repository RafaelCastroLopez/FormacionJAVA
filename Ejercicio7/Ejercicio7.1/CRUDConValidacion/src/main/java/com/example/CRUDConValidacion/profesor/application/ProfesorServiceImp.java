package com.example.CRUDConValidacion.profesor.application;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.inputController.ProfesorInPutDto;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController.ProfesorOutPutDto;
import com.example.CRUDConValidacion.profesor.infraestructure.repository.ProfesorRepository;
import com.example.CRUDConValidacion.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorServiceImp implements ProfesorService{

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public ProfesorOutPutDto addProfesor(ProfesorInPutDto profersorInPutDto) throws Exception {

        Optional<Persona> personaOpt = personaRepository.findById(profersorInPutDto.getId_persona());

        if (personaOpt.isEmpty()){
            throw new Exception("la persona no se encuentra con este Id");
        }

        Persona persona = personaOpt.get();

        Profesor profesor = profersorInPutDto.inPutToProfesor();
        profesor.setPersona(persona);
        profesorRepository.save(profesor);

        return new ProfesorOutPutDto(profesor);
    }

    @Override
    public void deleteProfesor(String id) throws Exception {
        Optional<Profesor> profesorOpt = profesorRepository.findById(id);

        if (profesorOpt.isEmpty())
            throw new Exception("No se ha encontrado ese profesor");

        profesorRepository.deleteById(id);
    }

    @Override
    public ProfesorOutPutDto updateProfesor(String id, ProfesorInPutDto profersorInPutDto) throws Exception {
        Optional<Profesor> profesorOpt = profesorRepository.findById(id);
        Profesor profesor;

        if(profesorOpt.isEmpty())
            throw new Exception("No se ha encontrado el profesor a modificar");

        Optional<Persona> personaOpt = personaRepository.findById(profersorInPutDto.getId_persona());

        if (personaOpt.isEmpty()){
            throw new Exception("la persona no se encuentra con este Id");
        }

        Persona persona = personaOpt.get();

        profesor = profesorOpt.get();
        profesor.setPersona(persona);
        profesor.setComents(profersorInPutDto.getComents());
        profesor.setBranch(profersorInPutDto.getBranch());

        profesorRepository.save(profesor);

        return new ProfesorOutPutDto(profesor);
    }

    @Override
    public ProfesorOutPutDto getProfesorById(String id) throws Exception {

        Optional<Profesor> profesorOPT = profesorRepository.findById(id);

        if (profesorOPT.isEmpty()){
            throw new Exception("no se ha podido encontrar el profesor");
        }

        Profesor profesor = profesorOPT.get();

        return new ProfesorOutPutDto(profesor);
    }
}
