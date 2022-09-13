package com.example.CRUDConValidacion.profesor.infraestructure.controller.inputController;

import com.example.CRUDConValidacion.persona.application.PersonaService;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ProfesorInPutDto {

    public Integer id_persona;
    public String coments;
    public String branch;

    public Profesor inPutToProfesor() throws Exception {
        Profesor profesor=new Profesor();
        profesor.setComents(this.getComents());
        profesor.setBranch(this.getBranch());

        return profesor;
    }
}
