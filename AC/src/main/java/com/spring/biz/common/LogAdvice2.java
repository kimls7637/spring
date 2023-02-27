package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice2 { // 기능이 바뀐, 업데이트한 로그어드바이스
	public void printLog2(JoinPoint jp) {
		System.out.println("[향상된 로그] 비즈니스 메서드 수행후에 호출되는 로그");
		
		String methodName=jp.getSignature().getName(); // 메서드1) 메서드시그니처 가져오는것. 현재 수행하고있는 메서드 이름
		Object[] args=jp.getArgs();
		System.out.println("   "+methodName+" 메서드 처리중");
		System.out.println("   "+args[0]+"을 인자로 수행완료");
	
		
		
		
		
		
	}
}
