package com.example.InyeccionDeDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    Persona persona = new Persona();

    @Override
    public void addPersona(Persona p) {
        persona = p;
    }

    @Override
    public Persona getPersona() {
        return persona;
    }

}
