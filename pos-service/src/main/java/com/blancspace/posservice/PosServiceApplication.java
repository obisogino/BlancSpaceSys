package com.blancspace.posservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosServiceApplication.class, args);
	}

}
