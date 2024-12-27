package com.durgesh.blog.entites;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "POST")
public class Post {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int postId;
	
	@Column(name ="TITLE", length = 10)
	private String title;
	@Column(name ="CONTENT", length = 10)
	private String content;
	@Column(name ="IMAGE_NAME", length = 1000)
	private String imageName;
	
//	@Column(name="Added_Date")
//	private Date addedDate;
	
    @ManyToOne
	private Category category;
	
    @ManyToOne
	private User user;
	
}
