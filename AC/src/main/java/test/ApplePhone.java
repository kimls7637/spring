package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// new
// <bean> 
// id가 없음 그래서 이름을 따로 줘야함
public class ApplePhone implements Phone {
	// 애플폰을 만들적에 "주입"
	// 멤버변수자리에 new하지않는다
	// watch류 라면 다 들어올수있다

	//@Autowired // 메모리에 존재하는 Watch타입의 객체를 자동으로 주입 -> DI해줌으로써 IoC를 지원하는 스프링 컨테이너
	// @Qalifier("aw") // ※메모리에 동일한 타입의 객체가 2개 이상이면 에러발생!!!!
	private Watch watch; 
	// private int number;

	
//	  public ApplePhone() { 
//		  System.out.println("ApplePhone 기본생성자"); 
//	}
	 

	// 애플폰 만들때 워치가 만들어져야 한다
	// 어떠한 생성자를 까봤을때 인자로 명시되어있는 멤버변수가 있다면
	// 필수적이어서, 필요해서 넣어놓은것
	// 생성자가 있다면 중요하다는 것
	// ★ 생성자의 인자로 객체에 주입할 값을 받아오는 것 ★
	// 스프링설정파일에 명시해주면됨
	// [생성자 주입]
	public ApplePhone(Watch watch) { 
		this.watch=watch;
		System.out.println("ApplePhone 생성자"); 
	}


	// 설정파일에 인자 하나 더 넣어주면됨
	/*
	 * public ApplePhone(Watch watch,int number) { this.watch=watch;
	 * this.number=number; System.out.println("ApplePhone 생성자22"); }
	 */

	@Override // 가독성, 수행능력 향상
	public void powerOn() {
		System.out.println("애플폰 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("애플폰 OFF");
	}
	@Override
	public void volumeUp() {
		// watch=new AppleWatch(); 직접 new 좋지않다
		watch.volumeUp();
		// new한적이 없기때문에 동작하지않는다
		/*
		AppleWatch watch=new AppleWatch();
		watch.volumeUp();
		// 직접적으로 new를 작성하는건 볼륨업메서드할때마다 watch를 만들어달라는 뜻
		 */
	}
	@Override
	public void volumeDown() {
		// 이렇게 new를 해줄수밖에 없다
		// 그럼 위에 멤버변수로 뺀 의미가 없다
		// watch=new AppleWatch();
		watch.volumeDown();
	}

	//	  public void initMethod() { 
	//	  System.out.println("객체를 초기화할때 호출할수있는 메서드"); 
	//	  }
	// bean 기본생성자 호출
	// 멤버변수를 초기화하거나 시작할때 크롤링, 샘플데이터 세팅할때, 초기화할떄 돌려야하는 로직 등에 활용
}
