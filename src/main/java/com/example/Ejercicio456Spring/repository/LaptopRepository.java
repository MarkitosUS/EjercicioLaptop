package com.example.Ejercicio456Spring.repository;


import com.example.Ejercicio456Spring.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
