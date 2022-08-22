package com.example.InyeccionDeDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador2 {

    @Autowired
    PersonaService personaService;

    @GetMapping("controlador2/getPersona")
    public Persona ImprimirMultiplicacion(){
        personaService.getPersona().setEdad(personaService.getPersona().getEdad() * 2);
        return personaService.getPersona();
    }

    @Autowired
    CiudadesService ciudadesService;

    @GetMapping("controlador2/getCiudad")
    public List<Ciudad> getCiudades(){
        return ciudadesService.getCiudad();
    }
}
