package com.example.CRUDConValidacion.estudiante_asignatura.application;

import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.inPut.StudentSubjectInPutDto;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.outPut.StudentSubjectOutPutDto;

public interface StudentSubjectService {

    public StudentSubjectOutPutDto addStudentSubject(StudentSubjectInPutDto studentSubjectInPutDto) throws Exception;

    public void deleteStudentSubject(String id) throws Exception;

    public StudentSubjectOutPutDto updateStudentSubject(String id, StudentSubjectInPutDto studentSubjectInPutDto) throws Exception;

    public StudentSubjectOutPutDto getStudentSubjectById(String id) throws Exception;
}
