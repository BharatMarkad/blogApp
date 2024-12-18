package com.durgesh.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String filedName;
	long filedValue;
	
	public ResourceNotFoundException(String resourceName, String filedName, long filedValue) {
		super(String.format("%s not found with %s :%s", resourceName,filedName,filedValue));
		this.resourceName = resourceName;
		this.filedName = filedName;
		this.filedValue = filedValue;
	}
	
	

	
}
