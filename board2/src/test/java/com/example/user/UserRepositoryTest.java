package com.example.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@SpringBootTest
// 실행 후 다시 롤백 시켜줌 = 계속 테스트 할 수 있게 해줌
// 1. 단위테스트는 테스트를 반복적으로 실행할수있음
// 2. 테스트의 성공실패 여부를 빠르게 알수있음
// 3. 스프링테스트와 연동해서 스프링기반의 어플리케이션을 쉽게 테스트 할수있다.
@Transactional
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	@DisplayName("UserRepository 구현객체는 Null이 아니다.")
	public void testconfig() {
		assertThat(userRepository).isNotNull();
	}
	
	@Test
	public void testSaveUser() {
		User user = new User();
		user.setUsername("hong");
		user.setPassword("zxcv1234");
		user.setName("홍길동");
		user.setEmail("hong@gmail.com");
		user.setTel("010-2222-2222");
		
		userRepository.save(user);
		List<User> users = userRepository.findAll();
		
		assertThat(users.size()).isEqualTo(1);
	}
}
