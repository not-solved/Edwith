package kr.or.connect.calculatorcli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// Mockito를 이용하여 mock 객체 사용 테스트
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = {ApplicationConfig.class})
@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {
	// @Autowired
	@InjectMocks
	MyService myService;
	
	@Mock
	CalculatorService calculatorService;
	
	@Test
	public void execute() throws Exception {
		int value1 = 5;
		int value2 = 10;
		given(calculatorService.plus(5,  10)).willReturn(15);
		
		int result = myService.execute(value1, value2);
		
		verify(calculatorService).plus(anyInt(), anyInt());
		Assert.assertEquals(30, result);
	}
}
