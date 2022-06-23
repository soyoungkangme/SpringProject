package com.ssamz.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// 횡단 관심 클래스 
@Service
@Aspect
public class AroundAdvice { 
	
//	@Pointcut("execution(* com.ssamz.biz..*Impl.*(..))")    // 비즈니스 메서드 필터링 
//	public void allPointcut() {}
	
	// 횡단 관심 메서드중 around만 리턴타입 Object 
	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable  {   // 메서드 내부 예외 try~catch 안하고 던지겠다 (Exception의 부모 Throwable)
		
		String method = jp.getSignature().getName();   // 어떤 비즈니스 메서드의 수행시간인지 
		// getSignature() 는 반환타입이 Signature 
		 
		Object returnObj = null;
		
	    StopWatch watch = new StopWatch();         // 클라이언트의 비즈니스 메서드 가로챈 후 비포로직 실행
	    watch.start();
	    
		returnObj = jp.proceed();                  // 클라이언트가 요청한 비즈니스 메서드로 넘어가서 반환값 받아옴 
		
		watch.stop();                              // 제어권 다시 돌아온 후 횡단관심 메서드에서 클라이언트에게 반환함 (리턴타입 void면 안됨)
		System.out.println(method + "() 수행에 소요된 시간 : " + watch.getTotalTimeSeconds() + "m/s");
		
		return returnObj;
		// 리턴타입 있기 때문에 
	}

}
