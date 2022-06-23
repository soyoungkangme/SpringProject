package polymorphism;

public class GoogleTV implements TV {
	
	private Speaker speaker;
	// 다형성 적용, xml 에서 스피커 쉽게 바꾸기 (SonySpeaker 타입 말고 Speaker 타입)
	private int price;
	
	
	
	// 생성자 인젝션 (생성자 오버로딩)
	public GoogleTV() {
		System.out.println("===> GoogleTV(1) 생성");
	}
	
	// command+option+s, constructor using fields
	// 스프링 컨테이너는 디폴트 생성자만 호출 가능 -> 호출 가능 하도록 xml 수정하기 (constructor-arg ref)
	public GoogleTV(Speaker speaker) {
		System.out.println("===> GoogleTV(2) 생성");
		this.speaker = speaker;
	}
	// 다형성 적용, xml 에서 스피커 쉽게 바꾸기 (모든 하위 클래스 상위 인터페이스로 받을수 있음, 묵시적 형변환)
	
	// 멤버변수 두개 모두 한번에 초기화 하고 싶다면 생성자 또 오버로딩
	public GoogleTV(Speaker speaker, int price) {
		System.out.println("===> GoogleTV(3) 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	
	// 세터 인젝션 
	// 생성자 아닌 세터 메서드 호츌해서 멤버변수 초기화 하기
	public void setSpeaker(Speaker speaker) {
	    System.out.println("---> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("---> setPrice() 호출");
		this.price = price;
	}

	
	
	public void powerOn() {
		System.out.println("GoogleTV---전원 켠다." + price);
	}

	public void powerOff() {
		System.out.println("GoogleTV---전원 끈다.");
	}
	
	
	
	public void volumeUp() {
		// speaker = new SonySpeaker(); -> not nullPointException 
		// -> 순제어, 메모리 낭비, 스피커 교체 어려움 
		// -> GoogleTV 생성 될 때 SonySpeaker 가 인자로 넘어가도록 생성자 오버로딩하고 xml 수정 
	    speaker.volumeUp();
	}
	public void volumeDown() {
		// speaker = new SonySpeaker();
		speaker.volumeDown();
	}
	

}
