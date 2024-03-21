package com.example.post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class Postcontroller {

	private final PostService postservice;
	
	@GetMapping("/list")
	public String list(@RequestParam(name = "page", required = false, defaultValue = "0") int page, Model model) {
		Page<Post> paging = postservice.getPosts(page);
		model.addAttribute("paging", paging);
		
		return "post/list";		// "src/main/resources/templates/post/list.html"로 내부이동
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") Long id, Model model) {
		Post post = postservice.getPostDetail(id);
		model.addAttribute("post", post);
		
		return "post/detail"; 	// "src/main/resources/templates/post/detail.html"로 내부이동
	}
}
