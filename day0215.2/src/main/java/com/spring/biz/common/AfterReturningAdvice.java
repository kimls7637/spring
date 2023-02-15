package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.spring.biz.member.MemberVO;
import com.spring.biz.board.BoardVO;

@Service
@Aspect
public class AfterReturningAdvice {
	@AfterReturning(pointcut="PointcutCommon.bPointcut()", returning="obj")
	public void printLogARA(JoinPoint jp, Object obj) {
//		System.out.println("인자 " + jp.getArgs()[0] + "사용");
//		System.out.println("결과값은 "+obj);
	}
	
//	public void printLogARA(JoinPoint jp, Object obj) {
////		System.out.println("[AR 로그] 비즈니스 메서드 수행 이후에 호출되는 로그");
////		System.out.println("결과값은 "+obj);
//		if(obj instanceof MemberVO) {
//			System.out.println("로그인을 시도했습니다.");
//			if(((MemberVO) obj).getMid().equals("admin")) {
//				System.out.println("관리자 모드 수행함");
//			}
//		} else if(obj instanceof BoardVO) {
//			System.out.println("글을 조회했습니다.");
//		} else {
//			System.out.println("전체 목록을 조회했습니다.");
//		}
//	}
}
