package com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller;


import com.example.CRUDConValidacion.estudiante_asignatura.application.StudentSubjectService;
import com.example.CRUDConValidacion.estudiante_asignatura.domain.StudentSubject;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.inPut.StudentSubjectInPutDto;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.outPut.StudentSubjectOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @PostMapping("subject")
    public StudentSubjectOutPutDto addStudentSubject(@RequestBody StudentSubjectInPutDto studentSubjectInPutDto) throws Exception {
        return studentSubjectService.addStudentSubject(studentSubjectInPutDto);
    }
}
