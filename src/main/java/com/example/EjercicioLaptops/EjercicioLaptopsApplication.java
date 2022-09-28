package com.example.EjercicioLaptops;

import com.example.EjercicioLaptops.entities.Laptop;
import com.example.EjercicioLaptops.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioLaptopsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioLaptopsApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// CREAR LIBRO

		Laptop laptop = new Laptop(null, "Yakuza");

		// ALMACENAR UN LAPTOP
		System.out.println("Num laptops en base de datos: " + repository.findAll().size());
		repository.save(laptop);

		// RECUPERAR TODOS LOS LAPTOPS

		System.out.println("Num laptops en base de datos: " + repository.findAll().size());
	}

}
