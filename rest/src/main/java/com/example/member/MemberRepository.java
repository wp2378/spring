package com.example.member;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	Boolean existsByemail(String email);
	List<Member> findByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);
	List<Member> findByCreatedDateAfter(LocalDateTime startDate);
	List<Member> findByCreatedDateBefore(LocalDateTime endDate);
}
