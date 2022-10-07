package com.example.uploaddownloadfile.exceptions;

public class FileNotFound extends RuntimeException{

    public FileNotFound(String mensaje){
        super(mensaje);
    }
}
