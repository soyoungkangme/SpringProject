package com.rubypaper.tv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// 환경 설정 클래스 (XML 설정 대신함) 

@Configuration   // = 메모리 로딩 
@ComponentScan(basePackages = {"com.rubypaper", "com.test"})   // 해당 패캐지의 @Configuration, @Service, @Repository, @Controller, @Component 메모리 로딩 
public class TVConfiguration {
	
	
	/* @Bean 대신 @Service, @Repository, @Controller 사용 => 내가 안만든 객체는 @Bean 사용해야함 
	@Bean  // = <bean> -> 컨테이너가 환경설정 클래스 로딩하는 순간 메서드 실행 
	public TV tv() {
		return new SamsungTV();   // 이 객체가 메모리에 뜰때 메서드 이름이 아이디 
	}
	
	@Bean  
	public Speaker speaker() {
		return new AppleSpeaker();
	}
	*/
	
	
	/* 세터인젝션 
	@Bean 
	public TV tv() {
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(speaker());         // SamsungTV에 만든 세터메서드 사용 
		return tv;
	}
	
	public Speaker speaker() {
		return new SonySpeaker();   // 스피커 변경 여기 바꾸면됨 
	}
	*/

}
