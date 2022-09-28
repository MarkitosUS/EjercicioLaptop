package com.example.Ejercicio456Spring.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    // -- ATRIBUTOS --

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // -- CONSTRUCTORES --

    public Laptop() {
    }

    public Laptop(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // -- GETTER Y SETTER --


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
