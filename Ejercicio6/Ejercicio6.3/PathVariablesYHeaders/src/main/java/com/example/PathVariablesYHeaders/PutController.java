package com.example.PathVariablesYHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class PutController {
    @Autowired
    ControladorCRUD controladorCRUD;

    @PutMapping("{id}")
    public void llamadaPut(@PathVariable int id, @RequestBody Persona persona){
        controladorCRUD.modificarPersona(id,persona);
    }
}
