package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect // 메모리의 해당타입으로 된 모든 객체한테 설정을 연결해줌
// ex) xml에서 bean으로 id준 객체 1개, @Service로 무명객체 1개 둘 한테 aspect연결이 되어서 로그 두 번 나온것
public class AfterThrowingAdvice {
	
//	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
//	public void aPointcut() {} // 포인트컷 선언 
	
	
	// 어떤 비즈니스 메서드 돌리다가 문제가 생겼는지(JoinPoint jp) 어떤 예외가 발생했는지 알려줄수있는 인자(Exception exceptObj)
	@AfterThrowing(pointcut="PointcutCommon.aPointcut()", throwing="excepObj")
	public void printLogATA(JoinPoint jp, Exception excepObj) {
		System.out.println("[ATA 로그] 내가 만든 에러 발생!!");
		// System.out.println("   "+jp.getSignature().getName()+" 메서드를 수행하던중 "+excepObj.getMessage()+" 예외발생");
	// Exception클래스가 원래 message를 멤버로 가지고있음
	
	}
}
