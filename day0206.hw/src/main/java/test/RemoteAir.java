package test;

public class RemoteAir implements Remote {
	public RemoteAir() {
		System.out.println("AIR 기본생성자");
	}
	public void on() {
		System.out.println("AIR 전원 키기");
	}
	public void off() {
		System.out.println("AIR 전원 끄기");
	}
	public void up() {
		System.out.println("AIR 온도 ++");
	}
	public void down() {
		System.out.println("AIR 온도 --");
	}
}
