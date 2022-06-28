package com.ssamz.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

// 사전처리(횡단 관심) 클래스를 LogAdvice 에서 AdvancedLogAdvice 로 바꿀때 BoardServiceImpl 수정 없음, XML 만 수정 
// Board, User의 모든 비즈니스 메서드에 사전처리 동작

@Service    // 빈등록 대체 (실행되는 횡단 관심 객체) 
@Aspect      // = Pointcut + Advice 
public class AdvancedLogAdvice {
	
//	@Pointcut("execution(* com.ssamz.biz..*Impl.*(..))")    // 비즈니스 메서드 필터링 
//	public void allPointcut() {}
//	// 비어있는 메서드 = 참조형 메서드, 여러개의 포인트컷을 구분하는 기능 (id 역할) -> 이름 고유해야함 
//	
//	@Pointcut("execution(* com.ssamz.biz..*Impl.get*)")
//	public void getPointcut() {}
	
	
	// Pointcut 객체 분리 후 앞에 클래스이름 붙이기 
	@Before("BoardPointcut.allPointcut()")       // 횡단관심 메서드가 동작하는 시점  
	public void printLog(JoinPoint jp) { 
		
		String method = jp.getSignature().getName();    
		Object[] args = jp.getArgs();
		// 클라이언트가 비즈니스 메서드 호출할때 인자로 어떤값 넘겨줬는지 Object 배열로 리턴 
		
		System.out.println("<사전 처리---AdvancedLogAdvanced> " + method + "() 의 ARGS 정보 : " + args[0].toString());
	}

}


// 클라이언트가 VO 객체에 값 담아서 인자로 비즈니스 메서드에 넘기면, 사전 처리 메서드에서 그 인자 받을 수 있음 
// => 유효성 체크에 이용 가능 (잘못된 데이터 전달 됐을때 비즈니스 메서드 실행되지 않도록)