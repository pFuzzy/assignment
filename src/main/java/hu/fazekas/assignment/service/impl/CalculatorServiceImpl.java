package hu.fazekas.assignment.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import hu.fazekas.assignment.service.CalculatorService;

@Component
public class CalculatorServiceImpl implements CalculatorService{

	@Override
	public 	BigDecimal add(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

	@Override
	public 	BigDecimal subtract(BigDecimal a, BigDecimal b) {
		return a.subtract(b);
	}

	@Override
	public 	BigDecimal multiply(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}

	@Override
	public 	BigDecimal divide(BigDecimal a, BigDecimal b) {
		try {
			return a.divide(b, 2, RoundingMode.HALF_UP);
		} catch(ArithmeticException ex) {
			return BigDecimal.ZERO;
		}
	}

}
