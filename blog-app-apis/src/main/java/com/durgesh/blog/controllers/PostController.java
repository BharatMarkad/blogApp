package com.durgesh.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.blog.payloads.PostDto;
import com.durgesh.blog.payloads.PostResponse;
import com.durgesh.blog.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/user/{id}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer id,
			@PathVariable Integer categoryId) {
		PostDto postDto1 = postService.createPost(postDto, id, categoryId);
		return new ResponseEntity<PostDto>(postDto1, HttpStatus.CREATED);

	}

	@PutMapping("/upatePost/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {

		PostDto updatePost = postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);

	}

	@GetMapping("/getPost/{postId}")
	public ResponseEntity<PostDto> getPostDetail(@PathVariable Integer postId) {
		PostDto post = postService.getPost(postId);

		return new ResponseEntity<PostDto>(post, HttpStatus.OK);

	}

	@GetMapping("/getAllPost")
	public ResponseEntity<List<PostDto>> getAllPost(@RequestParam (value = "pageNumber", defaultValue = "10", required = false) Integer  pageNumber, 
			@RequestParam(value = "pageSize", defaultValue = "10", required = false ) Integer pageSize ) {
		List<PostDto> allPost = postService.getAllPost(pageNumber,pageSize);
		return new ResponseEntity<List<PostDto>>(allPost, HttpStatus.OK);

	}
	
	@GetMapping("/category/{categoryId}")
     public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
    	 
    	 List<PostDto> postByCategory = postService.getPostByCategory(categoryId);
    	 return new ResponseEntity<List<PostDto>>(postByCategory,HttpStatus.OK);
     }
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
	
		List<PostDto> postByUser = postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(postByUser,HttpStatus.OK);
	}
	
	@GetMapping("/getAllPostpegination")
	public ResponseEntity<PostResponse> getAllPostWithDetails(@RequestParam (value = "pageNumber", defaultValue = "5", required = false) Integer  pageNumber, 
			@RequestParam(value = "pageSize", defaultValue = "10", required = false ) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue ="title", required = false) String sortBy) {
		 PostResponse allPostWithDetails = postService.getAllPostWithDetails(pageNumber, pageSize, sortBy);
		return new ResponseEntity<PostResponse>(allPostWithDetails, HttpStatus.OK);

	}
}
