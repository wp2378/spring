package com.example.web.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private int no;
	private String id;
	private String name;
	private String tel;
	private String email;
	// 날짜, 숫자를 원하는 형식으로 변경가능
	@JsonFormat(pattern = "M월 d일")
	private Date birth;
	@JsonFormat(pattern = "yyyy년 M월 d일") 
	private Date createdDate;
	
}
