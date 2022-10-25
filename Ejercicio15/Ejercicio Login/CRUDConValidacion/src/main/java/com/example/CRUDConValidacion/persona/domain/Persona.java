package com.example.CRUDConValidacion.persona.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_persona")
    private Integer id_persona;

    String username;

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

    @Column(nullable = false)
    boolean admin;

}
