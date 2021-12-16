package com.projeto.ParaquedistaVesp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParaquedistaVespApplication {

	public static void main(String[] args) {
		System.out.println("Inicializando Application...");
		SpringApplication.run(ParaquedistaVespApplication.class, args);
		System.out.println("Application inicializado com sucesso");
	}

}
