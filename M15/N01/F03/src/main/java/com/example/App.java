package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;

import com.example.security.JwtAuthorizationFilter;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.repository.jpa")
@EnableMongoRepositories(basePackages = "com.example.repository.mongo")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Configuration
	@EnableWebSecurity
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf()
				.disable()
				.addFilterAfter(
						new JwtAuthorizationFilter(),
						UsernamePasswordAuthenticationFilter.class
					)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/players")
				.permitAll()
				.anyRequest()
				.authenticated();
		}
	
	}

}
