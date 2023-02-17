package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("kiwi")
public class KiwiPhone implements Phone {
	@Autowired
	@Qualifier("kw")
	private Watch watch;
	
	@Override
	public void powerOn() {
		System.out.println("Ű���� ON");
	}
	@Override
	public void powerOff() {
		System.out.println("Ű���� OFF");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
}
