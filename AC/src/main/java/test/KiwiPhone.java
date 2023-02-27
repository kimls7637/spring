package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("kiwi")
public class KiwiPhone implements Phone {
	@Autowired
	@Qualifier("kw") // watch류 여러개이므로 설정해주기
	private Watch watch;
	private int number;
	
	// 기본생성자 하나 유지하면서
	public KiwiPhone() {
		System.out.println("KiwiPhone 기본 생성자");
	}
	
	// setter 두개 만듦(멤버변수 두개라서)
	// 인풋있는데 아웃풋 없음
	// 스프링 설정파일에 가져가서 setter주입할거야라고 property로 사용
//	public void setWatch(Watch watch) {
//		this.watch=watch;
//		System.out.println("setter 주입: watch");
//	}
//	public void setNumber(int number) {
//		this.number=number;
//		System.out.println("setter 주입: number");
//	}
	
	
	public void volumeUp() {
		watch.volumeUp();
	}
	public void volumeDown() {
		watch.volumeDown();
	}
	@Override
	public void powerOn() {
		System.out.println("키위폰 ON");		
	}
	@Override
	public void powerOff() {
		System.out.println("키위폰 OFF");		
	}
	public void destroyMethod() {
		System.out.println("객체메모리 해제할때 호출할수있는 메서드");
		// close() 연결해제로직 등을 호출할때 활용
	}
}
