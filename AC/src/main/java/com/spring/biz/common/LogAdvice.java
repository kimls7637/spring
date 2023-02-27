package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// aspect를 보고 컨테이너가 실행시에 위빙처리해줌
// 

// LogAdvice 자체를 ServiceImpl 부를 타이밍에 같이 불러야함
// == ServiceImpl클래스에서 LogAdvice메서드를 수행할거기때문에!
// => 수행하려면 LogAdvice를 객체화해야함
// -> 어노테이션 필요 ->  ServiceImpl이랑 같은레벨이어서 @Service작성
// 이때 pointcut을 보고 동작하는거라 이름은 따로 필요없음
@Service
@Aspect // 포인트컷과 어드바이스 메서드(동작시점)를 보고 실행시에 결합해줌
public class LogAdvice { // Advice : 횡단관심(공통로직) 
	// 연결될수있는 모든 포인트컷을 상단에 선언
	// 비어있는 메서드블록 사용
	// @Pointcut을 통해 하나의 어드바이스에 여러개의 포인트컷 선언 가능
//	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
//	public void aPointcut() {} // 포인트컷 선언
//	@Pointcut("execution(* com.spring.biz..*Impl.select*(..))")
//	public void bPointcut() {}


	// 동작시점을 @을 통해 누구와 결합할지 결정할수있음
	// 설정파일에서 before로 연결했었음   
	// pointcut="aPointcut()" 원래 이건데 설정사항 한가지일때는 생략해서 씀
	// @Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		System.out.println("[로그] 비즈니스 메서드 수행 전에 호출되는 로그");
		String methodName=jp.getSignature().getName(); 
		// 메서드1) getSignature() 메서드시그니처 가져오는것. 현재 수행하고있는 메서드(핵심관심) 이름
		Object[] args=jp.getArgs(); 
		// 메서드2) getArgs() 이 핵심관심이 사용하는 인자확인할수있음, 아웃풋 obj
		System.out.println("   "+methodName+" 메서드 처리중");
		System.out.println("   "+args[0]+"을 인자로 사용중");
		
		// jp.getArgs()[0]
		// 여기서의 인덱스가 jp로 가져온 비즈니스 메서드가 어떤 인자를 사용하고있는지를 알수있음
		// 이떄 비즈니스 메서드에서 인자를 한개면 0만 두개면 인덱스 0,1둘다 뽑을수있음!!
 		
		
	}
	

	
}
