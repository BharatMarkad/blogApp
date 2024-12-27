package com.durgesh.blog.payloads;



import java.util.Date;

import com.durgesh.blog.entites.Category;
import com.durgesh.blog.entites.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PostDto {

	
	private String title;
	private String content;
	private String imageName;
//	private Date addedDate;
	private CategoryDto category;
	private UserDto user;

	

}
