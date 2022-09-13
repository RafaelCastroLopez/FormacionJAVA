package com.example.CRUDConValidacion.student.infraestructure.controller.outPutController;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.infraestructure.controller.outPut.PersonaOutPutDto;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController.ProfesorOutPutDto;
import com.example.CRUDConValidacion.student.domain.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Data
public class StudentOutPutDto {

    public PersonaOutPutDto persona;
    public int num_hours_week;
    public String coments;
    public ProfesorOutPutDto profesor;
    public String branch;

    public StudentOutPutDto(Student student){
        this.persona=(new PersonaOutPutDto(student.getPersona()));
        this.num_hours_week=student.getNum_hours_week();
        this.coments=student.getComents();
        this.profesor=(new ProfesorOutPutDto(student.getProfesor()));
        this.branch=student.getBranch();
    }

}
