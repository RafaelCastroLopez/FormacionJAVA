package com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.outPut;

import com.example.CRUDConValidacion.estudiante_asignatura.domain.StudentSubject;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController.ProfesorOutPutDto;
import com.example.CRUDConValidacion.student.infraestructure.controller.outPutController.StudentOutPutDto;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentSubjectOutPutDto {

    public String id_subject;

    public ProfesorOutPutDto profesor;

    public String subject;

    public String coments;

    public Date initial_date;

    public Date finish_date;

    public List<StudentOutPutDto> studentsList;

    public StudentSubjectOutPutDto (StudentSubject studentSubject){
        setId_subject(studentSubject.getId_subject());
        setProfesor(new ProfesorOutPutDto(studentSubject.getProfesor()));
        setSubject(studentSubject.getSubject());
        setComents(studentSubject.getComents());
        setInitial_date(studentSubject.getInitial_date());
        setFinish_date(studentSubject.getFinish_date());

        List<StudentOutPutDto> studentList = studentSubject.getStudents() != null ? studentSubject.getStudents().stream().map(StudentOutPutDto::new).collect(Collectors.toList()):null;
        setStudentsList(studentList);
    }
}
