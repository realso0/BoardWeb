package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method=jp.getSignature().getName(); //실행된 메소드 이름
		Object[] args=jp.getArgs(); //메소드 호출시 넘겨준 인자목록을 Object배열로 받음.
		
		System.out.println("[사전 처리] "+method+"()메소드 ARGS 정보: "+args[0].toString());
	}
}
