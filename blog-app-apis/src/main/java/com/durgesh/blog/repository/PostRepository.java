package com.durgesh.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.blog.entites.Category;
import com.durgesh.blog.entites.Post;
import com.durgesh.blog.entites.User;
import com.durgesh.blog.payloads.PostDto;

public interface PostRepository extends JpaRepository<Post,Integer> {

	public List<Post> findByCategory(Category category);
	
	public List<Post> findByUser(User user);

}
