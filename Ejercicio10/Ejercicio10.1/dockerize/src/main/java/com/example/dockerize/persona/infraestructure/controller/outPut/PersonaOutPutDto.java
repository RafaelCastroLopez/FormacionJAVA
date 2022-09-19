package com.example.dockerize.persona.infraestructure.controller.outPut;

import com.example.dockerize.persona.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutPutDto {
    public String usuario;

    public String name;

    public String surname;

    public String company_email;

    public String personal_email;

    public String city;

    public Boolean active;

    public Date created_date;

    public String imagen_url;

    public Date termination_date;

    public PersonaOutPutDto(Persona persona) {
        this.usuario = persona.getUsuario();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.company_email = persona.getCompany_email();
        this.personal_email = persona.getPersonal_email();
        this.city = persona.getCity();
        this.active = persona.getActive();
        this.created_date = persona.getCreated_date();
        this.imagen_url = persona.getImagen_url();
        this.termination_date = persona.getTermination_date();
    }

    public Persona personaOutPut (){
        Persona persona = new Persona();
        persona.setUsuario(this.getUsuario());
        persona.setName(this.getName());
        persona.setSurname(this.getSurname());
        persona.setCompany_email(this.getCompany_email());
        persona.setPersonal_email(this.getPersonal_email());
        persona.setCity(this.getCity());
        persona.setActive(this.getActive());
        persona.setCreated_date(this.getCreated_date());
        persona.setImagen_url(this.getImagen_url());
        persona.setTermination_date(this.getTermination_date());
        return persona;
    }

}
