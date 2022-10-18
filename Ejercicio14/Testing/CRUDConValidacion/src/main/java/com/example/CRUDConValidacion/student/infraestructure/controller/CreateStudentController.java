package com.example.CRUDConValidacion.student.infraestructure.controller;

import com.example.CRUDConValidacion.student.application.StudentService;
import com.example.CRUDConValidacion.student.infraestructure.controller.inPutController.StudentInPutDto;
import com.example.CRUDConValidacion.student.infraestructure.controller.outPutController.StudentOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("student")
    public StudentOutPutDto addStudent(@RequestBody StudentInPutDto studentInPutDto) throws Exception {
        return studentService.addStudent(studentInPutDto);
    }
}
