package com.example.InyeccionDeDependencias;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Ciudad {
    String nombreCiudad;
    int numHabitantes;


}
