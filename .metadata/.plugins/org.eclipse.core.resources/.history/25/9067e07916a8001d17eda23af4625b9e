package test;

public class BeanFactory {
	public Object getBean(String beanName) {
		// 무엇을 달라 할지 모르기 때문에 최상의 Object
		if(beanName.equals("apple")) {
			return new ApplePhone();
		}
		else if(beanName.equals("kiwi")) {
			return new KiwiPhone();
		}
		return null;
	}
}
