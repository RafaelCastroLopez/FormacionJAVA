package com.example.examenJPA;

import com.example.examenJPA.cabeceraFra.domain.CabeceraFra;
import com.example.examenJPA.cabeceraFra.infraestructure.repository.CabeceraFraRepository;
import com.example.examenJPA.cliente.domain.Cliente;
import com.example.examenJPA.cliente.infraestructure.repository.ClienteRepository;
import com.example.examenJPA.lineasFra.domain.LineasFra;
import com.example.examenJPA.lineasFra.infraestructure.repository.LineasFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GuardarInfo implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Autowired
    LineasFraRepository lineasFraRepository;

    @Override
    public void run(String... args) throws Exception {

        clienteRepository.save(new Cliente("pepe"));
        CabeceraFra cabeceraFra = new CabeceraFra();
        Optional<Cliente> clienteOpt = clienteRepository.findById(1);
        cabeceraFra.setIdCliente(clienteOpt.get());
        cabeceraFra.setImporteFra(200);

        LineasFra lineasFra1 = new LineasFra();
        lineasFra1.setIdFra(cabeceraFra);
        lineasFra1.setProducto("goma");
        lineasFra1.setCantidad(10);
        lineasFra1.setPrecio(15);

        LineasFra lineasFra2 = new LineasFra();
        lineasFra2.setIdFra(cabeceraFra);
        lineasFra2.setProducto("goma");
        lineasFra2.setCantidad(10);
        lineasFra2.setPrecio(15);

        cabeceraFra.getLineaList().add(lineasFra1);
        cabeceraFra.getLineaList().add(lineasFra2);

        cabeceraFraRepository.save(cabeceraFra);
        //lineasFraRepository.save(lineasFra1);
        //lineasFraRepository.save(lineasFra2);


    }
}
