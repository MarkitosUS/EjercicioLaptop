package com.example.EjercicioLaptops.controller;

import com.example.EjercicioLaptops.entities.Laptop;
import com.example.EjercicioLaptops.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // -- ATRIBUTOS --

    private LaptopRepository laptopRepository;

    // -- CONSTRUCTORES --

    public LaptopController(LaptopRepository laptopRepository) { this.laptopRepository = laptopRepository; }

    // BUSCAR LISTA DE LOS LAPTOPS

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){

        return laptopRepository.findAll();

    }

    // BUSCAR UN SOLO LAPTOP

    @GetMapping("/api/laptops/{id}")
    public Laptop findOneById(@PathVariable Long id){

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        return laptopOpt.orElse(null);

    }

    // CREAR UN LAPTOP

    @PostMapping("/api/laptops")
    public Laptop crear(@RequestBody Laptop laptop){

        return laptopRepository.save(laptop);

    }

    // ACTUALIZAR UN LAPTOP

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId() == null){

            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();

        }

        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();

        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // BORRAR UN LAPTOP
    @ApiIgnore
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if (!laptopRepository.existsById(id)) {
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();

        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }
    @ApiIgnore
    @DeleteMapping("/api/books")
    public  ResponseEntity<Laptop> deleteAll(){

        log.info("REST Request for Deleting all laptops");
        laptopRepository.deleteAll();


        return ResponseEntity.noContent().build();

    }

}
