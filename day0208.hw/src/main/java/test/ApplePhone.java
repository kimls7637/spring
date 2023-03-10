package test;

public class ApplePhone implements Phone {
	
	private Watch watch;
	
	public ApplePhone(AppleWatch watch) {
		this.watch = watch;
		System.out.println("ApplePhone 생성자");
	}
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
