package com.sapient.calculator.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorRestController {
	@Autowired
	private CalculatorDao service;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public double add(@PathVariable double number1,@PathVariable double number2) {
		return service.add(number1,number2);
	}

	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public double sub(@PathVariable double number1,@PathVariable double number2) {
		return service.subtract(number1,number2);
	}

	@RequestMapping(value = "/mul", method = RequestMethod.GET)
	public double mul(@PathVariable double number1,@PathVariable double number2) {
		return service.multiply(number1,number2);
	}

	@RequestMapping(value = "/div", method = RequestMethod.GET)
	public double div(@PathVariable double number1,@PathVariable double number2) {
		return service.divide(number1,number2);
	}
}
