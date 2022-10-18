package com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.inPut;

import com.example.CRUDConValidacion.estudiante_asignatura.domain.StudentSubject;
import lombok.Data;

import java.util.Date;

@Data
public class StudentSubjectInPutDto {

    public String id_profesor;

    public String subject;

    public String coments;

    public Date initial_date;

    public Date finish_date;

    public StudentSubject inPutToStudentSubject(){
        StudentSubject studentSubject = new StudentSubject();

        studentSubject.setSubject(this.subject);
        studentSubject.setComents(this.coments);
        studentSubject.setInitial_date(this.initial_date);
        studentSubject.setFinish_date(this.finish_date);

        return studentSubject;
    }

}
