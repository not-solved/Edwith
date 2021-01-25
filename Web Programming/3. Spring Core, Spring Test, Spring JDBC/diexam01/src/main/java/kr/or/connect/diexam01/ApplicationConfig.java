package kr.or.connect.diexam01;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}


/*
	Annotation
	- 자바에서 Annotation은 컴파일, 런타임 시 해석될 수 있음
	
	@configuration : spring 설정 클래스를 의미
	@Bean : AnnotationConfigurationApplicationContext를 자동으로 실행, 그 결과를 싱글톤으로 리턴
*/