package com.example.InyeccionDeDependencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InyeccionDeDependenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(InyeccionDeDependenciasApplication.class, args);


	}

	@Bean
	public List<Ciudad> registrarCiudad(){
		List<Ciudad> ciudades = new ArrayList<Ciudad>();

		return ciudades;
	}

	@Bean("Bean1")
	public void addPersona1(){
		Persona persona1 = new Persona();

	}

	@Bean("Bean2")
	public void addPersona2(){
		Persona persona2 = new Persona();

	}

	@Bean("Bean3")
	public void addPersona3(){
		Persona persona3 = new Persona();

	}

}
