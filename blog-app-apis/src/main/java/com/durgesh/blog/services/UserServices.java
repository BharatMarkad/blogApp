package com.durgesh.blog.services;

import java.util.List;

import com.durgesh.blog.payloads.UserDto;

public interface UserServices {

	public UserDto createUser(UserDto user);
	public UserDto updateUser(UserDto user, Integer userId);
	public UserDto getUserById(Integer id);
	public List<UserDto> getAllUser();
	public void deleteUserById(Integer userId);
	public List<UserDto> saveAllUser(List<UserDto> userdto);
	
	
}
