package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice { // Advice : 횡단관심(공통로직)	
	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		
		String methodName=jp.getSignature().getName();
		
		System.out.println("DAO2 "+methodName+" 메서드 처리중");
		//Object[] args=jp.getArgs();
		//System.out.println("   "+args[0]+"을 인자로 사용중");
	}
}
