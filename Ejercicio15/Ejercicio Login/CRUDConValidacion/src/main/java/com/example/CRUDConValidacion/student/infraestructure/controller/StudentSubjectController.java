package com.example.CRUDConValidacion.student.infraestructure.controller;

import com.example.CRUDConValidacion.student.application.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentSubjectController {

    @Autowired
    StudentService studentService;

    @PutMapping("student/{id}/subjects")
    public void addStudentSubject (@PathVariable String id, @RequestBody List<String> id_subjects) throws Exception {
        studentService.addSubjectStudent(id, id_subjects);
    }

    @DeleteMapping("student/{id}/subjects")
    public void deleteStudentSubject (@PathVariable String id, @RequestBody List<String> id_subjects) throws Exception {
        studentService.deleteSubjectStudent(id, id_subjects);
    }
}
