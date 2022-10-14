package com.example.EjercicioEspecial.services;

import com.example.EjercicioEspecial.Registro.AdapterService;
import com.example.EjercicioEspecial.SerVivo;
import org.springframework.stereotype.Service;

@Service("alien")
public class AlienService implements AdapterService<SerVivo> {

    @Override
    public void process(SerVivo request) {
        System.out.println("para el servicio de alien:" + request.toString());
    }
}