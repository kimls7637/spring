package test;

import org.springframework.stereotype.Component;

@Component("kw")
public class KiwiWatch implements Watch {

	public KiwiWatch() {
		System.out.println("KiwiWatch 생성완");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("KiwiWatch�� volumeUp() �����");
	}

	@Override
	public void volumeDown() {
		System.out.println("KiwiWatch�� volumeDown() �����");
	}

}
