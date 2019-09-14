package com.example.TAREA_REST;

public class PumakatariNotFoundException extends RuntimeException {
    public PumakatariNotFoundException(Long id) {
        super("No se pudo encontrar el Pumakatari " + id);
    }

}
