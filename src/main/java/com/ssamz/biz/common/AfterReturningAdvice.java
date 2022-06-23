package com.ssamz.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.ssamz.biz.user.UserVO;

// 횡단 관심 클래스 
@Service
@Aspect
public class AfterReturningAdvice {
	
//	@Pointcut("execution(* com.ssamz.biz..*Impl.get*(..))")    // 비즈니스 메서드 필터링 
//	public void getPointcut() {}
//	// BoardServiceImpl의 비즈니스 메서드는 다 void -> 매개변수 returnObj가 null 안되도록 반환하는 비즈니스 메서드로 필터링 (get메서드)

	// 비즈니스 메서드가 뭘 반환할지 몰라서 Object 타입으로 받음
	@AfterReturning(pointcut="BoardPointcut.agetPoingcut", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		
		String method = jp.getSignature().getName();      // 어떤 메서드의 반환값인지  
		System.out.println("<사후 처리>" + method + "() 가 리턴한 값 : " + returnObj.toString());

		// 관리자("test")가 로그인 했을때의 사후처리 
		// 어떤 비즈니스 메서드를 호출했냐에 따라 참조변수의 타입 다름 
		if (returnObj instanceof UserVO) {      // 참조변수의 타입 확인하는 연산자
			UserVO user = (UserVO) returnObj;   // 명시적 형변환 
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "님 관리자 전용 페이지로 이동합니다.");
			}
		}
	}
}
