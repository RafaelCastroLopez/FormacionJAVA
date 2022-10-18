package com.example.CRUDConValidacion.student.application;

import com.example.CRUDConValidacion.student.infraestructure.controller.inPutController.StudentInPutDto;
import com.example.CRUDConValidacion.student.infraestructure.controller.outPutController.StudentOutPutDto;

import java.util.List;

public interface StudentService {

    public StudentOutPutDto addStudent(StudentInPutDto studentInPutDto) throws Exception;

    public void deleteStudent (String id) throws Exception;

    public StudentOutPutDto updateStudent(String id, StudentInPutDto studentInPutDto) throws Exception;

    public StudentOutPutDto getStudentById (String id) throws Exception;

    public void addSubjectStudent(String id, List<String> id_subjects) throws Exception;

    public void deleteSubjectStudent(String id, List<String> id_subjects) throws Exception;
}
