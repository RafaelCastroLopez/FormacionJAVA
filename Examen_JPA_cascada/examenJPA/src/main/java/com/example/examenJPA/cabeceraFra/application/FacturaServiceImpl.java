package com.example.examenJPA.cabeceraFra.application;

import com.example.examenJPA.cabeceraFra.domain.CabeceraFra;
import com.example.examenJPA.cabeceraFra.infraestructure.controller.FacturaOutputDto;
import com.example.examenJPA.cabeceraFra.infraestructure.repository.CabeceraFraRepository;
import com.example.examenJPA.exceptions.EntityNotFoundException;
import com.example.examenJPA.lineasFra.domain.LineasFra;
import com.example.examenJPA.lineasFra.infraestructure.controller.LineaInputDto;
import com.example.examenJPA.lineasFra.infraestructure.repository.LineasFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Autowired
    LineasFraRepository lineasFraRepository;

    @Override
    public List<FacturaOutputDto> getAll() throws Exception {
        List<CabeceraFra> facturaList = cabeceraFraRepository.findAll();
        List<FacturaOutputDto> facturaOutputDtoList = new ArrayList<>();

        return facturaOutputDtoList = facturaList.stream().map(FacturaOutputDto::new).collect(Collectors.toList());
    }

    @Override
    public String deleteFactura(Integer idFra) throws Exception {

        Optional<CabeceraFra> cabeceraFraOptional = cabeceraFraRepository.findById(idFra);
        if(cabeceraFraOptional.isEmpty()){
            throw new EntityNotFoundException("no existe esa factura", 404);
        }

        cabeceraFraRepository.deleteById(idFra);

        return "se ha borrado correctamente";
    }

    @Override
    public FacturaOutputDto addLinea(Integer idFra, LineaInputDto lineaInputDto) throws Exception {

        Optional<CabeceraFra> cabeceraFraOptional = cabeceraFraRepository.findById(idFra);
        if(cabeceraFraOptional.isEmpty()){
            throw new EntityNotFoundException("no existe esa factura", 404);
        }

        CabeceraFra cabeceraFra = cabeceraFraOptional.get();
        LineasFra lineasFra = lineaInputDto.toLineasFra();

        cabeceraFra.getLineaList().add(lineasFra);
        lineasFra.setIdFra(cabeceraFra);

        lineasFraRepository.save(lineasFra);

        return new FacturaOutputDto(cabeceraFra);

    }
}
