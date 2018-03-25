package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) { 
		//예외가 발생한 메소드 정보를 알기위해, JoinPoint객체를 매개변수로 받음. 어떤 예외가 발생됬는지 확인하기 위해, Exception 매개변수를 받음.
		String method=jp.getSignature().getName(); //실행된 메소드 이름
		System.out.println(method+ "() 메소드 수행 중 예외 발생!");
		
		System.out.println("[예외 처리] "+method + "() 메소드 수행 중 발생된 예외 메세지  : "+ exceptObj.getMessage());
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
		} else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		} else if(exceptObj instanceof Exception) {
			System.out.println("문제가 발생했습니다.");
		}
	}
}
