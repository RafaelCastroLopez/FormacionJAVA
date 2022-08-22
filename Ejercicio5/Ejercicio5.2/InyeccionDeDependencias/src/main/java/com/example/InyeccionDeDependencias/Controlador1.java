package com.example.InyeccionDeDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;

    @GetMapping("controlador1/addPersona")
    public Persona addInfo(@RequestHeader String nombre, @RequestHeader int edad, @RequestHeader String poblacion){
        personaService.getPersona().setNombre(nombre);
        personaService.getPersona().setEdad(edad);
        personaService.getPersona().setPoblacion(poblacion);
        return personaService.getPersona();
    }

    @Autowired
    CiudadesService ciudadesService;

    @PostMapping("controlador1/addCiudad")
    public void addCiudades(@RequestHeader String nombre, @RequestHeader int habitantes){
        Ciudad ciudad = new Ciudad();
        ciudad.setNombreCiudad(nombre);
        ciudad.setNumHabitantes(habitantes);

        ciudadesService.addCiudad(ciudad);
    }



}
