package com.example.mongodb.domain.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.mongodb.domain.User;
import com.example.mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		
		User user1 = new User(null, "Jão", "jao123@gmail.com");
		User user2 = new User(null, "Maria", "maria123@gmail.com");
		User user3 = new User(null, "Wesley Nilson", "weslao@gmail.com");
		
		repository.saveAll(Arrays.asList(user1, user2, user3));
	}

}
