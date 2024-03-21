package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * @Configuration
 * 		- 이 클래스가 스프링 빈 설정 클래스임을 나타낸다.
 * 		- 이 클래스에서 @Bean이 지정된 메소드가 반환하는 객체는 스프링 컨테이너 빈으로 등록된다.
 * 
 * BCryptPasswordEncoder
 * 		- BCrypt는 단방향 해시 알고리즘이다.
 * 		- BCrypt는 레인보우 테이블 공격을 방지하기 위ㅐ서 salting과 key stretching을 적용한다.
 * 
 * SecurityFilterChain
 * 		- Spring Security에서 인증/인가 관련 보안작업을 처리하는 각종 필터들의 집합이다.
 * 		- 사용자는 HttpsSecurity객체가 제공하는 메소드를 이용해서 SecurityFilterChain에 포함된 각종 필터들에 대한 설정을 커스텀할 수 있다.
 * 		- 사용자는 커스텀 설정이 적용된 SecurityFilterChain을 반환하는 메소드를 정의해서 각종 보안설정을 한다.
 * 
 * HttpSecurity
 * 		- Spring Security와 관련된 각종 설정을 지원하는 객체다.
 * 		- 주요 내용
 * 			+ URL 접근 권한 설정
 * 			+ 로그인/로그아웃 설정
 * 			+ csrf, https 호출 설정
 *  
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
	
		
	@Bean
	SecurityFilterChain filetChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers("/**").permitAll());
		http.formLogin(formLogin -> formLogin.loginPage("/user/login").defaultSuccessUrl("/"));
		http.logout(logout -> logout.logoutUrl("/user/logout").logoutSuccessUrl("/").invalidateHttpSession(true));
	     
		
		return http.build();
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
