package com.example.dockerize.persona.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue
    @Column(name = "id_persona")
    private Integer id_persona;

    String usuario;

    String password;

    String name;

    String surname;

    String company_email;

    String personal_email;

    String city;

    Boolean active;

    Date created_date;

    String imagen_url;

    Date termination_date;

}
