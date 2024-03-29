package com.sample.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAdvice {
	// pointcut = 어디에 적용할지, throwing = 넘길 매개변수 이름
	@AfterThrowing(pointcut = "execution(* com.sample.service.*.*(..))", throwing = "ex")
	public void handlerException(Exception ex) {
		System.out.println("예외가 발생하였습니다. 오류메세지: " + ex.getMessage());
	}
}
