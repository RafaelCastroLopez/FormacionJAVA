package com.example.examenJPA.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class EntityNotFoundException extends Exception {

    Date timeStamp;
    int httpCode;

    public EntityNotFoundException(String mensaje, int codigo){
        super(mensaje);
        setTimeStamp(new Date());
        setHttpCode(codigo);
    }
}
