package com.example.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CommandLineRunnerApplication{

	public static void main(String[] args) {
		SpringApplication.run(CommandLineRunnerApplication.class, args);

	}

/*
	@Bean
	CommandLineRunner ejecutame(){
		return p -> {
			System.out.println("linea a ejecutar");
		};
	}
*/
}
