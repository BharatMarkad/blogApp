package com.durgesh.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.blog.payloads.ApiResponse;
import com.durgesh.blog.payloads.UserDto;
import com.durgesh.blog.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUserR(@Valid @RequestBody UserDto userDto) {
		UserDto saveUser = userServices.createUser(userDto);
		return new ResponseEntity<UserDto>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<UserDto> getUserByIdR(@PathVariable Integer id) {
		UserDto userByIdR = userServices.getUserById(id);
		return new ResponseEntity<UserDto>(userByIdR, HttpStatus.OK);
	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUserR(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
		UserDto updateUser = userServices.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);

	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> allUser = userServices.getAllUser();
		return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{ghgh}")
	public ResponseEntity<ApiResponse> delateUser(@PathVariable("ghgh") Integer userId) {
		userServices.deleteUserById(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Delated Successfully", true), HttpStatus.OK);

	}
}
