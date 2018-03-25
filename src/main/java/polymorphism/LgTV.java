package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;
	
	/*public LgTV() {
		System.out.println("===> LgTV(1) 객체 생성");
	}
	
	public LgTV(Speaker speaker) {
		System.out.println("===> LgTV(2) 객체 생성");
		this.speaker=speaker;
	}*/
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리..");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	
	public void volumeUp() {
		//System.out.println("LgTV---소리 올린다.");
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		//System.out.println("LgTV---소리 내린다.");
		speaker.volumeDown();
	}
}
