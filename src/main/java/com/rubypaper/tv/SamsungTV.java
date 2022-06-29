package com.rubypaper.tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tv")
public class SamsungTV implements TV {
	
	@Autowired
	private Speaker speaker;
	 
	/* 세터인젝션 
	public void setSpeaker(Speaker speaker) {   
		this.speaker = speaker;
	}
	*/

	public SamsungTV() {
		System.out.println("===> SamsungTV 생성");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	

}
