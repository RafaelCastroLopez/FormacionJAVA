package com.example.CRUDConValidacion.persona.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonaSearchCriteria {
    public String usuario;
    public String name;
    public String surName;
    public Date created_date;
}
