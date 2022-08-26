package com.example.Perfiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@PropertySource("miconfiguracion.properties")
@RestController
public class LeerMiConfiguracionProperties implements CommandLineRunner {

    @Value("${valor1}")
    public String valor1;

    @Value("${valor2}")
    public String valor2;

    @Override
    public void run(String... arg0){
        System.out.println(valor1);
        System.out.println(valor2);
    }

    @GetMapping("miconfiguracion")
    public String leerMiConfiguracion(){
        return "El valor1 es:" + valor1 + "\n" + "El valor2 es:" + valor2;
    }


}
