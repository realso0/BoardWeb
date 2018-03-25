package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVo;

@Service
@Aspect
public class AfterReturningAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@AfterReturning(pointcut="getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) { //비즈니스 메소드 이후에 발생하는 어드바이저이므로, 출력 결과를 매개변수로 받아 확인할 수 있음.
		String method=jp.getSignature().getName(); //실행된 메소드 이름
		
		if(returnObj instanceof UserVo) { //returnObj가 UserVo 타입인지 확인(True/False)
			UserVo user=(UserVo) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName()+"로그인(Admin)" + "---- afterReturning");
			}
		}
		
		System.out.println("[사후 처리] " + method + "() 메소드 리턴값 : "+ returnObj.toString() + "---- afterReturning");
	}
}
