package com.Proyecto;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Proyecto.models.Personas;
import com.Proyecto.services.PersonasService;

@SpringBootApplication


public class ProyectoApplication implements CommandLineRunner {
	
	@Autowired
	private PersonasService personasService;

	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

public void run(String... args) throws Exception{
		
	personasService.obtenerTodosPersonas().forEach(personas->{
		
		System.out.println("Personas existente..:"+personas);
	});
}
	
	}


