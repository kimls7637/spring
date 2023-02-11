package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("apple 과 kiwi 중에 골라주세요");
		System.out.print(">> ");
		String ans = sc.next();
//		String ans = new Scanner(System.in).next();
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		try {
			Phone phone = (Phone)factory.getBean(ans);
			phone.powerOn();
			phone.volumeDown();
		} catch (Exception e) {
			System.out.println("해당 객체가 없습니다...");
		}
		
		factory.close();
		sc.close();
		
	}
}
