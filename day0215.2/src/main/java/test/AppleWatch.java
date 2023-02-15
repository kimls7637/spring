package test;

public class AppleWatch implements Watch {

	public AppleWatch() {
		System.out.println("AppleWatch 생성완");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("AppleWatch�� volumeUp() �����");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleWatch�� volumeDown() �����");
	}

}
