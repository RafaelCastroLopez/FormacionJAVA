package com.example.CargaDePropiedades;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LecturaPropiedades {

    @Value("${greeting}")
    public String greeting;

    @Value("${my.number}")
    public int myNumber;

    @Value("${new.property:new.property no tine valor}")
    public String newProperty;

    public String getGreeting() {
        return greeting;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public String getNewProperty(){
        return newProperty;
    }
}
