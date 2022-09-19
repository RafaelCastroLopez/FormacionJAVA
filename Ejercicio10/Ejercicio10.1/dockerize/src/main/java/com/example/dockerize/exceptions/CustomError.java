package com.example.dockerize.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {
    Date timeStamp;
    int httpCode;
    String mensaje;

    public CustomError(String mensaje, int codigo){
        setMensaje(mensaje);
        setHttpCode(codigo);
        setTimeStamp(new Date());
    }
}
