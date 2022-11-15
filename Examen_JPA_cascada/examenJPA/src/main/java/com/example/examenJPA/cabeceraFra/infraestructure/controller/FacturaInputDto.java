package com.example.examenJPA.cabeceraFra.infraestructure.controller;

import com.example.examenJPA.cabeceraFra.domain.CabeceraFra;
import com.example.examenJPA.cliente.domain.Cliente;
import lombok.Data;

@Data
public class FacturaInputDto {

    public int cliente;
    double importeFactura;

    public CabeceraFra inputDtoToFactura(){
        CabeceraFra cabeceraFra = new CabeceraFra();
        cabeceraFra.setImporteFra(this.importeFactura);

        return cabeceraFra;
    }

}
