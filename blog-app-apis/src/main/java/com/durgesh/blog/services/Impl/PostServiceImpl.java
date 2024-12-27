package com.durgesh.blog.services.Impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.blog.entites.Category;
import com.durgesh.blog.entites.Post;
import com.durgesh.blog.entites.User;
import com.durgesh.blog.exceptions.ResourceNotFoundException;
import com.durgesh.blog.payloads.PostDto;
import com.durgesh.blog.repository.CategoryRepository;
import com.durgesh.blog.repository.PostRepository;
import com.durgesh.blog.repository.UserRepo;
import com.durgesh.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public PostDto createPost(PostDto postDto, Integer id, Integer categoryId) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", id));
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setUser(user);
		post.setCategory(category);
		post.setImageName("default.png");
//		post.setAddedDate(new Date());

		Post save = postRepository.save(post);
		return this.modelMapper.map(save, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle());

		Post save = postRepository.save(post);

		return this.modelMapper.map(save, PostDto.class);
	}

	@Override
	public PostDto getPost(Integer postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> all = postRepository.findAll();

		List<PostDto> collect = all.stream().map((pp) -> modelMapper.map(pp, PostDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", categoryId));
		List<Post> posts = postRepository.findByCategory(cat);
		List<PostDto> list = posts.stream().map((pot) -> this.modelMapper.map(pot, PostDto.class))
				.collect(Collectors.toList());

		return list;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		
		List<Post> postByUser = this.postRepository.findPostByUser(user);
		
		List<PostDto> collect = postByUser.stream().map((us)-> this.modelMapper.map(us, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

}