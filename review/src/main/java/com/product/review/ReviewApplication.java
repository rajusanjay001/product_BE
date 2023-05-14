package com.product.review;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.product.review.entities.User;
import com.product.review.repository.UserRepository;

@SpringBootApplication
public class ReviewApplication {
	
	   @Autowired
	    private UserRepository repository;

	    @PostConstruct
	    public void initUsers() {
	        List<User> users = Stream.of(
	                new User(1, "raju", "password", "raju.sanjay001@gmail.com"),
	                new User(2, "test", "password", "user1@mailinator.com")
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	    }

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

}
