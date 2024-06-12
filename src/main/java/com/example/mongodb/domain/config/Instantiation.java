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
import com.example.mongodb.domain.dto.CommentDTO;
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
		
		User user1 = new User(null, "Joey Ramone", "joey@gmail.com");
		User user2 = new User(null, "Johnny Ramone", "johnny@gmail.com");
		User user3 = new User(null, "Dee Dee", "deedee@gmail.com");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Sheena Is A Punk Rocker", " Ramones", new AuthorDTO(user1));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Pet Sematary", "Ramones", new AuthorDTO(user1));
		
		CommentDTO c1 = new CommentDTO("Well the kids are all hopped up and ready to go", sdf.parse("22/03/2018"), new AuthorDTO(user2));
		CommentDTO c2 = new CommentDTO("Under the arc of a weather stain boards", sdf.parse("22/03/2018"), new AuthorDTO(user3));
		CommentDTO c3 = new CommentDTO("Ancient goblins, and warlords", sdf.parse("22/03/2018"), new AuthorDTO(user1));
		
		post1.getComments().addAll(Arrays.asList(c1));
		post2.getComments().addAll(Arrays.asList(c2,c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		user1.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(user1);
		
	}

}
