package client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ctrl.Ctrl;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		Ctrl ctrl = (Ctrl)factory.getBean("ctrl"); // Look up
		ctrl.startApp();
		factory.close();
	}
}
