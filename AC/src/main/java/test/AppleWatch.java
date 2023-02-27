package test;

import org.springframework.stereotype.Component;


public class AppleWatch implements Watch{
	// 객체 생성 타이밍을 제대로 알고있어야 스프링에서 각종 설정들을 유의미하게 사용할수있다
	public AppleWatch() {
		System.out.println("AppleWatch 객체 생성완");
	}

	@Override
	public void volumeUp() {
		System.out.println("AppleWatch로 volumeUp() 수행완");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleWatch로 volumeDown() 수행완");
	}

	
}
