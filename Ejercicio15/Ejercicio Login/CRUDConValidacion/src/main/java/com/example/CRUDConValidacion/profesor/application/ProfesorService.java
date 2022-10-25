package com.example.CRUDConValidacion.profesor.application;

import com.example.CRUDConValidacion.profesor.infraestructure.controller.inputController.ProfesorInPutDto;
import com.example.CRUDConValidacion.profesor.infraestructure.controller.outputController.ProfesorOutPutDto;

public interface ProfesorService {

    public ProfesorOutPutDto addProfesor (ProfesorInPutDto profersorInPutDto) throws Exception;

    public void deleteProfesor (String id) throws Exception;

    public ProfesorOutPutDto updateProfesor(String id, ProfesorInPutDto profersorInPutDto) throws Exception;

    public ProfesorOutPutDto getProfesorById (String id) throws Exception;
}
