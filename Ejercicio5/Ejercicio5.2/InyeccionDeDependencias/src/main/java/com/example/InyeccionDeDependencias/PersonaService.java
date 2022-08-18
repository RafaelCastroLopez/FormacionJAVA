package com.example.InyeccionDeDependencias;

import org.springframework.context.annotation.Bean;

public interface PersonaService {

    public void addPersona(Persona p);

    public Persona getPersona();

}
