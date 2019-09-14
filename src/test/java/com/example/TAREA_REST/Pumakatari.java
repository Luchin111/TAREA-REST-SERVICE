package com.example.TAREA_REST;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Pumakatari {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    private @Id @GeneratedValue Long id;
    private String placa;
    private String ruta;

    Pumakatari() {}

    Pumakatari(String placa, String ruta) {
        this.placa = placa;
        this.ruta = ruta;
    }

}
