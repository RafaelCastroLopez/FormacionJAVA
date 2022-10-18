package com.example.CRUDConValidacion.profesor.domain;

import com.example.CRUDConValidacion.persona.domain.Persona;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class Profesor {

    @Id
    @GenericGenerator(
            name = "assigned-sequence",
            strategy = "com.example.CRUDConValidacion.profesor.domain.GeneradorProfesor",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_name", value = "hibernate_sequence"),
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_prefix", value = "PRO"),
            })
    @GeneratedValue(generator = "assigned-sequence", strategy = GenerationType.SEQUENCE)
    public String id_profesor;

    @OneToOne
    @JoinColumn(name = "id_persona")
    public Persona persona;

    public String coments;

    @Column(nullable = false)
    public String branch;
}
