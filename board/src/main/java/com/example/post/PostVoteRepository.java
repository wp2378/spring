package com.example.post;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.User;

@Repository
public interface PostVoteRepository extends JpaRepository<PostVoter, Long> {

	Optional<PostVoter> findByPostAndUser(Post post, User user);
}
