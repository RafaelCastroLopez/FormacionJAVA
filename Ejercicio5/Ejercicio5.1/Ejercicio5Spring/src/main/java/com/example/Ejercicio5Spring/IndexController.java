package com.example.Ejercicio5Spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @GetMapping("user/{name}")
    public String holaMundoGet(@PathVariable String name){
        return "hola mundo:" + name;
    }

    @PostMapping("useradd")
    public Persona holaMundo(@RequestBody Persona persona){
        persona.setEdad(persona.getEdad()+1);
        return persona;
    }
}
