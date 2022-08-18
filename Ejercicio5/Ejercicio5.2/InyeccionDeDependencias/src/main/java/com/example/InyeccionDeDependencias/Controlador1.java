package com.example.InyeccionDeDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
    List<Ciudad> ciudades;

    @PostMapping("controlador1/addCiudad")
    public void addCiudades(){
        Ciudad ciudad1 = new Ciudad("Malaga", 571000);
        Ciudad ciudad2 = new Ciudad("Madrid", 3200000);
        Ciudad ciudad3 = new Ciudad("Alicante", 331500);

        ciudades.add(ciudad1);
        ciudades.add(ciudad2);
        ciudades.add(ciudad3);
    }



}
