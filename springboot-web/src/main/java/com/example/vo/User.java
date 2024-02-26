package com.example.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

	private String id;
	private String password;
	private String name;
	private String te;;
	private String email;
	private Date createdDate;
	private Date updatedDate;
	
		
	}
	

