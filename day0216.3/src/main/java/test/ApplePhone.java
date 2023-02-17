package test;

public class ApplePhone implements Phone {
	///// @Autowired // 메모리에 존재하는 Watch타입의 객체를 자동으로 주입 -> DI해줌으로써 IoC를 지원하는 스프링 컨테이너
	///// @Qualifier("aw") // 메모리에 동일한 타입의 객체가 2개이상이면 에러발생!!!!!
	private Watch watch;
	public ApplePhone(Watch watch) {
		this.watch=watch;
	}
	
	@Override
	public void powerOn() {
		System.out.println("������ ON");
	}
	@Override
	public void powerOff() {
		System.out.println("������ OFF");
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
