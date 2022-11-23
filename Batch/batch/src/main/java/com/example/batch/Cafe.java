package com.example.batch;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@Entity
public class Cafe {

    @Id
    @GeneratedValue
    public Integer idCafe;
    @Column
    public String nombre;
    @Column
    public String origen;
    @Column
    public String caracteristica;

    public Cafe(String nombre, String origen, String caracteristica){
        this.setNombre(nombre);
        this.setOrigen(origen);
        this.setCaracteristica(caracteristica);
    }
}
