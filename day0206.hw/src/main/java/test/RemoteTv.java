package test;

public class RemoteTv implements Remote {
	public RemoteTv() {
		System.out.println("TV 기본생성자");
	}
	public void on() {
		System.out.println("TV 전원 켜기");
	}
	public void off() {
		System.out.println("TV 전원 끄기");
	}
	public void up() {
		System.out.println("TV 소리 ++");
	}
	public void down() {
		System.out.println("TV 소리 --");
	}
}
