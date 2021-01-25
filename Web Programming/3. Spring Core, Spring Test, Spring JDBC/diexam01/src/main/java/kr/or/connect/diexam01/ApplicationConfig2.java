package kr.or.connect.diexam01;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("kr.or.connect.diexam01")	// 현재 프로젝트의 패키지 컴포넌트를 스캔할 것이라 명시함
 
public class ApplicationConfig2 {
	// 내부에는 아무것도 없지만
	// ComponentScan 어노테이션으로 다른 어노테이션을 모두 읽어와 메모리에 올려두고 사용한다.
}


/*
	Annotation
	- 자바에서 Annotation은 컴파일, 런타임 시 해석될 수 있음
	
	@configuration : spring 설정 클래스를 의미
	@ComponentScan : 파라미터르 들어온 패키지 이하에서 
						@Controller, @Serveice, @Repository, @Component 어노테이션이 붙어있는
						클래스를 찾아 모두 메모리에 올려준다.
*/