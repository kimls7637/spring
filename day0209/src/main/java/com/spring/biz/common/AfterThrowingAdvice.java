package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void printLogATA(JoinPoint jp, Exception exceptionObj) {
//		System.out.println("[ATA 로그] 비즈니스 메서드 수행중에 예외발생시 호출되는 로그");
		System.out.println(jp.getSignature().getName() + "비즈니스 메서드를 수행하던 중 "+exceptionObj.getMessage()+" 발생");
	}
}
