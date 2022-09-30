package com.example.mongodb.person.infraestructure.controller.input;

import com.example.mongodb.person.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonInputDTO {

    public String username;
    public String name;
    public String surname;
    public String password;
    public String company_email;
    public String personal_email;
    public String city;
    public Boolean active;
    public Date created_date;
    public Date termination_date;
    public String image_url;

    public Persona inputDTOtoPerson(){
        Persona persona = new Persona();
        persona.setUsername(this.username);
        persona.setName(this.name);
        persona.setPassword(this.password);
        persona.setSurname(this.surname);
        persona.setCompany_email(this.company_email);
        persona.setPersonal_email(this.personal_email);
        persona.setCity(this.city);
        persona.setActive(this.active);
        persona.setCreated_date(this.created_date);
        persona.setTermination_date(this.termination_date);
        persona.setImage_url(this.image_url);

        return persona;
    }
}
