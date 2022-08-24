package com.example.CargaDePropiedades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CargaDePropiedadesApplication implements CommandLineRunner {

	@Autowired
	LecturaPropiedades lecturaPropiedades;

	@Autowired
	LecturaPropiedadesYML lecturaPropiedadesYML;

	public static void main(String[] args) {
		SpringApplication.run(CargaDePropiedadesApplication.class, args);
	}

	public void run(String... arg0){
		System.out.println("Lectura desde application.properties");
		System.out.println("El valor de greeting es:" + lecturaPropiedades.getGreeting());
		System.out.println("El valor de my.number es:" + lecturaPropiedades.getMyNumber());
		System.out.println("El valor de new.property es:" + lecturaPropiedades.getNewProperty());
		System.out.println("");
		System.out.println("Lectura desde yml");
		System.out.println("El valor de greeting es:" + lecturaPropiedadesYML.getGreeting1());
		System.out.println("El valor de my.number es:" + lecturaPropiedadesYML.getMyNumber2());

	}



}
