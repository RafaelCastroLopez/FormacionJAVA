package com.example.mongodb.person.infraestructure.controller.output;

import com.example.mongodb.person.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputDTO {
    public String idPerson;
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

    public PersonOutputDTO(Persona persona){
        this.idPerson = persona.getIdPerson();
        this.username = persona.getUsername();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.password = persona.getPassword();
        this.company_email = persona.getCompany_email();
        this.personal_email = persona.getPersonal_email();
        this.city = persona.getCity();
        this.active = persona.getActive();
        this.created_date = persona.getCreated_date();
        this.termination_date = persona.getTermination_date();
        this.image_url = persona.getImage_url();
    }
}
