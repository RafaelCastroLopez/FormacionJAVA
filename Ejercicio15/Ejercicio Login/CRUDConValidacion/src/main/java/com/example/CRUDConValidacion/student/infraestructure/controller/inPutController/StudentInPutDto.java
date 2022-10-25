package com.example.CRUDConValidacion.student.infraestructure.controller.inPutController;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.profesor.application.ProfesorService;
import com.example.CRUDConValidacion.student.domain.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class StudentInPutDto {

    public Integer id_persona;

    public int num_hours_week;

    public String coments;

    public String id_profesor;

    public String branch;

    public Student inPutToStudent() throws Exception {
        Student student = new Student();
        student.setNum_hours_week(this.getNum_hours_week());
        student.setComents(this.getComents());
        student.setBranch(this.getBranch());
        return student;
    }
}
