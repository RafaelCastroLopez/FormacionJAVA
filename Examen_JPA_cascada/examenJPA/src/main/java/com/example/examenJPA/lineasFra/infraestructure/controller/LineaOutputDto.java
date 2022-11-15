package com.example.examenJPA.lineasFra.infraestructure.controller;

import com.example.examenJPA.lineasFra.domain.LineasFra;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.sound.sampled.Line;

@Data
@AllArgsConstructor
public class LineaOutputDto {

    int id;
    String producto;
    double cantidad;
    double importe;

    public LineaOutputDto(LineasFra lineasFra){
        setId(lineasFra.getIdLineas());
        setProducto(lineasFra.getProducto());
        setCantidad(lineasFra.getCantidad());
        setImporte(lineasFra.getPrecio());
    }
}
