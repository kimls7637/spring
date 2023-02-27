package test;

public interface Phone {
	// d인터페이스는 추상메서드만을 가지기 때문에 바디 지우고 퍼블릭 지움
	void powerOn();
	void powerOff(); 
	void volumeUp();
	void volumeDown();
}
