package com.example.Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("perfil1")
@Component
public class Perfil1 implements Perfil{

    @Override
    public String miFuncion() {
        return "hola, soy el perfil 1";
    }
}
