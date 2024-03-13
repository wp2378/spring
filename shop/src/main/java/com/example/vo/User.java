package com.example.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class User {

	private int no;
	private String id;
	// Json방식으로 값이 로딩될 때 이부분은 로딩이 되지않음
	@JsonIgnore
	private String password;
	private String name;
	private String email;
	private String tel;
	private String deleted;
	private Date birth;
	private Date createdDate;
	private Date updatedDate;
}
