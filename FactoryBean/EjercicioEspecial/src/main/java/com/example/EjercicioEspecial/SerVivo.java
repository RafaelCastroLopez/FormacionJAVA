package com.example.EjercicioEspecial;

import lombok.Data;

import java.io.Serializable;

@Data
public class SerVivo implements Serializable {

    private static final long serialVersionUID = 1L;

    public String nombre;
    public String tipo;
}
