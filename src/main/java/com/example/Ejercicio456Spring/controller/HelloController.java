package com.example.Ejercicio456Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludo")
    public String Saludo(){

        return "Bienvenido";

    }

}
