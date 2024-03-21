package com.example.post;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create")
	public String form(Model model) {
		model.addAttribute("postForm", new PostForm());
			
		return "post/form";			//"src/main/resources/templates/post/form.html"
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public String create(@Valid PostForm postForm, BindingResult errors, Principal principal) {
		if (errors.hasErrors()) {
			
			return "post/form";
		}
		
		postService.createPost(postForm, principal.getName());
		
		return "redirect:/post/list";
	}
	
	// 페이징 처리 목록조회
	@GetMapping("/list")
	public String list(@RequestParam(name="page", required = false, defaultValue = "0")int page, Model model) {
		Page<Post> paging= postService.getPosts(page); // 모든 게시글을 조회해서 담아놓는것
		model.addAttribute("paging", paging);
		
		return "post/list";		// "src/main/resources/templates/list.html"
	}
	
	// 상세 보기 
	@GetMapping("/detail")
	public String detail(@RequestParam("id") Long id, Model model) {
		Post post = postService.getPostDetail(id);
		model.addAttribute("post", post);
		return "post/detail";  		//"src/main/resource/templates/post/detail.html"
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String form(@PathVariable("id") Long id, Principal principal, Model model) {
		Post post = postService.getPostDetail(id);
		//post.getUser().getUsername() : 게시글 작성자 아이디
		//principal.getName()		   : 로그인한 사용자 아이디
		if(!post.getUser().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"수정할수 없다");
		}
		
		PostForm postForm = new PostForm();
		postForm.setTitle(post.getTitle());
		postForm.setContent(post.getContent());
		model.addAttribute("postForm", postForm);
		
		return "post/form";		// "src/main/resources/templates/list.html" 등록화면으로 이동 
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}")
	public String modify(@PathVariable("id") Long id, PostForm postForm, BindingResult errors, Principal principal) {
		if(errors.hasErrors()) {
			return "post/form";
		}
		Post post = postService.getPostDetail(id);
		if(!post.getUser().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"수정할수 없다");
		}
		
		postService.updatePost(postForm, post);
		
		return String.format("redirect:/post/detail?id=%d", id);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/vote/{id}")
	public String vote(@PathVariable("id") Long id, Principal principal) {
		postService.vote(id, principal.getName());
		
		return String.format("redirect:/post/detail?id=%d", id);
	}
	
}







