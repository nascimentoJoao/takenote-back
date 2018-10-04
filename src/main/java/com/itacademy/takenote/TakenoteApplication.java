package com.itacademy.takenote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class TakenoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakenoteApplication.class, args);
		System.out.println("Aplicação TakeNote está rodando!");
	}
}
