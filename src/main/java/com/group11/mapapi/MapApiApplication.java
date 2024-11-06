package com.group11.mapapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MapApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapApiApplication.class, args);
	}

}
