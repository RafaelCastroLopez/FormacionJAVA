package com.example.examenJPA.cabeceraFra.infraestructure.controller;

import com.example.examenJPA.cabeceraFra.application.FacturaService;
import com.example.examenJPA.cabeceraFra.domain.CabeceraFra;
import com.example.examenJPA.cabeceraFra.infraestructure.repository.CabeceraFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("factura")
public class GetAll {

    @Autowired
    FacturaService facturaService;

    @GetMapping("")
    public List<FacturaOutputDto> getAll() throws Exception {
        return facturaService.getAll();
    }
}
