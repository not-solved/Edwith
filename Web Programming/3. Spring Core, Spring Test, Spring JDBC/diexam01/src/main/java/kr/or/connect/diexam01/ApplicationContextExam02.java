package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// DI 활용의 장점 - 의존성을 이용하여, Engine을 생성하지 않고도 Enging 클래스를 생성하고 사용
		Car car = (Car)ac.getBean("c");
		car.run();
	}
}
