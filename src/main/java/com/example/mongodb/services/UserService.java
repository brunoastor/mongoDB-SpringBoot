package com.example.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.domain.User;
import com.example.mongodb.domain.dto.UserDTO;
import com.example.mongodb.repository.UserRepository;
import com.example.mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));		
	}
	
	public User insert(User obj){
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objdto) {
		return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
	}
}
