package com.example.member;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequset {

	@Schema(description = "이메일")
	private String email;
	@Schema(description = "비밀번호")
	private String password;
	@Schema(description = "이름")
	private String name;
	@Schema(description = "전화번호")
	private String tel;
	
	public Member toEntity() {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(password);
		member.setName(name);
		member.setTel(tel);
		member.setCreatedDate(LocalDateTime.now());
		member.setUpdatedDate(LocalDateTime.now());
		
		return member;
	}
}
