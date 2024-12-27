package com.durgesh.blog.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Table(name= "Category")
@NoArgsConstructor
@Setter
@Getter
public class Category {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int categoryId;
	
	@Column(name="Category_Title", nullable = false, length=10)
	private String categoryTitle;
	
	@Column(name= "Category_Descreption", nullable = false)
	private String categoryDescreption;
	
	@OneToMany (mappedBy = "category" , cascade= CascadeType.ALL)
	private List<Post> posts = new ArrayList<Post>();
}
