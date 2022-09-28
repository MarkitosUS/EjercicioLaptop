package com.example.Ejercicio456Spring;

import com.example.Ejercicio456Spring.entities.Laptop;
import com.example.Ejercicio456Spring.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio456SpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio456SpringApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// CREAR LIBRO

		Laptop laptop = new Laptop(null, "Yakuza");

		// ALMACENAR UN LAPTOP
		System.out.println("Num libros en base de datos: " + repository.findAll().size());
		repository.save(laptop);

		// RECUPERAR TODOS LOS LAPTOPS

		System.out.println("Num laptops en base de datos: " + repository.findAll().size());
	}

}
