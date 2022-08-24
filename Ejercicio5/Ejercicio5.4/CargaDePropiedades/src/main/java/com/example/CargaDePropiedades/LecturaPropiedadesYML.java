package com.example.CargaDePropiedades;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("Propiedades.yml")
@ConfigurationProperties
public class LecturaPropiedadesYML {
    @Value("${greeting1}")
    public String greeting1;
    @Value("${my.number2}")
    public int myNumber2;

    public String getGreeting1() {
        return greeting1;
    }

    public int getMyNumber2() {
        return myNumber2;
    }


}
