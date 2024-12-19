package com.durgesh.blog.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.blog.entites.User;
import com.durgesh.blog.exceptions.ResourceNotFoundException;
import com.durgesh.blog.payloads.UserDto;
import com.durgesh.blog.repository.UserRepo;
import com.durgesh.blog.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User saveUser = userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());

		User updateUser = this.userRepo.save(user);
		UserDto userToDto1 = this.userToDto(updateUser);
		return userToDto1;
	}

	@Override
	public UserDto getUserById(Integer id) {
		User users = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

		return this.userToDto(users);

	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = userRepo.findAll();

		List<UserDto> userList = users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		return userList;
	}

	@Override
	public void deleteUserById(Integer userId) {
		User userdelete = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		userRepo.delete(userdelete);

	}
	
	@Override
	public List<UserDto> saveAllUser(List<UserDto> userDto) {
	
//		userRepo.saveAll(userdto);
		return null;
	}
	       
	
	public int Addition() {
		return 0;
		
	}
	
	private User dtoToUser(UserDto userDto) {

		User us = new User();
		us.setId(userDto.getId());
		us.setName(userDto.getName());
		us.setEmail(userDto.getEmail());
		us.setPassword(userDto.getPassword());
		us.setAbout(userDto.getAbout());
		return us;

	}

	public UserDto userToDto(User user) {

		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setAbout(user.getAbout());
		return dto;
             }

	

}
