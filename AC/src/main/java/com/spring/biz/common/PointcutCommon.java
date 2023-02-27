package com.spring.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 포인트컷 모듈화 => 포인트컷 클래스 따로 만듦
// 이곳에 있는 포인트컷과 다른곳에 있는 advice가 나중에 결합되어야 하기때문에 @Aspect
@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void aPointcut() {} // 포인트컷 선언
	@Pointcut("execution(* com.spring.biz..*Impl.select*(..))")
	public void bPointcut() {}

}
