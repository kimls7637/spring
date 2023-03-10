package view;

import java.util.Scanner;
import java.util.ArrayList;

public class View {
	private Scanner sc;
	public View() {
		sc = new Scanner(System.in);
	}
	public int printMenu() {
		System.out.println("=== 실습 ===");
		System.out.println("1. 작성하기");
		System.out.println("2. 출력하기");
		System.out.println("3. 종료하기");
		System.out.print(">> ");
		int action = sc.nextInt();
		return action;
	}
	public String getStr() {
		System.out.print("입력 : ");
		String str = sc.next();
		return str;
	}
	public void printDatas(ArrayList<String> datas) {
		for(int i = 0; i < datas.size(); i++) {
			System.out.println(i+1 + "번째 : " + datas.get(i));
		}
	}
	public void printResult(boolean what) {
		if(what) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	public void powerOff() {
		System.out.println("실습을 종료합니다.");
	}
}
