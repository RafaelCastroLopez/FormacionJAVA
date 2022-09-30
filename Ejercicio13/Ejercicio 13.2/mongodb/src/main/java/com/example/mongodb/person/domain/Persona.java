package com.example.mongodb.person.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Persona {

    @Id
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
}
