package com.example.CRUDConValidacion.persona.infraestructure.controller.outPut;

import com.example.CRUDConValidacion.persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutPutDto {

    public String username;

    public String name;

    public String surname;

    public String company_email;

    public String personal_email;

    public String city;

    public Boolean active;

    public Date created_date;

    public String imagen_url;

    public Date termination_date;

    public boolean admin;

    public PersonaOutPutDto(Persona persona) {

        this.username = persona.getUsername();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.company_email = persona.getCompany_email();
        this.personal_email = persona.getPersonal_email();
        this.city = persona.getCity();
        this.active = persona.getActive();
        this.created_date = persona.getCreated_date();
        this.imagen_url = persona.getImagen_url();
        this.termination_date = persona.getTermination_date();
        this.admin=persona.isAdmin();
    }

    public Persona personaOutPut (){
        Persona persona = new Persona();
        persona.setUsername(this.getUsername());
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
