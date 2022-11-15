package com.example.examenJPA.cliente.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue
    public Integer idCliente;

    @NotNull
    String nombreCliente;

    public Cliente(String nombreCliente){
        this.nombreCliente=(nombreCliente);
    }
}
