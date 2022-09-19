package com.example.dockerize.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class UnprocessableEntityException extends Exception{

    Date timeStamp;
    int httpCode;

    public UnprocessableEntityException(String mensaje, int codigo){
        super(mensaje);
        setHttpCode(codigo);
        setTimeStamp(new Date());

    }
}
