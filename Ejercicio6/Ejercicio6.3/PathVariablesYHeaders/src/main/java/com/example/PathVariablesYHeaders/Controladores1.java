package com.example.PathVariablesYHeaders;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controladores1 {

    //public String template = "hola";

    @PostMapping("")
    public Greeting llamadaPost(@RequestBody Greeting greeting){
        return greeting;
    }

    @GetMapping("{id}/{nombre}")
    public Greeting llamadaGet(@PathVariable int id,@PathVariable String nombre){
        return new Greeting(id,nombre);
    }

    @PutMapping("")
    public Greeting llamadaPut(@RequestParam int id, @RequestParam String nombre){
        return new Greeting(id,nombre);
    }

}
