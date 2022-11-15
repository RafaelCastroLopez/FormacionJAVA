package com.example.examenJPA.cabeceraFra.domain;

import com.example.examenJPA.cliente.domain.Cliente;
import com.example.examenJPA.lineasFra.domain.LineasFra;
import com.example.examenJPA.lineasFra.infraestructure.controller.LineaOutputDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraFra {

    @Id
    @GeneratedValue
    public int idFra;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    public Cliente idCliente;

    public double ImporteFra;
    
    @OneToMany(mappedBy = "idFra", cascade = CascadeType.ALL)
    List<LineasFra> lineaList = new ArrayList<>();
}
