package com.example.CRUDConValidacion.estudiante_asignatura.application;

import com.example.CRUDConValidacion.estudiante_asignatura.domain.StudentSubject;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.inPut.StudentSubjectInPutDto;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.controller.outPut.StudentSubjectOutPutDto;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.repository.StudentSubjectRepository;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import com.example.CRUDConValidacion.profesor.infraestructure.repository.ProfesorRepository;
import com.example.CRUDConValidacion.student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentSubjectServiceImp implements StudentSubjectService {

    @Autowired
    StudentSubjectRepository studentSubjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public StudentSubjectOutPutDto addStudentSubject(StudentSubjectInPutDto studentSubjectInPutDto) throws Exception {

        if(studentSubjectInPutDto.getId_profesor() == null)
            throw new Exception("se debe pasar un Id_profesor");
        if (studentSubjectInPutDto.getSubject() == null)
            throw new Exception("se debe pasar un nombre para subject");
        if(studentSubjectInPutDto.getInitial_date() == null)
            throw new Exception("se debe indicar en que fecha inicia el curso");

        Optional<Profesor> profesorOpt = profesorRepository.findById(studentSubjectInPutDto.getId_profesor());

        if (profesorOpt.isEmpty())
            throw new Exception("el profesor indicado no se ha encontrado");

        StudentSubject studentSubject = studentSubjectInPutDto.inPutToStudentSubject();
        studentSubject.setProfesor(profesorOpt.get());

        studentSubjectRepository.save(studentSubject);

        return new StudentSubjectOutPutDto(studentSubject);
    }

    @Override
    public void deleteStudentSubject(String id) throws Exception {
        Optional<StudentSubject> studentSubjectOptional = studentSubjectRepository.findById(id);

        if (studentSubjectOptional.isEmpty())
            throw new Exception("no se ha encontrado ninguna asignatura con ese id");

        studentSubjectRepository.deleteById(id);
    }

    @Override
    public StudentSubjectOutPutDto updateStudentSubject(String id, StudentSubjectInPutDto studentSubjectInPutDto) throws Exception {
        if(studentSubjectInPutDto.getId_profesor() == null)
            throw new Exception("se debe pasar un Id_profesor");
        if (studentSubjectInPutDto.getSubject() == null)
            throw new Exception("se debe pasar un nombre para subject");
        if(studentSubjectInPutDto.getInitial_date() == null)
            throw new Exception("se debe indicar en que fecha inicia el curso");

        Optional<StudentSubject> studentSubjectOptional = studentSubjectRepository.findById(id);

        if (studentSubjectOptional.isEmpty())
            throw new Exception("la asignatura indicada para modificar no existe");

        StudentSubject studentSubject = studentSubjectOptional.get();
        studentSubject.setSubject(studentSubjectInPutDto.getSubject());
        studentSubject.setComents(studentSubjectInPutDto.getComents());
        studentSubject.setInitial_date(studentSubjectInPutDto.getInitial_date());
        studentSubject.setFinish_date(studentSubjectInPutDto.getFinish_date());

        Optional<Profesor> profesorOpt = profesorRepository.findById(studentSubjectInPutDto.getId_profesor());

        if (profesorOpt.isEmpty())
            throw new Exception("el profesor indicado no se ha encontrado");

        studentSubject.setProfesor(profesorOpt.get());

        studentSubjectRepository.save(studentSubject);

        return new StudentSubjectOutPutDto(studentSubject);
    }

    @Override
    public StudentSubjectOutPutDto getStudentSubjectById(String id) throws Exception {
        Optional<StudentSubject> studentSubjectOptional = studentSubjectRepository.findById(id);

        if (studentSubjectOptional.isEmpty())
            throw new Exception("no se ha encontrado ninguna asignatura con este id");

        StudentSubject studentSubject = studentSubjectOptional.get();

        return new StudentSubjectOutPutDto(studentSubject);
    }
}
