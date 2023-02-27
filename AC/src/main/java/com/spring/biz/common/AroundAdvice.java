package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	// 메커니즘이 아예 다르다. around로 활용할 메서드는 인자, 아웃풋 있음
	// 가로챌수있는 능력있음. (비즈니스 메서드 전,후에 개입할수있다) 캐스팅할때 종종 등장함
	// pjp 이미 있는 클래스, 수행하려고하는 비즈니스 메서드 그 자체
	// pjp.proceed에서 예외발생할수도있기때문에 throws로 예외 떠넘기기 사용
	public Object printLogAA(ProceedingJoinPoint pjp) throws Throwable{
		// System.out.println("[AA 로그] 비즈니스 메서드 수행을 가로챔(탈취)");
		
		// 성능확인해줌
		StopWatch sw=new StopWatch();
		sw.start();
		
		// System.out.println("[BEFORE] 비즈니스 메서드 수행 전");
		Object obj=pjp.proceed(); // 여기서 동작해야함. 어떤 비즈니스 메서드의 수행속도를 재기위해 around를 사용하는 경우가 많다
		// System.out.println("[AFTER] 비즈니스 메서드 수행 후");
		
		sw.stop(); // 수행 끝난 시점에 종료
		String mn=pjp.getSignature().getName();
		System.out.println("  "+mn+"메서드를 수행하는데에 걸린시간 "+sw.getTotalTimeMillis()+"(ms)초");
		return obj;
		
		// 비즈니스 메서드를 인자로 가지고와서 자기거 안에서 수행시킴
		// 그런데 비즈니스 메서드가 아웃풋이 있을수있다.
		// 그걸 따로 저장해놨다가 반환함(어떤것이 들어올지모르기때문에 obj로 받음)
		
		// 순서 >> 
		// 비즈니스 메서드 수행전에 본인 횡단관심하고
		// 비즈니스 메서드 탈취한것 수행시키고
		// 비즈니스 메서드 아웃풋을 기억해두었다가 반환
	}
}
