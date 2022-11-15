package com.example.examenJPA.lineasFra.infraestructure.controller;

import com.example.examenJPA.lineasFra.domain.LineasFra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaInputDto {

    String producto;
    double cantidad;
    double importe;

    public LineasFra toLineasFra(){
        LineasFra lineasFra=new LineasFra();
        lineasFra.setProducto(this.getProducto());
        lineasFra.setCantidad(this.getCantidad());
        lineasFra.setPrecio(this.getImporte());
        return lineasFra;
    }
}
