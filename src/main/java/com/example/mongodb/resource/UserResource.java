package com.example.mongodb.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User pessoa1 = new User(1, "maria", "maria@uol.com");
		User pessoa2 = new User(2, "jose", "jose@uol.com");
		User pessoa3 = new User(3, "benedito", "benedito@uol.com");
		
		List<User> usuarios = new ArrayList<>();
		usuarios.addAll(Arrays.asList(pessoa1, pessoa2, pessoa3));
		
		return ResponseEntity.ok().body(usuarios);
		
	}

}
