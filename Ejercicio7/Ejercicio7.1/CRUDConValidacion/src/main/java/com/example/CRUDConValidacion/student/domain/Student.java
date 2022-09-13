package com.example.CRUDConValidacion.student.domain;

import com.example.CRUDConValidacion.estudiante_asignatura.domain.StudentSubject;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GenericGenerator(
            name = "assigned-sequence",
            strategy = "com.example.CRUDConValidacion.student.domain.GeneradorStudent",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_name", value = "hibernate_sequence"),
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_prefix", value = "STU"),
            })
    @GeneratedValue(generator = "assigned-sequence", strategy = GenerationType.SEQUENCE)
    @Column (name = "id_student")
    public String id_student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    public Persona persona;

    public int num_hours_week;

    public String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    public Profesor profesor;

    public String branch;

    @ManyToMany(mappedBy = "students")
    List<StudentSubject> studentSubjects;
}
