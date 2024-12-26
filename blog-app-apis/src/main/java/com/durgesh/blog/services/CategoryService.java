package com.durgesh.blog.services;

import java.util.List;

import com.durgesh.blog.payloads.CategoryDto;

public interface CategoryService {

	public CategoryDto SaveCategory(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	public void deleteCategory(Integer categoryId);
	
	public CategoryDto getCategory(Integer categoryId );
	
	public List<CategoryDto> getAllCategory();
}
