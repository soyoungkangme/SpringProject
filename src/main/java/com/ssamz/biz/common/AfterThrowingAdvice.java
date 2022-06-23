package com.ssamz.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

// 횡단 관심 클래스 
// 물리적으로는 가능하나 논리적으로 막아야 하는 상황들 (0번글 등록, 잔액보다 많은 금액 인출, ...) 에서 강제로 예외발생 

@Service
@Aspect
public class AfterThrowingAdvice {
	
//	@Pointcut("execution(* com.ssamz.biz..*Impl.*(..))")    // 비즈니스 메서드 필터링 
//	public void allPointcut() {}
	
	// 발생한 예외의 종류에 따라 예외처리 로직 분기 처리 
	@AfterThrowing(pointcut="BoardPointcut.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {      // 모든 예외의 최상위 부모이기 때문에 모든 예외 받을수 있음 (묵시적 형변환)
		
		String method = jp.getSignature().getName();                   // 어떤 비즈니스 메서드에서 예외 발생했는지 
		System.out.println("<예외 처리>" + method + "() 수행 중 예외 발생");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("0번 글은 등록할 수 없습니다.");
		} else if(exceptObj instanceof ArithmeticException) {
			System.out.println("0으로 숫자를 나눌 수는 없습니다.");
		} else if(exceptObj instanceof SQLException) {
			System.out.println("SQL 구문에 문법 오류가 있습니다.");
		} else {
			System.out.println("문제 발생");
		}
	}

}
 