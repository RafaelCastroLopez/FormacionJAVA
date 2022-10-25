package com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController;

import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorOutPutDto {

    public Persona persona;

    public String coments;

    public String branch;

    public ProfesorOutPutDto (Profesor profesor){
        this.persona=profesor.getPersona();
        this.branch=profesor.getBranch();
        this.coments=profesor.getComents();
    }

    public Profesor outPutProfesor(){
        Profesor profesor = new Profesor();

        profesor.setPersona(this.getPersona());
        profesor.setComents(this.getComents());
        profesor.setBranch(this.getBranch());

        return profesor;
    }
}
