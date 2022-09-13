package com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller;

import com.example.CRUDConValidacion.estudiante_asignatura.application.StudentSubjectService;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.outPut.StudentSubjectOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @GetMapping("subject/{id}")
    public StudentSubjectOutPutDto getStudentSubjectById (@PathVariable String id) throws Exception {
        return studentSubjectService.getStudentSubjectById(id);
    }
}
