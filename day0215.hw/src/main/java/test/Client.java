package test;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		//BeanFactory factory=new BeanFactory(args[0]);
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		/*
		Phone phone=(Phone)factory.getBean("kiwi"); // Look up
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		 */

		/*
		Phone phone02=(Phone)factory.getBean("apple");
		Phone phone03=(Phone)factory.getBean("apple");
		 */

		/*
		TestBean tb=(TestBean)factory.getBean("tb");
		List<String> list=tb.getList();
		for(String v:list) {
			System.out.println(v);
		}



		DaoBean db=(DaoBean)factory.getBean("db");
		System.out.println("���ڿ��� �Է��ϼ���.");
		String str=new Scanner(System.in).next();
		db.insert(str);
		for(String v:db.selectAll()) {
			System.out.println(v);
		}
		 */

		System.out.print("생성할 객체의 이름을 입력하세요. >>>  ");
		String beanName=new Scanner(System.in).next();
		try {
			Phone phone=(Phone)factory.getBean(beanName);
			phone.powerOn();
			phone.volumeUp();
		} catch(Exception e) {
			System.out.println("해당 객체가 없습니다...");
		}
		factory.close();


















	}
}
