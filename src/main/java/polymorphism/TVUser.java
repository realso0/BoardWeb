package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// BeanFactory factory=new BeanFactory();
		// TV tv=(TV)factory.getBean(args[0]);
		// tv.powerOn();
		// tv.volumeUp();
		// tv.volumeDown();
		// tv.powerOff();

		// 1. Spring 컨테이너 구동한다. 컨테이너 구동과 동시에 객체 생성 및 객체의 멤버변수가 초기화됨.
		// lazy-init="true" 설정하는 순간, 컨테이너 구동과 동시에 객체를 생성하지 않고, factory.getBean("tv")에서 객체(빈)를 사용하는 시점에 객체 생성된다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring 컨테이너를 종료한다. 컨테이너는 종료전 자신이 관리하는 모든 객체(빈)를 삭제하는데, 이 예제에서는 SamsungTV 객체가 삭제됨.
		factory.close();
	}
}
