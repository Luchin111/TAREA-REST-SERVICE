package com.example.TAREA_REST;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PumakatariNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PumakatariNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(PumakatariNotFoundException ex) {
        return ex.getMessage();
    }
}
