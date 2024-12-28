package com.durgesh.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.durgesh.blog.entites.Category;
import com.durgesh.blog.entites.Post;
import com.durgesh.blog.entites.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	public List<Post> findByCategory(Category category);

	public List<Post> findByUser(User user);

	
	 @Query("select p from Post p where p.title like :key")
	 public List<Post> searchByTitle(@Param("key") String title);
	
	
}
