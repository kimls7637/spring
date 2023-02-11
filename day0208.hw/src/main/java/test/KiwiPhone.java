package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("kiwi")
public class KiwiPhone implements Phone {
	@Autowired
	@Qualifier("kw")
	private Watch watch;
	public void powerOn() {
		System.out.println("키위폰 ON");
	}
	public void powerOff() {
		System.out.println("키위폰 OFF");
	}
	public void volumeUp() {
		watch.volumeUp();
	}
	public void volumeDown() {
		watch.volumeDown();
	}
}
