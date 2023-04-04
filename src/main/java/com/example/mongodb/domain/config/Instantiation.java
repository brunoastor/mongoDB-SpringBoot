package com.example.mongodb.domain.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.mongodb.domain.Post;
import com.example.mongodb.domain.User;
import com.example.mongodb.domain.dto.AuthorDTO;
import com.example.mongodb.repository.PostRepository;
import com.example.mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User user1 = new User(null, "Jão", "jao123@gmail.com");
		User user2 = new User(null, "Maria", "maria123@gmail.com");
		User user3 = new User(null, "Wesley Nilson", "weslao@gmail.com");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Alô you", "gabba gabba hey", new AuthorDTO(user1));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Cya baby", "Goodnight", new AuthorDTO(user1));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
