package com.ssamz.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


// 모든 횡단관심 메서드의 AOP Pointcut 설정 긁어옴 

// @Service -> 생성될 필요 없는 객체 
@Aspect
public class BoardPointcut {
	
	@Pointcut("execution(* com.ssamz.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.ssamz.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@Pointcut("execution(* com.ssamz.biz.user.*Impl.*(..))")
	public void userPointcut() {}
	
	@Pointcut("execution(* com.ssamz.biz.board.*Impl.*(..))")
	public void boardPointcut() {}
	
}


// XML 아닌 Annotation 으로 자바소스 수정없이 유지보수 가능하지만, 
// AOP는 어차피 포인트컷 객체를 자바소스로 수정하므로 XML을 더 선호한다함 
