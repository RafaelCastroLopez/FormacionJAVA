package com.example.EjercicioEspecial.controller;

import com.example.EjercicioEspecial.Registro.ServiceRegistry;
import com.example.EjercicioEspecial.SerVivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("serVivo")
public class SerVivoController {

    @Autowired
    public ServiceRegistry serviceRegistry;

    @PostMapping
    public void processStudentDetail(@RequestBody SerVivo serVivo){
        serviceRegistry.getService(serVivo.getTipo()).process(serVivo);
    }
}
