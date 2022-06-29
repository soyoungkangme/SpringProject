package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		/*
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext("com.rubypaper.tv");
		
		AnnotationConfigApplicationContext = 스프링 컨테이너 중 하나 -> xml 대신 환경설정 클래스를 로딩함
		"com.rubypaper.tv" 의 @Configuration 뿐만 아니라 @Service, @Repository, @Controller, @Component 모두 메모리에 로딩함
		여러 패키지의 @ 객체를 메모리에 로딩하고 싶다면 @ComponentScan
		*/
		
		
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(TVConfiguration.class);

		
		
		// 컨테이너가 생성한 객체들 중에 id가 tv 인 객체 리턴 (Lookup) 
	    TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown(); 
		tv.powerOff();
		
		
		// 스프링 컨테이너 삭제
		// 모든 컨테이너는 삭제되기 직전 컨테이너가 생성한 객체들 메모리에서 먼저 제거 
		container.close();	
		
	}

}
