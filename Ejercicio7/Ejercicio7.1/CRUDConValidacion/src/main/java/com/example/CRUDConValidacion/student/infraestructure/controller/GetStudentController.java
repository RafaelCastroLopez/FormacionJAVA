package com.example.CRUDConValidacion.student.infraestructure.controller;

import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import com.example.CRUDConValidacion.student.application.StudentService;
import com.example.CRUDConValidacion.student.infraestructure.controller.outPutController.StudentOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetStudentController {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    StudentService studentService;

    @GetMapping("student/{id}")
    public StudentOutPutDto getStudent(@PathVariable String id, @RequestParam String outPutType) throws Exception {

        StudentOutPutDto studentOutPutDto = studentService.getStudentById(id);

        if (outPutType.equals("full")) {
            return studentOutPutDto;
        } else {
            studentOutPutDto.setPersona(null);
        }
        return studentOutPutDto;
    }
}
