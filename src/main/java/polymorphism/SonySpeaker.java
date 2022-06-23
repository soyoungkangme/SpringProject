package polymorphism;


public class SonySpeaker implements Speaker {
// 다형성 적용, xml 에서 스피커 쉽게 바꾸기 
	
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 생성");
	}

	public void volumeUp() {
		System.out.println("SonySpeaker---소리 울린다.");
	}

	public void volumeDown() {
		System.out.println("SonySpeaker---소리 내린다.");
	}

}
