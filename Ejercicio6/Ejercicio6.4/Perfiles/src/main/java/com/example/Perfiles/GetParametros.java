package com.example.Perfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetParametros {

    @Autowired
    Perfil perfil;

    @Value("${url}")
    public String url;

    @Value("${password}")
    public String password;

    @GetMapping("parametros")
    public String devolverParametros(){
        return "La url es:" + url + "\n" + "Y la password es:" + password;

    }

    @GetMapping("perfil")
    public String quePerfilSoy(){
        return perfil.miFuncion();
    }
}
