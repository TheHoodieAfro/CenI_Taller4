package com.taller.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.taller.repository.interfaces")
@EntityScan(basePackages = {"com.taller.dbauthentication","com.taller.model"})
@ComponentScan(basePackages = {"com.taller.dbauthentication","com.taller.repository.interfaces","com.taller.service.implementations","com.taller.controller"})
public class Taller1Application {

	public static void main(String[] args) {
		SpringApplication.run(Taller1Application.class, args);
	}

}