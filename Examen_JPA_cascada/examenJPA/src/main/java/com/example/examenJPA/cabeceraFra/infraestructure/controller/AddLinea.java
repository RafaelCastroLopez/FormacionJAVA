package com.example.examenJPA.cabeceraFra.infraestructure.controller;

import com.example.examenJPA.cabeceraFra.application.FacturaService;
import com.example.examenJPA.lineasFra.infraestructure.controller.LineaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
public class AddLinea {

    @Autowired
    FacturaService facturaService;

    @PostMapping("linea/{idFra}")
    public FacturaOutputDto addLinea(@PathVariable Integer idFra, @RequestBody LineaInputDto lineaInputDto) throws Exception {
        return facturaService.addLinea(idFra,lineaInputDto);
    }
}
