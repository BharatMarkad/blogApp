package com.durgesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.blog.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
