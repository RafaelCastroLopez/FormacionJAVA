package com.example.InyeccionDeDependencias;

import org.springframework.stereotype.Service;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadesServiceImpl implements CiudadesService{
    List<Ciudad> ciudades = new ArrayList<>();

    @Override
    public void addCiudad(Ciudad c) {
        ciudades.add(c);
    }

    @Override
    public List<Ciudad> getCiudad() {
        return ciudades;

    }

}
