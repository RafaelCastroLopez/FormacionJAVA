package com.example.PathVariablesYHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PostController {

    @Autowired
    ControladorCRUD controladorCRUD;

    @PostMapping("")
    public void llamadaPost(@RequestBody Persona persona){
        controladorCRUD.addPersona(persona);
    }
}
