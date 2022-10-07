package com.example.uploaddownloadfile.exceptions;

import com.example.uploaddownloadfile.domain.File;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
@ResponseBody
public class ExceptionController {

    @ExceptionHandler(FileNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomError fileNotFoundException(FileNotFound exception){
        return new CustomError(exception.getMessage(), 404, new Date());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public CustomError RunTimeException(RuntimeException exception){
        return new CustomError(exception.getMessage(), 406, new Date());
    }
}
