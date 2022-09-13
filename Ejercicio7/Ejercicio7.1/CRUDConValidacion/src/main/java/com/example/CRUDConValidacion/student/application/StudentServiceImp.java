package com.example.CRUDConValidacion.student.application;

import com.example.CRUDConValidacion.estudiante_asignatura.domain.StudentSubject;
import com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.repository.StudentSubjectRepository;
import com.example.CRUDConValidacion.persona.domain.Persona;
import com.example.CRUDConValidacion.persona.infraestructure.repository.PersonaRepository;
import com.example.CRUDConValidacion.profesor.domain.Profesor;
import com.example.CRUDConValidacion.profesor.infraestructure.repository.ProfesorRepository;
import com.example.CRUDConValidacion.student.domain.Student;
import com.example.CRUDConValidacion.student.infraestructure.controller.inPutController.StudentInPutDto;
import com.example.CRUDConValidacion.student.infraestructure.controller.outPutController.StudentOutPutDto;
import com.example.CRUDConValidacion.student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    StudentSubjectRepository studentSubjectRepository;

    @Override
    public StudentOutPutDto addStudent(StudentInPutDto studentInPutDto) throws Exception {

        if(studentInPutDto.getNum_hours_week() < 0)
            throw new Exception("las horas no pueden estar vacias");
        if(studentInPutDto.getBranch() == null)
            throw new Exception("Debe de poner una rama del estudiante");

        Optional<Persona> personaOpt = personaRepository.findById(studentInPutDto.getId_persona());
        Optional<Profesor> profesorOpt = profesorRepository.findById(studentInPutDto.getId_profesor());

        Persona persona;
        Profesor profesor;

        if (personaOpt.isEmpty()){
            throw new Exception("No se ha encnotrado persona con ese ID");
        }
        if (profesorOpt.isEmpty()){
            throw new Exception("No se ha encotrado profesor con este ID");
        }

        persona = personaOpt.get();
        profesor = profesorOpt.get();

        Student student = studentInPutDto.inPutToStudent();
        student.setPersona(persona);
        student.setProfesor(profesor);
        studentRepository.save(student);

        return new StudentOutPutDto(student);
    }

    @Override
    public void deleteStudent(String id) throws Exception {

        Optional<Student> studentOpt = studentRepository.findById(id);

        if (studentOpt.isEmpty())
            throw new Exception("No se ha encontrado ese estudiante");

        studentRepository.deleteById(id);
    }

    @Override
    public StudentOutPutDto updateStudent(String id, StudentInPutDto studentInPutDto) throws Exception {
        Optional<Student> studentOpt = studentRepository.findById(id);
        Student student;

        if(studentOpt.isEmpty())
            throw new Exception("No se ha encontrado el estudiante a modificar");

        Optional<Persona> personaOpt = personaRepository.findById(studentInPutDto.getId_persona());
        Optional<Profesor> profesorOpt = profesorRepository.findById(studentInPutDto.getId_profesor());

        Persona persona;
        Profesor profesor;

        if (personaOpt.isEmpty()){
            throw new Exception("No se ha encnotrado persona con ese ID");
        }
        if (profesorOpt.isEmpty()){
            throw new Exception("No se ha encotrado profesor con este ID");
        }

        persona = personaOpt.get();
        profesor = profesorOpt.get();

        student = studentOpt.get();
        student.setPersona(persona);
        student.setNum_hours_week(studentInPutDto.getNum_hours_week());
        student.setComents(studentInPutDto.getComents());
        student.setProfesor(profesor);
        student.setBranch(studentInPutDto.getBranch());

        studentRepository.save(student);

        return new StudentOutPutDto(student);
    }

    @Override
    public StudentOutPutDto getStudentById(String id) throws Exception {
        Optional<Student> studentOpt = studentRepository.findById(id);

        if (studentOpt.isEmpty())
            throw new Exception("no se ha encontrado ningun estudiante");

        Student student = studentOpt.get();

        return new StudentOutPutDto(student);
    }

    @Override
    @Transactional
    public void addSubjectStudent(String id, List<String> id_subjects) throws Exception {
        Optional<Student> studentOpt = studentRepository.findById(id);

        if(studentOpt.isEmpty())
            throw new Exception("no se ha encontrado el estudiante con el id indicado");

        Student student = studentOpt.get();

        for(String id_subject:id_subjects){
            Optional<StudentSubject> studentSubjectOpt = studentSubjectRepository.findById(id_subject);

            if (studentSubjectOpt.isEmpty())
                throw new Exception("el subject con id:" + studentSubjectOpt + "no se ha encontrado");

            StudentSubject studentSubject = studentSubjectOpt.get();

            if (studentSubject.getStudents().contains(student))
                throw new Exception("el estudiante ya tiene esta asignatura asignada anteriormente");

            studentSubject.getStudents().add(student);
            studentSubjectRepository.save(studentSubject);
        }
    }

    @Override
    @Transactional
    public void deleteSubjectStudent(String id, List<String> id_subjects) throws Exception {

        Optional<Student> studentOpt = studentRepository.findById(id);

        if (studentOpt.isEmpty())
            throw new Exception("no se ha encontrado estudiante con el id indicado");

        Student student = studentOpt.get();

        for(String id_subject:id_subjects){
            Optional<StudentSubject> studentSubjectOpt = studentSubjectRepository.findById(id_subject);

            if (studentSubjectOpt.isEmpty())
                throw new Exception("el subject con id:" + studentSubjectOpt + "no se ha encontrado");

            StudentSubject studentSubject = studentSubjectOpt.get();

            if (!studentSubject.getStudents().contains(student))
                throw new Exception("este estudiante no tiene esta asignatura asignada");

            studentSubject.getStudents().remove(student);

            studentSubjectRepository.save(studentSubject);
        }

    }
}
