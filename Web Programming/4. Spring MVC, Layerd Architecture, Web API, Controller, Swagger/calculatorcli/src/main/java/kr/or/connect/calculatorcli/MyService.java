package kr.or.connect.calculatorcli;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	private final CalculatorService calculatorService;
	
	public MyService(CalculatorService cs) {
		this.calculatorService = cs;
	}
	
	public int execute(int value1, int value2) {
		return calculatorService.plus(value1, value2) * 2;
	}
}
