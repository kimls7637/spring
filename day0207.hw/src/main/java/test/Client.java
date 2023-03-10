package test;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		TestBean tb = (TestBean)factory.getBean("tb");
		ArrayList<String> datas = tb.getDatas();
		for(String v : datas) {
			System.out.println(v);
		}
		
		System.out.print("입력 : ");
		String str = sc.next();
		tb.insert(str);
		datas = tb.selectAll();
		for(String v : datas) {
			System.out.println(v);
		}
		
		factory.close();
		sc.close();
	}
}
