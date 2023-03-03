package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
//	@Pointcut("execution(* com.spring.biz..*Impl.select*(..))")
//	public void bPointcut() {}
	
	
	// 어드바이스마다 수행하는 메서드가 다름
	// 각각의 공통로직은 메서드명 다를수있다
	
	// obj를 인자로 받음으로써 결과 알수있음
	// 
	@AfterReturning(pointcut="PointcutCommon.bPointcut()", returning="obj")
	
	public void printLogARA(JoinPoint jp, Object obj) {
		// System.out.println("[ARA 로그] 비즈니스 메서드 수행 이후에 호출되는 로그");
		System.out.println(" [로그] "+jp.getSignature().getName()+"(), 인자로 "+jp.getArgs()[0]+" 사용");
		System.out.println("결과 " + obj+" 반환됨");

		if (obj instanceof MemberVO) {
			System.out.println("회원 조회했습니다.");
			if(((MemberVO) obj).getId().equals("admin")){
				System.out.println("관리자 모드 수행함");
			}
		} else if (obj instanceof BoardVO) {
			System.out.println("글을 조회했습니다.");
		} else {
			System.out.println("전체 조회했습니다.");
		}
	}
}
