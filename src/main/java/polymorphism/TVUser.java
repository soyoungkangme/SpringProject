package polymorphism;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
        
		// TV tv = new SamsungTV();    
		// 묵시적 형변환 -> 유지보수 한줄로
	    
		// TV tv = (TV) TVContainer.getBean(args[0]);
		// static 이므로 직접 호출, Object 타입 반환하므로 메서드 갖고있는 TV 타입으로 명시적 형변환
		// run configuration, arguments (명령형 매개변수) -> 자바소스 안건들임 (유지보수, OOP)
	    
//		tv.powerOn();
//		tv.volumeUp(); 
//		tv.volumeDown(); 
//		tv.powerOff();
		
		
		// 1. 스프링 컨테이너 직접 생성, XML 로딩, 등록된 객체의 디폴트 생성자 호출, 객체 생성 (pre-loading)
		GenericXmlApplicationContext container = 
		    new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 컨테이너가 생성한 객체들 중에 id가 tv 인 객체 리턴 (Lookup)
	    TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown(); 
		tv.powerOff();
		
		// 3. 스프링 컨테이너 삭제
		// 모든 컨테이너는 삭제되기 직전 컨테이너가 생성한 객체들 메모리에서 먼저 제거 
		container.close();
		
		
		// <bean> 의 scope 속성에 대한 설명 코드
//		TV tv1 = (TV) container.getBean("tv");
//		TV tv2 = (TV) container.getBean("tv");
//		TV tv3 = (TV) container.getBean("tv");
//		System.out.println(tv1.toString());
//		System.out.println(tv2.toString());
//		System.out.println(tv3.toString());
		
		
		
	}

}
