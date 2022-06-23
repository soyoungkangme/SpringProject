package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// <bean> 은 클래스이름#0, Annotation 은 클래스 이름의 첫 글자를 소문자로 바꿔 자동 id 생성, 직접 지정하고 싶으면 ("아이디") 
// 룩업 해야 하므로 아이디 필수 
@Component("tv")
public class LgTV implements TV {
	
	
	
	// 생성자/세터 인젝션 대신 사용 (변수위에 설정하여 해당 타입의 객체 자동 할당, not null point exception, 의존성 주입) (Type Injection)
	@Autowired
	private Speaker speaker;
	// 스피커 변경할때 자바소스 수정 안하기 위해 다형성 이용하면 (SonySpeaker -> Speaker)   
	// 에러뜸 (not single match bean, 메모리에 두개의 스피커 객체 있다) -> 스피커 두개의 @Component 삭제하고 XML <bean> 등록 
	
	
	// 부모를 오버라이딩 하지 않으면, 부모로부터 상속되고, 추상메서드를 하나라도 가지면 추상클래스로 선언해야함
	// 추상클래스는 객체 생성 불가 하므로 부모의 메서드 꼭 오버라이딩 해야 일반 클래스로서 객체 생성 가능 
	public LgTV() {
		System.out.println("===> LgTV 생성");
	}
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	

}
