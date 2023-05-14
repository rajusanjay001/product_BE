package com.product;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(
	        RestTemplateBuilder restTemplateBuilder) {

	    return restTemplateBuilder
	            .setConnectTimeout(Duration.ofSeconds(10))
	            .setReadTimeout(Duration.ofSeconds(100))
	            .build();
	}
}
