package com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller;

import com.example.CRUDConValidacion.estudiante_asignatura.application.StudentSubjectService;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.outPut.StudentSubjectOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @DeleteMapping("subject/{id}")
    public void deleteStudentSubject (@PathVariable String id) throws Exception {
        studentSubjectService.deleteStudentSubject(id);
    }
}
