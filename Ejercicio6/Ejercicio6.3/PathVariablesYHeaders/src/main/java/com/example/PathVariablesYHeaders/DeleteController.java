package com.example.PathVariablesYHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class DeleteController {
    @Autowired
    ControladorCRUD controladorCRUD;

    @DeleteMapping("{id}")
    public void llamadaDelete(@PathVariable int id){
        controladorCRUD.deletePersona(id);
    }
}
