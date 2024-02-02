package com.effigo.demopostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DemoPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPostgresApplication.class, args);
	}

}
