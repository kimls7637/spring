package test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		// Phone phone=new ApplePhone(); 직접 new하면 결합도가 높다
		// Phone phone=new KiwiPhone();
		// 스프링설정파일로 빼면 -> 결합도 낮춤
		
		// BeanFactory bf=new BeanFactory();
	
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		// 추상클래스 최상위 클래스
		// GenericXmlApplicationContext가 자바에서만 쓰이고, 웹에서는 다른애를 쓰기때문에
		// 앞에 최상위클래스를 써놓은것(부모)
		// 스프링설정파일을 부름으로써 스프링컨테이너가 구동
		// 안에 있는 빈객체들이 생성. new되는것
		
		/*
		// 결합도 낮추기 위해 팩토리패턴, 오브젝트 반환되기때문에 형변환
		Phone phone=(Phone)factory.getBean("kiwi"); 
		// getBean이 스프링설정파일에 있는 객체를 가져올거다 Look up
		// 이때 한번 불러서 아래에서 여러번 호출하는것(싱글톤 패턴)
		// 올바른 요청주면 객체 반환해서 사용함
		
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
		TestBean tb=(TesjhtBean)factory.getBean("tb");
		list<String> list=tb.getlist();
		for(String v:list) {
			System.out.println(v);
		}
		*/
		
		/*
		 * Scanner sc=new Scanner(System.in); System.out.println("문자 입력 >>"); String msg
		 * = sc.next();
		 * 
		 * DBean db=(DBean)factory.getBean("db"); db.insert(msg);
		 * System.out.println(db);
		 * 
		 * for(String v: db.selectAll()) { System.out.println(v); }
		 */
		
		// 셍성완 3개 떴다는건 new3번 == @컴포넌트 3번
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println();
		
		System.out.print(" >>> 핸드폰 기종을 입력해주세요\n"
				+ "- ApplePhone (apple 입력)\n"
				+ "- KiwiPhone (kiwi 입력)\n"
				+ ": ");
		String str=sc.next();
		
		if(!(str.equals("apple") || str.equals("kiwi"))) {
			System.out.println("해당객체가 없습니다.");
		}else {
			Phone phone=(Phone)factory.getBean(str); // 룩업
			phone.powerOn();
			phone.volumeUp();
		}
		
		 
		
		
		factory.close(); // 다 썼으면 닫아주기 xml구동해서 만들어진 팩토리 닫아줌으로써 노란밑줄 사라짐
		
		// 지금까지 객체 1개
		
	}
}
