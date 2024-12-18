package com.durgesh.blog.entites;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Table(name="User")
@NoArgsConstructor
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	@Column(name="User_Name", nullable = false, length = 10)
	private String name;
	private String email;
	private String password;
	private String about;
}
