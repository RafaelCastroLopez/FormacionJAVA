package com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller;

import com.example.CRUDConValidacion.estudiante_asignatura.application.StudentSubjectService;
import com.example.CRUDConValidacion.estudiante_asignatura.domain.StudentSubject;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.inPut.StudentSubjectInPutDto;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.outPut.StudentSubjectOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @PutMapping("subject/{id}")
    public StudentSubjectOutPutDto updateStudentSubject (@PathVariable String id, @RequestBody StudentSubjectInPutDto studentSubjectInPutDto) throws Exception {
        return studentSubjectService.updateStudentSubject(id, studentSubjectInPutDto);
    }
}
