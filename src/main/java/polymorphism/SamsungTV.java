package polymorphism;

public class SamsungTV implements TV {
	
    private int price;
    // 디폴트 생성자에 의한 초기화 0
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 생성");
	}
	
	// <bean> 속성 설명을 위한 코드 
	// POJO (스프링이 관리하는 클래스의 함수, 매개변수, 반환타입 등 내맘대로 가능 <-> Servlet)
	public void 멤버변수초기화() {
		System.out.println("---> 멤버변수 초기화()");
		price = 1700000;
	}
	public void 자원해제() {
		System.out.println("---> 자원해제()");
		price = 0;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다." + price);
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV---소리 울린다.");
	}
	public void volumeDown() {
		System.out.println("SamsungTV---소리 내린다.");
	}
	

}
