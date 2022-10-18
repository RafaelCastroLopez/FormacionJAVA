package com.example.CRUDConValidacion.persona.infraestructure.controller.inPut;

import com.example.CRUDConValidacion.persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonaInputDto {

    public String usuario;

    public String password;

    public String name;

    public String surname;

    public String company_email;

    public String personal_email;

    public String city;

    public Boolean active;

    public Date created_date;

    public String imagen_url;

    public Date termination_date;

    public Persona personaInPut (){
        Persona persona = new Persona();
        persona.setUsuario(this.getUsuario());
        persona.setPassword(this.getPassword());
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
