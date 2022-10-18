package com.example.CRUDConValidacion.estudiante_asignatura.domain;

import com.example.CRUDConValidacion.profesor.domain.Profesor;
import com.example.CRUDConValidacion.student.domain.Student;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class StudentSubject {

    @Id
    @GenericGenerator(
            name = "assigned-sequence",
            strategy = "com.example.CRUDConValidacion.estudiante_asignatura.domain.GeneradorStudentSubject",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_name", value = "hibernate_sequence"),
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_prefix", value = "PRO"),
            })
    @GeneratedValue(generator = "assigned-sequence", strategy = GenerationType.SEQUENCE)
    private String id_subject;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_studentSubject",
            joinColumns = @JoinColumn(name = "id_subject", referencedColumnName = "id_subject"),
            inverseJoinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id_student"))
    private List<Student> students;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    private String subject;

    private String coments;

    private Date initial_date;

    private Date finish_date;
}
