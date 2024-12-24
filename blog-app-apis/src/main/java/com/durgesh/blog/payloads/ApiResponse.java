package com.durgesh.blog.payloads;

import com.durgesh.blog.utils.ApiConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

	private String message;
	private boolean success;
	
	
}
