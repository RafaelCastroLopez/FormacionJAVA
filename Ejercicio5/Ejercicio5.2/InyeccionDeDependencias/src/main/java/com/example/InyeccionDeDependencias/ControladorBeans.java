package com.example.InyeccionDeDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBeans {

    @Autowired
    Persona persona1;

    @GetMapping("controlador/bean/bean1")
    @Qualifier("Bean1")
    public Persona persona1(){

        return persona1;
    }

    @Autowired
    Persona persona2;

    @GetMapping("controlador/bean/bean2")
    @Qualifier("Bean2")
    public Persona persona2(){
        persona2.setNombre("pepe");
        persona2.setEdad(50);
        persona2.setPoblacion("Bilbao");

        return persona2;
    }

    @Autowired
    Persona persona3;

    @GetMapping("controlador/bean/bean3")
    @Qualifier("Bean3")
    public Persona persona3(){
        persona3.setNombre("Lola");
        persona3.setEdad(18);
        persona3.setPoblacion("Jaen");

        return persona3;
    }
}
