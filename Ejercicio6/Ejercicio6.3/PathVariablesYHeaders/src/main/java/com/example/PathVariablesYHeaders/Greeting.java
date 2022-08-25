package com.example.PathVariablesYHeaders;

import lombok.Data;

@Data
public class Greeting {
    public int id;
    public String nombre;

    public Greeting(int id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }


}
