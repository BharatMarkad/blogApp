package com.durgesh.blog.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size (min =1, max=20, message = "Name must be present min size 1 & Max Size is 20")	
	private String name;
	
	@Email
	@Column(name = "User_Emali")
	@Size(max=20, message = "@ sighn must be present..!!")
	private String email;
	
	
	@Column(name="Password", nullable = true )
	@NotEmpty(message = "Passward must be present")
	@Size(min=1, max=10)
	private String password;
	
	@NotNull(message = "something need to write")
	private String about;
}
