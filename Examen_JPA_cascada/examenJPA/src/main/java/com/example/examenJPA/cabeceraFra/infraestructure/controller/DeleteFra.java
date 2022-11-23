package com.example.examenJPA.cabeceraFra.infraestructure.controller;

import com.example.examenJPA.cabeceraFra.application.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("add")
public class DeleteFra {

    @Autowired
    FacturaService facturaService;

    @DeleteMapping("/{idFra}")
    public String deleteFra(@PathVariable Integer idFra) throws Exception {
        return facturaService.deleteFactura(idFra);
    }
}
