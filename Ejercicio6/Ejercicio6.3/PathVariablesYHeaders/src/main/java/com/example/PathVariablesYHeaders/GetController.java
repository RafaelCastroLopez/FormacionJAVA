package com.example.PathVariablesYHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class GetController {
    @Autowired
    ControladorCRUD controladorCRUD;

    @GetMapping("{id}")
    public String llamadaGetId(@PathVariable int id){
        return controladorCRUD.consultarPorID(id);
    }

    @GetMapping("nombre/{nombre}")
    public String llamadaGetNombre(@PathVariable String nombre){
        return controladorCRUD.consultarPorNombre(nombre);
    }
}
