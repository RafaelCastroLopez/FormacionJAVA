package com.example.CRUDConValidacion.student.infraestructure.controller;

import com.example.CRUDConValidacion.student.application.StudentService;
import com.example.CRUDConValidacion.student.infraestructure.controller.inPutController.StudentInPutDto;
import com.example.CRUDConValidacion.student.infraestructure.controller.outPutController.StudentOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateStudentController {

    @Autowired
    StudentService studentService;

    @PutMapping("student/{id}")
    public StudentOutPutDto updateStudent(@PathVariable String id, @RequestBody StudentInPutDto studentInPutDto) throws Exception {
        return studentService.updateStudent(id, studentInPutDto);
    }
}
