package com.ivandjoh.springh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	// RestTemplate bean
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
