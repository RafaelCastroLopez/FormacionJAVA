package com.example.examenJPA.lineasFra.domain;

import com.example.examenJPA.cabeceraFra.domain.CabeceraFra;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LineasFra {

    @Id
    @GeneratedValue
    public int idLineas;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFra")
    CabeceraFra idFra;

    @NotNull
    String producto;
    double cantidad;
    double precio;
}
