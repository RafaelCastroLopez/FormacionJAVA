package com.example.CRUDConValidacion.student.infraestructure.controller;

import com.example.CRUDConValidacion.student.application.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentController {
    @Autowired
    StudentService studentService;

    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable String id) throws Exception {
        studentService.deleteStudent(id);
    }
}
