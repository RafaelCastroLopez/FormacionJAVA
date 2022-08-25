package com.example.PathVariablesYHeaders;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ControladorCRUD {

    public List<Persona> personas = new ArrayList<>();

    public List<Persona> getLista(){
        return personas;
    }

    public void addPersona(Persona p){
        personas.add(p);
    }

    public void deletePersona(int id){
        personas.remove(id);
    }

    public void modificarPersona(int id, Persona nuevaPersona){
        Persona oldPersona = personas.get(id);

        if(oldPersona == null)
            return;

        Optional<String> newName = Optional.ofNullable(nuevaPersona.getNombre());
        Optional<String> newPoblacion = Optional.ofNullable(nuevaPersona.getPoblacion());

        nuevaPersona.setNombre(newName.isPresent()?nuevaPersona.getNombre():oldPersona.getNombre());
        nuevaPersona.setPoblacion(newPoblacion.isPresent()?nuevaPersona.getPoblacion():oldPersona.getPoblacion());
        if(nuevaPersona.getEdad() < 0) {
            nuevaPersona.setEdad(oldPersona.getEdad());
        }

        personas.set(id, nuevaPersona);
    }

    public String consultarPorID(int id){
        return personas.get(id).toString();
    }

    public String consultarPorNombre(String nombre){
        for(Persona persona:personas){
            if (persona.getNombre().equals(nombre)) {
                return persona.toString();
            }
        }
        return null;
    }
}
