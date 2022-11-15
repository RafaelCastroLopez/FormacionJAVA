package com.example.examenJPA.cabeceraFra.infraestructure.controller;

import com.example.examenJPA.cabeceraFra.domain.CabeceraFra;
import com.example.examenJPA.cliente.infraestructure.controller.ClienteOutputDto;
import com.example.examenJPA.lineasFra.infraestructure.controller.LineaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FacturaOutputDto {

    int idFactura;
    double importeFra;
    ClienteOutputDto clienteOutputDto;
    List<LineaOutputDto> lineaOutputDtoList;

    public FacturaOutputDto(CabeceraFra cabeceraFra){
        setIdFactura(cabeceraFra.getIdFra());
        setImporteFra(cabeceraFra.getImporteFra());
        setClienteOutputDto(new ClienteOutputDto(cabeceraFra.idCliente));
        setLineaOutputDtoList(cabeceraFra.getLineaList().stream().map(LineaOutputDto::new).toList());
    }
}
