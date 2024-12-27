package com.durgesh.blog.services;


import java.util.List;

import com.durgesh.blog.entites.Post;
import com.durgesh.blog.payloads.PostDto;

public interface PostService {

	public PostDto createPost(PostDto post, Integer id, Integer categoryId);
	
	public PostDto updatePost(PostDto postDto, Integer postId);
	
	public PostDto getPost(Integer postId);
	
	public List<PostDto> getAllPost();
	
	public List<PostDto> getPostByCategory(Integer categoryId);
	
	public List<PostDto> getPostByUser(Integer userId);
}
