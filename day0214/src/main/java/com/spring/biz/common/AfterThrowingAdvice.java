package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect // 메모리의 해당타입으로 된 모든 객체한테 설정을 연결해줌
public class AfterThrowingAdvice {
	@AfterThrowing(pointcut="PointcutCommon.aPointcut()", throwing="exceptionObj")
	public void printLogATA(JoinPoint jp, Exception exceptionObj) {
//		System.out.println("[ATA 로그] 비즈니스 메서드 수행중에 예외발생시 호출되는 로그");
//		System.out.println("[로그]" + jp.getSignature().getName() + "  메서드를 수행하던 중 "+exceptionObj.getMessage()+" 발생");
		
	}
}
