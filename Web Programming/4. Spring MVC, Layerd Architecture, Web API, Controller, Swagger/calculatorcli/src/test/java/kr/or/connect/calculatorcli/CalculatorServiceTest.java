package kr.or.connect.calculatorcli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// @Before : 테스트 메소드가 실행되기 전에 실행된다. 테스트메소드가 있는 만큼 실행된다.
// @BeforeClass : 테스트 클래스가 실해오디기 전에 딱 한번 실행됨

// @AfterClass : 테스트 클래스의 모든 테스트 메소드가 실행이 끝난 후 딱 한번 실행됨
// @After : 테스트 메소드가 실행된 후에 실행된다. @Before과 마찬가지로, 테스트메소드가 있는 만큼 실행된다.

// @Test : 테스트 메소드에 붙는 어노테이션

// @RunWith : JUnit에서 제공, SpringJUnit4ClassRunner.class를 제공하는 확장기능이 있으며 스프링 빈 컨테이너가 내부적으로 생성되도록 한다.
// @ContextConfiguration : 내부적으로 생성된 스프링 빈 컨테이너가 사용할 설정파일을 지정 (여기서는 AplicationConfig 클래스로 지정)

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class CalculatorServiceTest {
	@Autowired
	CalculatorService calculatorService;
	
	@Before
	public void init() {
		this.calculatorService = new CalculatorService();
	}
	
	// 덧셈 테스트
	@Test
	public void plus() throws Exception {
		int value1 = 10;
		int value2 = 5;
		
		int result = calculatorService.plus(value1, value2);
		
		Assert.assertEquals(15, result);
	}

	// 나눗셈 테스트
	@Test
	public void divide() throws Exception {
		int value1 = 10;
		int value2 = 5;
		
		int result = calculatorService.divide(value1, value2);
		
		Assert.assertEquals(2, result);
	}

	// 나눗셈 예외처리 테스트
	@Test
	public void divideException() throws Exception {
		int value1 = 10;
		int value2 = 0;
		
		try {
			calculatorService.divide(value1, value2);
		}
		catch(ArithmeticException ae) {
			Assert.assertTrue(true);	// 이 부분이 실행되면 성공
			return;						// 더이상 실행하지 않음
		}
		
        Assert.fail();			// 이부분이 실행되면 실패
	}
}

/*	그 외 주요 Assert
 * 		assertEqual(x, y) : x, y값이 일치하면 테스트 성공 (x : 에상값, y : 실제 값)
 * 		assertArrayEquals(a, b) : 배열 a와 b가 일치하면 테스트 성공
 * 		
 * 		assertFalse(x) : x가 false이면 테스트 성공
 * 		assertTrue(x) : x가 true이면 테스트 성공
 * 		assertTrue(message, condition) : condition이 true이면 message를 표시하고 테스트 성공		
 * 
 *		assertNull(n) : n이 null이면 테스트 성공
 *		assertNotNull(n) : n이 null이 아니면 테스트 성공
 *
 *		assertSame(ox, oy) : 객체 ox, oy가 같은 객체임을 확인
 *								ox와 oy가 같은 객체를 참고하고 있으면 테스트 성공 (레퍼런스 동일여부 확인)
 *		assertNotSame(ox, oy) : 객체  ox, oy가 같은 객체를 참조하고 있지 않다면 테스트 실패
*/
