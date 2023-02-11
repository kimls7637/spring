package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		Controller ctrl = (Controller)factory.getBean("ctrl"); // Look up
		ctrl.startApp();
		factory.close();
	}
}
