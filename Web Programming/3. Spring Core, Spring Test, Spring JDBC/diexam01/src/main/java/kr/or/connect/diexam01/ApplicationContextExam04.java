package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// AnnotationConfig 활용
public class ApplicationContextExam04 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		// getBean에서 클래스 id를 이용하지 않고 Car 클래스를 직접 반환함
		// 이 경우 Car 클래스가 있으면 알아서 반환하게 함
		Car car = (Car) ac.getBean(Car.class);
		car.run();
	}
}
