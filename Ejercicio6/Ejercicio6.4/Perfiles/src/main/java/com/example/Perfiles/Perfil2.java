package com.example.Perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("perfil2")
@Component
public class Perfil2 implements Perfil{

    @Override
    public String miFuncion() {
        return "hola, soy el perfil 2";
    }
}
