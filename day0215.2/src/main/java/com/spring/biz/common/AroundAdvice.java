package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object printLogAA(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("[AA 로그] 비즈니스 메서드 수행을 가로챔(탈취)");
		//System.out.println("[BEFOR] 비즈니스 메서드 수행 전");
		StopWatch sw = new StopWatch();
		sw.start();
		Object obj = pjp.proceed();
		//System.out.println("[AFTER] 비즈니스 메서드 수행 후");
		sw.stop();
		String mn = pjp.getSignature().getName();
//		System.out.println(mn+"메서드를 수행하는 데에 걸린 시간 "+sw.getTotalTimeMillis()+"초");
		return obj;
	}
}
