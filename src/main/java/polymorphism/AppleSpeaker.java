package polymorphism;

// @Annotation
// 스피커는 @Autowired 로 의존성 주입 (notNullPointException, 자동할당) 하기 때문에 아이디 필요 없음 
public class AppleSpeaker implements Speaker {
// command+option+t, extract interface, select all, unchecked all -> Speaker.java 생김 
// 다형성 적용하여 xml 에서 스피커 쉽게 바꾸기 
	
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 생성");
	}

	public void volumeUp() {
		System.out.println("AppleSpeaker---소리 울린다.");
	}

	public void volumeDown() {
		System.out.println("AppleSpeaker---소리 내린다.");
	}
	
	

}
