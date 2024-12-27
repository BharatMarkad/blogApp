package com.durgesh.blog.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.blog.entites.Category;
import com.durgesh.blog.exceptions.ResourceNotFoundException;
import com.durgesh.blog.payloads.CategoryDto;
import com.durgesh.blog.repository.CategoryRepository;
import com.durgesh.blog.services.CategoryService;

@Service
public class CategorySeviceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto SaveCategory(CategoryDto categoryDto) {
		Category map = modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepository.save(map);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category categoryaa = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));

		categoryaa.setCategoryDescreption(categoryDto.getCategoryTitle());
		categoryaa.setCategoryTitle(categoryDto.getCategoryDescreption());
		
	
		Category updatedCatogeory = categoryRepository.save(categoryaa);
		return this.modelMapper.map(updatedCatogeory, CategoryDto.class);
	}
	
	public void deleteCategory(Integer categoryId ) {
		
		Category getcategory = categoryRepository.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException("Category", "category Id", categoryId));
		
		categoryRepository.delete(getcategory);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category category = this.categoryRepository
				.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "category Id",categoryId ));
		
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> allCategory = this.categoryRepository.findAll();
		
		List<CategoryDto> list = allCategory.stream().map((cat) -> modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return list;
	}

	

}
