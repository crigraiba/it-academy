package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.repository.jpa")
@EnableMongoRepositories(basePackages = "com.example.repository.mongo")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
