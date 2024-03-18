package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.user.UserSignupForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	@GetMapping("/signup")
	public String form(Model model) {
		// Model객체에 입력폼의 입력필드와 매핑되는 폼객체를 저장한다.
		model.addAttribute("userSignupForm", new UserSignupForm());
		return "register-form";
		
	}
	
	
	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("userSignupForm") UserSignupForm form, BindingResult errors) {
	
		// BindingResult객체에 오류가 있으면, 유효성 체크를 통과하지 못한 것임으로 회원가입폼으로 내부이동시킨다.
		if(errors.hasErrors()) {
			return "register-form";
		}
		
		return "redirect:/user/completed";
	}

	@GetMapping("/completed")
	public String completed() {
		
	
		return "completed";		// src/main/resources/templates/completed.html
	}
}
