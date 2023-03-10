package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("apple")
// new
// bean
public class ApplePhone implements Phone {
	@Autowired // 메모리에 존재하는 Watch타입의 객체를 자동으로 주입 -> DI해줌으로써 IoC를 지원하는 스프링 컨테이너 
	private Watch watch;
	
	public void powerOn() {
		System.out.println("애플폰 ON");
	}
	public void powerOff() {
		System.out.println("애플폰 OFF");
	}
	public void volumeUp() {
		watch.volumeUp();
	}
	public void volumeDown() {
		watch.volumeDown();
	}
	public void initMethod() {
		System.out.println("객체를 초기화할 때 호출할 수 있는 메서드");
		// <bean>멤버변수 사용
		// 초기화할 때 사용
	}
}
