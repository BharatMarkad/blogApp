package com.durgesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.blog.entites.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
