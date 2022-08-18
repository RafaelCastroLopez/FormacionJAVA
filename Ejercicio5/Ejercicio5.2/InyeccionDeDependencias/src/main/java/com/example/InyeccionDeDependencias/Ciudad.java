package com.example.InyeccionDeDependencias;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Ciudad {
    String nombreCiudad;
    int numHabitantes;

    public Ciudad(String nombreCiudad, int numHabitantes) {
        this.nombreCiudad = nombreCiudad;
        this.numHabitantes = numHabitantes;
    }
}
