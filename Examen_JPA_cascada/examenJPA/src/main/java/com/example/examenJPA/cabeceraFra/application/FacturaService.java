package com.example.examenJPA.cabeceraFra.application;

import com.example.examenJPA.cabeceraFra.infraestructure.controller.FacturaOutputDto;
import com.example.examenJPA.lineasFra.infraestructure.controller.LineaInputDto;

import java.util.List;

public interface FacturaService {

    public List<FacturaOutputDto> getAll() throws Exception;
    public String deleteFactura(Integer idFra) throws Exception;
    public FacturaOutputDto addLinea(Integer idFra, LineaInputDto lineaInputDto) throws Exception;
}
