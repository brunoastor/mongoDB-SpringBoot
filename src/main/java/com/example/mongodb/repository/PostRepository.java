package com.example.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.example.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
