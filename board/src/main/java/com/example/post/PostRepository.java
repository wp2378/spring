package com.example.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long>{

	//페이징 처리
//	Page<Post> findAll(Pageable pageable);
}
